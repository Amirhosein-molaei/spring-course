package com.molaei.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillingAddress extends Audit implements Serializable {
    private static final Long serialVersionUID = 105L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long billingAddressId;

    @NotEmpty
    private String city;

    @NotEmpty
    private String zipCode;

    @NotEmpty
    private String country;

    @NotEmpty
    private String state;

    @NotEmpty
    private String apartmentNumber;

    @NotEmpty
    private String streetName;
}
