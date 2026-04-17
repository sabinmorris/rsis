FROM eclipse-temurin:17-jre
COPY target/lookups-api.jar lookups-api.jar
ENTRYPOINT ["java","-jar","/lookups-api.jar"]