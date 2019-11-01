package vendingMachine;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shubham Gupta on 13/06/19.
 */
public class Inventory {

    private static Set<InventoryEntry> list = new HashSet<>();

    public Set<InventoryEntry> getInventory(){
        list.add(new InventoryEntry("Chips", 10, 5));
        list.add(new InventoryEntry("Coke", 15, 5));
        list.add(new InventoryEntry("Pepsi", 20, 5));
        list.add(new InventoryEntry("Coffee", 12, 5));
        list.add(new InventoryEntry("Tea", 10, 5));
        return list;
    }

    public void reduceInventory(String name) throws Exception {
        InventoryEntry currInv = getInventory().stream().filter(x -> x.getName().equals(name)).findAny().get();
        Integer quantity = currInv.getQuantity();
        if (quantity==0) throw new Exception("Not enough quantity");
        currInv.setQuantity(quantity-1);
    }

    public InventoryEntry checkInventory(String name) throws Exception {
        InventoryEntry currInv = getInventory().stream().filter(x -> x.getName().equals(name)).findAny().get();
        Integer quantity = currInv.getQuantity();
        if (quantity==0) throw new Exception("Not enough quantity");
        else return currInv;
    }

}
