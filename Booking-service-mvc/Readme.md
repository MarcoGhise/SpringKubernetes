docker build --file=Dockerfile --tag=mvc-service:brown --rm=true .

C:\minikube\istio-1.0.1-win\bin\istioctl.exe kube-inject -f mvc-service.yml > istio-mvc-service.yml

kubectl.exe apply -f istio-mvc-service.yml