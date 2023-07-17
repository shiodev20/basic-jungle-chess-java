
package com.tutorial.junglechess;

import java.awt.Point;
import java.io.File;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Board {

  private int[] xMarks = { 0, 80, 160, 240, 320, 400, 480, 560 };
  private int[] yMarks = { 0, 80, 160, 240, 320, 400, 480, 560, 640, 720 };

  private Set<Piece> pieces = new HashSet<>();
  private int totalBlackPiece = 8, totalRedPiece = 8;
  private boolean isBlackMove = true;
  private String winSide = "";

  public StepStack stepStack = new StepStack();

  public Board() {
    // Trap
    this.pieces.add(new EnvironmentPiece(240, 560, Rank.TRAP, "res/trap.gif"));
    this.pieces.add(new EnvironmentPiece(160, 640, Rank.TRAP, "res/trap.gif"));
    this.pieces.add(new EnvironmentPiece(320, 640, Rank.TRAP, "res/trap.gif"));
    this.pieces.add(new EnvironmentPiece(240, 80, Rank.TRAP, "res/trap.gif"));
    this.pieces.add(new EnvironmentPiece(160, 0, Rank.TRAP, "res/trap.gif"));
    this.pieces.add(new EnvironmentPiece(320, 0, Rank.TRAP, "res/trap.gif"));

    // Den
    this.pieces.add(new EnvironmentPiece(240, 640, Rank.DEN, "res/den.gif"));
    this.pieces.add(new EnvironmentPiece(240, 0, Rank.DEN, "res/den.gif"));

    // River
    this.pieces.add(new EnvironmentPiece(80, 240, Rank.RIVER));
    this.pieces.add(new EnvironmentPiece(80, 320, Rank.RIVER));
    this.pieces.add(new EnvironmentPiece(80, 400, Rank.RIVER));
    this.pieces.add(new EnvironmentPiece(160, 240, Rank.RIVER));
    this.pieces.add(new EnvironmentPiece(160, 320, Rank.RIVER));
    this.pieces.add(new EnvironmentPiece(160, 400, Rank.RIVER));
    this.pieces.add(new EnvironmentPiece(320, 240, Rank.RIVER));
    this.pieces.add(new EnvironmentPiece(320, 320, Rank.RIVER));
    this.pieces.add(new EnvironmentPiece(320, 400, Rank.RIVER));
    this.pieces.add(new EnvironmentPiece(400, 240, Rank.RIVER));
    this.pieces.add(new EnvironmentPiece(400, 320, Rank.RIVER));
    this.pieces.add(new EnvironmentPiece(400, 400, Rank.RIVER));

    // Black team
    this.pieces.add(new PlayablePiece(0, 480, Rank.ELEPHANT, true, "res/blackPiece/elephant.gif"));
    this.pieces.add(new PlayablePiece(160, 480, Rank.WOLF, true, "res/blackPiece/wolf.gif"));
    this.pieces.add(new PlayablePiece(320, 480, Rank.LEOPARD, true, "res/blackPiece/leopard.gif"));
    this.pieces.add(new PlayablePiece(480, 480, Rank.MOUSE, true, "res/blackPiece/mouse.gif"));
    this.pieces.add(new PlayablePiece(80, 560, Rank.CAT, true, "res/blackPiece/cat.gif"));
    this.pieces.add(new PlayablePiece(400, 560, Rank.DOG, true, "res/blackPiece/dog.gif"));
    this.pieces.add(new PlayablePiece(0, 640, Rank.TIGER, true, "res/blackPiece/tiger.gif"));
    this.pieces.add(new PlayablePiece(480, 640, Rank.LION, true, "res/blackPiece/lion.gif"));

    // Red team
    this.pieces.add(new PlayablePiece(480, 160, Rank.ELEPHANT, false, "res/redPiece/elephant.gif"));
    this.pieces.add(new PlayablePiece(320, 160, Rank.WOLF, false, "res/redPiece/wolf.gif"));
    this.pieces.add(new PlayablePiece(160, 160, Rank.LEOPARD, false, "res/redPiece/leopard.gif"));
    this.pieces.add(new PlayablePiece(0, 160, Rank.MOUSE, false, "res/redPiece/mouse.gif"));
    this.pieces.add(new PlayablePiece(400, 80, Rank.CAT, false, "res/redPiece/cat.gif"));
    this.pieces.add(new PlayablePiece(80, 80, Rank.DOG, false, "res/redPiece/dog.gif"));
    this.pieces.add(new PlayablePiece(480, 0, Rank.TIGER, false, "res/redPiece/tiger.gif"));
    this.pieces.add(new PlayablePiece(0, 0, Rank.LION, false, "res/redPiece/lion.gif"));

    this.trackStepStack(this.pieces);
  }

  public void movePiece(int fromX, int fromY, int toX, int toY) {
    boolean isValidStep = this.isValidStep(fromX, fromY, toX, toY);

    if (isValidStep) {

      if (this.getPieceAt(fromX, fromY) != null && this.getPieceAt(fromX, fromY).isPlayable()) {

        PlayablePiece movedPiece = (PlayablePiece) this.getPieceAt(fromX, fromY);

        if (movedPiece.getSide() == this.isBlackMove) {

          if (this.getPieceAt(toX, toY) != null && !this.getPieceAt(toX, toY).isPlayable()) {
            // PlayablePiece >< EnvironmentPiece

            EnvironmentPiece environmentPiece = (EnvironmentPiece) this.getPieceAt(toX, toY);

            switch (environmentPiece.getRank()) {
              case RIVER:
                if (movedPiece.isRiverPassable()) {
                  this.pieces.remove(movedPiece);
                  this.pieces.remove(environmentPiece);

                  PlayablePiece newPiece = new PlayablePiece(toX, toY, movedPiece.getRank(), movedPiece.getSide(),
                      movedPiece.getImageName());
                  this.pieces.add(newPiece);

                  this.trackMove();
                }
                break;

              case TRAP:
                if (this.getSideOfTrap(environmentPiece) != movedPiece.getSide()) {
                  this.pieces.remove(movedPiece);
                  this.pieces.remove(environmentPiece);

                  PlayablePiece newPiece = new PlayablePiece(toX, toY, Rank.DISABLED, movedPiece.getSide(),
                      movedPiece.getImageName());
                  this.pieces.add(newPiece);
                  this.trackMove();
                }
                break;

              case DEN:
                this.winSide = movedPiece.getSide() ? "black" : "red";
                this.trackMove();
                break;
            }

            this.playSoundEffect(Sound.MOVE.getValue());

          } else if (this.getPieceAt(toX, toY) != null && this.getPieceAt(toX, toY).isPlayable()) {
            // PlayablePiece >< PlayablePiece

            PlayablePiece targetPiece = (PlayablePiece) this.getPieceAt(toX, toY);

            if (movedPiece.getSide() != targetPiece.getSide()) {

              if (
                  (movedPiece.getRank().getValue() >= targetPiece.getRank().getValue()) ||
                  (movedPiece.getRank().getValue() == 1 && targetPiece.getRank().getValue() == 8)
              ) {
                
                if(movedPiece.getRank().getValue() == 8 && targetPiece.getRank().getValue() == 1) {

                }
                else {
                  this.pieces.remove(movedPiece);
                  this.pieces.remove(targetPiece);
                  this.pieces.add(new PlayablePiece(toX, toY, movedPiece.getRank(), movedPiece.getSide(), movedPiece.getImageName()));
  
                  if (targetPiece.getSide()) this.totalBlackPiece -= 1;
                  else this.totalRedPiece -= 1;
  
                  this.trackMove();
  
                  switch (movedPiece.getRank()) {
                    case MOUSE:
                      this.playSoundEffect(Sound.MOUSE.getValue());
                      break;
                    case CAT:
                      this.playSoundEffect(Sound.CAT.getValue());
                      break;
                    case WOLF:
                      this.playSoundEffect(Sound.WOLF.getValue());
                      break;
                    case DOG:
                      this.playSoundEffect(Sound.DOG.getValue());
                      break;
                    case LEOPARD:
                      this.playSoundEffect(Sound.LEOPARD.getValue());
                      break;
                    case TIGER:
                      this.playSoundEffect(Sound.TIGER.getValue());
                      break;
                    case LION:
                      this.playSoundEffect(Sound.LION.getValue());
                      break;
                    case ELEPHANT:
                      this.playSoundEffect(Sound.ELEPHANT.getValue());
                      break;
                  }

                }

              }

            }

          } else {
            // PlayablePiece >< Nothing
            this.pieces.remove(movedPiece);
            this.pieces.add(new PlayablePiece(toX, toY, movedPiece.getRank(), movedPiece.getSide(), movedPiece.getImageName()));

            this.playSoundEffect(Sound.MOVE.getValue());
            this.trackMove();
          }
        
        }

        this.trackStepStack(this.pieces);
        this.trackPieceTotal();
        this.trackEnvironments();
      }

    }

  }

  public boolean isValidStep(int fromX, int fromY, int toX, int toY) {
    int steps = 0;

    if (fromX == toX) {
      steps = Math.abs(fromY - toY) / 80;
    } else if (fromY == toY) {
      steps = Math.abs(fromX - toX) / 80;
    }

    return steps == 1;
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

  public Set<Point> getRiverPoints() {
    Set<Point> points = new HashSet<>();

    points.add(new Point(80, 240));
    points.add(new Point(80, 320));
    points.add(new Point(80, 400));
    points.add(new Point(160, 240));
    points.add(new Point(160, 320));
    points.add(new Point(160, 400));
    points.add(new Point(320, 240));
    points.add(new Point(320, 320));
    points.add(new Point(320, 400));
    points.add(new Point(400, 240));
    points.add(new Point(400, 320));
    points.add(new Point(400, 400));

    return points;
  }

  public boolean getMoveSide() {
    return this.isBlackMove;
  }

  public boolean getSideOfTrap(EnvironmentPiece piece) {
    boolean isBlack = true;

    if (piece.getY() <= 240) {
      isBlack = false;
    }

    return isBlack;
  }

  public void trackEnvironments() {
    for (Point point : this.getRiverPoints()) {
      if (this.getPieceAt(point.x, point.y) == null) {
        pieces.add(new EnvironmentPiece(point.x, point.y, Rank.RIVER));
      }
    }
  }

  public void trackPieceTotal() {
    if (this.totalBlackPiece == 0) {
      this.winSide = "red";
    }
    if (this.totalRedPiece == 0) {
      this.winSide = "black";
    }
  }

  public void trackMove() {
    this.isBlackMove = !this.isBlackMove;
  }

  public String trackWin() {
    return this.winSide;
  }

  public void trackStepStack(Set<Piece> pieces) {
    this.stepStack.pushToStepStack(this.pieces);
  }

  public void handleBackStep() {
    if (this.stepStack.getStepStack().size() > 1) {
      this.stepStack.getStepStack().pop();
      this.pieces = this.stepStack.getStepStack().peek();
      this.trackMove();
    }
  }

  public void playSoundEffect(String location) {
    try {
      File soundPath = new File(location);

      if (soundPath.exists()) {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundPath);

        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();

      } else {
        System.out.println("Can't not play sound effect");
      }

    } catch (Exception e) {
      System.out.println(e);
    }
  }

}
