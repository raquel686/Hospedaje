FROMopenjdk:8-jdk-alpine
#Runasanon-rootusertomitigatesecurityrisks
#https://security.stackexchange.com/questions/106860/can-a-root-user-inside-a-docker-lxc-break-the-security-of-the-whole-system
RUNaddgroup-Sspring&&adduser-Sspring-Gspring
USERspring:spring
ARGJAR_FILE=target/*.jar
COPY${JAR_FILE}app.jar
ENTRYPOINT["java","-jar","/app.jar"]