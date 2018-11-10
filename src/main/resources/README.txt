1. Run Application

$ mvn spring-boot:run

$ java -jar target/myproject-1.0-SNAPSHOT.jar

For instance, if you are running your application by using java -jar, you can enable the debug property as follows:

$ java -jar myproject-0.0.1-SNAPSHOT.jar --debug

2. Spring Profiles

You can use a spring.profiles.active Environment property to specify which profiles are active. For example, you could
include it in your application.properties, as shown in the following example:

spring.profiles.active=dev,hsqldb

You could also specify it on the command line by using the following switch: --spring.profiles.active=dev,hsqldb.

Note: Ignore some tests due to mvn clean install not picking up resource files
