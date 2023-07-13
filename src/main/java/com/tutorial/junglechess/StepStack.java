package com.tutorial.junglechess;

import java.util.*;

public class StepStack {

  private Stack<Set<Piece>> stepStack = new Stack<>();

  public void pushToStepStack(Set<Piece> pieces) {
    Set<Piece> deepCopyPieces = new HashSet<>();

    for (Piece piece : pieces) {
      deepCopyPieces.add(piece);
    }

    this.stepStack.push(deepCopyPieces);
  }

  public Stack<Set<Piece>> getStepStack() {
    return this.stepStack;
  }
}
