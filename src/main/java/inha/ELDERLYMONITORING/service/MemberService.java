package inha.ELDERLYMONITORING.service;

import inha.ELDERLYMONITORING.common.config.SimplePasswordEncoder;
import inha.ELDERLYMONITORING.domain.Member;
import inha.ELDERLYMONITORING.repository.MemberRepository;
import inha.ELDERLYMONITORING.web.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static inha.ELDERLYMONITORING.domain.Member.createMember;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public Long join(MemberRequest request) {
        Member member = createMember(request.getEmail(), passwordEncoder.encode(request.getPassword()));
        return memberRepository.save(member).getId();
    }

    public Long login(MemberRequest request) {
        Member member = checkValid(request);
        return member.getId();
    }

    private Member checkValid(MemberRequest request) {
        return memberRepository.findByEmail(request.getEmail())
                .orElseThrow(IllegalArgumentException::new);
    }
}
