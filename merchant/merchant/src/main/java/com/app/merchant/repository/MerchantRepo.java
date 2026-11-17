package com.app.merchant.repository;

import com.app.merchant.model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

public interface MerchantRepo extends JpaRepository<Merchant,Integer> {
    @Query(value = "select * from merchant where mobile_no=:mobNo", nativeQuery = true)
    Merchant getMerchantsByMob(String mobNo);

    @Query("select new Merchant(merchantName,age) from Merchant m where m.mobileNo=:mobileNo")
    Merchant getNameAndAge(@PathVariable String mobileNo);
}
