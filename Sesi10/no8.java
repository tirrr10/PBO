package Sesi10;

import java.io.*;

public class no8 {
    public void methodA() {
        System.out.println("Method A");
    }

    public void methodB() throws IOException {
        System.out.println(20 / 0);
        System.out.println("Method B");
    }
}

class Utama {
    public static void main(String[] args) throws IOException {
        no8 c = new no8();
        c.methodA();
        c.methodB();
    }
}