
package tada.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="driving", url="http://localhost:8082")
public interface DrivingService {

    @RequestMapping(method= RequestMethod.PUT, value="/drivings/{drivingId}")
    public void cancelDriving(@PathVariable("drivingId") final Long drivingId, @RequestBody Driving driving);

}