FROM openjdk:17-jdk-alpine3.14

COPY "./target/progkorbead-movie.jar" "/application/progkorbead-movie.jar"

CMD ["java", "-jar", "/application/progkorbead-movie.jar"]
