package vendingMachine;

import org.junit.jupiter.api.Test;

/**
 * Created by Shubham Gupta on 17/06/19.
 */
public class VendingMainTest {

    VendingMain main = new VendingMain();

    @Test
    void testVendingMachineWithReturnCoin() throws Exception {
        main.driver("Chips", 100);
        main.driver("Chips", 10);
    }

    @Test
    void testVendingMachineExactCoin() throws Exception {
        main.driver("Chips", 10);
    }
}