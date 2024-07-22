package CodingProbs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Sample {

    public static void main(String[] args) {
        Map<Integer,String>  mp = new TreeMap<>();

        mp.put(5,"sai");
        mp.put(6,"STG");
        mp.put(1,"prakash");
        mp.put(3,"Srinath");

        for(Map.Entry<Integer,String> m : mp.entrySet())
            System.out.println("🔑 : "+m.getKey() + " ⏭ "+ m.getValue());

//        System.out.println(mp.);
    }
}
