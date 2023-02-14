package br.com.Attornatus.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String publicPlace;
    @Column
    private String zipCode;
    @Column
    private String number;
    @Column
    private String city;
    @Column
    private boolean mainAddress;





}
