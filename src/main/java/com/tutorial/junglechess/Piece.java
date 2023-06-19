/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorial.junglechess;

/**
 *
 * @author nghin
 */
// enum Rank {
//   MOUSE,
//   CAT,
//   WOLF,
//   DOG,
//   LEOPARD,
//   TIGER,
//   LION,
//   ELEPHANT,
//   TRAP,
//   DEN,
//   RIVER
// }

// enum EnvironmentType {
//
// }
public abstract class Piece {

  int x, y;
  String imageName;
  Rank rank;
  boolean playable = true;

  Piece(int x, int y, Rank rank, String imageName) {
    this.x = x;
    this.y = y;
    this.rank = rank;
    this.imageName = imageName;

    if (this.rank == Rank.TRAP || this.rank == Rank.DEN || this.rank == Rank.RIVER)
      this.playable = false;
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
