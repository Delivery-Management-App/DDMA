package com.ddma.deliverymanagement.entity.db;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.search.annotations.*;
import org.hibernate.search.spatial.Coordinates;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "dispatch_station")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Spatial
public class DispatchStation implements Serializable {
    @Id
    private Long stationId;

    @Latitude
    private Double latitude;

    @Longitude
    private Double longitude;

    @OneToMany(mappedBy = "dispatch_station")
    private Set<Robot> robotSet;


    public void setStationId(Long stationId) {
        this.stationId = stationId;
    }

    public Long getStationId() {
        return stationId;
    }

    public Set<Robot> getRobotSet() {
        return robotSet;
    }

    public void setRobotSet(Set<Robot> robotSet) {
        this.robotSet = robotSet;
    }
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
