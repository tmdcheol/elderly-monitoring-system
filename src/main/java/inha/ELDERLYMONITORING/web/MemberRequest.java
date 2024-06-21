package inha.ELDERLYMONITORING.web;

import inha.ELDERLYMONITORING.domain.Member;
import inha.ELDERLYMONITORING.domain.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import static inha.ELDERLYMONITORING.domain.Role.*;

@Data
public class MemberRequest {

    @NotEmpty(message = "빈 값입니다.")
    @Email
    String email;

    @NotEmpty(message = "빈 값입니다.")
    String password;

    public Member of(PasswordEncoder passwordEncoder){
        return Member.builder()
                .email(email)
                .password(passwordEncoder.encode(password))
                .role(ROLE_USER)
                .build();
    }
}
