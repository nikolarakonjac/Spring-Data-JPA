package com.example.demo;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "Company")
@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor()
@ToString
public class Company {

    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_sequence"
    )
    @Column(
            name = "id"
    )
    private int id;

    @Column(
            name = "uuid"
    )
    private UUID uuid;

    @Column(
            name = "pib",
            length = 15,
            unique = true,
            nullable = false
    )
    private String pib;

    @Column(
            name = "ziro_racun",
            length = 20,
            unique = true,
            nullable = false
    )
    private String ziro_racun;

    @Column(
            name = "grad",
            length = 20
    )
    private String grad;


    public Company(UUID uuid, String pib, String ziro_racun, String grad) {
        this.uuid = uuid;
        this.pib = pib;
        this.ziro_racun = ziro_racun;
        this.grad = grad;
    }
}
