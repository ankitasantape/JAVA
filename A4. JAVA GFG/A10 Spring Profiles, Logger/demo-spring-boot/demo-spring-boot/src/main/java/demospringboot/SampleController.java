package demospringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// component - allow IOC
// Autowired - allow DI

@RestController
public class SampleController {
    private static Logger logger = LoggerFactory.getLogger(SampleController.class);

    SampleController(){
        this.logger.info("Inside SampleController constructor, object = {}", this);
    }

    // injecting the dependency of Person in this class
    @Autowired // tells spring not to create a new object, instead get the object from IOC container
    Person person;//

    @Autowired
    Person person2;

//    Even if I remove @Autowired and write it like this, still it will work,  Becoz, we're using the same varible which has been instantiated at the same level either by me or by springboot.
//    Person person = new Person();

     @Value("${discount.percentage}")
    private Long discountPercentage;

//    http://localhost:9000/hello?n=abc
    @GetMapping("/hello")
    public String sayHello(@RequestParam("n") String name){  // starting point
//        SampleController sc = new SampleController();
//        logger.info("Newly created sample controller object is {}", sc);

//        logger.info("Saying hello to {}", name);
//        logger.info("discountPercentage: {}", discountPercentage);

//        Person person = new Person(); // after injecting dependency of person class no need to create local object here,
//        now the person will be coming from outer block or if your not sure of this you can simply do this.person
//        in this case this.person and simply person will behave in same manner becoz there is no local variable person which can lead toa conflict
//        int id = person.getRandomPersonId();
//        @Autowired
//        Person person;

        int id = this.person.getRandomPersonId();
        logger.info("person = {}, person2 = {}, id = {}", this.person, this.person2, id);

        return "Hello " + name;

    }

    // The number of times you hit the API everytime you will different value
    // person = demospringboot.Person@f4fe87a, id = 1582935616
    // person = demospringboot.Person@5e03a950, id = 991313319
    // But, after injecting dependency injection, the no. of times you hit the API everytime you will get the same value
//     Becoz, we're using the same varible which has been instantiated at the same level either by me or by springboot.
    // person = demospringboot.Person@56b08e59, id = -1465104909
//    person = demospringboot.Person@56b08e59, id = -1310758031

}

// This object is created by spring and it has different address than the object created by user(me)
// Inside SampleController constructor, object = demospringboot.SampleController@e041f0c

// This object is created by user(me) and it has different address than the object created by spring
// Newly created sample controller object is     demospringboot.SampleController@75248fd9