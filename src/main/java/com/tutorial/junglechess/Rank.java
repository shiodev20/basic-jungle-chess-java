package com.tutorial.junglechess;

public enum Rank {
  MOUSE(1),
  CAT(2),
  WOLF(3),
  DOG(4),
  LEOPARD(5),
  TIGER(6),
  LION(7),
  ELEPHANT(8),
  TRAP(0),
  DEN(0),
  RIVER(0),
  DISABLED(0);
  
  private int value;

  Rank(int value) {
    this.value = value;
  }

  public int getValue() {
    return this.value;
  }
}
