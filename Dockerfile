FROM eclipse-temurin:17-jre
COPY target/lookup-api.jar lookup-api.jar
ENTRYPOINT ["java","-jar","/lookup-api.jar"]