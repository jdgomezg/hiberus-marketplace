package com.coding.challenge.marketplace.service;

import com.coding.challenge.marketplace.config.MarketPlacerException;
import com.coding.challenge.marketplace.model.Orders;
import com.coding.challenge.marketplace.model.Products;
import com.coding.challenge.marketplace.repository.OrdersRepository;
import com.coding.challenge.marketplace.repository.ProductsRepository;
import com.coding.challenge.marketplace.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderServiceInterface {

    @Autowired
    OrdersRepository ordersRepository;

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public List getAllOrders() throws MarketPlacerException {
        return ordersRepository.findAll();
    }

    @Override
    public Boolean insertOrder(Orders order) throws MarketPlacerException {
        order.setShippingStatus(Boolean.TRUE);
        order.setTotalAmount(invoicing(order.getProducts()));
        ordersRepository.save(order);
        return Boolean.TRUE;
    }

    private Double invoicing(List<Products> products) throws MarketPlacerException {
        //TODO implemets call to other microservice checkout
        Double totalAmount = 0.0;
        for (Products product : products) {
            totalAmount = totalAmount + product.getCost();
        }
        return totalAmount;
    }

    @Override
    public Orders getOrderByClientId(Long clientId) throws MarketPlacerException {
        if (clientId == null) {
            throw new MarketPlacerException(Constants.REQUIRED_CUSTOMER);
        }
        Orders orders = ordersRepository.findById(clientId).orElseThrow(() -> new MarketPlacerException(Constants.NO_DATA_FOUND + clientId));
        return orders;
    }

}
