FROM openjdk:11
VOLUME /tmp
EXPOSE 8888
ADD ./target/human-resources-config-server-0.0.1-SNAPSHOT.jar human-resources-config-server.jar
ENTRYPOINT ["java","-jar","/human-resources-config-server.jar"]