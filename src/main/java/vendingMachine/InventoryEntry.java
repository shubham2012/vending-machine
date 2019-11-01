package vendingMachine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Shubham Gupta on 17/06/19.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryEntry {
    private String name;
    private Integer price;
    private Integer quantity;
}
