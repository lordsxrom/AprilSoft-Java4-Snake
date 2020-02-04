import enums.Box;
import enums.GameState;
import objects.Head;
import utils.Ranges;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class View {

    private final static int IMAGE_SIZE = 30;

    private ViewListener listener;

    private JPanel mainPanel;

    private BufferedImage map;

    public View() {
        initImages();
        initPanel();
        initFrame();
    }

    public void addListener(final ViewListener listener) {
        this.listener = listener;
    }

    private void initImages() {
        for (Box box : Box.values()) {
            box.image = getImage(box.name().toLowerCase());
        }
    }

    private Image getImage(String name) {
        String filename = "img/" + name + ".png";
        ImageIcon icon = new ImageIcon(getClass().getResource(filename));
        return icon.getImage();
    }

    private void initPanel() {
        mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(map, 0, 0, null);
            }
        };

        mainPanel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int btn = e.getKeyCode();
                System.out.println("View->keyPressed->key:" + btn);
                if (btn == KeyEvent.VK_UP) listener.onButtonClicked(Head.DIR_UP);
                if (btn == KeyEvent.VK_LEFT) listener.onButtonClicked(Head.DIR_LEFT);
                if (btn == KeyEvent.VK_RIGHT) listener.onButtonClicked(Head.DIR_RIGHT);
                if (btn == KeyEvent.VK_DOWN) listener.onButtonClicked(Head.DIR_DOWN);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        mainPanel.setFocusable(true);
        mainPanel.setPreferredSize(new Dimension(Ranges.COLS * IMAGE_SIZE,
                Ranges.ROWS * IMAGE_SIZE));
    }

    private void initFrame() {
        JFrame frame = new JFrame();
        frame.setBounds(0, 0, 800, 800);
        frame.setResizable(false);
        frame.setTitle("Snake");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setIconImage(getImage("icon"));
        frame.setLayout(new BorderLayout());
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.pack();
    }

    public void updateMap(BufferedImage map) {
        this.map = map;
        mainPanel.repaint();
    }

    public void updateScore(int score) {

    }

    public void updateGameState(GameState state) {

    }
}

