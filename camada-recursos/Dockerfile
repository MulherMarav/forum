FROM khipu/openjdk17-alpine
EXPOSE 8080
ADD /target/forum-0.0.1-SNAPSHOT.jar forum.jar
ENTRYPOINT ["java","-jar","/forum.jar"]


## mvn package
## docker build -t forum -f Dockerfile .
## docker run -p 3000:8080 forum