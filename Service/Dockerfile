FROM camunda/zeebe-simple-monitor:0.17.0-alpha1 as source

FROM openjdk:11-jre

VOLUME /tmp
ADD target/service.jar service.jar

ENTRYPOINT ["java","-jar","service.jar"]
