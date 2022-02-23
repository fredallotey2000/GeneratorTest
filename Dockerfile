
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM adoptopenjdk/openjdk11:ubi
ENV APP_HOME=/usr/app/
workdir $APP_HOME
COPY target/*.jar app.jar
expose 8080
CMD ["java","-jar","app.jar"]
