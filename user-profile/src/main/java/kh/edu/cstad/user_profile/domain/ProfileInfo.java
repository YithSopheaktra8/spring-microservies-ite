package kh.edu.cstad.user_profile.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "profile_info")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProfileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true , nullable = false)
    private Long userId;

    private String firstName;

    private String lastName;

    private String gender;

    @Column(columnDefinition = "TEXT")
    private String headline;

    @Column(columnDefinition = "TEXT")
    private String iLove;

    private String findMeIn;

    private String hometown;

    private String website;

}
