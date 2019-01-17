docker build --file=Dockerfile --tag=mvc-service:blue --rm=true .

kubectl apply -f kubernetes/mvc-service.yml

Enable and Create Ingress

kubectl create clusterrolebinding default-admin --clusterrole cluster-admin --serviceaccount=default:default 