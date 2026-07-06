package Sesi10;

public class no5 {

    public static void main(String[] args) {
        int bil = 10;
        try {
            System.out.println(bil / 0);
        } catch (ArithmeticException e) {
            System.out.println("Pesan error: ");
            System.out.println(e.getMessage());
            System.out.println("Info stack erase");
            e.printStackTrace();
            e.printStackTrace(System.out);
        } catch (Exception e) {
            System.out.println("Ini menghandle error yang terjadi");
        }
    }
}
/*
 * (Analisis: Penggunaan try-catch pada kode ini sangat baik karena menerapkan
 * prinsip urutan penanganan dari
 * yang paling spesifik (ArithmeticException) menuju yang paling umum
 * (Exception). Program berhasil menangani error
 * pembagian nol dengan aman tanpa membuat aplikasi crash secara mendadak.)
 */