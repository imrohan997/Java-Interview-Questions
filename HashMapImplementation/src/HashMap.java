import java.util.ArrayList;
import java.util.LinkedList;

/**
 * User implemented HashMap in Java.
 *
 * @param <K>
 * @param <V>
 */
public class HashMap<K, V> {

    //Node for HashMap
    private class HMNode {
        K key;
        V value;
        public HMNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size; //n
    private LinkedList<HMNode>[] buckets; // N = buckets.length

    /**
     * Constructor
     */
    public HashMap() {
        initbuckets(4);
        size = 0;
    }

    /**
     * It initialises the buckets
     */
    private void initbuckets(int N) {
        buckets = new LinkedList[N];
        for (int i = 0; i < buckets.length; ++i) {
            buckets[i] = new LinkedList<>();
        }
    }

    /**
     * Method to add key-value pair to HashMap.
     * @param key
     * @param val
     */
    public void put(K key, V val) {
        int bi = hashfn(key);
        int di = getIndexInBucket(bi, key);

        if (di == -1) {
            HMNode node = new HMNode(key, val);
            buckets[bi].add(node);
            size++;
        } else {
            HMNode node = buckets[bi].get(di);
            node.value = val;
        }

        double loadingFactor = this.size*1.0/buckets.length;
        if(loadingFactor > 2.0) {
            rehash();
        }
    }

    /**
     * Method to get value for a given key in HashMap.
     * @param key
     * @return
     */
    public V get(K key) {
        int bi = hashfn(key);
        int di = getIndexInBucket(bi, key);
        if(di != -1) {
            return buckets[bi].get(di).value;
        } else {
            return null;
        }
    }

    /**
     * Method to check whether key is present in HashMap.
     * @param key
     * @return
     */
    public boolean containsKey(K key) {
        int bi = hashfn(key);
        int di = getIndexInBucket(bi, key);
        if(di != -1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *It removes key from the HashMap
     * @param key
     * @return
     */
    public V remove(K key) {
        int bi = hashfn(key);
        int di = getIndexInBucket(bi, key);
        if(di != -1) {
           return buckets[bi].remove(di).value;
        } else {
            return null;
        }
    }

    /**
     * It return list of all the keys present in HashMap
     * @return
     */
    public ArrayList<K> keySet() {
        ArrayList<K> keys = new ArrayList<>();
        for(int bi = 0; bi < buckets.length; ++bi) {
            LinkedList<HMNode> bucket = buckets[bi];
            for(HMNode node:bucket) {
                keys.add(node.key);
            }
        }
        return keys;
    }

    /**
     * It returns number of key-vale pair present in HashMap.
     * @return
     */
    public int size() {
        return this.size;
    }

    private int hashfn(K key) {
        int hashcode = key.hashCode();
        return Math.abs(hashcode) % buckets.length;
    }

    private int getIndexInBucket(int bi, K key) {
        LinkedList<HMNode> list = buckets[bi];
        int di = 0;
        while (di != list.size()) {
            if (list.get(di).key.equals(key)) {
                return di;
            }
            di++;
        }
        return -1;
    }

    private void rehash() {
        LinkedList<HMNode>[] oldBuckets = buckets;
        initbuckets(oldBuckets.length*2);

        for (int bi = 0; bi < oldBuckets.length; ++bi) {
            for(HMNode node:oldBuckets[bi]) {
                int newbi = hashfn(node.key);
                buckets[newbi].add(node);
            }
        }

    }
}
