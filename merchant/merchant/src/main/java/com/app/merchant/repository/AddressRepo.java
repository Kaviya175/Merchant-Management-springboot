package com.app.merchant.repository;

import com.app.merchant.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo  extends JpaRepository<Address, Integer> {
}
