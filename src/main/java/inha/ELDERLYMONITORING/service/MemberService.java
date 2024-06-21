package inha.ELDERLYMONITORING.service;

import inha.ELDERLYMONITORING.domain.Member;
import inha.ELDERLYMONITORING.repository.MemberRepository;
import inha.ELDERLYMONITORING.web.MemberRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static inha.ELDERLYMONITORING.domain.Member.createMember;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Long join(MemberRequest request) {
        Member member = createMember(request.getEmail(), request.getPassword());
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
