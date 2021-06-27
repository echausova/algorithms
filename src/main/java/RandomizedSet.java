import java.util.*;

public class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random r;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        r = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.get(val) != null) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.get(val) == null) {
            return false;
        }

        int idx = map.get(val);

        int last = list.get(list.size() - 1);
        list.set(list.size() - 1, val);
        list.set(idx, last);

        map.put(last, idx);
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int n = list.size();
        int val = r.nextInt(n);
        return list.get(val);
    }
}
