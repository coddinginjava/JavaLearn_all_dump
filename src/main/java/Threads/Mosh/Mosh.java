package Threads.Mosh;

import java.util.concurrent.CompletableFuture;

public class Mosh {
    public static void main(String[] args) {

        MailServer.sendAsync();

        System.out.println("hello world");

        simulateDelay(5000);
    }



    public static void simulateDelay(Integer timeInMilli){
        try {
            Thread.sleep(timeInMilli);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
class MailServer {
    public static void send(){
        Mosh.simulateDelay(3000);
        System.out.println("Mail sent");
    }

    public static CompletableFuture<Void> sendAsync () {
        return CompletableFuture.runAsync(() -> send());
    }
}
