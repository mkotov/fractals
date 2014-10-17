package cube;

import base.*;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;

public class Main
{
	private static Drawer drawer;
	private static Image image;
	public static void main(String[] args)
	{
		drawer = new Drawer(Cube.createCube(4), new PainterImageBuilder());
		
		Vector sun = new Vector(-1.2, 0.5, 1.0);
		sun = sun.mul(1.0 / sun.norm());
		image = drawer.draw(1024, 780, sun,
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
