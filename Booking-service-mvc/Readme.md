docker build --file=Dockerfile --tag=mvc-service:brown --rm=true .

C:\minikube\istio_0.5.1_win\bin\istioctl.exe kube-inject -f mvc-service.yml > istio-mvc-service.yml

kubectl.exe apply -f .\kubernetes\istio-mvc-service.yml