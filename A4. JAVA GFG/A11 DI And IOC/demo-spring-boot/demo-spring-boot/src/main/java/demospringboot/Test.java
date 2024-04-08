package demospringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);

    @Value("${jdbc.url}")
    private String jdbcUrl; // url in a format which is used to connect to a relational db from java

    @Value("${username}")
    private String username;

    @Value("${password}")
    private String password;

    // 3rd type of Dependency Injection

    Person person;

    @Autowired
    public void setPerson(Person person){
        this.logger.info("Inside setPerson: person - {} ", person);
        this.person = person;
    }

    @Autowired
    DBConnection dbConnection;

    Test(){
        this.logger.info("Inside test jdbcUrl = {}", jdbcUrl); // Inside test jdbcUrl = null
    }

//    @Autowired
//    Person person;

//    Person person = new Person();

//  Hit this api to see values inside this API http://localhost:9000/test?n=Ankita
    @GetMapping("/test")
    public String testFunc(@RequestParam("n") String name){  // starting point

        dbConnection.setPerson(person);
        this.logger.info("Inside testFunc = jdbcUrl - {}", jdbcUrl); // Inside testFunc jdbcUrl = jdbc.mysql://localhost:3306/youtube
//      int id = this.person.getRandomPersonId();
//      logger.info("person = {}, id = {}", this.person, id);

        return "Hello " + name;
    }
}
