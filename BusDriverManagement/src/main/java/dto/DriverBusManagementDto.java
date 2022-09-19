package dto;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

import entity.BusLine;
import entity.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public class DriverBusManagementDto {
	  Driver driver;

	    Map<BusLine, Integer> assignedBuses;

	    float totalDistance;

	    public DriverBusManagementDto(Driver driver, Map<BusLine, Integer> assignedBuses) {
	        this.driver = driver;
	        this.assignedBuses = assignedBuses;
	    }

	    public void setTotalDistance() {
	        if (assignedBuses == null || assignedBuses.isEmpty()) {
	            this.setTotalDistance(0);
	        }
	        AtomicReference<Float> totalDistance = new AtomicReference<>((float) 0);
	        this.assignedBuses.forEach((busLine, round) -> totalDistance.updateAndGet(v -> v + busLine.getDistance() * round));
	        this.totalDistance = totalDistance.get();

	    }
}
