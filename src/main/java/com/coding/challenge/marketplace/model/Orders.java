package com.coding.challenge.marketplace.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@ApiModel(description = "represents the order scheme")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Customer identifier")
    private Long clientId;
    @ApiModelProperty(notes = "Creation time")
    private Date date;
    @ApiModelProperty(notes = "Address customer")
    private String direction;
    @ApiModelProperty(notes = "Total Amount for the order")
    private Double totalAmount;
    @ApiModelProperty(notes = "Shipping status")
    private Boolean shippingStatus;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", fetch = FetchType.EAGER)
    @ApiModelProperty(notes = "Related products")
    private List<Products> products;

    public Orders() {
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Boolean getShippingStatus() {
        return shippingStatus;
    }

    public void setShippingStatus(Boolean shippingStatus) {
        this.shippingStatus = shippingStatus;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

}
