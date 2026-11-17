package com.app.merchant.model;

import lombok.Data;

@Data
public class ModelRequest {
    private Merchant merchant;
    private Address address;
}
