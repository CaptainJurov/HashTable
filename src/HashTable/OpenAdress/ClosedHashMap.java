package HashTable.OpenAdress;

import HashTable.HashTable;
import HashTable.HashFunction;
public class ClosedHashMap<K, V> implements HashTable<K, V> {
    protected Pair<K, V>[] table;
    private final HashFunction<K> hf;
    public ClosedHashMap(int size, HashFunction<K> hf) {
        this.table = new Pair[size];
        this.hf = hf;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7FFFFFFF) % table.length;
    }

    private int getIndex(K key, int attempt) {
        return (hash(key) + attempt) % table.length;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < table.length; i++) {
            int index = getIndex(key, i);
            Pair<K, V> p = table[index];
            if (p == null) return null;
            if (!p.isdel && p.key.equals(key)) return p.value;
        }
        return null;
    }

    @Override
    public void insert(K key, V val) {
        for (int i = 0; i < table.length; i++) {
            int index = getIndex(key, i);
            Pair<K, V> p = table[index];
            if (p == null || p.isdel) {
                table[index] = new Pair<>(key, val);
                return;
            } else if (p.key.equals(key)) {
                p.value = val;
                return;
            }
        }
    }

    @Override
    public void remove(K key) {
        for (int i = 0; i < table.length; i++) {
            int index = getIndex(key, i);
            Pair<K, V> p = table[index];
            if (p == null) return;
            if (!p.isdel && p.key.equals(key)) {
                p.isdel = true;
                return;
            }
        }
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < table.length; i++) {
            result+=(table[i] != null && !table[i].isdel ? (table[i].key+" "+table[i].value)+"\n" : "");
        }
        return result;
    }
    protected int getSize() {return table.length;}
}