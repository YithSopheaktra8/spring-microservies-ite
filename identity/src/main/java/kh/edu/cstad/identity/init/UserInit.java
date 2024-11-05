package kh.edu.cstad.identity.init;


import jakarta.annotation.PostConstruct;
import kh.edu.cstad.identity.domain.Authority;
import kh.edu.cstad.identity.domain.User;
import kh.edu.cstad.identity.repository.UserRepository;
import kh.edu.cstad.identity.security.repository.AuthorityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserInit {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {

        Authority read = authorityRepository.save(Authority.builder().name("READ").build());
        Authority write = authorityRepository.save(Authority.builder().name("WRITE").build());
        authorityRepository.saveAll(List.of(read, write));

        User user = User.builder()
                .username("user")
                .uuid(UUID.randomUUID().toString())
                .password(passwordEncoder.encode("password"))
                .email("user@gmail.com")
                .authorities(Set.of(read,write))
                .build();

        userRepository.save(user);
    }
}