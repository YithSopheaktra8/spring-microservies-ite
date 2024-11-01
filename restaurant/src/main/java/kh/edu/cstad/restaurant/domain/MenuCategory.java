package kh.edu.cstad.restaurant.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "menu_category")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MenuCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String alias;

    private String name;

    private String description;

    private String icon;

    private Boolean isAvailable;

    @OneToMany(mappedBy = "menuCategory")
    private List<MenuItem> menuItems;
}
