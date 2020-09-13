package leetcode.lee146;

public class lee146 {

    public static void main(String[] args) throws Exception {
//        LRUCache cache = new LRUCache(2);
        LRUCache2 cache = new LRUCache2(2);

//        Random random = new Random();
//        for (int i = 1; i <= 16 ; i++) {
//            Thread.sleep(100);
//            cache.put(i, random.nextInt());
//        }
//
//        int[] randomList = new int[]{7,4,12,13,1};
//
//        for (int i = 0; i < randomList.length; i++) {
//            Thread.sleep(100);
//            cache.put(i,random.nextInt());
//        }
//
//
//        cache.put(200,random.nextInt());
//        cache.printLRU();
//        LRUCache.Node lru = cache.getLRU();
//        System.out.println("key="+lru.getKey()+",lastUseTime="+lru.getLastUseTime());

        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));


//        System.out.println(cache.get(2));
//        cache.put(2,6);
//        System.out.println(cache.get(1));
//        cache.put(1,5);
//        cache.put(1,2);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));

    }
}
