FROM openjdk:1.8
VOLUME /tmp
COPY /target/ProductDeploy-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 8400
ENV JAVA_OPTS=""
RUN sh -c "touch ProductDeploy-0.0.1-SNAPSHOT.jar"
ENTRYPOINT [ "java", "-jar", "ProductDeploy-0.0.1-SNAPSHOT.jar" ]