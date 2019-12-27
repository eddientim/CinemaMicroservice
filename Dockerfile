FROM openjdk:11

ADD target/cinemamicroservice.jar /app/cinemamicroservice.jar

#Setting up an alternative directory for tmp files tomcat requires it
RUN mkdir - /app/java_tmp

WORKDIR /app

EXPOSE 8000

ENV TZ Europe/London

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-Duser.country=GB", "-Duser.language=en", "-XX:MaxRAMFraction=2", "-Djava.io.tmpdir=/app/java_tmp", "-jar", "cinemamicroservice.jar"]