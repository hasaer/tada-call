
package tada.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name="driving", url="http://driving:8080")
public interface DrivingService {

    @RequestMapping(method= RequestMethod.PATCH, path="/drivings")
    public void cancelDriving(@RequestBody Driving driving);

}