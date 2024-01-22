import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{
    //SCREEN SETTINGS
    final private int originalTileSize = 16; // 16x16 tiles, default size of player character
    final private int scale = 3;
    final private int tileSize = originalTileSize; // 16x16 tile
    final private int maxScreenColumns = 16;
    final private int maxScreenRows = 12;
    final private int screenWidth = tileSize * maxScreenColumns * scale; // 768 pixels
    final private int screenHeight = tileSize * maxScreenRows * scale; // 576 pixels

    Thread gameThread;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    @Override
    public void run() {
        while(gameThread != null) {
//            System.out.println("hehehe");


            update();

            repaint();
        }
    }

    public void update() {
        // 1 UPDATE: update information such as character positions

    }
    public void paintComponent(Graphics g) {
        // 2 DRAW: draw the screen with the updated information
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.yellow);

        g2.fillRect(100, 100, tileSize, tileSize);

        g2.dispose();
    }
}
