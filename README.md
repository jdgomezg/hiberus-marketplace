# hiberus-marketplace
Spring boot rest services docker container H2 database

# Prerequisites
1. Have docker installed
2. Have Java JDK 1.8 installed
3. Have Maven configured on the computer

# Installation

1. Inside the project run command "mvn clean install"

[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  8.671 s
[INFO] Finished at: 2020-06-29T11:17:54-05:00
[INFO] ------------------------------------------------------------------------

2. run the command "docker build -t marketplace ." to generate the project image

Sending build context to Docker daemon  44.77MB
Step 1/4 : FROM openjdk:8-jre
 ---> b1b24a1b2834
Step 2/4 : MAINTAINER jugomez3@gmail.com
 ---> Running in d60e07158234
Removing intermediate container d60e07158234
 ---> 6f5826fa3d23
Step 3/4 : ADD target/marketplace-0.0.1-SNAPSHOT.jar marketplace-0.0.1-SNAPSHOT.jar
 ---> c374dbb548f7
Step 4/4 : ENTRYPOINT ["java","-jar","/marketplace-0.0.1-SNAPSHOT.jar"]
 ---> Running in 1ba0461deb6d
Removing intermediate container 1ba0461deb6d
 ---> 1628fbff3050
Successfully built 1628fbff3050
Successfully tagged marketplace:latest

3. run the command "docker run -p 0.0.0.0:8080:8080 marketplace" to mount the image and accept requests on port 8080

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.3.1.RELEASE)

2020-06-29 16:22:20.490  INFO 1 --- [           main] c.c.c.m.MarketplaceApplication           : Starting MarketplaceApplication v0.0.1-SNAPSHOT on 08d8c22c13f3 with PID 1 (/marketplace-0.0.1-SNAPSHOT.jar started by root in /)
2020-06-29 16:22:20.493  INFO 1 --- [           main] c.c.c.m.MarketplaceApplication           : No active profile set, falling back to default profiles: default
2020-06-29 16:22:21.702  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFERRED mode.
2020-06-29 16:22:21.786  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 72ms. Found 2 JPA repository interfaces.
2020-06-29 16:22:22.426  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2020-06-29 16:22:22.445  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2020-06-29 16:22:22.445  INFO 1 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.36]
2020-06-29 16:22:22.519  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2020-06-29 16:22:22.519  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1965 ms
2020-06-29 16:22:22.576  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
2020-06-29 16:22:22.863  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2020-06-29 16:22:22.873  INFO 1 --- [           main] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:testdb'
2020-06-29 16:22:23.150  INFO 1 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-06-29 16:22:23.342  INFO 1 --- [         task-1] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
2020-06-29 16:22:23.654  WARN 1 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
2020-06-29 16:22:23.914  INFO 1 --- [           main] pertySourcedRequestMappingHandlerMapping : Mapped URL path [/v2/api-docs] onto method [springfox.documentation.swagger2.web.Swagger2Controller#getDocumentation(String, HttpServletRequest)]
2020-06-29 16:22:24.045  INFO 1 --- [         task-1] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 5.4.17.Final
2020-06-29 16:22:24.332  INFO 1 --- [         task-1] o.hibernate.annotations.common.Version   : HCANN000001: Hibernate Commons Annotations {5.1.0.Final}
2020-06-29 16:22:24.496  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2020-06-29 16:22:24.499  INFO 1 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed
2020-06-29 16:22:24.556  INFO 1 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found 1 custom documentation plugin(s)
2020-06-29 16:22:24.601  INFO 1 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2020-06-29 16:22:24.971  INFO 1 --- [           main] DeferredRepositoryInitializationListener : Triggering deferred initialization of Spring Data repositories…
2020-06-29 16:22:25.007  INFO 1 --- [         task-1] org.hibernate.dialect.Dialect            : HHH000400: Using dialect: org.hibernate.dialect.H2Dialect
2020-06-29 16:22:25.950  INFO 1 --- [         task-1] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
2020-06-29 16:22:25.965  INFO 1 --- [         task-1] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
2020-06-29 16:22:26.641  INFO 1 --- [           main] DeferredRepositoryInitializationListener : Spring Data repositories initialized!
2020-06-29 16:22:26.675  INFO 1 --- [           main] c.c.c.m.MarketplaceApplication           : Started MarketplaceApplication in 6.719 seconds (JVM running for 7.173)

4. now the project is running, so you can go to the path 'resources/postman/' and take the JSON file to mount it on postman and launch requests.

# Post conditions

1. In the Path http://localhost:8080/h2-console you can find the console for the database

 url=jdbc:h2:mem:testdb
 username=sa
 password= none

2. In the Path http://localhost:8080/swagger-ui.html you can find documentation about API consume