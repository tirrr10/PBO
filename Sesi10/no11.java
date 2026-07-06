package Sesi10;

class RangeErrorException extends Throwable {
    public RangeErrorException(String s) {
        super(s);
    }
}

public class no11 { // Menyediakan kelas utama pembungkus method main
    public static void main(String[] args) {
        int position = 1;
        try {
            if (position > 0) {
                throw new RangeErrorException("Position " + position);
            }
        } catch (RangeErrorException e) {
            System.out.println("Range error: " + e.getMessage());
        }

        System.out.println("This is the last program.");
    }
}