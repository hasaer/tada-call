package tada;

public class Called extends AbstractEvent {

    private Long callId;
    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    private String callStatus;

    public Long getDrivingId() {
        return drivingId;
    }

    public void setDrivingId(Long drivingId) {
        this.drivingId = drivingId;
    }

    private Long drivingId;

    private String starting;
    private String destination;
    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    private Integer charge;

    public Called(){
        super();
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
