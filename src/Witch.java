import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Witch {
    private final int MOVE_AMT = 3;
    private BufferedImage right;
    private int xCoord;
    private int yCoord;
    private Animation animation;

    public Witch() {
        xCoord = 1350;
        yCoord = 855;
        try {
            right = ImageIO.read(new File("src\\images\\witch0.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String filename = "src\\images\\witch" + i + ".png";
            try {
                images.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        animation = new Animation(images, 150);
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
        return getPlayerImage().getWidth();
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