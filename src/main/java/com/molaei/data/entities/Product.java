package com.molaei.data.entities;

import lombok.*;
import org.hibernate.validator.constraints.Range;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
public class Product extends Audit implements Serializable {

    public Product(){
        categoryList = new HashMap<>();
        categoryList.put("LapTop", "LapTop");
        categoryList.put("TV", "TV");
        categoryList.put("mobile", "mobile");
    }
    private static final Long serialVersionUID = 100L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotEmpty
    private String productName;

    @NotEmpty
    private String productBrand;

    @NotEmpty
    private String productModel;

    @NotEmpty
    private String productDescription;

    @NotNull
    @Range(min = 0)
    private Double productPrice;

    @NotNull
    @Range(min = 0)
    private Double unitInStock;

    @Transient
    private MultipartFile productImage;

    @OneToMany(mappedBy = "product")
    private List<CardItem> cardItems;

    @Transient
    private Map<String, String> categoryList;
}
