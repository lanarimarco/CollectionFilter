package marco.example;

import java.util.ArrayList;
import java.util.Collection;

public class CustomersFilterByIteration implements CustomersFilter{

    private Collection<Customer> customers;

    public CustomersFilterByIteration(Collection<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public Collection<Customer> getCustomersByName(String name) {
        Collection<Customer> result = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().equals(name)) {
                result.add(customer);
            }
        }
        return result;
    }

    @Override
    public Collection<Customer> getCustomersByNameAndEmail(String name, String email) {
        Collection<Customer> result = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().equals(name) && customer.getEmail().equals(email)) {
                result.add(customer);
            }
        }
        return result;
    }

    @Override
    public Collection<Customer> getCustomersByNameAndEmailAndAddress(String name, String email, String address) {
        Collection<Customer> result = new ArrayList<>();
        for (Customer customer : customers) {
            if (customer.getName().equals(name) && customer.getEmail().equals(email) && customer.getAddress().equals(address)) {
                result.add(customer);
            }
        }
        return result;
    }
}
