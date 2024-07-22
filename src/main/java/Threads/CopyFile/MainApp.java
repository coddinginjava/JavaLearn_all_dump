package Threads.CopyFile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {
    public static void main(String[] args) throws IOException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

//        File test=new File("check.txt");
////        if (test.createNewFile()) {
//            System.out.println("File created: " + test.getAbsolutePath());
////        }

        executorService.submit(new UtilityClass("a.txt","b.txt"));

        executorService.shutdown();

    }
}
