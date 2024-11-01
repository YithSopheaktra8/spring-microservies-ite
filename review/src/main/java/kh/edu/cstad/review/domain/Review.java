package kh.edu.cstad.review.domain;

import jakarta.persistence.*;
import kh.edu.cstad.review.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "reviews")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Review extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer rating;

    @Column(columnDefinition = "TEXT")
    private String comment;

    private Long userId;

    private Long productId;

    private Long serviceAlias;

    private String photoUrl;
}
