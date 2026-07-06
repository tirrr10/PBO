package Sesi10;

public class no4 {
    public static void main(String[] args) {
        int bil = 10;
        String b[] = { "a", "b", "c" };
        try {
            System.out.println(bil / 0); // Dipindahkan ke atas
            System.out.println(b[3]); // Dipindahkan ke bawah
        } catch (ArithmeticException e) {
            System.out.println("Terjadi Aritmatika error");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Melebihi jumlah array");
        } catch (Exception e) {
            System.out.println("Ini menghandle error yang terjadi");
        }
    }
}

/*
 * (Penjelasan Error: Karena baris System.out.println(b[3]); dieksekusi terlebih
 * dahulu,
 * program langsung melemparkan exception ArrayIndexOutOfBoundsException dan
 * langsung melompat
 * ke blok catch yang bersesuaian. Akibatnya, baris pembagian dengan nol (bil/0)
 * di bawahnya tidak sempat dieksekusi.)
 */