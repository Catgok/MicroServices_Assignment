package com.catgok.domain.DeliveryAddress.repository;

import com.catgok.domain.DeliveryAddress.entity.DeliveryAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryAddressDao extends JpaRepository<DeliveryAddress, Integer> {
    public List<DeliveryAddress> getDeliveryAddressByUserId(String userId);

    public DeliveryAddress getDeliveryAddressByDaId(Integer daId);

    public void deleteDeliveryAddressByDaId(Integer daId);
}
