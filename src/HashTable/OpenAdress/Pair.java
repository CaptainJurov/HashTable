package HashTable.OpenAdress;

class Pair<K, V> {
    K key;
    V value;
    boolean isdel;
    Pair(K key, V value) {
        this.key = key;
        this.value = value;
        this.isdel = false;
    }
}
