package DS.most_orig.level1.HashTable;

import java.util.LinkedList;

public class MyHashtable {
    private class Entry {
        public int Key;
        public String value;

        public Entry(int key, String value) {
            Key = key;
            this.value = value;
        }
    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value) {
        int index = hash(key);

        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        for (Entry entry : entries[index]) {
            if (entry.Key == key) {
                entry.value = value;
                return;
            }
        }


        entries[index].addLast(new Entry(key, value));
    }

    public String get(int key) {
        int index = hash(key);

        LinkedList<Entry> entry = entries[index];

        if (entry != null) {
            for (Entry e : entry) {
                if (e.Key == key) {
                    return e.value;
                }
            }
            return null;
        }

        return null;
    }

    public void remove(int key) {
        int index = hash(key);

        if (entries[index] != null) {

            for (Entry entry : entries[index]) {
                if (entry.Key == key) {
                    entries[index].remove(entry);
                    return;
                }
            }
        }

    }

    private int hash(int key) {
        return key % entries.length;
    }

}

