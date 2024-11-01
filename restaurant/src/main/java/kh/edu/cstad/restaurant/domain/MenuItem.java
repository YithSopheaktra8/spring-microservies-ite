package kh.edu.cstad.restaurant.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "menu_items")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String alias;

    private String name;

    private String picture;

    private String description;

    private BigDecimal price;

    private Boolean isAvailable;

    @ManyToOne
    private Restaurant restaurant;

    @ManyToOne
    private MenuCategory menuCategory;
}
