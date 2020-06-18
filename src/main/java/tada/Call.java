package tada;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Call_table")
public class Call {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long callId;
    private String starting;
    private String destination;

    @PostPersist
    public void onPostPersist(){
        Called called = new Called();
        BeanUtils.copyProperties(this, called);
        called.publishAfterCommit();


        CallCanceled callCanceled = new CallCanceled();
        BeanUtils.copyProperties(this, callCanceled);
        callCanceled.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        tada.external.Driving driving = new tada.external.Driving();
        // mappings goes here
        Application.applicationContext.getBean(tada.external.DrivingService.class)
            .cancelDriving(driving);


    }


    public Long getCallId() {
        return callId;
    }

    public void setCallId(Long callId) {
        this.callId = callId;
    }
    public String getStarting() {
        return starting;
    }

    public void setStarting(String starting) {
        this.starting = starting;
    }
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }




}
