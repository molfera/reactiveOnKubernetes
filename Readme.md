## Minikube
minikube ssh

(CPUs=2, Memory=7900MB)

## Change minikube config
- minikube config view
- minikube config set cpus 6
- minikube config set memory 16384

## Show image in minikube
- minikube image ls
- docker image ls
- minikube image load `IMAGE`

docker --version

kubectl get pods

kubectl exec --stdin --tty [POD] /bin/bash

# Application
- puml
- https://cloud.mongodb.com/v2/634301ad4fecc079d2e72525#clusters
- configuration in application.properties

## Application from docker-compose

## Start application
### Monitoring
- kubectl
- minikube dashboard
- k9s

### After deploy pods
kubectl get events

kubectl edit deploy main-deployment

### Set pods to 0

## Namespace
### In a namespace
kubectl api-resources --namespaced=true

### Not in a namespace
kubectl api-resources --namespaced=false

### kubens
(https://github.com/ahmetb/kubectx)

### Redeploy application after namespace

## Ingress
minikube addons list

minikube addons enable ingress

Ingress https://kubernetes.io/docs/tasks/access-application-cluster/ingress-minikube/

## Test redeploy user:2
### Roling update 
- replica set to 4
- ab -n 1000 -c 10  http://localhost:8080/main/users

## Istio
https://istio.io/latest/about/service-mesh/
https://istio.io/latest/docs/setup/getting-started/

kubectl label namespace default istio-injection=enabled

istioctl dashboard kiali

----------------------------------

kubectl config set-context minikube --namespace=dev
kubectl delete namespace dev

kubectl apply -f main-deployment.yaml --namespace default

kubectl api-resources --namespaced=false

kubens (https://github.com/ahmetb/kubectx)

kubectl config view


## Links
https://minikube.sigs.k8s.io/docs/handbook/pushing/