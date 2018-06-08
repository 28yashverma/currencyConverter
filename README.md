# currencyConverter
This is a currency converter application consuming exposed api's by various end points on the internet

#Steps to build this application
As this application is already hosted on Pivotal Cloud Foundry, only a commit is necessary to push up the changes to the repo
From the repo it is picked up via Travis CI which in an Integration platform

Travis CI builds up the project and push it to the Cloud foundry platform

The URL of the application is - 

#Alternate run of the application - 
If you need to run this application locally on system for development or enhancement purposes 

1) Import the project 
2) Run as Maven Install (Make sure you have the JDK in your build path)
3) Run as Spring boot application or normal Java Application since this is an boot application
4) If you need to run this on a separate tomcat
5) Make sure the spring-boot-starter-tomcat dependency scope is 'provided' and packaging is set as WAR
6) After Maven Install you can find the WAR for this application in target folder
7) Copy that war file into the webapps section of tomcat
8) start tomcat 

