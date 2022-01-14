FROM openjdk:11
VOLUME /tmp
ADD ./target/human-resources-user-0.0.1-SNAPSHOT.jar human-resources-user.jar
ENTRYPOINT ["java","-jar","/human-resources-user.jar"]