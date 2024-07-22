package Patterns;

public class SingletonJava {

    private static volatile SingletonJava instance ;

    private SingletonJava (){

    }

    public  static SingletonJava getInstance(){
        if(instance ==null)
            synchronized (SingletonJava.class){
                if(instance ==null)
                    instance = new SingletonJava();
            }
        return  instance;
    }
}
