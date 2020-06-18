http POST localhost:8081/calls starting=A destination=Z charge=11113 callStatus=Called

http GET localhost:8081/calls/1

http GET localhost:8082/drivings/1

http PUT localhost:8082/drivings/1 drivingId=1 starting=A destination=Z charge=11113 drivingStatus=Finished charge=11113 callId=1

http GET localhost:8081/calls/1
