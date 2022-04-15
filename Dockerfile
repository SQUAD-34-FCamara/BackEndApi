FROM openjdk:11
ADD target/api-squad-kotlin.jar api-squad-kotlin.jar
ENTRYPOINT ["java", "-jar","api-squad-kotlin.jar"]
EXPOSE 8080