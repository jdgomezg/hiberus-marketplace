package com.coding.challenge.marketplace.controller;

import com.coding.challenge.marketplace.config.MarketPlacerException;
import com.coding.challenge.marketplace.model.Orders;
import com.coding.challenge.marketplace.service.OrderServiceInterface;
import com.coding.challenge.marketplace.util.Constants;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class OrderControllerTest {
    @InjectMocks
    OrderController orderController;

    @Mock
    OrderServiceInterface orderServiceInterface;

    private List<Orders> orders;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        orders = new ArrayList<>();
        Orders order = new Orders();
        order.setClientId(1L);
        order.setShippingStatus(Boolean.TRUE);
        order.setProducts(new ArrayList<>());
        order.setTotalAmount(100.00);
        order.setDirection("Cra 26 #35-52 2do Piso");
        order.setDate(new Date());
        orders.add(order);
    }

    @Test
    public void makeOrder() throws MarketPlacerException {
        Mockito.when(orderServiceInterface.insertOrder(Mockito.any())).thenReturn(Boolean.TRUE);
        ResponseEntity responseEntity = orderController.makeOrder(new Orders());
        assertEquals(responseEntity.getStatusCodeValue(), Constants.STATUS_CREATED);
    }

    @Test
    public void getOrders() throws MarketPlacerException {
        Mockito.when(orderServiceInterface.getAllOrders()).thenReturn(orders);
        ResponseEntity<List> orders = orderController.getOrders();
        assertEquals(orders.getStatusCodeValue(), Constants.STATUS_OK);
    }

    @Test
    public void getOrderById() {
        Mockito.when(orderServiceInterface.getOrderByClientId(Mockito.anyLong())).thenReturn(orders.get(0));
        ResponseEntity orders = orderController.getOrderById(1L);
        assertEquals(orders.getStatusCodeValue(), Constants.STATUS_OK);
    }

}
