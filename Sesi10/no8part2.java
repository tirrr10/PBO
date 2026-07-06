package Sesi10;

import java.io.*;

class UtamaModifikasi {
    public static void main(String[] args) {
        no8 o = new no8();
        o.methodA();
        try {
            o.methodB();
        } catch (Exception e) {
            System.out.println("Error di Method B");
        } finally {
            System.out.println("Ini selalu dicetak");
        }
    }
}