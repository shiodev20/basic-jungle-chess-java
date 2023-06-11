/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorial.junglechess;

/**
 *
 * @author nghin
 */



public class PlayablePiece extends Piece{
    private Rank rank;
    private boolean isRiverPassable = false;
    
    public PlayablePiece(int x, int y, Rank rank, String imageName) {
        this.x = x;
        this.y = y;
        this.rank = rank;
        this.imageName = imageName;
        
        if(this.rank == Rank.WOLF || this.rank == Rank.LEOPARD) this.isRiverPassable = true;
    }
}
