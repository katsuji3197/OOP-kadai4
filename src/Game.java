import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Game extends Frame {
    private final ArrayList<Point> coffee = new ArrayList<>();
    private int count = 0;

    Label countLabel;

    public static void main(String[] args) {
        new Game();
    }

    public Game() {
        super("Coffee Dripper");

        countLabel = new Label("クリックしてドリップ開始");
        countLabel.setSize(200, 30);
        add(countLabel);

        addWindowListener(new SampleWindowListener());
        addMouseListener(new SampleMouseAdapter());

        countLabel.setForeground(Color.DARK_GRAY);
        countLabel.setFont(new Font("SansSerif", Font.BOLD, 24));

        setSize(600, 600);
        setLayout(new FlowLayout());
        setVisible(true);

        new Animation().start();
    }

    public void paint(Graphics g) {
        g.setColor(Color.getHSBColor(9F, 0.53F,0.34F));
        for (Point zahyo : coffee) {
            g.fillOval(zahyo.x, zahyo.y, 10, 10);
        }
    }

    static class SampleWindowListener extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }

    class SampleMouseAdapter extends MouseAdapter {
        public void mousePressed(MouseEvent e) {
            coffee.add(new Point(e.getX(), e.getY()));
            count++;
            countLabel.setText(count + "ml");
            repaint();
        }
    }

    class Animation extends Thread {
        public void run() {
            while (true) {
                for (Point zahyo : coffee) {
                    zahyo.y += 2;
                }

                coffee.removeIf(zahyo -> zahyo.y > getHeight());

                repaint();

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    }
}
