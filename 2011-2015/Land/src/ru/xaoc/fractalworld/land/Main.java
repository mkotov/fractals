package ru.xaoc.fractalworld.land;

import ru.xaoc.fractalworld.base3d.*;

import java.awt.*;
import javax.swing.*;

public class Main
{
	private static Image image;
        public static final int W = 640;
        public static final int H = 480;
	public static void main(String[] args)
	{
		Drawer drawer = new Drawer(new Land(7), new PainterImageBuilder());
		
		Vector sun = new Vector(1, 1, 0);
		sun = sun.mul(1.0 / sun.norm());
		image = drawer.draw(W, H, sun,
                        Transform.createRotateZ(-Math.PI / 10).composite(
			 Transform.createRotateY(Math.PI / 10)).composite(
			 Transform.createScale(500, 500, -500).composite(
			 Transform.createTranslate(0, W / 2, H / 2))));
		JFrame frame = new JFrame();
		frame.addNotify();
		frame.setSize(frame.getInsets().left +
			frame.getInsets().right  + W,
			frame.getInsets().top +
			frame.getInsets().bottom + H);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new JPanel() {
                        @Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D G = (Graphics2D)g;
				G.drawImage(image, 0, 0, 640, 480, null);
			}
		});
		frame.setVisible(true);
	}
}
