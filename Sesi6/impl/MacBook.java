package Sesi6.impl;

import Sesi6.abstarct.LaptopAbstract;

public class MacBook extends LaptopAbstract {

    public void powerOn() {
        System.out.println("MacBook menyala.....");
    }

    public void powerOff() {
        System.out.println("MacBook mati...");
    }

    public void volumeUp() {
        volume += 5;
        System.out.println("Volume MacBook naik");
        statusVolume();
    }

    public void volumeDown() {
        volume -= 5;
        System.out.println("Volume MacBook turun");
        statusVolume();
    }
}
