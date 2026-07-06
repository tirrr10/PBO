package Sesi11;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVWriter {
    public static void main(String[] args) {
        String csvFile = "D:\\new_students.csv"; // Sesuaikan dengan path file Anda
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Tambah Data Mahasiswa Baru ---");
        System.out.print("Masukkan NIM   : ");
        String nim = scanner.nextLine();

        System.out.print("Masukkan Nama  : ");
        String nama = scanner.nextLine();

        System.out.print("Masukkan Umur  : ");
        String umur = scanner.nextLine();

        System.out.print("Masukkan Prodi : ");
        String prodi = scanner.nextLine();

        // Menggabungkan data menjadi satu baris berformat CSV
        String barisData = nim + "," + nama + "," + umur + "," + prodi;

        // Gunakan parameter 'true' pada FileWriter agar data baru di-append (tidak
        // menimpa data lama)
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
            bw.write(barisData);
            bw.newLine();
            System.out.println("Data berhasil ditambahkan ke " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}