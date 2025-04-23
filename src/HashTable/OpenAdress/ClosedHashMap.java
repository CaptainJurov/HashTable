package HashTable.OpenAdress;

import HashTable.HashTable;

public class ClosedHashMap<K, V> implements HashTable<K, V> {
    private Pair<K, V>[] table;
    private int size;
    public ClosedHashMap(int size) {
        this.size=size;
        table = new Pair[size];
        for (int i=0;i<size;i++) {
            table[i] = null;
        }
    }
    private int hash(K key) {
        return (int) (Math.pow(key.hashCode(), 2)%size);
    }
    @Override
    public V get (K key) {
        return null;
    }

    @Override
    public void insert (K key, V val) {

    }

    @Override
    public void remove (K key) {

    }
}
