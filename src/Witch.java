import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Witch {
    private final int MOVE_AMT = 3;
    private BufferedImage right;
    private boolean facingRight;
    private int xCoord;
    private int yCoord;
    private int score;
    private Animation animation;
    private Animation idle;
    private Animation jump;
    private Animation attacking;
    private boolean isIdle;
    private boolean jumping;
    private boolean attack;


    public Witch() {
        facingRight = true;
        xCoord = 2350;
        yCoord = 855;
        score = 0;
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



        /*ArrayList<BufferedImage> jumps=new ArrayList<>();
        for (int i=1; i<4; i++) {
            String filename = "src\\images\\wj_up_"+ i + ".png";
            try {
                jumps.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

         */


        animation = new Animation(images, 100);

        /* jump= new Animation(jumps,100);*/
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
        return getPlayerImage().getWidth();
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



    public void attack() {
        attack = true;
    }

    public BufferedImage getPlayerImage() {
        if (!isIdle) {
            return animation.getActiveFrame();
        }
     /*   if (jumping) {
            return jump.getActiveFrame();
        }*/
        if (attack) {
            return attacking.getActiveFrame();
        }
        return idle.getActiveFrame();

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

}