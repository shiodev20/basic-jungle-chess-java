/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tutorial.junglechess;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
public class JungleChessPanel extends JPanel implements MouseListener {

  final static int ROWS = 10;
  final static int COLS = 8;
  private int orgX = 0, orgY = 0, side = 80;
  private Point pressedPoint;

  private Board board;

  public JungleChessPanel() {
    this.setBackground(Color.white);
    this.setSize(800, 800);

    this.board = new Board();
    addMouseListener(this);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D graphic = (Graphics2D) g;
    graphic.setStroke(new BasicStroke(2));
    drawBoard(g);

    try {
      drawPieces(g);
      drawEnvironments(g);
    } catch (IOException ex) {
      Logger.getLogger(JungleChessPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  private void drawBoard(Graphics g) {
    for (int i = 0; i < COLS; i++) {
      g.drawLine(orgX + i * side, orgY, orgX + i * side, orgY + (ROWS - 1) * side);
    }

    for (int i = 0; i < ROWS; i++) {
      g.drawLine(orgX, orgY + i * side, orgX + (COLS - 1) * side, orgY + i * side);
    }
  }

  private void drawPieces(Graphics g) throws IOException {
    for (Piece piece : this.board.getPieces()) {
      if (piece.getImageName() != null) {
        File imageFile = new File(piece.getImageName());
        BufferedImage image = ImageIO.read(imageFile);
        g.drawImage(image, piece.getX(), piece.getY(), this);
      }
    }
  }

  private void drawEnvironments(Graphics g) throws IOException {
    File riverFile = new File("res/river.gif");
    File denFile = new File("res/den.gif");
    File trapFile = new File("res/trap.gif");

    BufferedImage riverImage = ImageIO.read(riverFile);
    BufferedImage denImage = ImageIO.read(denFile);
    BufferedImage trapImage = ImageIO.read(trapFile);

    g.drawImage(trapImage, 240, 560, this);
    g.drawImage(trapImage, 160, 640, this);
    g.drawImage(trapImage, 320, 640, this);
    g.drawImage(trapImage, 240, 80, this);
    g.drawImage(trapImage, 160, 0, this);
    g.drawImage(trapImage, 320, 0, this);

    g.drawImage(denImage, 240, 0, this);
    g.drawImage(denImage, 240, 640, this);

    for (Point point : this.board.getRiverPoints()) {
      g.drawImage(riverImage, (int)point.getX(), (int)point.getY(), this);
    }
  }

  @Override
  public void mouseClicked(MouseEvent e) {
  }

  @Override
  public void mousePressed(MouseEvent e) {
    this.pressedPoint = new Point(this.board.getXMark(e.getPoint().x), this.board.getYMark(e.getPoint().y));
  }

  @Override
  public void mouseReleased(MouseEvent e) {
    Point targetPoint = new Point(board.getXMark(e.getPoint().x), board.getYMark(e.getPoint().y));
    this.board.movePiece(this.pressedPoint.x, this.pressedPoint.y, targetPoint.x, targetPoint.y);
    repaint();
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }
}
