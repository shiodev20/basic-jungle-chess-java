/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.tutorial.junglechess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author nghin
 */
public class JungleChess {

  JButton resetBtn = new JButton("Chơi mới");
  JButton backStepBtn = new JButton("Lùi 1 bước");
  JButton exitBtn = new JButton("Thoát");
  JButton ruleBtn = new JButton("Luật chơi");

  JLabel moveSideLabel = new JLabel("Bên đen đi");

  public JungleChess() {
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    JFrame jungleChessFrame = new JFrame("Cờ Thú");
    jungleChessFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    jungleChessFrame.setLayout(new BorderLayout());

    JungleChessPanel jungleChessPanel = new JungleChessPanel(moveSideLabel);
    jungleChessFrame.add(jungleChessPanel, BorderLayout.CENTER);

    JPanel panel1 = new JPanel();
    panel1.setBackground(Color.WHITE);
    panel1.setPreferredSize(new Dimension(470, 100));

    JPanel panel2 = new JPanel();
    panel2.setBackground(Color.WHITE);
    panel2.setPreferredSize(new Dimension(500, 100));

    JPanel panel3 = new JPanel();
    panel3.setBackground(Color.WHITE);
    panel3.setPreferredSize(new Dimension(100, (int) (dim.getHeight() * 0.07)));

    jungleChessFrame.add(panel1, BorderLayout.WEST);
    jungleChessFrame.add(panel2, BorderLayout.EAST);
    jungleChessFrame.add(panel3, BorderLayout.SOUTH);

    panel3.add(moveSideLabel);

    panel3.add(ruleBtn);
    panel3.add(backStepBtn);
    panel3.add(resetBtn);
    panel3.add(exitBtn);

    resetBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        jungleChessPanel.restart();
      }
    });

    backStepBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        jungleChessPanel.backStep();
      }

    });

    exitBtn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });

    ruleBtn.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {

        String[] rules = {
            "Mỗi bên sẽ có 8 quân cờ.",
            "Các quân cờ sẽ có cấp độ của riêng mình:",
            "- Chuột: 1",
            "- Mèo: 2",
            "- Sói: 3",
            "- Chó: 4",
            "- Báo: 5",
            "- Hổ: 6",
            "- Sư tử: 7",
            "- Voi: 8.",
            "Quân cờ chỉ ăn được quân cờ có cấp độ bằng hoặc nhỏ hơn cấp độ của mình.",
            "Tuy nhiên, có một ngoại lệ là Chuột sẽ ăn được Voi.",
            "-----------------------------",
            "Trong tất cả quân cờ chỉ có Chuột là được đi qua sông.",
            "Khi quân cờ đi vào bẫy thì bẫy sẽ mất và cấp độ của quân cờ sẽ thành 0 cho đến hết ván cờ.",
            "-----------------------------",
            "Điều kiện giành chiến thắng:",
            "- Cờ quân mình vào được Hố của đối phương.",
            "- Ăn hết cờ đối phương."
        };

        JOptionPane.showMessageDialog(jungleChessFrame, rules, "Luật chơi", JOptionPane.INFORMATION_MESSAGE);
      }

    });
    
    jungleChessFrame.setVisible(true);
  }

  public static void main(String[] args) {
    new JungleChess();
  }

}
