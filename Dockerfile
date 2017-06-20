FROM openjdk:jdk-alpine

RUN apk --no-cache add curl

RUN addgroup -g 1000 spring_boot && \
    adduser -g 1000 -s /bin/sh -h /spring_boot -D -G spring_boot spring_boot

COPY target/*.jar /spring_boot
COPY entrydocker.sh /spring_boot
COPY healthcheck.sh /spring_boot

USER spring_boot

ENV JAVA_OPTS="-Xms1G"

WORKDIR /spring_boot

EXPOSE 8080

CMD /spring_boot/entrydocker.sh

HEALTHCHECK --interval=30s --timeout=10s --retries=3 CMD /spring_boot/healthcheck.sh 2>&1
