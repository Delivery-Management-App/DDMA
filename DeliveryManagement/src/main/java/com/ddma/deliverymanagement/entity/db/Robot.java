package com.ddma.deliverymanagement.entity.db;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;


/*
create table robot (
        id integer not null auto_increment,
        load integer not null,
        drone_type varchar(255),
        dispatch_station_id varchar(255),
        primary key (id)) engine=InnoDB
*/
@Entity
@Table(name = "robots")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Robot implements Serializable {

    //https://www.baeldung.com/java-serial-version-uid
    private static final long serialVersionUID = 1L;

    @Id
    @PrimaryKeyJoinColumn
    @JsonProperty("id")
    private String id;

    @Column(name = "load")
    @JsonProperty("load")
    private int load;

    @Column(name = "dispatch_station_id")
    @JsonProperty("dispatch_station_id")
    private String dispatchStationId;

    @Enumerated(value = EnumType.STRING)
    @JsonProperty("item_type")
    private RobotType type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    public String getDispatchStationId() {
        return dispatchStationId;
    }

    public void setDispatchStationId(String dispatchStationId) {
        this.dispatchStationId = dispatchStationId;
    }

    public RobotType getType() {
        return type;
    }

    public void setType(RobotType type) {
        this.type = type;
    }
}

