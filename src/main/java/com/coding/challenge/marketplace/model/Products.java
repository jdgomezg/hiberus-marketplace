package com.coding.challenge.marketplace.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@ApiModel(description = "represents the products scheme")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Product identifier")
    private int id;
    @ApiModelProperty(notes = "Product quantity")
    private int quantity;
    @ApiModelProperty(notes = "Product cost")
    private double cost;
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_CLIENT_ID", nullable = false, updatable = false)
    @ApiModelProperty(notes = "Related order")
    @JsonBackReference
    private Orders order;

    public Products() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }
}
