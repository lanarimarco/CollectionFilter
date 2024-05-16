package marco.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Customers {

    private Collection<Customer> customers;

    private Map<String, Collection<Customer>> customersByName = new HashMap<>();
    private Map<String, Collection<Customer>> customersByNameAndEmail = new HashMap<>();
    private Map<String, Collection<Customer>> customersByNameAndEmailAndAddress = new HashMap<>();

    public Customers(Collection<Customer> customers) {
        this.customers = customers;
        for (Customer customer : customers) {
            addKey(customersByName, customer, customer.getName());
            addKey(customersByNameAndEmail, customer, customer.getEmail() + "_" + customer.getName());
            addKey(customersByNameAndEmailAndAddress, customer, customer.getEmail() + "_" + customer.getName() + "_" + customer.getAddress());
        }
    }

    private static void addKey(Map<String, Collection<Customer>> map, Customer customer, String key) {
        if (map.containsKey(key)) {
            map.get(key).add(customer);
        } else {
            Collection<Customer> newCollection = new ArrayList<>();
            newCollection.add(customer);
            map.put(key, newCollection);
        }
    }

    public Collection<Customer> getCustomersByName(String name) {
        return customersByName.get(name);
    }

    public Collection<Customer> getCustomersByNameAndEmail(String name, String email) {
        return customersByNameAndEmail.get(email + "_" + name);
    }

    public Collection<Customer> getCustomersByNameAndEmailAndAddress(String name, String email, String address) {
        return customersByNameAndEmailAndAddress.get(email + "_" + name + "_" + address);
    }


}
