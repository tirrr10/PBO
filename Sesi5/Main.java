package Sesi5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("--- Simulasi Sistem Akademik ---");

        // Input Data Mahasiswa
        System.out.print("Masukkan Nama Mahasiswa: ");
        String sName = input.nextLine();
        System.out.print("Masukkan Alamat Mahasiswa: ");
        String sAddress = input.nextLine();
        Student s1 = new Student(sName, sAddress);

        System.out.print("Berapa mata kuliah yang ingin diinput? ");
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            input.nextLine(); // clear buffer
            System.out.print("Mata Kuliah ke-" + (i + 1) + ": ");
            String cName = input.nextLine();
            System.out.print("Nilai: ");
            int cGrade = input.nextInt();
            s1.addCourseGrade(cName, cGrade);
        }

        // Input Data Dosen
        input.nextLine(); // clear buffer
        System.out.println("\n--- Input Data Dosen ---");
        System.out.print("Masukkan Nama Dosen: ");
        String tName = input.nextLine();
        System.out.print("Masukkan Alamat Dosen: ");
        String tAddress = input.nextLine();
        Teacher t1 = new Teacher(tName, tAddress);

        System.out.print("Tambah Mata Kuliah yang Diampu: ");
        String tCourse = input.nextLine();
        if (t1.addCourse(tCourse)) {
            System.out.println("Mata kuliah berhasil ditambahkan.");
        } else {
            System.out.println("Mata kuliah sudah ada!");
        }

        // Menampilkan Hasil
        System.out.println("\n--- Ringkasan Data ---");
        System.out.println(s1.toString());
        s1.printGrades();
        System.out.println("Rata-rata Nilai: " + s1.getAverageGrade());

        System.out.println("\n" + t1.toString());

        input.close();
    }
}