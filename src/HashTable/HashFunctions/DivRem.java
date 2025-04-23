package HashTable.HashFunctions;

import HashTable.HashFunction;

public class DivRem<K> implements HashFunction<K> {
    @Override
    public int hash (K key) {
        return Math.abs(key.hashCode());
    }
}
