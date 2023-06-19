/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorial.junglechess;

/**
 *
 * @author nghin
 */
public class PlayablePiece extends Piece {

  private boolean isRiverPassable;
  private boolean isBlack;
  private boolean isTrapped;

  public PlayablePiece(int x, int y, Rank rank, boolean isBlack, String imageName) {
    super(x, y, rank, imageName);
    this.isBlack = isBlack;
    if (this.rank == Rank.MOUSE) this.isRiverPassable = true;
  }

  public boolean getSide() {
    return this.isBlack;
  }

  public boolean isRiverPassable() {
    return this.isRiverPassable;
  }

  public boolean isTrapped() {
    return isTrapped;
  }

  public void setIsTrapped() {
    
  }
}
