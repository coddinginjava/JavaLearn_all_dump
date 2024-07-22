package Threads.DeadLock;

public class MainApp {

    public static void main(String[] args) {
        Object book = new Object();
        Object pen = new Object();
        Thread t1 = new Thread(new Writer1(book, pen));
        Thread t2 = new Thread(new Writer2(book, pen));
        t1.start();
        t2.start();

        System.out.println("main has completed");
    }
}


class Writer1 implements Runnable {
    Object book, pen;

    public Writer1(Object book, Object pen) {
        this.book = book;
        this.pen = pen;
    }

    @Override
    public void run() {
        synchronized (book) {
            try {
               Thread.sleep(100);
            } catch (Exception e) {
            }
            synchronized (pen) {
                System.out.println("Writer one started writing");
            }
        }
    }
}

class Writer2 implements Runnable {
    Object book, pen;

    public Writer2(Object book, Object pen) {
        this.book = book;
        this.pen = pen;
    }

    @Override
    public void run() {
        synchronized (pen) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
            }
            synchronized (book) {
                System.out.println("Writer two started writing");
            }
        }
    }


}

