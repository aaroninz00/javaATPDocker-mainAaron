FROM openjdk:22
VOLUME /tmp
EXPOSE 9898
COPY target/MicroserviceDemo-0.0.1-SNAPSHOT.jar MicroserviceDemo.jar
ENTRYPOINT ["java","-jar","MicroserviceDemo.jar"]