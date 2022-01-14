# Criando e testando containers Docker

## Criar rede docker para sistema hr
```
docker network create human-resources-net
```

## Testando perfil dev com Postgresql no Docker
```
docker pull postgres:14-alpine

docker run -p 5432:5432 --name human-resources-worker-pg14 --network human-resources-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_human_resources_worker postgres:12-alpine

docker run -p 5433:5432 --name human-resources-user-pg14 --network human-resources-net -e POSTGRES_PASSWORD=1234567 -e POSTGRES_DB=db_human_resources_user postgres:12-alpine
```

## human-resources-config-server
```
FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD ./target/human-resources-config-server-0.0.1-SNAPSHOT.jar human-resources-config-server.jar
ENTRYPOINT ["java","-jar","/human-resources-config-server.jar"]
``` 
```
./mvnw clean package

docker build -t human-resources-config-server:v1 .

docker run -p 8888:8888 --name human-resources-config-server --network human-resources-net -e GITHUB_USER=${GITHUB_USER} -e GITHUB_PASS_KEY=${GITHUB_PASS_KEY} human-resources-config-server:v1
```

## human-resources-eureka-server
```
FROM openjdk:11
VOLUME /tmp
EXPOSE 8761
ADD ./target/human-resources-eureka-server-0.0.1-SNAPSHOT.jar human-resources-eureka-server.jar
ENTRYPOINT ["java","-jar","/human-resources-eureka-server.jar"]
``` 
```
./mvnw clean package

docker build -t human-resources-eureka-server:v1 .

docker run -p 8761:8761 --name human-resources-eureka-server --network human-resources-net human-resources-eureka-server:v1
```

## human-resources-worker
```
FROM openjdk:11
VOLUME /tmp
ADD ./target/human-resources-worker-0.0.1-SNAPSHOT.jar human-resources-worker.jar
ENTRYPOINT ["java","-jar","/human-resources-worker.jar"]
``` 
```
./mvnw clean package -DskipTests

docker build -t human-resources-worker:v1 .

docker run -P --network human-resources-net human-resources-worker:v1
```

## human-resources-user
```
FROM openjdk:11
VOLUME /tmp
ADD ./target/human-resources-user-0.0.1-SNAPSHOT.jar human-resources-user.jar
ENTRYPOINT ["java","-jar","/human-resources-user.jar"]
``` 
```
./mvnw clean package -DskipTests

docker build -t human-resources-user:v1 .

docker run -P --network human-resources-net human-resources-user:v1
```

## human-resources-payroll
```
FROM openjdk:11
VOLUME /tmp
ADD ./target/human-resources-payroll-0.0.1-SNAPSHOT.jar human-resources-payroll.jar
ENTRYPOINT ["java","-jar","/human-resources-payroll.jar"]
``` 
```
./mvnw clean package -DskipTests

docker build -t human-resources-payroll:v1 .

docker run -P --network human-resources-net human-resources-payroll:v1
```

## human-resources-oauth
```
FROM openjdk:11
VOLUME /tmp
ADD ./target/human-resources-oauth-0.0.1-SNAPSHOT.jar human-resources-oauth.jar
ENTRYPOINT ["java","-jar","/human-resources-oauth.jar"]
``` 
```
./mvnw clean package -DskipTests

docker build -t human-resources-oauth:v1 .

docker run -P --network human-resources-net human-resources-oauth:v1
```

## human-resources-api-gateway-zuul
```
FROM openjdk:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/human-resources-api-gateway-zuul-0.0.1-SNAPSHOT.jar human-resources-api-gateway-zuul.jar
ENTRYPOINT ["java","-jar","/human-resources-api-gateway-zuul.jar"]
``` 
```
./mvnw clean package -DskipTests

docker build -t human-resources-api-gateway-zuul:v1 .

docker run -p 8765:8765 --name human-resources-api-gateway-zuul --network human-resources-net human-resources-api-gateway-zuul:v1
```

## Alguns comandos Docker
Criar uma rede Docker
```
docker network create <nome-da-rede>
```
Baixar imagem do Dockerhub
```
docker pull <nome-da-imagem:tag>
```
Ver imagens
```
docker images
```
Criar/rodar um container de uma imagem
```
docker run -p <porta-externa>:<porta-interna> --name <nome-do-container> --network <nome-da-rede> <nome-da-imagem:tag> 
```
Listar containers
```
docker ps

docker ps -a
```
Acompanhar logs do container em execução
```
docker logs -f <container-id>
```