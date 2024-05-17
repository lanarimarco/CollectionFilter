package marco.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.logging.Logger;

public class CustomersTest {

    private static final Logger LOGGER = Logger.getLogger("CustomersTest");

    private static final int SIZE = 500;

    private static final Collection<Customer> CUSTOMERS = CollectionFilterTestUtils.createCustomers(SIZE);

    private static final CustomersFilter CUSTOMERS_FILTER_BY_ITERAION = new CustomersFilterByIteration(CUSTOMERS);

    private static final CustomersFilter CUSTOMERS_FILTER_BY_MAP = new CustomersFilterByMap(CUSTOMERS);


    @Test
    public void testGetCustomersByName() {
        for (int i = 0; i < SIZE; i++) {
            Assertions.assertEquals(
                    CUSTOMERS_FILTER_BY_MAP.getCustomersByName("Name" + i),
                    CUSTOMERS_FILTER_BY_ITERAION.getCustomersByName("Name" + i)
            );
        }
    }

    @Test
    public void testGetCustomersByNameAndEmail() {
        for (int i = 0; i < SIZE; i++) {
            Assertions.assertEquals(
                    CUSTOMERS_FILTER_BY_MAP.getCustomersByNameAndEmail("Name" + i, "Email" + i + "@example.com"),
                    CUSTOMERS_FILTER_BY_ITERAION.getCustomersByNameAndEmail("Name" + i, "Email" + i + "@example.com")
            );
        }
    }

    @Test
    public void testGetCustomersByNameAndEmailAndAddress() {
        for (int i = 0; i < SIZE; i++) {
            Assertions.assertEquals(
                    CUSTOMERS_FILTER_BY_MAP.getCustomersByNameAndEmailAndAddress("Name" + i, "Email" + i + "@example.com", "Address" + i),
                    CUSTOMERS_FILTER_BY_ITERAION.getCustomersByNameAndEmailAndAddress("Name" + i, "Email" + i + "@example.com", "Address" + i)
            );
        }
    }

    @Test
    public void performanceGetCustomersByName() {
        final int iterations = 10000;
        System.out.println("starting CUSTOMERS_FILTER_BY_MAP");
        long duration = measureDuration(() -> {
            for (int iteration = 0; iteration < iterations; iteration++) {
                for (int i = 0; i < SIZE; i++) {
                    CUSTOMERS_FILTER_BY_MAP.getCustomersByName("Name" + i);
                }
            }
        });
        System.out.println("duration: " + duration);

        System.out.println("starting CUSTOMERS_FILTER_BY_ITERATION");
        duration = measureDuration(() -> {
            for (int iteration = 0; iteration < iterations; iteration++) {
                for (int i = 0; i < SIZE; i++) {
                    CUSTOMERS_FILTER_BY_ITERAION.getCustomersByName("Name" + i);
                }
            }
        });
        System.out.println("duration: " + duration);
    }

    private long measureDuration(Runnable runnable) {
        long start = System.currentTimeMillis();
        runnable.run();
        return System.currentTimeMillis() - start;
    }

}
