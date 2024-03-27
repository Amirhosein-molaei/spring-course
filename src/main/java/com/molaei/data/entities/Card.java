package com.molaei.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card extends Audit implements Serializable {

    private static final Long serialVersionUID = 101L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @OneToOne()
    @JoinColumn(name = "customerId")
    private Customer customer;

    @OneToMany(mappedBy = "card")
    private List<CardItem> cardItems;

    private Double grandTotal;

}
