docker build --file=Dockerfile --tag=dao-service:latest --rm=true .

C:\minikube\istio-1.0.1-win\bin\istioctl.exe kube-inject -f dao-service.yml > istio-dao-service.yml

kubectl.exe apply -f .\kubernetes\istio-dao-service.yml