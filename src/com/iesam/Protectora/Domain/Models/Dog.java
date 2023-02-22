package com.iesam.Protectora.Domain.Models;

public class Dog extends Animal{
    private String raza;
    private boolean amigable;

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isAmigable() {
        return amigable;
    }

    public void setAmigable(boolean amigable) {
        this.amigable = amigable;
    }
}
