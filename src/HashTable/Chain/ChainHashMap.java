package HashTable.Chain;

import HashTable.HashFunction;
import HashTable.HashTable;

public class ChainHashMap<K, V> implements HashTable<K, V> {
    protected LinkedList<K, V>[] table;
    private int size;
    private HashFunction<K> hf;
    public ChainHashMap (int size, HashFunction<K> hf) {
        this.size = size;
        this.hf = hf;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<K, V>();
        }

    }

    public V get (K key) {
        LinkedList<K, V> bucket = table[getHash(key)];
        return bucket.find(key);
    }

    public void remove (K key) {
        LinkedList<K, V> bucket = table[getHash(key)];
        bucket.remove(key);
    }

    public void insert (K key, V val) {
        LinkedList<K, V> bucket = table[getHash(key)];
        if (bucket.find(key) == null) {
            bucket.insert(key, val);
        } else {
            bucket.remove(key);
            bucket.insert(key, val);
        }
    }

    private int getHash (K key) {
        return (int) (hf.hash(key) % size);
    }

    @Override
    public String toString () {
        String result = "";
        for (LinkedList<K, V> i : table) {
            result += "\nBucket: ";
            Node<K, V> cur = i.getHead();
            if (cur != null) {
                result += "[ {" + cur.value.toString() + "} ";
                while (cur.next != null) {
                    cur = cur.next;
                    result += "{" + cur.value.toString() + "} ";

                }
                result += "]";
            }
        }
        return result;
    }
}