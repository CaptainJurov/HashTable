package Primer.FileReader;

import HashTable.HashFunction;
import HashTable.HashFunctions.DivRem;
import HashTable.OpenAdress.ClosedHashMap;

public class Reader extends ClosedHashMap<String, Integer> {
    public Reader (int size) {
        super(size, new DivRem<>());
    }
}
