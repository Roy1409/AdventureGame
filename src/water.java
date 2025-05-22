import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class water {
    private final int MOVE_AMT = 3;
    private BufferedImage right;
    private boolean facingRight;
    private int xCoord;
    private int yCoord;
    private int score;
    private Animation animation;
    private Animation idle;
    private boolean y;


    public water() {
        facingRight = true;
        xCoord = 50;
        yCoord = 435;
        score = 0;
        try {
            right = ImageIO.read(new File("src\\widle1.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 1; i < 11; i++) {
            String filename = "src\\wwalk_"+ i + ".png";
            try {
                images.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        ArrayList<BufferedImage> x = new ArrayList<>();


        for (int i = 1; i < 9; i++) {
            String filename = "src\\widle_" + i + ".png";
            try {
                x.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


        animation = new Animation(images, 100);
        idle = new Animation(x, 100);
    }

    public int getxCoord() {
        if (facingRight) {
            return xCoord;
        } else {
            return (xCoord + (getPlayerImage().getWidth()));
        }
    }

    public int getyCoord() {
        return yCoord;
    }

    public int getScore() {
        return score;
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

    public void faceRight() {
        facingRight = true;
    }

    public void faceLeft() {
        facingRight = false;
    }

    public void turn() {
        if (facingRight) {
            faceLeft();
        } else {
            faceRight();
        }
    }

    public void moveRight() {
        if (xCoord + MOVE_AMT <= 920) {
            xCoord += MOVE_AMT;
            y=false;
        }
    }

    public void moveLeft() {
        if (xCoord - MOVE_AMT >= 0) {
            xCoord -= MOVE_AMT;
            y=false;
        }
    }


    public void moveUp() {
        if (yCoord - MOVE_AMT >= 0) {
            yCoord -= MOVE_AMT;
            y=false;
        }
    }

    public void moveDown() {
        if (yCoord + MOVE_AMT <= 435) {
            yCoord += MOVE_AMT;
            y=false;
        }
    }

    public BufferedImage getPlayerImage() {
        if (!y) {
            return animation.getActiveFrame(); }
        return idle.getActiveFrame();
    }

    public Rectangle playerRect() {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }

    public void idle() {
        y=true;
    }
}