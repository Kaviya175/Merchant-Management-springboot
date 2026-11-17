package com.app.admin.service;

import com.app.admin.entity.AdminPortalConsumer;
import com.app.admin.model.Merchant;
import com.app.admin.model.ModelRequest;
import com.app.admin.model.ModelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AdminPortalConsumer adminPortalConsumer;
    public Merchant getMerchantsByMob(String mobNo) {
        ResponseEntity<Merchant> adminResp= restTemplate.exchange("http://localhost:8081/merchant/mobNo/" + mobNo,
                HttpMethod.GET, null, Merchant.class);
        return adminResp.getBody();
    }

    public ModelResponse createMerchant(ModelRequest modelRequest) {
        return adminPortalConsumer.createAccount(modelRequest).getBody();
    }

    public Merchant getNameAndAge(String mobileNo) {
        return adminPortalConsumer.getNameAndAge(mobileNo).getBody();
    }
}
