FROM java:8

EXPOSE 8080

ARG JAR_FILE=build/libs/rest-exam-0.0.1.jar

ADD ${JAR_FILE} rest-exam.jar

RUN touch /tmp/healthy  # To control readiness of container

ENTRYPOINT ["java","-jar", "/rest-exam.jar"]

