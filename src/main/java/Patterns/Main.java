package Patterns;

public class Main {

    public static void main(String[] args) {
        SingletonJava s1 = SingletonJava.getInstance();
        SingletonJava s2 = SingletonJava.getInstance();

        System.out.println(s1 == s2);

    }
}
