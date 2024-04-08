package demospringboot;

import org.springframework.beans.factory.annotation.Value;

public class Sample {

    int a = 10; // Step 1

//    @Value()
//    int b; // Step 3

    Sample(){  // Step 2
        System.out.println(a);
    }

    @Value("${b}")
    int b = 20;

    public static void main(String[] args) {
        Sample sample = new Sample();
    }
}
