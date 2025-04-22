package HashTable;

class Node<K, V> {
    K key;
    V value;
    public Node<K, V> next;

    Node (K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
