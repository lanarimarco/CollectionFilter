package marco.example;


import java.util.ArrayList;
import java.util.Collection;

public class Main {
    public static void main(String[] args) {
        final Collection<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            String name = "Name" + i;
            String email = "Email" + i + "@example.com";
            String address = "Address" + i;
            customers.add(new Customer(name, email, address));
        }
    }
}