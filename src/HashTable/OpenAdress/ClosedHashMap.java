package HashTable.OpenAdress;

import HashTable.HashTable;

public class ClosedHashMap<K, V> implements HashTable<K, V> {
    private Pair<K, V>[] table;
    private int size;

    public ClosedHashMap (int size) {
        this.size = size;
        table = new Pair[size];
        for (int i = 0; i < size; i++) {
            table[i] = null;
        }
    }

    private int hash (K key) {
        return (int) (Math.pow(key.hashCode(), 2) % size);
    }

    private int getIndex (int num) {
        return (num) % table.length;
    }

    @Override
    public V get (K key) {
        int index = hash(key);
        for (int i = 0; i < table.length; i++) {
            Pair<K, V> p = table[getIndex(i + index)];
            if (p == null) return null;
            if (p.key.equals(key)) return p.value;
        }
        return null;
    }

    @Override
    public void insert (K key, V val) {
        int index = hash(key);
        for (int i = 0; i < table.length; i++) {
            Pair<K, V> p = table[getIndex(i + index)];
            if (p == null) {
                table[getIndex(i + index)] = new Pair<>(key, val);
                return;
            } else if (p.key.equals(key)) {
                p.value = val;
                return;
            }
        }
    }

    @Override
    public void remove (K key) {
        int index = hash(key);
        for (int i = 0; i < table.length; i++) {
            Pair<K, V> p = table[getIndex(i + index)];
            if (p == null) return;
            if (p.key.equals(key)) {
                table[getIndex(i+index)] = null;
                return;
            }
        }
    }

    @Override
    public String toString () {
        String result = "";
        for (int i=0;i<table.length;i++) {
            result+="\n["+i+"] - ";
            if (table[i]!=null) result+=table[i].value.toString();
            else result+="null";
        }
        return result;
    }
}
