package com.coding.challenge.marketplace.controller;

import com.coding.challenge.marketplace.model.Orders;
import com.coding.challenge.marketplace.service.OrderServiceInterface;
import com.coding.challenge.marketplace.util.Constants;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping(value = "marketplace")
public class OrderController {
    @Autowired
    OrderServiceInterface orderServiceInterface;

    @RequestMapping(value = "/createOrder", method = RequestMethod.POST)
    @ApiOperation(value = "Allows entering a purchase order", response = Object.class)
    @ApiResponses(value = {
            @ApiResponse(code = Constants.STATUS_CREATED, message = Constants.STATUS_CREATED_MESSAGE),
            @ApiResponse(code = Constants.STATUS_FAILED, message = Constants.STATUS_FAILED_MESSAGE)
    })
    @PostMapping(value = "createOrder", produces = Constants.APPLICATION_JSON)
    @ResponseBody
    @CrossOrigin
    public ResponseEntity makeOrder(@RequestBody Orders order) {
        orderServiceInterface.insertOrder(order);
        return ResponseEntity.status(Constants.STATUS_CREATED).build();
    }

    @RequestMapping(value = "/getOrders", method = RequestMethod.GET)
    @ApiOperation(value = "Get all the orders in the database", response = Object.class)
    @ApiResponses(value = {
            @ApiResponse(code = Constants.STATUS_OK, message = Constants.STATUS_OK_MESSAGE),
            @ApiResponse(code = Constants.STATUS_FAILED, message = Constants.STATUS_FAILED_MESSAGE)
    })
    @GetMapping(value = "getOrders", produces = Constants.APPLICATION_JSON)
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<List> getOrders() {
        return ResponseEntity.ok().body(orderServiceInterface.getAllOrders());
    }

    @RequestMapping(value = "/getOrderById/{clientId}", method = RequestMethod.GET)
    @ApiOperation(value = "Get specific order in the database", response = Object.class)
    @ApiResponses(value = {
            @ApiResponse(code = Constants.STATUS_OK, message = Constants.STATUS_OK_MESSAGE),
            @ApiResponse(code = Constants.STATUS_FAILED, message = Constants.STATUS_FAILED_MESSAGE)
    })
    @GetMapping(value = "/getOrderById/{clientId}", produces = Constants.APPLICATION_JSON)
    @ResponseBody
    @CrossOrigin
    public ResponseEntity<Orders> getOrderById(@PathVariable(value = "clientId") Long clientId) {
        return ResponseEntity.ok().body(orderServiceInterface.getOrderByClientId(clientId));
    }
}
