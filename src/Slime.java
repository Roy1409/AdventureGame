import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Slime {
    private int MOVE_AMT = 2;
    private BufferedImage right;
    private boolean facingRight;
    private int xCoord;
    private int yCoord;
    private int score;
    private Animation animation;
    private Animation death;
    private Animation takeHit;
    private Animation jump;
    private Animation attacking;
    private boolean y;
    private boolean jumping;
    private boolean attack;
    private boolean hit;
    private boolean dead;


    public Slime() {
        facingRight = false;
        xCoord = 1700;
        yCoord = 925;
        score = 0;
/*
        try {
            right = ImageIO.read(new File("src\\images\\widle1.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
*/


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

      ArrayList<BufferedImage> gotHit = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String filename = "src\\images\\shit" + i + ".png";
            try {
                gotHit.add(ImageIO.read(new File(filename)));
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
        ArrayList<BufferedImage> attk=new ArrayList<>();
        for (int i=1; i<28; i++) {
            String filename = "src\\images\\w3_atk_"+ i + ".png";
            try {
                attk.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
*/



        death=new Animation(q,100);
        animation = new Animation(images, 100);
        takeHit = new Animation(gotHit, 100);
       /* jump= new Animation(jumps,100);
        attacking=new Animation(attk,50);*/
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
            if (yCoord == 925) {
                y = false;

                jumping = false;
                attack=false;
            }
        }
    }


    public void moveLeft() {
        if (xCoord - 3 >= 0) {
            xCoord -= MOVE_AMT;
            if (yCoord==925) {
                y=false;
                jumping=false;
                attack=false;
            }
        }
    }
    public void attack() {
        if (facingRight) {
            xCoord += 30;
        } else {
            xCoord -= 30;
        }

    }
public boolean getHit(){
        return hit;
}
    public BufferedImage getPlayerImage() {
        if (dead) {
            return death.getActiveFrame();
        }
        if (hit){
            return takeHit.getActiveFrame();
        }
        return animation.getActiveFrame();
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

    public void setJumping(boolean x){
        jumping=x;
    }

    public void fall() {
        yCoord++;
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