import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class projectile {
    private int MOVE_AMT = 2;
    private boolean facingRight;
    private int xCoord;
    private int yCoord;
    private Animation animation;

    public projectile() {
        facingRight = false;
        xCoord = 125;
        yCoord = 910;
        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String filename = "src\\images\\ice"+ i + ".png";
            try {
                images.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        animation = new Animation(images, 100);
    }

    public int getxCoord() {
        return xCoord;
    }

    public int getyCoord() {
        return yCoord;
    }

    public int getHeight() {
        return getPlayerImage().getHeight();
    }

    public int getWidth() {
        if (facingRight) {
            return getPlayerImage().getWidth();
        } else {
            return getPlayerImage().getWidth() * -1;
        }
    }
    public void setxCoord(int x) {
        xCoord = x;
    }

    public void faceRight() {
        facingRight = true;
    }

    public void faceLeft() {
        facingRight = false;
    }

    public BufferedImage getPlayerImage() {

        return animation.getActiveFrame();
    }
    public Rectangle playerRect() {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }
}