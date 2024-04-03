package Computational.math.GraphicPart.MainComponents;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;

    public MainFrame(){
        setSize(new Dimension(WIDTH,HEIGHT));
    }

    //это пока для тестов, будет заменено
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
