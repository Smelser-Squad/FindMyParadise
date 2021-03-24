# FROM openjdk:11
# RUN addgroup --system spring && adduser --system --group spring
# USER spring:spring
# ARG DEPENDENCY=target/dependency
# COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
# COPY ${DEPENDENCY}/META-INF /app/META-INF
# COPY ${DEPENDENCY}/BOOT-INF/classes /app
# ENTRYPOINT ["java","-cp","app:app/lib/*","Findmyparadise.Application"]

FROM adoptopenjdk:11-jre-hotspot as builder
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk:11-jre-hotspot
# RUN addgroup --system spring && adduser --system --group spring
# USER spring:spring
COPY --from=builder dependencies/ ./
COPY --from=builder snapshot-dependencies/ ./
COPY --from=builder spring-boot-loader/ ./
COPY --from=builder application/ ./
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]

# FROM openjdk:11
# ARG JAR_FILE=target/*.jar
# COPY ${JAR_FILE} app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]