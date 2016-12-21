Tutorial:

    Terms present here are not described. Please refer to web for the info.

	1) Create a project with a "Gradle" picked and "Java" and "Web" checkmarks present.
		1.1) Put a GroupId like "ru.name.lastname.ProjectName"
		1.2) Put an ArtifactId as "ProjectName".
		1.3) Click "Next"
		1.4) Put checkmarks on:
			- Use autoimport
			- Create directories...
			- Create separate module per source set
		1.5) Put radiobutton to . Use local gradle distribution (in case there is one installed in a system), else try other options to check if gradle to operate properly in a following app development.
		1.6) Click "Next", "Finish"
		i. Idea is to open up a project.
	2) Install a web-server to windows. Wу are to use Apache Tomcat.
	3) Presuming that we have it installed, we do next:
		2.1) Click "Edit-configurations"
		2.2) Click + sign
		2.3) Find Tomcat Server - Local
		i. One has to add an artifact to this project to make it runnable.
		2.4) Click "Fix" at a down right corner and choose "...some artifact name (exploded)".
		2.5) Click "OK".
		i. At this point, project can be run.

	3) Add Spring framework dependencies by copypasting a next rows from this file to web.xml.

        compile group: 'org.springframework', name: 'spring-core', version: '4.3.4.RELEASE'
        compile 'org.springframework:spring-webmvc:4.3.4.RELEASE'
	i. 

    4) Add a folder named "WEB-INF" to a "webapp" folder.
    5) Add a file named "web.xml" to a "WEB-INF" folder.
	6) Add Dispatcher servlet to a "web.xml", by adding a following text to "web.xml":

	   <?xml version="1.0" encoding="UTF-8"?>
       <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                   http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
                version="3.1">

           <!--  This listener loads an xml config files -->
           <listener>
               <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
           </listener>

           <!-- Basic and I suppose the only dispatcher servlet in spring.
            It is in charge of directing all the requests to a respective controllers. -->
           <servlet>
               <servlet-name>dispatcher</servlet-name>
               <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
               <init-param>
                   <param-name>contextConfigLocation</param-name>
                   <param-value>/WEB-INF/dispatcher-servlet.xml</param-value>
               </init-param>
               <load-on-startup>1</load-on-startup>
           </servlet>
           <servlet-mapping>
               <servlet-name>dispatcher</servlet-name>
               <url-pattern>/</url-pattern>
           </servlet-mapping>

       </web-app>

    8) Make a file named "dispatcher-servlet.xml" in a "WEB-INF" folder.
    It will describe a dispatcher servlet present in a "web.xml".
    9) Put following text there. It has a View Resolver by default.

        <beans xmlns="http://www.springframework.org/schema/beans"
               xmlns:context="http://www.springframework.org/schema/context"
               xmlns:mvc="http://www.springframework.org/schema/mvc"
               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xsi:schemaLocation="
                    http://www.springframework.org/schema/beans
                    http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
                    http://www.springframework.org/schema/context
                    http://www.springframework.org/schema/context/spring-context-3.0.xsd
                    http://www.springframework.org/schema/mvc
                    http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd">

            <!-- Package where to look for a components of this project(app) -->
            <context:component-scan base-package="ru.vlad.yanchenko" />
            <!-- Deploying an ability to use annotations like @Controller, @RequestMapping etc. in a project -->
            <context:annotation-config />
            <!--<bean class="com.javacodegeeks.snippets.enterprise.HelloWorldController" />-->
            <!--<bean class="org.springframework.web.servlet.mvc.support.ControllerClassNameHandlerMapping" />-->

            <!-- This is a bean that says where the presentation / views / jsp pages reside -->
            <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
                <property name="prefix">
                    <value></value><!-- This is the path where jsp pages reside. The default path stands for
                    webapp. When moving to a different location, one has to make sure that index.jsp to be
                    seen to server when it starts. -->
                </property>
                <property name="suffix">
                    <value>.jsp</value>
                </property>
            </bean>

        </beans>

    10) Let's make first controller in a package "ru.name.lastname.controller"
    and call it "BasicController". Put a following code in there.

    // Put a correct file path here
    package ru.name.lastname.controller;

    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    public class BasicController {

        @RequestMapping(value="/demo1")
        String demo1(Model model) {
            return "demo1";
        }

    }

    i. From this moment on, we can see that URL "localhost:8080/demo1" (without "")
    is accessible and leads to a page showing Demo1 with some text.

    11) Now create package "businesslogic" and sub packages "dao" and "service" in it.
        Final packages are to be like this: "ru.name.lastname.businesslogic.dao" and
        "ru.name.lastname.businesslogic.service".
        11.1) Make a class BasicDAO in a "ru.name.lastname.businesslogic.dao" package.
        11.2) Make a class BasicService in a "ru.name.lastname.businesslogic.service" package.
        11.3) Add a following code to a respective classes:

        // DAO
        package ...businesslogic.dao;

        public class BasicDAO {

            @Override
            public String toString() {
                return "Hello , this is BasicDAO";
            }

        }

        // Service
        package ...businesslogic.service;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;
        import ...businesslogic.dao.BasicDAO;

        /**
         * This is a high level data access.
         */

        // Annotating with @Component to indicate this class is an auto scan component.
        @Component
        public class BasicService {

            // Аннотация @Autowired отмечает конструктор, поле или метод как требующий
            // автозаполнения инъекцией зависимости Spring.
            // http://www.seostella.com/ru/article/2012/02/12/ispolzovanie-annotacii-autowired-v-spring-3.html
            // http://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html
            // https://www.mkyong.com/spring/spring-auto-scanning-components/
            @Autowired
            BasicDAO basicDAO;
            /*
                You can use @Autowired annotation on setter methods to get rid of the <property>
                element in XML configuration file. When Spring finds an @Autowired annotation used
                with setter methods, it tries to perform byType autowiring on the method.

                You can use @Autowired annotation on properties to get rid of the setter methods.
                When you will pass values of autowired properties using <property> Spring will
                automatically assign those properties with the passed values or references.

                You can apply @Autowired to constructors as well. A constructor @Autowired annotation
                indicates that the constructor should be autowired when creating the bean, even if no
                <constructor-arg> elements are used while configuring the bean in XML file.
             */

            public void setBasicDAO(BasicDAO basicDAO) {
                this.basicDAO = basicDAO;
            }

            @Override
            public String toString() {
                return "BasicService [basicDAO=" + basicDAO + "]";
            }

        }

    12) (OPTIONAL) Import project to GitHub.
        12.1) Go to github.com, enter a personal account, create a repository with a name, say "SpringDemo".
        12.2) From a next page, you may copy a link and add to a IntelliJ Idea as a new repository and push
              it to remote repository (find in inet how) or copy a following text and run it in a IntelliJ
              Idea's terminal.

          echo "# SpringDemo" >> README.md
          git init
          git add README.md
          git commit -m "first commit"
          git remote add origin https://github.com/Vladchenko/SpringDemo.git
          git push -u origin master

        12.3) Go to menu VCS find something like "add VCS dependency" (the menu clause says
            something different, by the way)
        12.4) Mark all the files willing to commit in git in a "Project" pan.
        12.5) Click right mouse button on them, choose Git and "Add files".
        12.6) Commit all files.
        12.7) Push all files to github:
            12.7.1) Click VCS with a green arrow directing up in a up right hand corner.
            12.7.2) Check if any not useful files are to be present in a commit list and
                remove them, or add the needed ones.
            12.7.3) Click "Commit" and then "Commit and Push", "Commit" again, "Push" again.

          i. You may see online in github.com that your project files are there.