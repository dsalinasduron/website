/**
 * Java program that draws concentric circles
 *
 * Usage:
 * java Circles
 */

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")

public class Circles extends JFrame
{

 public Circles() {
  this.setTitle("Draw Concentric Circles");
  this.setSize(300,300);

  addWindowListener(new WindowAdapter() {
   public void windowClosing(WindowEvent e) {
    System.exit(0);
   }
  });

  Container contentPane = getContentPane();
  contentPane.add(new CirclePanel());
 }

 public static void main(String[] args) {
  JFrame rule = new Circles();

  rule.setVisible(true);
 }
}
