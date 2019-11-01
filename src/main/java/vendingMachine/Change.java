package vendingMachine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Shubham Gupta on 17/06/19.
 */
public class Change {

    private static Set<ChangeEntry> list = new HashSet<>();

    public List<ChangeEntry> getAvailableChange(){
        list.add(new ChangeEntry(1,10));
        list.add(new ChangeEntry(2,10));
        list.add(new ChangeEntry(5,10));
        list.add(new ChangeEntry(10,10));
        list.add(new ChangeEntry(20,10));
        list.add(new ChangeEntry(50,10));
        list.add(new ChangeEntry(100,10));
        return list.stream().sorted(Comparator.comparing(ChangeEntry::getCoin)
                .reversed()).collect(Collectors.toList());
    }

    public void addChange(int coin, int qty){
        ChangeEntry any = list.stream().filter(x -> x.getCoin() == coin).findAny().get();
        any.setCoin(any.getQuantity()+qty);
    }

    public void getAndSetCoin(int coin, int qty) throws Exception {
        ChangeEntry any = list.stream().filter(x -> x.getCoin() == coin).findAny().get();
        if (any.getQuantity()<qty)
            throw new Exception("Unable to get coin as qty not available");
        any.setQuantity(any.getQuantity()-qty);
    }

    public List<ChangeEntry> updateAndGetRemainingChange(int coin, int itemValue) throws Exception {
        if (coin == itemValue) {
            addChange(coin, 1);
        } else if (coin < itemValue){
            throw new Exception("Not enough coin");
        } else {
            List<ChangeEntry> mininumCoins = getMininumCoins(coin - itemValue);
            for (ChangeEntry x : mininumCoins) {
                getAndSetCoin(x.getCoin(), x.getQuantity());
            }
            return mininumCoins;
        }
        return null;
    }

    List<ChangeEntry> getMininumCoins(int changeToReturn) throws Exception {
        List<ChangeEntry> availableChange = getAvailableChange();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < availableChange.size(); i++) {
            while (changeToReturn>=availableChange.get(i).getCoin() && availableChange.get(i).getQuantity() > 0){
                int x = map.containsKey(availableChange.get(i).getCoin()) ?  map.get(availableChange.get(i).getCoin()) + 1 : 1;
                map.put(availableChange.get(i).getCoin(),x);
                changeToReturn-=availableChange.get(i).getCoin();
            }
            if (changeToReturn==0) break;
        }
        List<ChangeEntry> minCoins = new ArrayList<>();
        map.entrySet().stream().forEach(x->{
            ChangeEntry ce = new ChangeEntry();
            ce.setCoin(x.getKey());
            ce.setQuantity(x.getValue());
            minCoins.add(ce);
        });
        if (changeToReturn>0) throw new Exception("Not enough change");
        return minCoins;
    }

}
