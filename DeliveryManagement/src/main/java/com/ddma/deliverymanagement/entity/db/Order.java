package com.ddma.deliverymanagement.entity.db;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "order_num")
    @JsonProperty("order_num")
    private String ordernum;

    @Column(name = "destination_longitude")
    @JsonProperty("destination_longitude")
    private String destinationLongitude;

    @Column(name = "destination_latitude")
    @JsonProperty("destination_latitude")
    private String destinationLatitude;

    @Column(name = "weight")
    @JsonProperty("weight")
    private String weight;

    @Column(name = "drone_type")
    @JsonProperty("drone_type")
    private String droneType;

    @Column(name = "amount")
    @JsonProperty("amount")
    private String amount;

    @Column(name = "distance")
    @JsonProperty("distance")
    private String distance;

    @Column(name = "order_status")
    @JsonProperty("order_status")
    private String orderStatus;
    // fk need work on

    @ManyToOne
    private User userId;

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(String ordernum) {
        this.ordernum = ordernum;
    }

    public String getDestinationLongitude() {
        return destinationLongitude;
    }

    public void setDestinationLongitude(String destinationLongitude) {
        this.destinationLongitude = destinationLongitude;
    }

    public String getDestinationLatitude() {
        return destinationLatitude;
    }

    public void setDestinationLatitude(String destinationLatitude) {
        this.destinationLatitude = destinationLatitude;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDroneType() {
        return droneType;
    }

    public void setDroneType(String droneType) {
        this.droneType = droneType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
