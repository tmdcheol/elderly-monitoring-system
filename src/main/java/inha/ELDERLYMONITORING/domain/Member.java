package inha.ELDERLYMONITORING.domain;

import inha.ELDERLYMONITORING.common.config.SimplePasswordEncoder;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import static inha.ELDERLYMONITORING.domain.Role.*;
import static jakarta.persistence.EnumType.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String password;

    @Enumerated(value = STRING)
    private Role role;

    public static Member createMember(String email, String password) {
        return Member.builder()
                .email(email)
                .password(password)
                .role(ROLE_USER)
                .build();
    }
}
