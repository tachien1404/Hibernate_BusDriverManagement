package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "DRIVER_BUS_MANAGEMENT")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@IdClass(DriverBusManagementPrimaryKey.class)
public class DriverBusManagement implements Serializable{

    @Id
    @Column(name = "driver_id")
    Long driverId;

    @Id
    @Column(name = "bus_line_id")
    Long busLineId;

    @Column(name = "ROUND_NUMBER", nullable = false)
    Integer roundNumber;
    
}
