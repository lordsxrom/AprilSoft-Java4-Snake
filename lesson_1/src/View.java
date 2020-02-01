import objects.Map;
import enums.Box;
import enums.GameState;
import objects.Head;
import utils.Coord;
import utils.Ranges;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class View {

    private final static int IMAGE_SIZE = 30; // размер картинки одинаковый по x и по y

    private ViewListener listener;

    private JPanel mainPanel;

    private Timer timer;
    private Map map;

    public View() {
        initImages();
        initPanel();
        initFrame();
    }

    public void addListener(final ViewListener listener) {
        this.listener = listener;
    }

    private void initImages() {
        for (enums.Box box : Box.values()) {
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
                for (Coord coord : Ranges.getCoords()) {
                    g.drawImage((Image) map.getBox(coord).image,
                            coord.x * IMAGE_SIZE, coord.y * IMAGE_SIZE,
                            IMAGE_SIZE, IMAGE_SIZE, null);
                }
            }
        };

        mainPanel.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("UP");
                listener.onButtonClicked(Head.DIR_UP);
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

        mainPanel.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("DOWN");
                listener.onButtonClicked(Head.DIR_DOWN);

            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

        mainPanel.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("LEFT");
                listener.onButtonClicked(Head.DIR_LEFT);

            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

        mainPanel.registerKeyboardAction(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("RIGHT");
                listener.onButtonClicked(Head.DIR_RIGHT);
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);

        mainPanel.setPreferredSize(new Dimension(Ranges.COLS * IMAGE_SIZE,
                Ranges.ROWS * IMAGE_SIZE));

        timer = new Timer(15, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.repaint();
            }
        });
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

    public void start() {
        timer.start();
    }

    public void updateMap(Map map) {
        this.map = map;
    }

    public void updateScore(int score) {

    }

    public void updateGameState(GameState state) {

    }
}

