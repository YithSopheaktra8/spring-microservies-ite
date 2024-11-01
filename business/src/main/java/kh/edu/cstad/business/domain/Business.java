package kh.edu.cstad.business.domain;

import jakarta.persistence.*;
import kh.edu.cstad.business.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "business")
public class Business extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String alias;

    private String imageUrl;

    private String rating;

    private String price; // $, $$, $$$, $$$$

    private Integer reviewCount;

    private String phone;

    private String dateOpened;

    private String dateClosed;

    private Boolean isClosed;

    private Boolean isClaimed;

    private Boolean isOpening24Hours;
    
    @OneToMany
    private List<Category> categories;

    @OneToOne
    private Coordinates coordinates;

    @ManyToMany
    @JoinTable(
            name = "business_transactions",
            joinColumns = @JoinColumn(name = "business_id"),
            inverseJoinColumns = @JoinColumn(name = "transactions_id")
    )
    private List<Transactions> transactions; // pickup, delivery and restaurant_reservation.

    @OneToOne
    private Location location;

    @OneToMany
    private List<OpenHours> openHours; // list of open hours for each day of the week.



}
