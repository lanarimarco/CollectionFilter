package marco.example;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionFilterTestUtils {

    public static Collection<Customer> createCustomers(int size) {
        final Collection<Customer> customers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String name = "Name" + i;
            String email = "Email" + i + "@example.com";
            String address = "Address" + i;
            customers.add(new Customer(name, email, address));
        }
        return customers;
    }
}
