package com.app.merchant.service;

import com.app.merchant.exception.InvalidAddressException;
import com.app.merchant.model.Address;
import com.app.merchant.model.Merchant;
import com.app.merchant.model.ModelRequest;
import com.app.merchant.model.ModelResponse;
import com.app.merchant.repository.AddressRepo;
import com.app.merchant.repository.MerchantRepo;
import com.app.merchant.util.CacheUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class Service implements MerchantServiceInf {

    @Autowired
    MerchantRepo merchantRepo;

    @Autowired
    AddressRepo addressRepo;

    @Autowired
    CacheUtil  cacheUtil;

    @Override
    public String getMerchantInfo(String merchantId, String mobileNo) {
        String merchantName=null;
        if(merchantId.equalsIgnoreCase("1234"))
        {
            merchantName="Kaviya";
        }
        return merchantName;
    }

    @Override
    @Transactional
    public ModelResponse createMerchant(ModelRequest modelRequest) {

        Merchant merchant=modelRequest.getMerchant();
        Address address=modelRequest.getAddress();
        merchantRepo.save(generateMerchantId(modelRequest.getMerchant()));
        if(address.getState().equalsIgnoreCase("Karnataka"))
        {
            addressRepo.save(modelRequest.getAddress());
        }

        return new ModelResponse(merchant);
    }

    @Override
    public Merchant getMerchantDetail(Integer id) {
        return merchantRepo.findById(id).get();
    }

    @Override
    public Merchant getMerchantsByMob(String mobNo) {
        return merchantRepo.getMerchantsByMob(mobNo);
    }

    @Override
    public List<Merchant> createAllMerchants(List<Merchant> merchant) {
        return merchantRepo.saveAll(merchant.stream().map(this::generateMerchantId).toList());
    }

    @Override
    public Merchant getNameAndAge(String mobileNo) {
        return merchantRepo.getNameAndAge(mobileNo);
    }

    public Merchant generateMerchantId(Merchant merchant) {
        double id=  Math.random();
        String merchantId = Double.toString(id).substring(2).substring(0,6);
        merchant.setMerchantId(merchantId);
        return merchant;
    }
}
