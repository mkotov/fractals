package ru.xaoc.fractalworld.lsystems;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    private static Image image;

    public static void main(String[] args) {
        image = Collection.drawKochCurve(4);
        // image = Collection.drawKochSnowflake(4);
        // image = Collection.drawTriangle(7);
        // image = Collection.drawCrystal(4);
        // image = Collection.drawDragon(11);
        // image = Collection.drawHexagonalGosper(4);
        // image = Collection.drawSquareSierpinski(4);
        // image = Collection.drawHilbertCurve(5);
        // image = Collection.drawBoard(4);
        // image = Collection.drawYetAnotherKochCurve(3);
        // image = Collection.drawQuadraticKochIslandA(3);
        // image = Collection.drawQuadraticKochIslandB(2);
        // image = Collection.drawQuadraticSnowflake(4);
        // image = Collection.drawSierpinskiArrowhead(7);
        // image = Collection.drawCrossB(5);
        // image = Collection.drawRings(4);
        // image = Collection.drawBush1(5);
        // image = Collection.drawBush2(4);
        // image = Collection.drawBush3(4);
        // image = Collection.drawSticks(6);
        // image = Collection.drawBoxFractal(4);
        // image = Collection.drawWeed(4);
        // image = Collection.drawTree(20);
        // image = Collection.drawRings2(5);
        // image = Collection.drawSierpinskiTriangle(6);
        // image = Collection.drawSierpinskiCarpet(5);
        // image = Collection.drawMosaic(2);
        // image = Collection.drawSnowflake(2);
        // image = Collection.drawFlower(2);
        // image = Collection.drawLevyCurve(12);
        // image = Collection.drawPentaplexity(4);
        // image = Collection.drawTerdragon(7);
        // image = Collection.drawCross(5);
        // image = Collection.drawSierpinskiCarpet2(4);
        // image = Collection.drawPentigree(4);
        // image = Collection.drawHex7B(4);
        // image = Collection.drawPeanoC(3);
        // image = Collection.drawBorder(3);
        // image = Collection.drawDoily(4);
        // image = Collection.drawMaze1(5);
        // image = Collection.drawMaze2(6);
        // image = Collection.drawMoore(4);
        // image = Collection.drawPentant(3);
        // image = Collection.drawPentl(4);
        // image = Collection.drawSierpinskiCurve(10);
        // image = Collection.drawTiling(6);
        // image = Collection.drawADH231A(4);
        // image = Collection.drawADH256A(4);
        // image = Collection.drawADH258A(3);

        
        JFrame frame = new JFrame();
        frame.addNotify();
        frame.setSize(frame.getInsets().left
                + frame.getInsets().right + image.getWidth(null),
                frame.getInsets().top
                + frame.getInsets().bottom + image.getHeight(null));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                Graphics2D G = (Graphics2D) g;
                if (image != null) {
                    G.drawImage(image, 0, 0, null);
                }
            }
        });
        frame.setVisible(true);
    }
}
