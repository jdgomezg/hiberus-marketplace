package com.coding.challenge.marketplace.service;

import com.coding.challenge.marketplace.config.MarketPlacerException;
import com.coding.challenge.marketplace.model.Orders;
import com.coding.challenge.marketplace.model.Products;

import java.util.List;

public interface OrderServiceInterface {
    /**
     * get all orders in database
     *
     * @return @{@link List}
     * @throws MarketPlacerException
     */
    public List getAllOrders() throws MarketPlacerException;

    /**
     * persist an order
     *
     * @param order data to persist
     * @return @{@link Boolean}
     * @throws MarketPlacerException
     */
    public Boolean insertOrder(Orders order) throws MarketPlacerException;


    /**
     * @param clientId identifier of element to find
     * @return @{@link Object}
     * @throws MarketPlacerException
     */
    public Orders getOrderByClientId(Long clientId) throws MarketPlacerException;
}
