FROM openjdk:jdk-alpine

RUN apk --no-cache add curl

RUN addgroup -g 1000  && \
    adduser -g 1000 -s spring-boot /bin/sh -h /spring-boot -D -G spring-boot

COPY target/*.jar  /spring-boot

USER spring-boot

ENV JAVA_OPTS="-Xms1G"

EXPOSE 8080

CMD java $JAVA_OPTS -jar spring-boot-0.0.1-SNAPSHOT.jar

