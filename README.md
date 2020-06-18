http POST localhost:8088/calls starting=A destination=Z charge=100 callStatus=Called

http GET localhost:8088/myPayments/1

http PUT localhost:8088/calls/1 starting=A destination=Z charge=100 callStatus=Canceled drivingId=1

http GET localhost:8088/myPayments/1

----

http POST localhost:8088/calls starting=A destination=Z charge=101 callStatus=Called

http GET localhost:8088/myPayments/2

http PUT localhost:8088/drivings/2 callId=2 starting=A destination=Z charge=101 drivingStatus=Finished
