# Deploy to Kubernetes
kubectl apply -f pricing-microservice-k8.yaml
echo ">> applied kubernetes config file"

# Re-assign the images version to Kubernetes PODs so that the POD re-deploys with latest image
kubectl set image deployments/pricing-microservice-deployment pricing-microservice=aakashkumar1980/pricing-microservice:$GIT_SHA
echo ">> set the container image tag to:"$GIT_SHA