<p align="center">
  <a href="#about" title="About">About</a> |
  <a href="#Technologies" title="Technologies">Technologies</a> |
  <a href="#Externals" title="Externals">Externals</a> |
  <a href="#Deployment" title="Deployment">Deployment</a> |
  <a href="#Database-Configuration " title="Database Configuration ">Database Configuration </a> |
  <a href="#Under-Development" title="Under Development">Under Development</a> |
  <a href="#Contributions" title="Contributing">Contributing</a>
</p>

<br>

## About 
Scool is an online educational institute for children helping both childrens and teachers to learn and teach from home with an easy to use user interface and management 
dashboard.

The Application is implemented as a [Spring Boot](https://projects.spring.io/spring-boot/) app running an embedded version of Tomcat. the data storage is 
[MySql](https://www.mysql.com/) Database accessed via [Spring JPA](https://projects.spring.io/spring-data-jpa/) on [AWS RDS](https://aws.amazon.com/rds/mysql/).

## Technologies

* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) - Java™ Platform, Standard Edition Development Kit
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[Mysql](https://www.mysql.com/) - Open-Source Relational Database Management System
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system
*   [Bootstrap](https://getbootstrap.com/) - front-end open source toolkit
*   [thymeleaf](http://thymeleaf.org/) - server-side Java template engine
*   [AWS](https://aws.amazon.com/rds/mysql/) - Amazon RDS for MySQL
*   [Spring Security](https://spring.io/projects/spring-security) -Spring Security is a powerful and highly customizable authentication and access-control framework
*   [Spring Rest](https://spring.io/guides/tutorials/rest/)
*   [Spring DATA JDBC](https://spring.io/projects/spring-data-jdbc)
## Externals

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)

### UI Template 
* [Front End - ](https://w3layouts.com/template/edu-school-a-website-template-for-education-schools/) 
Edu School a Website Template for Education Schools

# Database-Configuration 

to configure `MYSQL` on AWS please refer to [this manual](https://docs.aws.amazon.com/AmazonRDS/latest/UserGuide/CHAP_GettingStarted.CreatingConnecting.MySQL.html) 
and then in `application.properties` add your configurations 
```bash 
spring.datasource.url = your database url
spring.datasource.username = username
spring.datasource.password = password
```

## Deployment
### - Deploying the application to OpenShift or AWS


To deploy the sample application to OpenShift you can use the [OpenShift CLI](https://docs.openshift.org/latest/cli_reference/index.html):

```shell
oc new-app codecentric/springboot-maven3-centos~https://github.com/spiderocta/scool

```

This will create:

* An ImageStream called "springboot-maven3-centos"
* An ImageStream called "scool"
* A BuildConfig called "scool"
* DeploymentConfig called "scool"
* Service called "scool"

If you want to access the app from outside your OpenShift installation, you have to expose the scool service:

```shell
oc expose scool --hostname=www.example.com
```

#### To deploy the sample application to AWS or Container

you can check these links :
* [Deploying on AWS Using AWS Elastic Beanstalk](https://aws.amazon.com/blogs/devops/deploying-a-spring-boot-application-on-aws-using-aws-elastic-beanstalk/)
* [Deploying a Spring Boot Application - docs](https://docs.spring.io/spring-boot/docs/current/reference/html/deployment.html)



### maven

Build Spring Boot Project with Maven `mvn install / mvn clean install`

run spring boot using maven : `mvn spring-boot:run`

or load it into your ide then run it. 

access it via local host after configuring the port in properties file . 
``` 
 server.port = <<port number>>
```


# Contributions

#### In case you find a bug or have a suggested improvement
The [issue tracker](https://github.com/spiderocta/scool/issues) is the preferred channel for bug reports, features requests and submitting pull requests.

## Under-Development

- [ ] RESTful Web Service
- [ ] OpenFeign integrations
- [ ] HAL explorer
- [ ] automatic auditing
- [ ] enable new user registeration
- [ ] RESTful Web Service
- [ ] custom validations
- [ ] security changes for custom authentications
- [ ] profile link inside dashboard
- [ ] static and dynamic sorting
- [ ] logging and actuator


### Contributions can be made by following these steps:

1. Fork it!
2. Create your feature branch: `git checkout -b my-new-feature`
3. Commit your changes: `git commit -am 'Add some feature'`
4. Push to the branch: `git push origin my-new-feature`
5. Submit a pull request
