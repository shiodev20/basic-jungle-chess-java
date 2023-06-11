/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorial.junglechess;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author nghin
 */
public class JungleChessPanel extends JPanel {
    
    private int orgX = 0, orgY = 0, side = 80;
    private Board board;
    
    public JungleChessPanel() {
        this.setBackground(Color.white);
        this.setSize(800, 800);
        
        this.board = new Board();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        Graphics2D graphic = (Graphics2D) g;
        graphic.setStroke(new BasicStroke(2));
        drawBoard(graphic);
        
        try {
            drawPieces(g);
        } catch (IOException ex) {
            Logger.getLogger(JungleChessPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void drawBoard(Graphics g) {
        for (int i = 0; i < Board.COLS; i++) {
            g.drawLine(orgX + i * side, orgY, orgX + i * side, orgY + (Board.ROWS - 1) * side);
        }

        for (int i = 0; i < Board.ROWS; i++) {
            g.drawLine(orgX, orgY + i * side, orgX + (Board.COLS - 1) * side, orgY + i * side);
        }
    }
    
    private void drawPieces(Graphics g) throws IOException {
        for(Piece piece : this.board.getPlayablePieces()) {
            File imageFile = new File(piece.getImageName());
            BufferedImage image = ImageIO.read(imageFile);
            g.drawImage(image, piece.getX(), piece.getY(), this);
        }
        
        for(Piece piece : this.board.getEnvironmentPieces()) {
            File imageFile = new File(piece.getImageName());
            BufferedImage image = ImageIO.read(imageFile);
            g.drawImage(image, piece.getX(), piece.getY(), this);
        }
    }
}
