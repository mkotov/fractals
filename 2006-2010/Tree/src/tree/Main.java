package tree;
import base.*;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;
import zbuffer.*;

public class Main
{
	private static Drawer drawer;
	private static Image image;
	public static void main(String[] args)
	{
		drawer = new Drawer(new Tree(), new ZBufferImageBuilder());
		image = drawer.draw(1024, 780, new Vector(-1.0, 1.0, 1.5),
			 Transform.createRotateZ(-Math.PI / 12.0).composite(
			 Transform.createRotateY(Math.PI / 12.0)).composite(
			 Transform.createScale(1, 1, -1).composite(
			 Transform.createTranslate(0, 1024 / 2, 400))));
		JFrame frame = new JFrame();
		frame.addNotify();
		frame.setSize(frame.getInsets().left +
			frame.getInsets().right  + 1024,
			frame.getInsets().top +
			frame.getInsets().bottom + 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(new JPanel()
		{
			public void paintComponent(Graphics g)
			{
				super.paintComponent(g);
				Graphics2D G = (Graphics2D)g;
				G.drawImage(image, 0, 0, 1024, 780, null);
			}
		});
		frame.setVisible(true);
	}
}
