


package com.jsp.ai.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.jsp.ai.Entity.OrderEntity;

public interface OrderRepository
        extends JpaRepository<OrderEntity, BigInteger> {

    @Modifying
    @Transactional
    @Query("UPDATE OrderEntity o SET o.orderstatus = 'cancelled' WHERE o.orderid = :orderId")
    int updateOrderStatus(@Param("orderId") BigInteger orderId);
}
