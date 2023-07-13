package com.tutorial.junglechess;

public enum Sound {
  MOVE("res/sound/pieceMove.wav"),
  MOUSE("res/sound/mouse.wav"),
  CAT("res/sound/cat.wav"),
  WOLF("res/sound/wolf.wav"),
  DOG("res/sound/dog.wav"),
  LEOPARD("res/sound/leopard.wav"),
  TIGER("res/sound/tiger.wav"),
  LION("res/sound/lion.wav"),
  ELEPHANT("res/sound/elephant.wav");
  
  private String value;

  Sound(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
