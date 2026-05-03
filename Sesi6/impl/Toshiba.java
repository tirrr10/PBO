package Sesi6.impl;

import Sesi6.abstarct.LaptopAbstract;

public class Toshiba extends LaptopAbstract {

    public void powerOn() {
        System.out.println("Laptop Toshiba menyala...");
    }

    public void powerOff() {
        System.out.println("Laptop Toshiba mati...");
    }

    public void volumeUp() {
        volume += 10;
        System.out.println("Volume Toshiba naik");
        statusVolume();
    }

    public void volumeDown() {
        volume -= 10;
        System.out.println("Volume Toshiba turun");
        statusVolume();
    }
}
