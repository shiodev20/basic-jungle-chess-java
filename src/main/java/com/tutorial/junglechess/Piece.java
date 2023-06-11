/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorial.junglechess;

/**
 *
 * @author nghin
 */
enum Rank {
    MOUSE,
    CAT,
    WOLF,
    DOG,
    LEOPARD,
    TIGER,
    LION,
    ELEPHANT 
}

enum EnvironmentType {
    TRAP,
    DEN,
    RIVER
}
public abstract class Piece {
    int x, y;
    String imageName;
    
//    public abstract boolean isOutOfBoard();
//    public abstract boolean isSelfKilling();
//    public abstract boolean isValidMove();
//    public abstract void move();

    public String getImageName() {
        return imageName;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
}
