FROM maven:3.8.2-jdk-11 as builder
COPY . /usr/src/
WORKDIR /usr/src/
RUN mvn clean
RUN mvn install -Dmaven.test.skip=true

FROM amazoncorretto:11
VOLUME /tmp
COPY --from=builder /usr/src/target/sample5-0.0.1-SNAPSHOT.jar sample5-0.0.1.jar
ENTRYPOINT ["java","-jar","sample5-0.0.1.jar"]