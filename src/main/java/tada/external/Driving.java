package tada.external;

public class Driving {

    private Long id;
    private String starting;
    private String destination;
    private String drivingStatus;
    private Integer charge;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String getDrivingStatus() {
        return drivingStatus;
    }

    public void setDrivingStatus(String drivingStatus) {
        this.drivingStatus = drivingStatus;
    }
    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

}

