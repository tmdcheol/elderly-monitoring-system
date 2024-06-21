package inha.ELDERLYMONITORING.common.security;

import inha.ELDERLYMONITORING.common.security.CustomUserDetails;
import inha.ELDERLYMONITORING.domain.Member;
import inha.ELDERLYMONITORING.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = checkValid(email);
        return new CustomUserDetails(member);
    }

    private Member checkValid(String email){
        return memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
    }
}

