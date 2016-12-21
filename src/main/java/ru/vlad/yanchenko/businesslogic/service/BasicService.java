package ru.vlad.yanchenko.businesslogic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.vlad.yanchenko.businesslogic.dao.BasicDAO;

/**
 * This is a high level data access.
 */

@Service
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