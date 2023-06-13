package com.catgok.domain.DeliveryAddress.service;

import com.catgok.domain.DeliveryAddress.entity.DeliveryAddress;
import com.catgok.domain.DeliveryAddress.repository.DeliveryAddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAddressDomainService {
    @Autowired
    DeliveryAddressDao deliveryAddressDao;

    public List<DeliveryAddress> listDeliveryAddressByUserId(String userId) {
        return deliveryAddressDao.getDeliveryAddressByUserId(userId);
    }

    public DeliveryAddress getDeliveryAddressById(Integer daId) {
        return deliveryAddressDao.getDeliveryAddressByDaId(daId);
    }

    public int saveDeliveryAddress(DeliveryAddress deliveryAddress) {
        try {
            deliveryAddressDao.save(deliveryAddress);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateDeliveryAddress(DeliveryAddress deliveryAddress) {
        try {
            deliveryAddressDao.save(deliveryAddress);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int removeDeliveryAddress(Integer daId) {
        try {
            deliveryAddressDao.deleteDeliveryAddressByDaId(daId);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
