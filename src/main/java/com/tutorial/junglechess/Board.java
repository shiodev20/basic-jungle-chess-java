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

    final static int ROWS = 10;
    final static int COLS = 8;

    private Set<Piece> playablePieces = new HashSet<Piece>();
    private Set<Piece> environmentPieces = new HashSet<Piece>();

    public Board() {
//      Black team
        playablePieces.add(new PlayablePiece(0, 480, Rank.ELEPHANT, "res/blackPiece/elephant.gif"));
        playablePieces.add(new PlayablePiece(160, 480, Rank.WOLF, "res/blackPiece/wolf.gif"));
        playablePieces.add(new PlayablePiece(320, 480, Rank.LEOPARD, "res/blackPiece/leopard.gif"));
        playablePieces.add(new PlayablePiece(480, 480, Rank.MOUSE, "res/blackPiece/mouse.gif"));
        playablePieces.add(new PlayablePiece(80, 560, Rank.CAT, "res/blackPiece/cat.gif"));
        playablePieces.add(new PlayablePiece(400, 560, Rank.DOG, "res/blackPiece/dog.gif"));
        playablePieces.add(new PlayablePiece(0, 640, Rank.TIGER, "res/blackPiece/tiger.gif"));
        playablePieces.add(new PlayablePiece(480, 640, Rank.LION, "res/blackPiece/lion.gif"));

//      Red team
        playablePieces.add(new PlayablePiece(480, 160, Rank.ELEPHANT, "res/redPiece/elephant.gif"));
        playablePieces.add(new PlayablePiece(320, 160, Rank.WOLF, "res/redPiece/wolf.gif"));
        playablePieces.add(new PlayablePiece(160, 160, Rank.LEOPARD, "res/redPiece/leopard.gif"));
        playablePieces.add(new PlayablePiece(0, 160, Rank.MOUSE, "res/redPiece/mouse.gif"));
        playablePieces.add(new PlayablePiece(400, 80, Rank.CAT, "res/redPiece/cat.gif"));
        playablePieces.add(new PlayablePiece(80, 80, Rank.DOG, "res/redPiece/dog.gif"));
        playablePieces.add(new PlayablePiece(480, 0, Rank.TIGER, "res/redPiece/tiger.gif"));
        playablePieces.add(new PlayablePiece(0, 0, Rank.LION, "res/redPiece/lion.gif"));
        
        
//      Trap
        environmentPieces.add(new EnvironmentPiece(240, 560, EnvironmentType.TRAP, "res/trap.gif"));
        environmentPieces.add(new EnvironmentPiece(160, 640, EnvironmentType.TRAP, "res/trap.gif"));
        environmentPieces.add(new EnvironmentPiece(320, 640, EnvironmentType.TRAP, "res/trap.gif"));
        environmentPieces.add(new EnvironmentPiece(240, 80, EnvironmentType.TRAP, "res/trap.gif"));
        environmentPieces.add(new EnvironmentPiece(160, 0, EnvironmentType.TRAP, "res/trap.gif"));
        environmentPieces.add(new EnvironmentPiece(320, 0, EnvironmentType.TRAP, "res/trap.gif"));
        
        
//      Den
        environmentPieces.add(new EnvironmentPiece(240, 640, EnvironmentType.DEN, "res/den.gif"));
        environmentPieces.add(new EnvironmentPiece(240, 0, EnvironmentType.DEN, "res/den.gif"));

        
//      River
        environmentPieces.add(new EnvironmentPiece(80, 240, EnvironmentType.RIVER, "res/river.gif"));
        environmentPieces.add(new EnvironmentPiece(80, 320, EnvironmentType.RIVER, "res/river.gif"));
        environmentPieces.add(new EnvironmentPiece(80, 400, EnvironmentType.RIVER, "res/river.gif"));
        environmentPieces.add(new EnvironmentPiece(160, 240, EnvironmentType.RIVER, "res/river.gif"));
        environmentPieces.add(new EnvironmentPiece(160, 320, EnvironmentType.RIVER, "res/river.gif"));
        environmentPieces.add(new EnvironmentPiece(160, 400, EnvironmentType.RIVER, "res/river.gif"));
        environmentPieces.add(new EnvironmentPiece(320, 240, EnvironmentType.RIVER, "res/river.gif"));
        environmentPieces.add(new EnvironmentPiece(320, 320, EnvironmentType.RIVER, "res/river.gif"));
        environmentPieces.add(new EnvironmentPiece(320, 400, EnvironmentType.RIVER, "res/river.gif"));
        environmentPieces.add(new EnvironmentPiece(400, 240, EnvironmentType.RIVER, "res/river.gif"));
        environmentPieces.add(new EnvironmentPiece(400, 320, EnvironmentType.RIVER, "res/river.gif"));
        environmentPieces.add(new EnvironmentPiece(400, 400, EnvironmentType.RIVER, "res/river.gif"));

    }

    public Set<Piece> getPlayablePieces() {
        return playablePieces;
    }

    public Set<Piece> getEnvironmentPieces() {
        return environmentPieces;
    }
}
