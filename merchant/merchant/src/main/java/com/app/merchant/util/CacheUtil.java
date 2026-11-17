package com.app.merchant.util;

import com.app.merchant.model.Merchant;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component

public class CacheUtil {
    private Map<String, Merchant> map = new ConcurrentHashMap<>();
    public boolean containsMerchant(String key) {
        return map.containsKey(key);
    }
    public Merchant getMerchant(String key) {
        return map.get(key);
    }
    public void putMerchant(String mobNo,Merchant merchant) {
        map.put(mobNo, merchant);
    }
}
