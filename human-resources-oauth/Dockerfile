FROM openjdk:11
VOLUME /tmp
ADD ./target/human-resources-oauth-0.0.1-SNAPSHOT.jar human-resources-oauth.jar
ENTRYPOINT ["java","-jar","/human-resources-oauth.jar"]