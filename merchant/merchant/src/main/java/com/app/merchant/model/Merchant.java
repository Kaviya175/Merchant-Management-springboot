package com.app.merchant.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="merchant")
public class Merchant {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Integer id;
    String merchantId;
    String merchantName;
    Integer age;
    String mobileNo;
    String email;
    public Merchant(String merchantName, Integer age)
    {
        this.merchantName=merchantName;
        this.age=age;
    }
}

