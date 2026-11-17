package com.app.admin.controller;

import com.app.admin.model.Merchant;
import com.app.admin.model.ModelRequest;
import com.app.admin.model.ModelResponse;
import com.app.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;

    @GetMapping("/mobNo/{mobNo}")
    public ResponseEntity<Merchant> getMerchantsByMob(@PathVariable("mobNo") String mobNo){
        return new ResponseEntity<>(adminService.getMerchantsByMob(mobNo), HttpStatus.OK);
    }
    @PostMapping("/create/account")
    public ResponseEntity<ModelResponse> createAccount(@RequestBody ModelRequest modelRequest){
        return new ResponseEntity(adminService.createMerchant(modelRequest), HttpStatus.OK);
    }
    @GetMapping("/nameAndAge/{mobileNo}")
    public ResponseEntity<Merchant> getNameAndAge(@PathVariable String mobileNo)
    {
        return new ResponseEntity<>(adminService.getNameAndAge(mobileNo), HttpStatus.OK);
    }
}
