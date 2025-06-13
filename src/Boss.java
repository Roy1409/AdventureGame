import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;


public class Boss {
    private final int MOVE_AMT = 3;
    private BufferedImage right;
    private boolean facingRight;
    private int xCoord;
    private int yCoord;
    private int score;
    private Animation animation;
    private Animation death;
    private Animation walk;
    private Animation jump;
    private Animation attacking;
    private boolean y;
    private boolean jumping;
    private boolean attack;
    private boolean dead;


    public Boss() {
        y = true;
        facingRight = false;
        xCoord = 3000;
        yCoord = 570;
//        try {
//            right = ImageIO.read(new File("src\\images\\widle1.png"));
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }


        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String filename = "src\\images\\didle"+ i + ".png";
            try {
                images.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


  ArrayList<BufferedImage> x = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            String filename = "src\\images\\dwalk" + i + ".png";
            try {
                x.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        ArrayList<BufferedImage> attk=new ArrayList<>();
        for (int i=0; i<15; i++) {
            String filename = "src\\images\\da"+ i + ".png";
            try {
                attk.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        animation = new Animation(images, 450);
        walk = new Animation(x, 100);
        /* jump= new Animation(jumps,100);*/
        attacking=new Animation(attk,50);
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
        if (xCoord + 3 <= 2000) {
            xCoord += 4;
            if (yCoord == 570) {
                y = false;
                jumping = false;
            }
        }
    }


    public void moveLeft() {
        if (xCoord - 3 >= 0) {
            xCoord -= 4;
            if (yCoord==570) {
                y=false;
                jumping=false;
            }
        }}



    public void attack() {
        attack=true;
    }

    public BufferedImage getPlayerImage() {
        if (attack) {
            return attacking.getActiveFrame();
        }
        if (!y) {
            return walk.getActiveFrame();
        }
            return animation.getActiveFrame();

        //return death.getActiveFrame();
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

    public void death() {
        dead=true;
    }

    public boolean isdead() {
        return dead;
    }
    public void setdead(boolean x) {
        dead=x;
    }

    public boolean isattack() {
        return attack;
    }

    public boolean isfacingright(){
        return facingRight;
    }

    public void setAttacking(boolean x) {    attack=x;
    }

}