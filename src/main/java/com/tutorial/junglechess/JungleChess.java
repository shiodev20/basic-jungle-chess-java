/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.tutorial.junglechess;

import javax.swing.JFrame;

/**
 *
 * @author nghin
 */
public class JungleChess {
    
    public JungleChess() {
        JFrame jungleChessFrame = new JFrame("Cờ Thú");
        jungleChessFrame.setSize(800, 800);
        
        JungleChessPanel panel = new JungleChessPanel();
        
        jungleChessFrame.add(panel);
        jungleChessFrame.setVisible(true);
    }
    
    public static void main(String[] args) {
        new JungleChess();
    }
}
