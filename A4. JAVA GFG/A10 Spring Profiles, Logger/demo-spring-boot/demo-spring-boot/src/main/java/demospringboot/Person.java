package demospringboot;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Person {

    Person(String name, int age){
        this.age = age;
        this.name = name;
        this.id = new Random().nextInt(100);
    }

    Person(){

    }

    private int id; // unique key
    private String name;
    private int age;

    public Integer getRandomPersonId(){
        Random random = new Random();
        return random.nextInt();
    }
}
