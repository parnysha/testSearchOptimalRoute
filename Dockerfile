FROM openjdk:17-alpine
ARG JAR_FILE=target/testovoe-0.0.1-SNAPSHOT.jar
ARG TEST_FILE=Тестовое.docx
WORKDIR /opt/a
COPY ${JAR_FILE} app.jar
COPY ${TEST_FILE} Тестовое.docx
ENTRYPOINT ["java","-jar","app.jar"]