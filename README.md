http POST localhost:8088/calls starting=A destination=Z charge=100 callStatus=Called

http GET localhost:8088/myPayments/1

http PUT localhost:8088/calls/1 starting=A destination=Z charge=100 callStatus=Canceled drivingId=1

http GET localhost:8088/myPayments/1

----

http POST localhost:8088/calls starting=A destination=Z charge=101 callStatus=Called

http GET localhost:8088/myPayments/2

http PUT localhost:8088/drivings/2 callId=2 starting=A destination=Z charge=101 drivingStatus=Finished

----

AKIAT6IQHQ7SJQUW3EHS

wvnvGkl9/5voOOb6fjtr6XagpoBd7/AIMaGx2Gua

----

Local에 EKS 클러스터 접속정보 설정 ~

https://workflowy.com/s/msa/27a0ioMCzlpV04Ib#/64eb06e54637

----

