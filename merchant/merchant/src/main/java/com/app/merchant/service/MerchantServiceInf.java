package com.app.merchant.service;

import com.app.merchant.model.Merchant;
import com.app.merchant.model.ModelRequest;
import com.app.merchant.model.ModelResponse;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface MerchantServiceInf {
    public String getMerchantInfo(String merchantId, String mobileNo);


    ModelResponse createMerchant(ModelRequest modelRequest);

    public Merchant getMerchantDetail(Integer id);

    Merchant getMerchantsByMob(String mobNo);


    List<Merchant> createAllMerchants(List<Merchant> merchant);

    Merchant getNameAndAge(String mobileNo);
}
