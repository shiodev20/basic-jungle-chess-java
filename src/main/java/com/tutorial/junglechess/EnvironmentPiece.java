/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorial.junglechess;

/**
 *
 * @author nghin
 */
public class EnvironmentPiece extends Piece {

    private EnvironmentType type;

    public EnvironmentPiece(int x, int y, EnvironmentType type, String imageName) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.imageName = imageName;
    }
}
