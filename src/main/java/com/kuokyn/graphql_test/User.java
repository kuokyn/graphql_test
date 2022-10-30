package com.kuokyn.graphql_test;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@EqualsAndHashCode
@Entity
@Getter
@Setter
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "phone")
    private String phone;

    @OneToMany(fetch = FetchType.EAGER)
    List<Grocery> groceries;

    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public User(){}
}

