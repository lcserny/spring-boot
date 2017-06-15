FROM openjdk:jdk-alpine

RUN apk --no-cache add curl

RUN addgroup -g 1000 spring_boot && \
    adduser -g 1000 -s /bin/sh -h /spring_boot -D -G spring_boot spring_boot

COPY target/*.jar /spring_boot
COPY entrydocker.sh /spring_boot

USER spring_boot

ENV JAVA_OPTS="-Xms1G"

WORKDIR /spring_boot

EXPOSE 8080

CMD /string_boot/entrydocker.sh

