package marco.example;

import java.util.Collection;

public interface CustomersFilter {

    Collection<Customer> getCustomersByName(String name);

    Collection<Customer> getCustomersByNameAndEmail(String name, String email);

    Collection<Customer> getCustomersByNameAndEmailAndAddress(String name, String email, String address);
}
