package ru.xaoc.fractalworld.transformedtriangle;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    private static Image image;

    private static Image drawInvCenterSierpinskiTriangle() {
        Painter painter = new Painter(new SierpinskiTriangleGenerator(), new Transformator() {
            public Complex transform(Complex z) {
                return Complex.inv(z.add(new Complex(-.5, -Math.sqrt(3)/6))).add(new Complex(.5, Math.sqrt(3)/6));
            }
        });
        return painter.draw(640, 480, 500000, new Transformator() {
            public Complex transform(Complex z) {
                return Complex.conj(z).mul(36).add(new Complex(320, 240));
            }
        });
    }

    private static Image drawInvAngleSierpinskiTriangle() {
        Painter painter = new Painter(new SierpinskiTriangleGenerator(), new Transformator() {
            public Complex transform(Complex z) {
                return Complex.inv(z);
            }
        });
        return painter.draw(640, 480, 1000000, new Transformator() {
            public Complex transform(Complex z) {
                return Complex.conj(z).mul(100).add(new Complex(20, 20));
            }
        });
    }

    private static Image drawInvSomewhereSierpinskiTriangle() {
        Painter painter = new Painter(new SierpinskiTriangleGenerator(), new Transformator() {
            public Complex transform(Complex z) {
                return Complex.inv(z.add(new Complex(-.48, -.22))).add(new Complex(.48, .22));
            }
        });
        return painter.draw(640, 480, 1000000, new Transformator() {
            public Complex transform(Complex z) {
                return Complex.conj(z).mul(30).add(new Complex(320, 300));
            }
        });
    }

    private static Image drawPower2AngleSierpinskiTriangle() {
        Painter painter = new Painter(new SierpinskiTriangleGenerator(), new Transformator() {
            public Complex transform(Complex z) {
                return Complex.pow(z, 2);
            }
        });
        return painter.draw(640, 480, 500000, new Transformator() {
            public Complex transform(Complex z) {
                return Complex.conj(z).mul(400).add(new Complex(210, 400));
            }
        });
    }

    private static Image drawPower3AngleSierpinskiTriangle() {
        Painter painter = new Painter(new SierpinskiTriangleGenerator(), new Transformator() {
            public Complex transform(Complex z) {
                return Complex.pow(z, 3);
            }
        });
        return painter.draw(640, 480, 500000, new Transformator() {
            public Complex transform(Complex z) {
                return Complex.conj(z).mul(310).add(new Complex(320, 400));
            }
        });
    }

    private static Image drawInvCenterSierpinskiCarpet() {
        Painter painter = new Painter(new SierpinskiCarpetGenerator(), new Transformator() {
            public Complex transform(Complex z) {
                return Complex.inv(z.add(new Complex(-.5, -.5))).add(new Complex(.5, .5));
            }
        });
        return painter.draw(640, 480, 2000000, new Transformator() {
            public Complex transform(Complex z) {
                return Complex.conj(z).mul(35).add(new Complex(320, 240));
            }
        });
    }

    private static Image drawInvAngleSierpinskiCarpet() {
        Painter painter = new Painter(new SierpinskiCarpetGenerator(), new Transformator() {
            public Complex transform(Complex z) {
                return Complex.inv(z);
            }
        });
        return painter.draw(640, 480, 2000000, new Transformator() {
            public Complex transform(Complex z) {
                return Complex.conj(z).mul(200).add(new Complex(20, 20));
            }
        });
    }

    private static Image drawPower2AngleSierpinskiCarpet() {
        Painter painter = new Painter(new SierpinskiCarpetGenerator(), new Transformator() {
            public Complex transform(Complex z) {
                return Complex.pow(z, 2);
            }
        });
        return painter.draw(640, 480, 1000000, new Transformator() {
            public Complex transform(Complex z) {
                return Complex.conj(z).mul(230).add(new Complex(320, 470));
            }
        });
    }

    public static void main(String[] args) {
        //image = drawInvCenterSierpinskiTriangle();
        //image = drawInvAngleSierpinskiTriangle();
        image = drawInvSomewhereSierpinskiTriangle();
        //image = drawPower2AngleSierpinskiTriangle();
        //image = drawPower3AngleSierpinskiTriangle();
        //image = drawInvCenterSierpinskiCarpet();
        //image = drawInvAngleSierpinskiCarpet();
        //image = drawPower2AngleSierpinskiCarpet();
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
