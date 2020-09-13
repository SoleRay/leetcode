package leetcode.lee146;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2  implements Cache{

    private LinkedHashMap<Integer,Integer> map = new LinkedHashMap();

    private int capcity;

    public LRUCache2() {
        this(16);
    }

    public LRUCache2(int capcity) {
        this.capcity = capcity;
    }

    @Override
    public void put(int key, int value) {
        if(map.keySet().contains(key)){
            map.remove(key);
        }
        map.put(key,value);
        if(map.size() > capcity){
            removeLRU();
        }
    }

    private void removeLRU() {
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        if(iterator.hasNext()){
            iterator.next();
            iterator.remove();
        }
    }

    @Override
    public int get(int key) {
        if(!map.keySet().contains(key)){
            return -1;
        }
        Integer value = map.remove(key);
        map.put(key,value);
        return value;
    }
}
