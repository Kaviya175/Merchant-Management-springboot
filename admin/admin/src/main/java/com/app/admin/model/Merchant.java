package com.app.admin.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Merchant {

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
