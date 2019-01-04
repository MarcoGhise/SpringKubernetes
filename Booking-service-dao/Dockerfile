FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/Booking-service-dao-1.0.jar dao-service.jar
ENV JAVA_OPTS=""
ENTRYPOINT exec java -jar /dao-service.jar --debug
EXPOSE 2222