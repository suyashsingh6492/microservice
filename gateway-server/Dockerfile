#Start with a base image containing Java runtime
FROM eclipse-temurin:21

#Information around who maintains the image
LABEL "org.opencontainers.image.authors"="suyashs52"

# Add the application's jar to the image
COPY build/libs/gateway-server-0.0.1-SNAPSHOT.jar gateway-server-0.0.1.jar

# execute the application
ENTRYPOINT ["java", "-jar", "gateway-server-0.0.1.jar"]