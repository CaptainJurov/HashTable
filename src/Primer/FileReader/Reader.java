package Primer.FileReader;

import HashTable.Chain.ChainHashMap;
import HashTable.HashFunctions.DivRem;
import HashTable.OpenAdress.ClosedHashMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Reader extends ClosedHashMap<Character, Integer> {

    public Reader (int size) {
        super(size, new DivRem<>());
    }
    public void read(String name) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(name));
            String line;
            while ((line = reader.readLine()) != null) {
                for (Character s : line.toLowerCase().toCharArray()) {
                    Integer val = get(s);
                    if (val==null) val=0;
                    insert(s, ++val);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Файла такого нет");
        }
    }
    public void write(String name) {
        try {
            FileWriter fw = new FileWriter(name);

            fw.write(toString());

            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
