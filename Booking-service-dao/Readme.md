docker build --file=Dockerfile --tag=dao-service:latest --rm=true .

C:\minikube\istio_0.5.1_win\bin\istioctl.exe kube-inject -f dao-service.yml > istio-dao-service.yml

kubectl.exe apply -f .\kubernetes\istio-dao-service.yml