package com.cement.CodysseyBackend.domain.oauth.github.service;

import com.cement.CodysseyBackend.domain.member.domain.Member;
import com.cement.CodysseyBackend.domain.member.repository.MemberRepository;
import com.cement.CodysseyBackend.domain.oauth.github.AccessRepository;
import com.cement.CodysseyBackend.domain.oauth.github.domain.Access;
import com.cement.CodysseyBackend.domain.oauth.github.dto.GithubLoginResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GithubService {

    private final MemberRepository memberRepository;
    private final AccessRepository accessRepository;

    public String getCode(String code) {
        String responseData = null;
        try {
            URL url = new URL("https://github.com/login/oauth/access_token");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36");

            try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()))) {
                bw.write("client_id=ae435d706af35e3a7041&client_secret=41116a6f2e7c65801e2f1394f527ce8bab78cd7d&code=" + code);
                bw.flush();
            }

            int responseCode = conn.getResponseCode();
            responseData = getResponse(conn, responseCode);
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("URL ERROR");
        }

        return responseData;
    }

    public String getAccessToken(String response) {
        String access_token = null;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, String> map = objectMapper.readValue(response, Map.class);
            access_token = map.get("access_token");
        } catch (Exception e) {
            System.out.println("ERROR");
        }
        return access_token;
    }

    public GithubLoginResponse access(String access_token, RedirectAttributes redirectAttributes) {
        String result = null;
        GithubLoginResponse jsonResponse = null;
        try {
            URL url = new URL("https://api.github.com/user");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty(
                    "User-Agent",
                    "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36"
            );
            conn.setRequestProperty("Authorization", "token " + access_token);

            int responseCode = conn.getResponseCode();

            result = getResponse(conn, responseCode);
            conn.disconnect();

            // ##################################### JSON Parsing ####################################
            jsonResponse = githubJSONParsing(result);

        } catch (Exception e) {
            System.out.println("ERROR");
        }
        return jsonResponse;
    }

    private GithubLoginResponse githubJSONParsing(String data) {
        GithubLoginResponse result = null;
        try {
            JSONParser parser = new JSONParser();
            Object object = parser.parse(data);
            JSONObject jsonObject = (JSONObject) object;

            GithubLoginResponse resData = GithubLoginResponse.builder()
                    .github_id(jsonObject.get("login").toString())
                    .avatar_url(jsonObject.get("avatar_url").toString())
                    .username(jsonObject.get("name").toString())
                    .github_url(jsonObject.get("html_url").toString())
                    .build();
            resData.setCreated(createCheck(resData));

            result = resData;

        } catch (Exception e) {
            System.out.println("ERROR");
        }
        return result;
    }

    private String getResponse(HttpURLConnection conn, int responseCode) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (responseCode == 200) {
            try (InputStream is = conn.getInputStream();
                 BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    sb.append(line);
                }
            }
        }
        return sb.toString();
    }

    private boolean createCheck(GithubLoginResponse githubData) {
        Optional<Member> findMember = memberRepository.findByGithubId(githubData.getGithub_id());
        // 멤버가 있는 경우 (회원가입 X)
        if (findMember.isPresent()) {
            return true;
        } else {
            // 멤버가 없는 경우 (회원가입 O)
            return false;
        }
    }

    public void saveAccessToken(Access response) {
        accessRepository.save(response);
        // TODO 업데이트 되는지 확인 필요
    }

    public void saveMemberAccessToken(Access response) {
        Optional<Member> findMember = memberRepository.findByGithubId(response.getGithubId());

        if (findMember.isPresent()) {
            Member member = findMember.get();
            member.setAccessToken(response.getAccessToken());
            memberRepository.save(member);
        }
    }

}
