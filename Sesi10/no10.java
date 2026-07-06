package Sesi10;

import java.io.*;

class RandomAccessRevisi {

    public static void main(String[] args) {
        String bookList[] = { "Satu", "Dua", "Tiga" };
        int yearList[] = { 1920, 1230, 1440 }; // Diubah dari 1940 ke 1440 sesuai ketikan di gambar

        try {
            RandomAccessFile books = new RandomAccessFile("books.txt", "rw");

            // Menulis data ke file txt
            for (int i = 0; i < 3; i++) {
                books.writeUTF(bookList[i]);
                books.writeInt(yearList[i]);
            }

            // Mengembalikan pointer ke posisi awal file (indeks 0)
            books.seek(0);

            // Membaca data baris pertama dan kedua
            System.out.println(books.readUTF() + " " + books.readInt());
            System.out.println(books.readUTF() + " " + books.readInt());

            books.close();
        } catch (IOException e) {
            System.out.println("Indeks melebihi batas");
        }

        System.out.println("test");
    }
}