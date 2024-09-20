## Spring Boot Notes

1. Spring Boot supports specific java versions: 

	SPRING BOOT: `3.x.x` => JAVA 17 or 21  
	SPRING BOOT: `2.x.x` => JAVA 8 or 11 or 15     
    ONLINE FOOD ORDERING AND DELIVERY SYSTEM: Spring Boot Version: `2.7.13`  

2. A version with the suffix "SNAPSHOT" indicates that it is a development version or a version under active development.

3. To check the installation path of a specific Java version on your system, 
	Windows: `where java`
	Linux/macOS: `which java`

4. 	**Dependencies**
	1. Spring Web
	2. Spring Data JPA
	3. MySQL Driver


5. ### Steps to run Spring Boot Project:
	1. Right Click -> maven -> Force Update
	2. To clean, Run as -> Maven Clean
				 Project -> Clean... [*If getting ClassNotFoundException, Clean the Project*]
	3. Run as -> Spring Boot Project

6. 	Default port 8080
	
7. **White Label Error Page** 
	A "Whitelabel Error Page" typically indicates that an **unhandled exception** occurred in a Spring Boot application. When you see this error, it means that **Spring Boot's default error handling mechanism** has kicked in and it's displaying a generic error page instead of the expected application page.	


	*Handle Exceptions:* Ensure that your application properly handles exceptions. You can use Spring's `@ExceptionHandler` annotation to define methods that handle specific exceptions and return custom error responses.

8. **Project Structure** 

	* src/main/java/com/test/demo -> Application.java(`main` method)(`@SpringBootApplication`)  
								  -> /controller/controllers.java  
								  -> /service/services.java  
								  -> /dao/daos.java  
								  -> /entities/entities.java  
			
	* src/main/resources 		  -> application.properties 
		* contains non-Java resources such as property files, XML configuration files, static resources 
		* *application.properties*: configure properties such as database connection details, server port, logging levels, etc
		
	* src/test/java/com/test/demo -> ApplicationTests.java(`@SpringBootTest`)
		* contains test Java source code

	* src/test/resources 		 
		* contains resources for testing, such as configuration files, test data
	
	* target(maven) OR build(gradle)
		* output directory for *compiled code, resources and generated artifacts* produced during the build process.
		* When you compile a Maven project, the resulting compiled Java classes, along with other resources such as property files, XML configurations, etc., are placed in the `target/classes` directory
		* Also, any generated files, such as compiled `JARs, WARs` or any other artifacts, are placed in the `target directory`.
	
	* Maven Dependencies
		* Virtual representation of the dependencies specified in pom.xml file.
		* Maven handles dependencies by downloading them from remote repositories (such as Maven Central) and caching them in your local Maven repository
			* For Unix/Linux/Mac: `~/.m2/repository`
			* For Windows: `C:\Users\{YourUsername}\.m2\repository`

	* `pom.xml` OR `build.gradle` (if using Gradle):
		* Project Object Model.(POM)
		* manages dependencies for your project. 

	* `mvnw` file (Maven Wrapper)
		* It's a shell script or batch script that facilitates the use of Maven in a project without requiring a global installation of Maven on the system
		* If maven is not found globally, it automatically downloads the necessary Maven binaries for the project to a hidden directory within the project structure (usually `.mvn/wrapper`)

	* `mvnw.cmd` file
		* The `mvnw` file is accompanied by a `mvnw.cmd` file for *Windows* systems, providing the same functionality


9.  **Artifact**
	An artifact typically refers to any tangible output produced during the software development process. This can include source code, documentation, diagrams, executable files, configuration files, and other materials created as part of the SDLC.

10. **Artifact ID & Group ID**
	1. **Group ID:** used to identify the organization or group that the project belongs to.
	2. **Artifact ID:** used to identify the specific project  within the group. It's usually the name of your project.


* **Application context == IoC Container(Spring Container)** where all your application's beans, configurations, and infrastructure are managed and organized


## Lifecyle of Spring Boot Application: 

1. **Application Startup:** 	
	* Spring Boot initializes the application context.
	* Components are scanned and registered.
	* Auto-configuration takes place, where Spring Boot automatically configures beans based on dependencies, classpath,  and other factors.	

2. **Application Initialization:**
	* Beans defined in the application context are initialized, dependencies are injected, and any necessary setup is performed.
	* Application properties and configuration files are read and processed.	

3. **Application Configuration:**
	* Configuration properties and beans are wired together.
	* External configurations (e.g., from application.properties or application.yml) are loaded.
	* Conditional beans are created based on configuration conditions.			

4. **Running the Application:**
	* Spring Boot starts the embedded server (like Tomcat, Jetty, or Undertow).
	* HTTP requests are accepted and processed by the server.
	* DispatcherServlet (if using Spring MVC) routes requests to appropriate controllers.	


## Internals:
**Starter POM:**
When you include a starter POM in your project, Maven will automatically pull in all the required dependencies specified by that starter POM, along with their transitive dependencies
e.g.
```xml   
	<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
	</dependency>
```

* Starter pom's jars -> META-INF -> spring.factories (Enable or disable) Based on `@Conditional and @Configuration`
E.g.In spring.factories, class JPARepository -> `@ConditiononBean(DataSource.class)` means  if DataSource is loaded then only enable JpaRepository.

* `@SprinBootApplication` = `@Configuration` + `@EnableAutoConfiguration` + `@ComponentScan`  

`@Configuration` -> Behave that class as bean  
`@EnableAutoConfiguration` -> Enable few Component based on condition
`@ComponentScan` -> scans all packages and registered beans in container

