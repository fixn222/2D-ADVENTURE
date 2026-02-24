package entity;



import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import main.GamePanel;
import main.KeyHandler;

public final class Player extends Entity {

    GamePanel gp;
    KeyHandler keyH;
    

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        setDefualtValue();
        getPlayerImage();

    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/player/boy_up_1.png")));
            up2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/player/boy_up_2.png")));
            down1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/player/boy_down_1.png")));
            down2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/player/boy_down_2.png")));
            left1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/player/boy_left_1.png")));
            left2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/player/boy_left_2.png")));
            right1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/player/boy_right_1.png")));
            right2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/res/player/boy_right_2.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDefualtValue() {

        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }

    public void update() {

        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true ) 
        {
        
            if (keyH.upPressed) {
            direction = "up";
            y -= speed;

        } else if (keyH.downPressed) {
            direction = "down";

            y += speed;

        } else if (keyH.leftPressed) {
            direction = "left";

            x -= speed;

        } else if (keyH.rightPressed) {
            direction = "right";

            x += speed;

        }

        spriteCounter++;

        if (spriteCounter > 10) {
            if (spriteNum == 1) {
                spriteNum = 2;
                
            }else if (spriteNum == 2) {
                spriteNum =1 ;
            }
            spriteCounter = 0;
        }
        }

    }

    public void draw(Graphics2D g2) {
       // g2.setColor(Color.white);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize);
 
   BufferedImage image = switch (direction) {
    case "up"    -> (spriteNum == 1) ? up1    : up2;
    case "down"  -> (spriteNum == 1) ? down1  : down2;
    case "left"  -> (spriteNum == 1) ? left1  : left2;
    case "right" -> (spriteNum == 1) ? right1 : right2;
    default -> null;
};

        g2.drawImage(image, x, y , gp.tileSize , gp.tileSize , null);

    }

}
