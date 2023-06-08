package com.cement.CodysseyBackend.domain.member.service;

import com.cement.CodysseyBackend.domain.member.domain.Member;
import com.cement.CodysseyBackend.domain.member.domain.Profile;
import com.cement.CodysseyBackend.domain.member.domain.Stack;
import com.cement.CodysseyBackend.domain.member.dto.MemberCreateRequest;
import com.cement.CodysseyBackend.domain.member.dto.MemberLoginRequest;
import com.cement.CodysseyBackend.domain.member.repository.MemberRepository;
import com.cement.CodysseyBackend.domain.member.repository.ProfileRepository;
import com.cement.CodysseyBackend.domain.member.repository.StackRepository;
import com.cement.CodysseyBackend.domain.oauth.github.AccessRepository;
import com.cement.CodysseyBackend.domain.oauth.github.domain.Access;
import com.cement.CodysseyBackend.domain.oauth.github.dto.GithubLoginResponse;
import com.cement.CodysseyBackend.domain.oauth.github.service.GithubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ProfileRepository profileRepository;
    private final StackRepository stackRepository;
    private final AccessRepository accessRepository;
    private final GithubService githubService;

    public Member create(MemberCreateRequest request) {
        // request
        // - private String gender;
        // - private List<String> stack;
        // - private String access_token;

        // TOKEN으로 유저 정보 가져오기
        GithubLoginResponse githubLoginResponse = githubService.access(request.getAccess_token());
        // Access DB에서 정보 삭제하기
        Access accessRepoData = accessRepository.findByAccessToken(request.getAccess_token());
        accessRepository.delete(accessRepoData);
        // 회원가입 Logic
        Member member = Member.builder()
                .githubId(githubLoginResponse.getGithub_id())
                .username(githubLoginResponse.getUsername())
                .gender(request.getGender())
                .build();

        Member responseMember = memberRepository.save(member);

        Profile profile = Profile.builder()
                .memberId(responseMember.getId())
                .avatarUrl(githubLoginResponse.getAvatar_url())
                .githubUrl(githubLoginResponse.getGithub_url())
                .build();

        profileRepository.save(profile);

        for (String stack: request.getStack()) {
            Stack memberStack = Stack.builder()
                    .memberId(responseMember.getId())
                    .stack(stack)
                    .build();
            stackRepository.save(memberStack);
        }

        return responseMember;
    }

    public Member login(String request) {
        boolean check = tokenAccessCheck(request);
        if (check) {
            Optional<Member> member = memberRepository.findByAccessToken(request);
            return member.get();
        } else {
            return Member.builder().build();
        }
    }

    private boolean tokenAccessCheck(String check) {
        Optional<Member> findMember = memberRepository.findByAccessToken(check);
        return findMember.isPresent();
    }

}
