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
    
    
    public final int screenX ;
    public final int screenY;
    
    
    
    

    public Player(GamePanel gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        screenX = gp.screenWidth/2 - (gp.tileSize/2);
        screenY = gp.screenHeight/2 + (gp.tileSize/2);

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

        worldX = gp.tileSize * 23;
        worldY = gp.tileSize * 21;
        speed = 4;
        direction = "down";
    }

    public void update() {

        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true ) 
        {
        
            if (keyH.upPressed) {
            direction = "up";
            worldY -= speed;

        } else if (keyH.downPressed) {
            direction = "down";

            worldY += speed;

        } else if (keyH.leftPressed) {
            direction = "left";

            worldX -= speed;

        } else if (keyH.rightPressed) {
            direction = "right";

            worldX += speed;

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

        g2.drawImage(image, screenX, screenY , gp.tileSize , gp.tileSize , null);

    }

}
