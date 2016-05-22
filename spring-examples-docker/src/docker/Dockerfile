FROM yingzhuo/java:8
MAINTAINER yingzhuo <yingzhor@gmail.com>
WORKDIR /
ADD spring-examples-docker.jar app.jar
CMD ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]