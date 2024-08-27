#Start with a base image containing Java runtime
FROM eclipse-temurin:21

#Information around who maintains the image
LABEL "org.opencontainers.image.authors"="suyashs52"

# Add the application's jar to the image
COPY build/libs/loan-service-0.0.1.jar loan-service-0.0.1.jar

# execute the application
ENTRYPOINT ["java", "-jar", "loan-service-0.0.1.jar"]