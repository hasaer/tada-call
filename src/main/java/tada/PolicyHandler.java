package tada;

import tada.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired
    CallRepository callRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onEvent(@Payload String message) { }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDrivingCreated_MappingId(@Payload DrivingCreated drivingCreated){

        if(drivingCreated.isMe()){
            System.out.println("##### listener MappingId : " + drivingCreated.toJson());
            Call call = callRepository.findByCallId(drivingCreated.getCallId());
            call.setCallStatus("Called");
            call.setDrivingId(drivingCreated.getDrivingId());
            callRepository.save(call);
        }

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverDrivingFinished_ChangeStatus(@Payload DrivingFinished drivingFinished){

        if(drivingFinished.isMe()){
            System.out.println("##### listener ChangeStatus : " + drivingFinished.toJson());
            Call call = callRepository.findByCallId(drivingFinished.getCallId());
            call.setCallStatus("Finished");
            callRepository.save(call);
        }
    }
}
