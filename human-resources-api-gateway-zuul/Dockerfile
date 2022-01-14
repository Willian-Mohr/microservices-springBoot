FROM openjdk:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/human-resources-api-gateway-zuul-0.0.1-SNAPSHOT.jar human-resources-api-gateway-zuul.jar
ENTRYPOINT ["java","-jar","/human-resources-api-gateway-zuul.jar"]