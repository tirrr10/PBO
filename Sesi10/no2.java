package Sesi10;

/* 
public class no2 {
    public static void main(String[] args) {
        int i=0;
        String greeting[]={
            "Hello World!",
            "No, I mean it!",
            "Hello World"
        };
        
        while(i<4)
        {
            System.out.println(greeting[i]);
            i++;
        }
    }
}
    (Masalah muncul karena perintah perulangan tertulis while(i<4). Kondisi ini memaksa perulangan untuk 
    terus berjalan selama nilai i belum mencapai 4. Artinya, perulangan akan tetap mengeksekusi kode di dalamnya saat 
    nilai i berada di angka 0, 1, 2, dan 3 (total 4 kali jalan).)
*/

public class no2 {
    public static void main(String[] args) {
        int i = 0;
        String greetings[] = {
                "Hello World!",
                "No, I mean it!",
                "HELLO WORLD!"
        };

        while (i < 4) {
            try {
                System.out.println(greetings[i]);
                i++;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Resetting index value");
                i = 0; // <--- Ini yang bikin perulangan muter terus tanpa henti
            }
        }
    }
}