<h1>주제</h1>
<h3>택시 호출 서비스</h3>

<h1>요구사항</h1>
<h2>기능적 요구사항</h2>

1. 고객이 택시를 호출한다.
1. 호출 정보를 토대로 운행이 생성된다.
1. 운행이 생성되면 운임이 결제된다.
1. 고객은 호출을 취소할 수 있다.
1. 호출이 취소되면 운행은 취소 상태로 변경된다.
1. 운행이 취소 상태로 변경되면 결제는 취소된다.
1. 목적지 도착 시 기사는 운행을 종료할 수 있다.

<h2>비기능적 요구사항</h2>

1. 고객이 자주 확인할 수 있는 결제 내역은 대시보드에서 확인할 수 있어야 한다.
1. 운행 및 결제 서비스가 수행되지 않더라도, 호출은 24/7 가능해야 한다.
1. 운행이 생성되기 전까지 호출 상태는 확정되지 않는다.

<h2>Event Storming</h2>

<img src="https://user-images.githubusercontent.com/14112255/85084997-6b250d80-b211-11ea-84f9-9ee5b813ddf6.png">

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

