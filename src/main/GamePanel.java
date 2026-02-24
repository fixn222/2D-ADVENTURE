package main;

import Tile.TileManager;
import entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {
    private static final long serialVersionUID = 1L;
	final int originalTileSize = 16;// 16x16 tiles
    final int scale = 3;

    public final int tileSize = originalTileSize * scale; // 48x48 pixel

    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;

    public final int screenWidth = tileSize * maxScreenCol; // 768 pixels
    public final int screenHeight = tileSize * maxScreenRow;

    //WORLD SETTINGS
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int WorldHeight = tileSize * maxScreenCol;
    public final int WorldWidth = tileSize * maxScreenRow;
    

    // initialize FPS
    int fps = 60;

    TileManager tileManager = new TileManager(this);

    Thread gameThread = new Thread(this);
    KeyHandler keyH = new KeyHandler();
    public Player player = new Player(this, keyH);

    // set Player's default postition
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread() {

        gameThread.start();

    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / fps; // 0.0166666 seconds
        // double nextDrawTime = System.nanoTime() + drawInterval;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);

            lastTime = currentTime;

            if (delta >= 1) {
                // UPDATE : update information such as character postition
                update();
                // 2DRAW : draw the screen with updated information

                repaint();
                delta--;
                drawCount++;
            }

            if (timer >= 1000000000) {
                System.out.println("fps: " + drawCount);
                drawCount = 0;
                timer = 0;

            }

            // System.out.println(currentTime);

            // System.out.println("The game loop is running");

        }
    }

    public void update() {

        player.update();

    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        tileManager.draw(g2);
        player.draw(g2);

        g2.dispose();

    }

}
