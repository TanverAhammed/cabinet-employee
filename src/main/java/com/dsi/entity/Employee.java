package com.dsi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String contact;

    private String address;

    private LocalDate joiningDate;

    private String designation;

    private Boolean isAssigned;

    @ManyToOne
    @JoinColumn(name = "cabinet_id_fk", referencedColumnName = "id")
//    @JsonIgnore
    private Cabinet cabinet;

}
