package Sesi11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVCopy {
    public static void main(String[] args) {
        String fileAsal = "D:\\students.csv";
        String fileTujuan = "D:\\students_backup.csv";

        String line;

        System.out.println("Memulai proses penyalinan file...");

        try (
                BufferedReader br = new BufferedReader(new FileReader(fileAsal));
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileTujuan))) {
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine(); // Menambahkan baris baru di file tujuan
            }
            System.out.println("Penyalinan selesai! File berhasil disalin ke: " + fileTujuan);

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat menyalin file.");
            e.printStackTrace();
        }
    }
}