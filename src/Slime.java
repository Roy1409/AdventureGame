import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Slime {
    private int MOVE_AMT = 2;
    private boolean facingRight;
    private int xCoord;
    private int yCoord;
    private int score;
    private Animation animation;
    private Animation death;
    private boolean dead;

    public Slime() {
        facingRight = false;
        xCoord = 1700;
        yCoord = 925;
        score = 0;
        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            String filename = "src\\images\\srun"+ i + ".png";
            try {
                images.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ArrayList<BufferedImage> q= new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String filename = "src\\images\\sdead"+ i + ".png";
            try {
                q.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        death=new Animation(q,100);
        animation = new Animation(images, 100);
    }
    public void setMOVE_AMT(int x){
        MOVE_AMT = x;
    }
    public int getxCoord() {
            return xCoord;
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
        if (xCoord + 3 <= 2000) {
            xCoord += MOVE_AMT;
        }
    }

    public void moveLeft() {
        if (xCoord - 3 >= 0) {
            xCoord -= MOVE_AMT;
        }
    }
    public void attack() {
        if (facingRight) {
            xCoord += 30;
        } else {
            xCoord -= 30;
        }
    }

    public BufferedImage getPlayerImage() {
        if (dead) {
            return death.getActiveFrame();
        }
        return animation.getActiveFrame();
    }

    public Rectangle playerRect() {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }
    public void setxCoord(int x) {
       xCoord=x;
    }

    public void revive() {
        dead = false;
    }

    public void death() {
        death.resetCurrentFrame();
        dead=true;
    }
    public boolean isdead() {
        return dead;
    }

    public boolean isfacingright(){
        return facingRight;
    }
}