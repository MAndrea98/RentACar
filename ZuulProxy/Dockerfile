FROM openjdk:8-jre-alpine
ADD target/ZuulProxy-0.0.1-SNAPSHOT.jar ZuulProxy.jar

EXPOSE 8080

CMD [ "java", "-jar", "ZuulProxy.jar" ]