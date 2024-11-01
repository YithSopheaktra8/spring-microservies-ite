package kh.edu.cstad.services.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "services")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String businessAlias;

    private String name;

    @Column(unique = true , nullable = false)
    private String alias;

    private String description;

    private String imageUrl;

    private String serviceType;

    @OneToMany(mappedBy = "service")
    private List<Staff> staffs;

}
