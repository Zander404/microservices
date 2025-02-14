FROM maven as build
WORKDIR /build
COPY . .
RUN mvn clean package -DskipTests


FROM openjdk:21

WORKDIR /app
COPY --from=build ./build/target/*.jar ./app.jar
EXPOSE 8761
ENTRYPOINT java -jar app.jar