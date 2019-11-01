package vendingMachine;

import java.util.List;

/**
 * Created by Shubham Gupta on 13/06/19.
 */
public class VendingMain {

    private Inventory inventory = new Inventory();
    private Change change = new Change();

    public void driver(String item, int changeCollected) throws Exception {
        System.out.println("-----------Initial data --------------");
        System.out.println(inventory.getInventory());
        System.out.println(change.getAvailableChange());
        InventoryEntry inv = this.inventory.checkInventory(item);
        List<ChangeEntry> changeToReturn = change.updateAndGetRemainingChange(changeCollected, inv.getPrice());
        this.inventory.reduceInventory(item);
        System.out.println("Change to return: " + changeToReturn );
        System.out.println("----------After remaining data ---------");
        System.out.println(inventory.getInventory());
        System.out.println(change.getAvailableChange());
    }
}
