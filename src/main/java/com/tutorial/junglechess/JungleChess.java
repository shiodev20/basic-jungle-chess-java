/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.tutorial.junglechess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author nghin
 */
public class JungleChess {
  JButton resetBtn = new JButton("Chơi mới");
  JButton exitBtn = new JButton("Thoát");

  public JungleChess() {
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    JFrame jungleChessFrame = new JFrame("Cờ Thú");
    jungleChessFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    jungleChessFrame.setLayout(new BorderLayout());

    JungleChessPanel jungleChessPanel = new JungleChessPanel();
    jungleChessFrame.add(jungleChessPanel, BorderLayout.CENTER);

    JPanel panel1 = new JPanel();
    panel1.setBackground(Color.WHITE);
    panel1.setPreferredSize(new Dimension(450, 100));

    JPanel panel2 = new JPanel();
    panel2.setBackground(Color.WHITE);
    panel2.setPreferredSize(new Dimension(500, 100));

    JPanel panel3 = new JPanel();
    panel3.setBackground(Color.WHITE);
    panel3.setPreferredSize(new Dimension(100, (int) (dim.getHeight() * 0.07)));

    jungleChessFrame.add(panel1, BorderLayout.WEST);
    jungleChessFrame.add(panel2, BorderLayout.EAST);
    jungleChessFrame.add(panel3, BorderLayout.SOUTH);

    panel3.add(resetBtn);
    panel3.add(exitBtn);

    resetBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        jungleChessPanel.restart();
      }
    });

    exitBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    jungleChessFrame.setVisible(true);
  }

  public static void main(String[] args) {
    new JungleChess();
  }

}
