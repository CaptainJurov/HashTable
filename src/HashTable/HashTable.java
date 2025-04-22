package HashTable;

public interface HashTable<K, V> {
    V get(K key);
    void insert(K key, V val);
    void remove(K key);
}
