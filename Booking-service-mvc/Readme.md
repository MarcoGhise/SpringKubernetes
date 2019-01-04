docker build --file=Dockerfile --tag=mvc-service:latest --rm=true .

kubectl create -f kubernetes/mvc-service.yml

Enable and Create Ingress

kubectl create clusterrolebinding default-admin --clusterrole cluster-admin --serviceaccount=default:default 