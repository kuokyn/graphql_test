package com.kuokyn.graphql_test;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode
@Entity
@Getter
@Setter
public class Grocery implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "text", nullable = false)
    private String text;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "isBought")
    private Boolean isBought;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Grocery(String text, Integer quantity, Boolean isBought, User user) {
        this.text = text;
        this.quantity = quantity;
        this.isBought = isBought;
        this.user = user;
    }

    public Grocery(){}
}
