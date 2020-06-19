package tada;

import javax.persistence.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;
import tada.config.kafka.KafkaProcessor;

import java.util.List;

@Entity
@Table(name="Call_table")
public class Call {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long callId;
    private String callStatus;
    private String starting;
    private String destination;

    public Long getDrivingId() {
        return drivingId;
    }

    public void setDrivingId(Long drivingId) {
        this.drivingId = drivingId;
    }

    private Long drivingId;

    public String getCallStatus() {
        return callStatus;
    }

    public void setCallStatus(String callStatus) {
        this.callStatus = callStatus;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    private Integer charge;

    @PostPersist
    public void onPostPersist(){
        Called called = new Called();
        called.setCallId(this.getCallId());
        //called.setCallStatus(this.getCallStatus());
        called.setStarting(this.getStarting());
        called.setDestination(this.getDestination());
        called.setDrivingId(this.getDrivingId());
        called.setCharge(this.getCharge());
//        BeanUtils.copyProperties(this, called);
//        called.publishAfterCommit();

        ObjectMapper objectMapper = new ObjectMapper();
        String json = null;

        try {
            json = objectMapper.writeValueAsString(called);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("JSON format exception", e);
        }

        KafkaProcessor processor = Application.applicationContext.getBean(KafkaProcessor.class);
        MessageChannel outputChannel = processor.outboundTopic();

        outputChannel.send(MessageBuilder
                .withPayload(json)
                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
                .build());
    }

    @PostUpdate
    public void onPostUpdate(){
        if ("Canceled".equals(this.getCallStatus())) {
            CallCanceled callCanceled = new CallCanceled();
            callCanceled.setDrivingId(this.getDrivingId());
//            callCanceled.setCallId(this.getCallId());
//            callCanceled.setCallStatus(this.getCallStatus());
//            callCanceled.setStarting(this.getStarting());
//            callCanceled.setDestination(this.getDestination());
//            callCanceled.setDrivingId(this.getDrivingId());
//            callCanceled.setCharge(this.getCharge());
//
//            ObjectMapper objectMapper = new ObjectMapper();
//            String json = null;
//
//            try {
//                json = objectMapper.writeValueAsString(callCanceled);
//            } catch (JsonProcessingException e) {
//                throw new RuntimeException("JSON format exception", e);
//            }
//
//            KafkaProcessor processor = Application.applicationContext.getBean(KafkaProcessor.class);
//            MessageChannel outputChannel = processor.outboundTopic();
//
//            outputChannel.send(MessageBuilder
//                    .withPayload(json)
//                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)
//                    .build());

            BeanUtils.copyProperties(this, callCanceled);
            callCanceled.publishAfterCommit();
        } else {
            // Mapping DrivingId
        }
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
