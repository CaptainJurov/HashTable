package HashTable;

public class LinkedList<K, V> {
    private Node<K, V> head;

    LinkedList () {
        head = null;
    }

    public void insert (K key, V val) {
        if (head == null) {
            head = new Node<>(key, val);
            return;
        }
        Node<K, V> current = head;
        head = new Node<>(key, val);
        head.next = current;
    }

    public V find (K key) {
        Node<K, V> current = head;
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public void remove(K key) {
        if (head == null) return;
        if (head.key.equals(key)) {
            head = head.next;
            return;
        }
        Node<K, V> current = head;
        while (current.next != null && !current.next.key.equals(key)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public Node<K, V> getHead () {
        return head;
    }
}
