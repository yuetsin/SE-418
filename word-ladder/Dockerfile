FROM dockerfile/java:oracle-java8
VOLUME /tmp
ADD target/demo-0.0.1-SNAPSHOT app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=local","/app.jar"]