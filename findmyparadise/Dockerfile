FROM maven:3.6.3-jdk-11 AS builder
WORKDIR /server
COPY pom.xml /server/pom.xml
RUN mvn dependency:go-offline

COPY src /server/src
RUN mvn install
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} target/application.jar
WORKDIR /server/target
RUN java -Djarmode=layertools -jar application.jar extract
# RUN jar -xf ../*.jar

# FROM adoptopenjdk:11-jre-hotspot as builder
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} application.jar
# RUN java -Djarmode=layertools -jar application.jar extract

FROM openjdk:11-jre-slim
RUN addgroup --system spring && adduser --system --group spring
USER spring:spring
ARG DEPENDENCY=/server/target
COPY --from=builder ${DEPENDENCY}/dependencies/ ./
COPY --from=builder ${DEPENDENCY}/snapshot-dependencies/ ./
COPY --from=builder ${DEPENDENCY}/spring-boot-loader/ ./
COPY --from=builder ${DEPENDENCY}/application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]