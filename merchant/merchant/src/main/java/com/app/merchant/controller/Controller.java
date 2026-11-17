package com.app.merchant.controller;

import com.app.merchant.model.Merchant;
import com.app.merchant.model.ModelRequest;
import com.app.merchant.model.ModelResponse;
import com.app.merchant.service.MerchantServiceInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/merchant")
@RestController
public class Controller {
    @Autowired
    MerchantServiceInf merchantService;
    @GetMapping("/{merchantId}/info")
    public ResponseEntity<String> getMerchantInfo(@PathVariable("merchantId") String merchantId,
                                                  @RequestParam("mobNo") String mobileNo){

        return new ResponseEntity<>(merchantService.getMerchantInfo(merchantId,mobileNo),HttpStatus.OK);
    }
    @PostMapping("/create/account")
    public ResponseEntity<ModelResponse> createAccount(@RequestBody ModelRequest  modelRequest){
        return new ResponseEntity<>(merchantService.createMerchant(modelRequest), HttpStatus.OK);
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Merchant> getMerchantsDetails(@PathVariable("id") Integer id){
        return new ResponseEntity<>(merchantService.getMerchantDetail(id),HttpStatus.OK);
    }
    @GetMapping("/mobNo/{mobNo}")
    public ResponseEntity<Merchant> getMerchantsByMob(@PathVariable("mobNo") String mobNo){
        return new ResponseEntity<>(merchantService.getMerchantsByMob(mobNo),HttpStatus.OK);
    }
    @PostMapping("/create/account/all")
    public ResponseEntity<List<Merchant>> createAllMerchants(@RequestBody List<Merchant> merchant){
        return new ResponseEntity<>(merchantService.createAllMerchants(merchant),HttpStatus.OK);
    }
    @GetMapping("/nameAndAge/{mobileNo}")
    public ResponseEntity<Merchant> getNameAndAge(@PathVariable String mobileNo)
    {
        return new ResponseEntity<>(merchantService.getNameAndAge(mobileNo), HttpStatus.OK);
    }

}
