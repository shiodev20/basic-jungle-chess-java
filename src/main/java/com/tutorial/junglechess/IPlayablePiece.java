/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tutorial.junglechess;

/**
 *
 * @author nghin
 */
public interface IPlayablePiece {
    
    public boolean isOutOfBoard(int x, int y);
    public boolean isSelfKilling(PlayablePiece targetPiece);
}
