package com.cement.CodysseyBackend.domain.member.service;

import com.cement.CodysseyBackend.domain.member.domain.Member;
import com.cement.CodysseyBackend.domain.member.domain.Profile;
import com.cement.CodysseyBackend.domain.member.domain.Stack;
import com.cement.CodysseyBackend.domain.member.dto.MemberCreateRequest;
import com.cement.CodysseyBackend.domain.member.repository.MemberRepository;
import com.cement.CodysseyBackend.domain.member.repository.ProfileRepository;
import com.cement.CodysseyBackend.domain.member.repository.StackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ProfileRepository profileRepository;
    private final StackRepository stackRepository;

    public Member create(MemberCreateRequest request) {
        Member member = Member.builder()
                .githubId(request.getGithub_id())
                .username(request.getUsername())
                .gender(request.getGender())
                .build();

        Member responseMember = memberRepository.save(member);

        Profile profile = Profile.builder()
                .memberId(responseMember.getId())
                .avatarUrl(request.getAvatar_url())
                .githubUrl(request.getGithub_url())
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
}
