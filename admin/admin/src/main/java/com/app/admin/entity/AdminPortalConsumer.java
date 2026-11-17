package com.app.admin.entity;


import com.app.admin.model.Merchant;
import com.app.admin.model.ModelRequest;
import com.app.admin.model.ModelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "merchant",url = "http://localhost:8081/merchant")
public interface AdminPortalConsumer {
    @GetMapping("/nameAndAge/{mobileNo}")
    public ResponseEntity<Merchant> getNameAndAge(@PathVariable String mobileNo);

    @PostMapping("/create/account")
    public ResponseEntity<ModelResponse> createAccount(@RequestBody ModelRequest modelRequest);
}
