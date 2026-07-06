package Sesi10;
/*  
public class no3 {  
    public static void main(String[] args) {
        int bil=10;
        System.out.println(bil/0);
    }
}
    (Variabel bil yang bernilai 10 dipaksa untuk dibagi dengan angka 0. 
    Di dalam ilmu matematika maupun arsitektur komputer, pembagian dengan angka nol 
    menghasilkan nilai tak hingga atau tidak terdefinisi. Ketika perintah ini dijalankan,
    Java akan langsung panik karena tidak bisa memproses hasilnya.)
 */

public class no3 {
    public static void main(String[] args) {
        int bil=10;
        try
        {
            System.out.println(bil/0);
        }
        catch (ArithmeticException e)
        {
            System.out.println("Terjadi Aritmatika error");
        }
        catch (Exception e)
        {
            System.out.println("Ini menghandle error yang terjadi");
        }
    }
}