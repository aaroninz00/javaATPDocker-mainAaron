docker build -t microservice-image:latest .
docker run -it --name microservice-container -p 9898:9898 microservice-image:latest