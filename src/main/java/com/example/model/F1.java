package com.example.model;

import jakarta.persistence.Entity;

@Entity
public class F1 extends Vehicle {
    public F1() {
        super();
    }

    public F1(int x, int y) {
        super(x, y, 0, "F1", "/images/F1.png");
    }

    @Override
    public void move() {
        this.x += this.speed;
    }

    @Override
    public void accelerate() {
        if (this.speed < 30) { // F1 accélère plus vite
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