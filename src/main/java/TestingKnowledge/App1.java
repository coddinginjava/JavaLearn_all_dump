package TestingKnowledge;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class App1 {

    public synchronized static final void main(String[] args) {

        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();

        App1 a = new App1();


    }
}


final class App1_a {
    public App1_a() {
        System.out.println("created  app1_a");
    }
}
