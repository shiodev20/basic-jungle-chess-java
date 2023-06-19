/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorial.junglechess;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author nghin
 */
public class Board {

  final static int[] xMarks = { 0, 80, 160, 240, 320, 400, 480, 560 };
  final static int[] yMarks = { 0, 80, 160, 240, 320, 400, 480, 560, 640, 720 };

  private Set<Piece> pieces = new HashSet<>();

  public Board() {
    // Trap
    pieces.add(new EnvironmentPiece(240, 560, Rank.TRAP, "res/trap.gif"));
    pieces.add(new EnvironmentPiece(160, 640, Rank.TRAP, "res/trap.gif"));
    pieces.add(new EnvironmentPiece(320, 640, Rank.TRAP, "res/trap.gif"));
    pieces.add(new EnvironmentPiece(240, 80, Rank.TRAP, "res/trap.gif"));
    pieces.add(new EnvironmentPiece(160, 0, Rank.TRAP, "res/trap.gif"));
    pieces.add(new EnvironmentPiece(320, 0, Rank.TRAP, "res/trap.gif"));

    // Den
    pieces.add(new EnvironmentPiece(240, 640, Rank.DEN, "res/den.gif"));
    pieces.add(new EnvironmentPiece(240, 0, Rank.DEN, "res/den.gif"));

    // River
    pieces.add(new EnvironmentPiece(80, 240, Rank.RIVER, "res/river.gif"));
    pieces.add(new EnvironmentPiece(80, 320, Rank.RIVER, "res/river.gif"));
    pieces.add(new EnvironmentPiece(80, 400, Rank.RIVER, "res/river.gif"));
    pieces.add(new EnvironmentPiece(160, 240, Rank.RIVER, "res/river.gif"));
    pieces.add(new EnvironmentPiece(160, 320, Rank.RIVER, "res/river.gif"));
    pieces.add(new EnvironmentPiece(160, 400, Rank.RIVER, "res/river.gif"));
    pieces.add(new EnvironmentPiece(320, 240, Rank.RIVER, "res/river.gif"));
    pieces.add(new EnvironmentPiece(320, 320, Rank.RIVER, "res/river.gif"));
    pieces.add(new EnvironmentPiece(320, 400, Rank.RIVER, "res/river.gif"));
    pieces.add(new EnvironmentPiece(400, 240, Rank.RIVER, "res/river.gif"));
    pieces.add(new EnvironmentPiece(400, 320, Rank.RIVER, "res/river.gif"));
    pieces.add(new EnvironmentPiece(400, 400, Rank.RIVER, "res/river.gif"));

    // Black team
    pieces.add(new PlayablePiece(0, 480, Rank.ELEPHANT, true, "res/blackPiece/elephant.gif"));
    pieces.add(new PlayablePiece(160, 480, Rank.WOLF, true, "res/blackPiece/wolf.gif"));
    pieces.add(new PlayablePiece(320, 480, Rank.LEOPARD, true, "res/blackPiece/leopard.gif"));
    pieces.add(new PlayablePiece(480, 480, Rank.MOUSE, true, "res/blackPiece/mouse.gif"));
    pieces.add(new PlayablePiece(80, 560, Rank.CAT, true, "res/blackPiece/cat.gif"));
    pieces.add(new PlayablePiece(400, 560, Rank.DOG, true, "res/blackPiece/dog.gif"));
    pieces.add(new PlayablePiece(0, 640, Rank.TIGER, true, "res/blackPiece/tiger.gif"));
    pieces.add(new PlayablePiece(480, 640, Rank.LION, true, "res/blackPiece/lion.gif"));

    // Red team
    pieces.add(new PlayablePiece(480, 160, Rank.ELEPHANT, false, "res/redPiece/elephant.gif"));
    pieces.add(new PlayablePiece(320, 160, Rank.WOLF, false, "res/redPiece/wolf.gif"));
    pieces.add(new PlayablePiece(160, 160, Rank.LEOPARD, false, "res/redPiece/leopard.gif"));
    pieces.add(new PlayablePiece(0, 160, Rank.MOUSE, false, "res/redPiece/mouse.gif"));
    pieces.add(new PlayablePiece(400, 80, Rank.CAT, false, "res/redPiece/cat.gif"));
    pieces.add(new PlayablePiece(80, 80, Rank.DOG, false, "res/redPiece/dog.gif"));
    pieces.add(new PlayablePiece(480, 0, Rank.TIGER, false, "res/redPiece/tiger.gif"));
    pieces.add(new PlayablePiece(0, 0, Rank.LION, false, "res/redPiece/lion.gif"));

    

  }

  public void movePiece(int fromX, int fromY, int toX, int toY) {
    boolean isValidStep = this.isValidStep(fromX, fromY, toX, toY);

    if(isValidStep) {

      if(this.getPieceAt(fromX, fromY) != null && this.getPieceAt(fromX, fromY).isPlayable()) {
        // PlayablePiece movedPiece = (PlayablePiece) this.getPieceAt(fromX, fromY);

        System.out.println(this.getPieceAt(fromX, fromY).getRank());

        // if(this.getPieceAt(toX, toY) != null && !this.getPieceAt(toX, toY).isPlayable()) {
        //   // PlayablePiece >< EnvironmentPiece
        //   EnvironmentPiece environmentPiece = (EnvironmentPiece) this.getPieceAt(toX, toY);

        //   switch (environmentPiece.getRank()) {
        //     case RIVER:
        //       if(movedPiece.isRiverPassable()) {
        //         this.pieces.remove(movedPiece);
        //         this.pieces.add(new PlayablePiece(toX, toY, movedPiece.getRank(), movedPiece.getSide(), movedPiece.getImageName()));
        //       }
        //       break;
        //     case TRAP:
        //       break;

        //     case DEN:
        //       break;
        //   }

        // }
        // else if(this.getPieceAt(toX, toY) != null && this.getPieceAt(toX, toY).isPlayable()) {
        //   // PlayablePiece >< PlayablePiece

        // }
        // else {
        //   // PlayablePiece >< Nothing
        //   this.pieces.remove(movedPiece);
        //   this.pieces.add(new PlayablePiece(toX, toY, movedPiece.getRank(), movedPiece.getSide(), movedPiece.getImageName()));
        // }

      }

    }
  }

  public boolean isValidStep(int fromX, int fromY, int toX, int toY) {
    int steps = 0;

    if(fromX == toX) steps = Math.abs(fromY - toY) / 80;
    else if(fromY == toY) steps = Math.abs(fromX - toX) / 80;

    return steps == 1;
  }

  public boolean isSelfKill(PlayablePiece movedPiece, PlayablePiece targetPiece) {
    return movedPiece.getSide() == targetPiece.getSide();
  }

  public Piece getPieceAt(int x, int y) {
    for (Piece piece : this.getPieces()) {
      if (piece.getX() == x && piece.getY() == y) {
        return piece;
      }
    }
    return null;
  }

  public Set<Piece> getPieces() {
    return this.pieces;
  }

  public int getXMark(int x) {
    int idx = 0;

    for (int i = xMarks.length - 1; i > 0; i--) {
      if (x > xMarks[i]) {
        idx = i;
        break;
      }
    }
    return xMarks[idx];
  }

  public int getYMark(int y) {
    int idx = 0;

    for (int i = yMarks.length - 1; i > 0; i--) {
      if (y > yMarks[i]) {
        idx = i;
        break;
      }
    }
    return yMarks[idx];
  }

}