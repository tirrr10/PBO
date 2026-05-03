package Sesi6.abstarct;

import Sesi6.interfaces.Laptop;

public abstract class LaptopAbstract implements Laptop {
    protected int volume = 50;

    public void statusVolume() {
        System.out.println("Volume Sekarang: " + volume);
    }
}
