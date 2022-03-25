FROM gradle:6.9.1-jdk11 as compile

COPY . /home/source/java

WORKDIR /home/source/java

# Default gradle user is `gradle`. We need to add permission on working directory for gradle to build.
USER root

RUN chown -R gradle /home/source/java

USER gradle

RUN gradle clean build -x test


# Start with a base image containing Java runtime
FROM openjdk:11.0.7-jre-slim

WORKDIR /home/application/java

COPY --from=compile "/home/source/java/build/libs/myproject-0.0.1-SNAPSHOT.jar" .

EXPOSE 8090

# Run the jar file
ENTRYPOINT [ "sh", "-c", "java ${JAVA_AGENT} -Dspring.profiles.active=${PROFILE_ACTIVE} -Djava.security.egd=file:/dev/./urandom -jar /home/application/java/myproject-0.0.1-SNAPSHOT.jar" ]
