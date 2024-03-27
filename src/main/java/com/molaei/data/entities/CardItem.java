package com.molaei.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardItem extends Audit implements Serializable {

    private static final Long serialVersionUID = 107L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

    @ManyToOne
    @JoinColumn(name = "cardId")
    private Card card;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
