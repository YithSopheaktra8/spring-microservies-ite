package kh.edu.cstad.business.domain;

import jakarta.persistence.*;
import kh.edu.cstad.business.audit.Auditable;
import lombok.Data;

@Entity
@Table(name = "category")
@Data
public class Category extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(unique = true, nullable = false,length = 100)
    private String alias;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String icon;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    private Category parentCategory;

}
