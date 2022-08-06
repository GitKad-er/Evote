package com.projet.evote.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Privilege {

    @SequenceGenerator(
            name = "priv_sequence",
            sequenceName = "priv_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "priv_sequence"
    )
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private List<Role> roles;
}