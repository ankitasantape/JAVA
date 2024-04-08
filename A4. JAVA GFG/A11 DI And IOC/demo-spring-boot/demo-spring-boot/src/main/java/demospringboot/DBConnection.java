package demospringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DBConnection {

    private static Logger logger = LoggerFactory.getLogger(DBConnection.class);

    // jdbc:mysql://localhost:3306/dbName

//    @Value("${jdbc.url}")
//    private String jdbcUrl; // url in a format which is used to connect to a relational db from java
//
//    @Value("${username}")
//    private String username;
//
//    @Value("${password}")
//    private String password;
//
//    DBConnection(){
//        this.logger.info("jdbcUrl = {}, username = {}, password = {}", jdbcUrl, username, password);
//    }

//    DBConnection(@Value("${jdbc.url}") String jdbcUrl,
//                 @Value("${username}") String username,
//                 @Value("${password}") String password){
//        this.jdbcUrl = jdbcUrl;
//        this.username = username;
//        this.password = password;
//    }


//   Injecting the dependency using parameters (Way 1)

//    @Autowired
//    Person person;
//
//    DBConnection(){
//        this.logger.info("Inside DBConnection - person = {} ", person); // Inside DBConnection - person = null
//    }

//    Injecting the dependency using constructor (Way 2)

    Person person;

    @Autowired
    public void setPerson(Person person){
        this.person = person;
    }

//    DBConnection(Person person){
//        this.logger.info("Inside DBConnection - person = {} ", person); // Inside DBConnection - person = demospringboot.Person@3a71c100
//        this.person = person;
//    }

//  Which one is better 1 or 2, and when should we use which one?
//  Using setters (Way 3) - rarely used

//  @Autowired // redundant
//    DBConnection(Person person){
//        this.logger.info("Inside DBConnection, person - {}", person); // Inside DBConnection, person - demospringboot.Person@3f3c966c
//    }
//
//    @Autowired
//    DBConnection(Person person, @Value("${jdbc.url}") String jdbcUrl){
//        this.logger.info("Inside DBConnection, person - {}, jdbcUrl - {}", person, jdbcUrl); // Inside DBConnection, person - demospringboot.Person@3f3c966c, jdbcUrl - jdbc.mysql://localhost:3306/youtube
//    }
}
