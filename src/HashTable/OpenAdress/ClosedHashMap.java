package HashTable.OpenAdress;

import HashTable.HashTable;

public class ClosedHashMap<K, V> implements HashTable<K, V> {
    private Pair<K, V>[] table;

    public ClosedHashMap(int size) {
        this.table = new Pair[size];
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
            result+="\n["+i+"] - ";
            result+=(table[i] != null && !table[i].isdel ? table[i].value : "null");
        }
        return result;
    }
}