## Main method: 

* In a typical deployment of a `WAR file` in a servlet container like Tomcat, the main method is not directly utilized during runtime. Instead, the servlet container handles the initialization and execution of the application. Therefore, you don't necessarily need a main method in your Spring Boot application when deploying it as a `WAR file` in the `webapps` directory of a servlet container.

* However, Spring Boot applications are typically designed to be `executable JARs`, and the main method serves as the entry point for running the application standalone. When you package your Spring Boot application as a WAR file, you're essentially embedding it into a servlet container, and the servlet container's lifecycle takes precedence over the `main `method.

**Executable JAR deployment:*** If you're deploying your Spring Boot application as an executable JAR, you definitely need a main method as it's the entry point for running the application standalone.

**WAR deployment:** When deploying as a WAR file in a servlet container, the main method is not directly used during runtime. The servlet container's initialization and execution take over, and your application will be started and managed by the servlet container.

Main method calls -> 
```java
SpringApplication.run(SpringBootInternalApplication.class,args)
```
### Tasks Performed by SpringApplication.run()

1. **Create and Configure ApplicationContext**: The `run()` method creates an ApplicationContext(IoC Container), the central interface for providing configuration information to the Spring IoC container and obtaining bean instances. It's configured based on annotations, XML configuration, and other project settings.

2. **Register Application Startup Listeners**: Spring Boot automatically registers startup listeners, allowing custom actions when the application starts. These listeners are notified once the application context is fully initialized but before the application starts running.

3. **Load Spring Boot Properties**: Spring Boot loads properties from various sources like `application.properties`, `application.yml`, environment variables, and command-line arguments, making them available throughout the application.

4. **Scan for Components and Auto-Configuration**: Spring Boot scans the classpath for components annotated with Spring stereotypes (`@Component`, `@Service`, `@Repository`, etc.), and performs auto-configuration based on dependencies present in the classpath, configuring beans and services based on sensible defaults.

5. **Run Embedded Web Server (if applicable)**: If the application includes web-related dependencies (e.g., Spring MVC), Spring Boot starts an embedded web server (like Tomcat, Jetty, or Undertow) automatically, configuring and starting it to make the application accessible over HTTP.

6. **Trigger Spring Boot Application Events**: Spring Boot emits various events during startup, such as `ApplicationStartingEvent`, `ApplicationEnvironmentPreparedEvent`, `ApplicationContextInitializedEvent`, etc., which can be intercepted and processed by custom listeners if needed.

7. **Run Application**: Once initialized and configured, the application is started, and control flow is handed over to the Spring framework to manage the application's lifecycle.

8. **Display Startup Banner**: By default, Spring Boot displays a startup banner indicating the Spring Boot version and additional information. This banner can be customized or disabled as needed.

The `SpringApplication.run()` method is responsible for initializing the Spring application context, configuring dependencies, starting the embedded web server (if applicable), and kicking off the application's lifecycle.

## Startup Listeners: 
allow you to execute custom logic when the application starts up. They are notified by the Spring framework once the application context is fully initialized but before the application begins processing requests.

* **Registration:** Startup listeners can be registered within your Spring Boot application context. They can be implemented as Spring components and annotated with @Component, or you can register them programmatically.

* **Execution Order:** You can control the order of execution of startup listeners by setting their priority or order. Spring provides mechanisms such as implementing the Ordered interface or using the @Order annotation to specify the execution order.

* **Events:** `ApplicationStartingEvent`, `ApplicationEnvironmentPreparedEvent`, `ApplicationContextInitializedEvent`

* **Access to Application Context:** Startup listeners have access to the fully initialized application context, allowing them to interact with Spring-managed beans and resources within the application.

e.g
```java
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class MyStartupListener implements ApplicationListener<ApplicationStartedEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        // Custom logic to execute when the application starts
        System.out.println("Application started. Performing custom initialization...");
        // You can access application context and beans here if needed
    }
}
```

## Types of Events: 
1. **ApplicationStartingEvent:** 
* This event is the earliest event in the Spring Boot application lifecycle.
* It is fired just before the application context is created.
* At this stage, the application environment has not been set up yet.

2. **ApplicationEnvironmentPreparedEvent:**
* This event is fired when the Spring Environment is prepared but the application context is not yet created. 
* It provides an opportunity to modify the environment before the application context is created.

3. **ApplicationContextInitializedEvent:**
* This event indicates that the application context has been initialized, but it is not yet refreshed.
* At this point, the application context contains the bean definitions but is not fully configured.

4. **ApplicationPreparedEvent:**
* This event is fired just before the application context is refreshed but after the bean definitions have been loaded.
* It provides an opportunity to perform additional configuration or customization before the application context is fully prepared.

5. **ApplicationStartedEvent:**
* This event signals that the application context has been fully refreshed and the application has started.
* At this stage, the application is ready to process requests.

6. **ApplicationReadyEvent:**
* This event is fired when the application is ready to service requests.
* It indicates that the application is fully initialized and is now fully available to handle incoming requests.

7. **ApplicationFailedEvent:**
* This event is fired if the application fails to start up due to any exception.
* It provides information about the cause of the failure and can be used for error handling or logging purposes.

## javax vs jakarta:
* In Java 8, the standard package for Java Persistence API (JPA) annotations is `javax.persistence`. This package is part of the Java EE (EE) specification.

* However, in Java 17 and newer versions, the package for JPA annotations has transitioned to `jakarta.persistence`. This transition occurred due to the evolution of Java EE into the Eclipse Jakarta EE specification.

