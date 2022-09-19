package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@Entity
@Table(name = "BUS_LINE")
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BusLine implements Serializable {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BUS_LINE_SEQ")
	@SequenceGenerator(name = "BUS_LINE_SEQ", sequenceName = "BUS_LINE_SEQ", allocationSize = 1, initialValue = 1)
	Long id;

	@Column(nullable = false)
	Float distance;

	@Column(name = "STOP_STATION_NUMBER", nullable = false)
	Float stopStationNumber;

}
