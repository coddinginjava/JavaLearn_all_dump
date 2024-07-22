package Patterns;

public class SingletonJava {

    private static  SingletonJava singletonJava = null;

    private SingletonJava (){

    }

    public  static synchronized SingletonJava getInstance(){
        if(singletonJava ==null)
            singletonJava = new SingletonJava();
        return  singletonJava;
    }
}
