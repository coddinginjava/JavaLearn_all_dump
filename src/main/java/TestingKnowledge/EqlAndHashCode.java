package TestingKnowledge;

public class EqlAndHashCode {
    public static void main(String[] args) {

//        findings if hascode are same for set now issues but
//        if equal are always true then hashSet will  the first element


//        Set<Integer> ls = new HashSet<>();
//        System.out.println(ls.add(1)); // true
//        System.out.println(ls.add(2)); // true
//        System.out.println(ls.add(1)); // false
//
//        System.out.println("ls = " + ls);


//````````````````````set `````````````````````````````````
//        Labour l1 = new Labour("sai", 1);
////        Labour l2 = l1;
//        Labour l2 = new Labour("stg", 2);
//        Labour l3 = new Labour("si", 3);
//
//        Set<Labour> set = new HashSet<>();
//        set.add(l1);
//        set.add(l2);
//        set.add(l3);
//
//        for (Labour l : set)
//            System.out.println("l = " + l);

//
//        Labour l1 = new Labour("sai", 1);
////        Labour l2 = l1;
//        Labour l2 = new Labour("stg", 2);
//        Labour l3 = new Labour("si", 3);
//
//        Map<Labour, Integer> map = new HashMap<>();
//        map.put(l1, 1);
//        map.put(l2, 2);
//        map.put(l3, 3);
//
//        for (Map.Entry<Labour, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " ➡ " + entry.getValue());
//        }


        int oldCapacity = 10;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        System.out.println("newCapacity = " + newCapacity);


        System.out.println("A".hashCode());
    }
}

class Labour {
    private int id;
    private String name;

    public Labour(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    @Override
    public String toString() {
        return name;
    }
}