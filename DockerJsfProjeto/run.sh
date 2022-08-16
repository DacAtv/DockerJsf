mvn clean package
docker image build -t DockerImagen/app .
docker container run -p 8081:8080 --name app DockerImagen/app