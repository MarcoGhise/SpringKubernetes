FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/Booking-service-mvc-blue.jar mvc-service.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar /mvc-service.jar --debug
EXPOSE 80