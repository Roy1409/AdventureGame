import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class character {
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
    private boolean y;
    private boolean jumping;
    private boolean attack;


    public character() {
        facingRight = true;
        xCoord = 50;
        yCoord = 435;
        score = 0;
/*
        try {
            right = ImageIO.read(new File("src\\images\\widle1.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
*/


        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String filename = "src\\images\\run"+ i + ".png";
            try {
                images.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        ArrayList<BufferedImage> x = new ArrayList<>();

/*
        for (int i = 1; i < 9; i++) {
            String filename = "src\\images\\widle_" + i + ".png";
            try {
                x.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }*/
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


        animation = new Animation(images, 100);
      /*  idle = new Animation(x, 100);*/
       /* jump= new Animation(jumps,100);
        attacking=new Animation(attk,50);*/
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
        if (xCoord + .25 <= 700) {
            xCoord += .5;
            if (yCoord == 435) {
                y = false;
                jumping = false;
                attack=false;
            }}}


    public void moveLeft() {
        if (xCoord - 3 >= 0) {
            xCoord -= 3;
            if (yCoord==435) {
                y=false;
                jumping=false;
                attack=false;
            }
    }}


    public void moveUp() {
        if (yCoord==435) {
            yCoord -= 100;
            y=false;
            jumping=true;
            attack=false;
        }
    }

    public void moveDown() {
        if (yCoord + MOVE_AMT <= 435) {
            yCoord += MOVE_AMT;
            if (yCoord==435) {
            y=false;
            jumping=false;
                attack=false;
            }  }
    }

    public void attack() {
        attack=true;
    }

    public BufferedImage getPlayerImage() {
        if (!y) {
            return animation.getActiveFrame(); }
        if (jumping) {
            return jump.getActiveFrame();
        }
        if (attack){
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

    public void idle() {
        y=true;
    }

    public void setJumping(boolean x){
        jumping=x;
    }

    public void fall() {
        yCoord++;
    }
}