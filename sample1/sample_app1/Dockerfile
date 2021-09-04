# マルチステージビルド
FROM maven:3.8.2-jdk-8 as builder
COPY . /usr/src/
WORKDIR /usr/src/
RUN mvn clean
RUN mvn install -Dmaven.test.skip=true

FROM amazoncorretto:8
VOLUME /tmp
COPY --from=builder /usr/src/target/sample1-0.0.1-SNAPSHOT.jar sample1-0.0.1.jar
ENTRYPOINT ["java","-jar","sample1-0.0.1.jar"]