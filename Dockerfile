FROM eclipse-temurin:17
COPY target/Forum-0.0.1-SNAPSHOT.jar forum.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","forum.jar"]