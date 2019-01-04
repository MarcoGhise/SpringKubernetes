docker build --file=Dockerfile --tag=booking-dao:latest --rm=true .

kubectl run booking-dao --image=booking-dao:latest --port=2222 --image-pull-policy Never
kubectl run mongo --image=library/mongo:latest --port=27017
oppure
kubectl create -f kubernetes/dao-service.yml

kubectl get ing

kubectl expose deployment booking-dao --type=LoadBalancer --port=2222 --target-port=2222
kubectl expose deployment mongo --type=LoadBalancer --port=27017 --target-port=27017
kubectl get services
.\minikube.exe service mongo

.\minikube.exe status



=====================

docker pull nhatthai/api-service <== Download image from DockerHub

Create Persitant Volume

$ cd manifests
$ kubectl create -f mongo-pv.yml
$ kubectl get pv

Create Persitant Volume Claim

$ cd manifests
$ kubectl create -f mongo-pvc.yml
$ kubectl get pvc

Create MongoDB Controller

$ cd manifests
$ kubectl create -f mongo-controller.yml

Create MongoDB Service

$ cd manifests
$ kubectl create -f mongo-service.yml

Create API Service Deployment

$ cd manifests
$ kubectl create -f api-deploy.yml

Create API Service

$ cd manifests
$ kubectl create -f api-service.yml

Check Services

$ kubectl describe services

$ kubectl describe replicationcontrollers/mongo-controller

$ kubectl exec -it mongo-controller-vbqf4 -c mongo bash

Enable and Create Ingress

$ minikube addons enable ingress

$ cd manifests
$ kubectl create -f ingress.yml

Add mysite.com into /etc/hosts

$ minikube ip
192.168.99.100

192.168.99.100 mysite.com




DAO
docker build --file=Dockerfile --tag=dao-service:latest --rm=true .

kubectl create -f kubernetes/dao-service.yml