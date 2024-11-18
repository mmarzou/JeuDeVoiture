package com.example.model;

import jakarta.persistence.Entity;

@Entity
public class Audi extends Vehicle {
    public Audi() {
        super();
    }

    public Audi(int x, int y) {
        super(x, y, 0, "Audi", "/images/Audi.png");
    }

    @Override
    public void move() {
        this.x += this.speed;
    }

    @Override
    public void accelerate() {
        if (this.speed < 15) { // Audi accélère plus vite
            this.speed += 2;
        }
    }

    @Override
    public void brake() {
        if (this.speed > 0) {
            this.speed--;
        }
    }
} 