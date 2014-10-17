package FractalStrings;

/**
 * Фрактальные строки
 * Файл содержит классы, относящиеся к графическому интерфейсу
 * @author Котов Матвей
 * @version 1.0
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;

public class FractalStringsApplet extends JApplet
{
        @Override public void init()
        {
                drawPanel = new DrawPanel(
                        new CancelCallBack()
                {
                        public void callBack()
                        {
                                progress.setValue(100);
                                cancelButton.setEnabled(false);
                                okButton.setEnabled(true);
                        }
                },
                        new ProcessCallBack()
                {
                        public void callBack(int n)
                        {
                                progress.setValue(n);
                        }
                },
                        new StartCallBack()
                {
                        public void callBack()
                        {
                                progress.setValue(0);
                                cancelButton.setEnabled(true);
                                okButton.setEnabled(false);
                        }
                });
                setLayout(new BorderLayout());
                add(drawPanel, BorderLayout.CENTER);
                JPanel northPanel = new JPanel();
                GridBagLayout layout = new GridBagLayout();
                northPanel.setLayout(layout);
                GridBagConstraints constraints;
                constraints = new GridBagConstraints(0, 0, 1, 1, 0, 0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 5, 0, 0), 0, 0);
                northPanel.add(new JLabel("Строка: "), constraints);
                constraints = new GridBagConstraints(1, 0, 1, 1, 80, 0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 5), 0, 0);
                northPanel.add(textField, constraints);
                constraints = new GridBagConstraints(2, 0, 1, 1, 0, 0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 5, 0, 0), 0, 0);
                northPanel.add(new JLabel("Число точек: "), constraints);
                constraints = new GridBagConstraints(3, 0, 1, 1, 0, 0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 0, 0, 5), 0, 0);
                northPanel.add(spinner, constraints);
                constraints = new GridBagConstraints(4, 0, 1, 1, 0, 0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 5, 0, 5), 0, 0);
                okButton.addActionListener(new ActionListener()
                {
                        public void actionPerformed(ActionEvent e)
                        {
                                drawPanel.draw(calculator.calculate(textField.getText().toUpperCase().trim()),
                                        (Integer)spinner.getValue());
                        }
                });
                northPanel.add(okButton, constraints);
                okButton.doClick();
                constraints = new GridBagConstraints(5, 0, 1, 1, 0, 0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.NONE,
                        new Insets(0, 5, 0, 5), 0, 0);
                cancelButton.addActionListener(new ActionListener()
                {
                        public void actionPerformed(ActionEvent e)
                        {
                                drawPanel.stop();
                        }
                });
                cancelButton.setEnabled(false);
                northPanel.add(cancelButton, constraints);
                constraints = new GridBagConstraints(6, 0, 1, 1, 20, 0,
                        GridBagConstraints.CENTER,
                        GridBagConstraints.HORIZONTAL,
                        new Insets(0, 5, 0, 5), 0, 0);
                northPanel.add(progress, constraints);
                add(northPanel, BorderLayout.NORTH);
                okButton.doClick();
        }
        
        private JSpinner     spinner      = new JSpinner(new SpinnerNumberModel(10000, 1, 10000000, 10000));
        private JTextField   textField    = new JTextField("TEXT", 100);
        private JButton      okButton     = new JButton("Построить");
        private JButton      cancelButton = new JButton("Остановить");
        private JProgressBar progress     = new JProgressBar(0, 100);
        private DrawPanel    drawPanel;
        private Calculator   calculator   = new Calculator();
}


/** Обратный вызов при нажатии кнопки "Отмена" */
interface CancelCallBack
{
        void callBack();
}

/** Обратный вызов при старте построения */
interface StartCallBack
{
        void callBack();
}

class DrawPanel extends JPanel
{
        public DrawPanel(CancelCallBack cancelCallBack, ProcessCallBack processCallBack, StartCallBack startCallBack)
        {
                this.cancelCallBack = cancelCallBack;
                this.startCallBack = startCallBack;
                drawer = new Drawer(processCallBack);
        }
        
        @Override public void setBounds(int x, int y, int width, int height)
        {
                super.setBounds(x, y, width, height);
                redrawImage();
        }
        
        @Override public void paintComponent(Graphics g)
        {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }
        
        /** Метод вызывается, когда требуется полная перерисовка изображения:
         * при изменении размера или при изменении рисуемой строки */
        private void redrawImage()
        {
                threadGroup.interrupt();
                Thread thread = new Thread(threadGroup, runable);
                thread.start();
        }
        
        /** Задаёт новую рисуемую строку и перерисовывает */
        public void draw(SystemOfTransforms system, int count)
        {
                this.system = system;
                this.count = count;
                redrawImage();
        }
        
        
        /** Метод вызывается, когда требуется прекратить перерисовку */
        public void stop()
        {
                threadGroup.interrupt();
                cancelCallBack.callBack();
        }
        
        private CancelCallBack     cancelCallBack;
        private StartCallBack      startCallBack;
        private Drawer             drawer;
        private BufferedImage      image;
        private SystemOfTransforms system;
        private int                count;
        private ThreadGroup        threadGroup = new ThreadGroup("paint_thread");
        private Runnable           runable = new Runnable()
        {
                public void run()
                {
                        if (getWidth() > 0 && getHeight() > 0 && system != null)
                        {
                                startCallBack.callBack();
                                BufferedImage tempImage = new BufferedImage(getWidth(), getHeight(),
                                        BufferedImage.TYPE_INT_RGB);
                                drawer.draw(system, tempImage, count);
                                if (!Thread.currentThread().isInterrupted())
                                {
                                        image = tempImage;
                                        repaint();
                                        cancelCallBack.callBack();
                                }
                        }
                }
        };
}
