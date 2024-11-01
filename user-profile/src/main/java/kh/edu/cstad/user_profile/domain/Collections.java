package kh.edu.cstad.user_profile.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "collections")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Collections {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean isPublic;

    @OneToMany(mappedBy = "collection")
    private List<Bookmark> bookmarks;
}
