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
public class ChangeEntry {
    private Integer coin;
    private Integer quantity;
}
