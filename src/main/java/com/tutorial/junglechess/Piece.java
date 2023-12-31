/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorial.junglechess;

/**
 *
 * @author nghin
 */

public abstract class Piece {

  private int x, y;
  private String imageName;
  private Rank rank;
  private boolean playable = true;

  public Piece(int x, int y, Rank rank) {
    this.x = x;
    this.y = y;
    this.rank = rank;
    if (this.rank == Rank.TRAP || this.rank == Rank.DEN || this.rank == Rank.RIVER)
      this.playable = false;
  }

  public Piece(int x, int y, Rank rank, String imageName) {
    this(x, y, rank);
    this.imageName = imageName;
  }

  public boolean isPlayable() {
    return this.playable;
  }

  public String getImageName() {
    return imageName;
  }

  public void setImageName(String imageName) {
    this.imageName = imageName;
  }

  public Rank getRank() {
    return rank;
  }

  public void setRank(Rank rank) {
    this.rank = rank;
  }

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

}
