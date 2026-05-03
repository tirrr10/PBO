package Sesi7.no2;

import java.util.ArrayList;
import java.util.ArrayDeque;

public class Collection {
    public static void main(String[] args) {
        // 1. Contoh ArrayList
        ArrayList<String> listMahasiswa = new ArrayList<>();
        listMahasiswa.add("Ferdi");
        listMahasiswa.add("Alice");
        System.out.println("ArrayList: " + listMahasiswa);

        // 2. Contoh ArrayDeque (Bisa tambah di depan atau belakang)
        ArrayDeque<String> antrian = new ArrayDeque<>();
        antrian.addLast("Antrian 1");
        antrian.addLast("Antrian 2");
        antrian.addFirst("Prioritas"); // Menambah ke urutan paling depan

        System.out.println("ArrayDeque: " + antrian);
    }
}