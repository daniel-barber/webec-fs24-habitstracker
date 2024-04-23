FROM adoptium/temurin:21-slim

WORKDIR /app

COPY build.gradle ./
COPY pom.xml ./

RUN gradle clean dependencies

COPY src .

RUN gradle build

EXPOSE 8080

CMD ["java", "-jar", "build/libs/*.jar"]
