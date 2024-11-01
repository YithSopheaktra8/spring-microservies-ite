package kh.edu.cstad.services.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "staff")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Staff {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String imageUrl;

    private String position;

    private Integer age;

    private BigDecimal salary;

    @ManyToOne
    private Service service;

}
