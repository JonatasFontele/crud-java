package com.jony.crudjava.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "user", schema = "system")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@NotNull
    //private String password;

    @NotNull
    @NotEmpty
    private String name;

    //private String email;

    //private String role;

    //private String office;

    //private LocalDate admissionDate;

    //private LocalDate expirationDate;

}
