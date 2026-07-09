package Sesi13;

import java.sql.*;
import java.util.Scanner;

public class AplikasiRetail {
    private static final String URL = "jdbc:mysql://localhost:3306/toko_retail";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    private static Connection conn;
    private static Scanner scanner = new Scanner(System.util.in);

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            int pilihan;
            do {
                tampilkanMenu();
                System.out.print("Pilihan : ");
                pilihan = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.println();

                switch (pilihan) {
                    case 1:
                        tampilSemuaData();
                        break;
                    case 2:
                        tambahData();
                        break;
                    case 3:
                        cariData();
                        break;
                    case 4:
                        ubahData();
                        break;
                    case 5:
                        hapusData();
                        break;
                    case 0:
                        System.out.println("Keluar dari program. Terima kasih!");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid!");
                }
                System.out.println();
            } while (pilihan != 0);

            conn.close();
        } catch (SQLException e) {
            System.out.println("Koneksi Database Gagal: " + e.getMessage());
        }
    }

    private static void tampilkanMenu() {
        System.out.println("+-------------------+");
        System.out.println("| MENU TOKO RETAIL  |");
        System.out.println("+-------------------+");
        System.out.println("| 1. Tampil Semua Data |");
        System.out.println("| 2. Tambah Data       |");
        System.out.println("| 3. Cari Data         |");
        System.out.println("| 4. Ubah Data         |");
        System.out.println("| 5. Hapus Data        |");
        System.out.println("| 0. Keluar            |");
        System.out.println("+-------------------+");
    }

    // MENU 1: Tampil Semua Data (Sesuai format tabel visual di image_ec159c.png)
    private static void tampilSemuaData() {
        String query = "SELECT * FROM barang";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("+------------------------------------------------------------+");
            System.out.println("|                 DAFTAR BARANG TOKO RETAIL                  |");
            System.out.println("+---+--------+---------------------------------+-------+-----+");
            System.out.printf("| %-1s | %-6s | %-31s | %-5s | %-3s |\n", "#", "Kode", "Nama Barang", "Harga", "Stok");
            System.out.println("+---+--------+---------------------------------+-------+-----+");

            int no = 1;
            while (rs.next()) {
                System.out.printf("| %-1d | %-6s | %-31s | %-5d | %-3d |\n",
                        no++,
                        rs.getString("kode"),
                        rs.getString("nama_barang"),
                        rs.getInt("harga"),
                        rs.getInt("stok"));
            }
            System.out.println("+---+--------+---------------------------------+-------+-----+");
            System.out.println("Total: " + (no - 1) + " barang");
        } catch (SQLException e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
    }

    // MENU 2: Tambah Data
    private static void tambahData() {
        System.out.println("[ TAMBAH DATA BARANG ]");
        System.out.print("Masukkan Kode Barang : ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan Nama Barang : ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Harga       : ");
        int harga = scanner.nextInt();
        System.out.print("Masukkan Stok        : ");
        int stok = scanner.nextInt();

        String query = "INSERT INTO barang (kode, nama_barang, harga, stok) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, kode);
            pstmt.setString(2, nama);
            pstmt.setInt(3, harga);
            pstmt.setInt(4, stok);
            pstmt.executeUpdate();
            System.out.println("Data sukses ditambahkan!");
        } catch (SQLException e) {
            System.out.println("Gagal menambahkan data: " + e.getMessage());
        }
    }

    // MENU 3: Cari Data
    private static void cariData() {
        System.out.println("[ CARI DATA BARANG ]");
        System.out.print("Masukkan Kode / Nama Barang yang dicari: ");
        String keyword = scanner.nextLine();

        String query = "SELECT * FROM barang WHERE kode = ? OR nama_barang LIKE ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, keyword);
            pstmt.setString(2, "%" + keyword + "%");
            ResultSet rs = pstmt.executeQuery();

            System.out.println("\nHasil Pencarian:");
            while (rs.next()) {
                System.out.printf("Kode: %s | Nama: %s | Harga: %d | Stok: %d\n",
                        rs.getString("kode"), rs.getString("nama_barang"), rs.getInt("harga"), rs.getInt("stok"));
            }
        } catch (SQLException e) {
            System.out.println("Gagal mencari data: " + e.getMessage());
        }
    }

    // MENU 4: Ubah Data
    private static void ubahData() {
        System.out.println("[ UBAH DATA BARANG ]");
        System.out.print("Masukkan Kode Barang yang akan diubah: ");
        String kode = scanner.nextLine();

        System.out.print("Nama Baru : ");
        String nama = scanner.nextLine();
        System.out.print("Harga Baru: ");
        int harga = scanner.nextInt();
        System.out.print("Stok Baru : ");
        int stok = scanner.nextInt();

        String query = "UPDATE barang SET nama_barang = ?, harga = ?, stok = ? WHERE kode = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, nama);
            pstmt.setInt(2, harga);
            pstmt.setInt(3, stok);
            pstmt.setString(4, kode);
            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("Data berhasil diperbarui!");
            else
                System.out.println("Kode barang tidak ditemukan!");
        } catch (SQLException e) {
            System.out.println("Gagal mengubah data: " + e.getMessage());
        }
    }

    // MENU 5: Hapus Data
    private static void hapusData() {
        System.out.println("[ HAPUS DATA BARANG ]");
        System.out.print("Masukkan Kode Barang yang akan dihapus: ");
        String kode = scanner.nextLine();

        String query = "DELETE FROM barang WHERE kode = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, kode);
            int rows = pstmt.executeUpdate();
            if (rows > 0)
                System.out.println("Data berhasil dihapus!");
            else
                System.out.println("Kode barang tidak ditemukan!");
        } catch (SQLException e) {
            System.out.println("Gagal menghapus data: " + e.getMessage());
        }
    }
}