package Threads.CopyFile;

import java.io.*;

public class UtilityClass implements Runnable {
    private String src;
    private String desc;

    public UtilityClass(String src, String desc) {
        this.src = src;
        this.desc = desc;
    }

    public void run() {
        try {
            Thread.sleep(2000);
            copyFiles();
            System.out.println("finished");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void copyFiles() throws IOException {

        File srcFile = new File(src);
        File desFile = new File(desc);

        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(desFile);

        transfer(fis, fos);

    }

    private void transfer(InputStream is, OutputStream os) throws IOException {
        int value;
        while ((value = is.read()) != -1) {
            os.write(value);
        }
    }
}
