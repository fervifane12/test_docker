FROM azul/zulu-openjdk:21-jre
ARG JAR_FILE=target/Exercise-2-0.0.1.jar
COPY ${JAR_FILE} Exercise-2.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "Exercise-2.jar"]