package ru.vlad.yanchenko.businesslogic.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * This is a low level data access (data base, network)
 */

@Repository
// Annotating with @Component to indicate this class is an auto scan component.
@Component
public class BasicDAO {

    @Override
    public String toString() {
        return "Hello, this is BasicDAO";
    }

}
