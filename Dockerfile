FROM openjdk:jdk-alpine

RUN apk --no-cache add curl

RUN addgroup -g 1000  && \
    adduser -g 1000 -s spring-boot /bin/sh -h /spring_boot -D -G spring_boot spring_boot

COPY target/*.jar  /spring_boot

USER spring_boot

ENV JAVA_OPTS="-Xms1G"

EXPOSE 8080

CMD java $JAVA_OPTS -jar spring-boot-0.0.1-SNAPSHOT.jar

