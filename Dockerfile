FROM openjdk:17-jdk-alpine3.14

COPY "./target/algrelatives.jar" "/application/algrelatives.jar"

CMD ["java", "-jar", "/application/algrelatives.jar"]
