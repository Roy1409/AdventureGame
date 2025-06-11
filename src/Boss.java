import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageFilter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;


<<<<<<<< HEAD:src/Boss.java
public class Boss {
    private final int MOVE_AMT = 3;
========
public class Slime {
    private int MOVE_AMT = 2;
>>>>>>>> origin/master:src/Slime.java
    private BufferedImage right;
    private boolean facingRight;
    private int xCoord;
    private int yCoord;
    private int score;
    private Animation animation;
    private Animation death;
<<<<<<<< HEAD:src/Boss.java
    private Animation idle;
========
    private Animation takeHit;
>>>>>>>> origin/master:src/Slime.java
    private Animation jump;
    private Animation attacking;
    private boolean y;
    private boolean jumping;
    private boolean attack;
<<<<<<<< HEAD:src/Boss.java
    private boolean dead;


    public Boss() {
        facingRight = false;
        xCoord = 3000;
        yCoord = 550;
//        try {
//            right = ImageIO.read(new File("src\\images\\widle1.png"));
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }


        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String filename = "src\\images\\didle"+ i + ".png";
========
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
>>>>>>>> origin/master:src/Slime.java
            try {
                images.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ArrayList<BufferedImage> q= new ArrayList<>();

<<<<<<<< HEAD:src/Boss.java

        /*    ArrayList<BufferedImage> x = new ArrayList<>();*/

/*
        for (int i = 1; i < 9; i++) {
            String filename = "src\\images\\widle_" + i + ".png";
========
        for (int i = 0; i < 6; i++) {
            String filename = "src\\images\\sdead"+ i + ".png";
>>>>>>>> origin/master:src/Slime.java
            try {
                q.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
<<<<<<<< HEAD:src/Boss.java
        }*/

========
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
>>>>>>>> origin/master:src/Slime.java
        ArrayList<BufferedImage> attk=new ArrayList<>();
        for (int i=0; i<15; i++) {
            String filename = "src\\images\\da"+ i + ".png";
            try {
                attk.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
*/

<<<<<<<< HEAD:src/Boss.java
        animation = new Animation(images, 450);
        /*  idle = new Animation(x, 100);*/
       /* jump= new Animation(jumps,100);*/
        attacking=new Animation(attk,50);
========


        death=new Animation(q,100);
        animation = new Animation(images, 100);
        takeHit = new Animation(gotHit, 100);
       /* jump= new Animation(jumps,100);
        attacking=new Animation(attk,50);*/
    }
    public void setMOVE_AMT(int x){
        MOVE_AMT = x;
>>>>>>>> origin/master:src/Slime.java
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
<<<<<<<< HEAD:src/Boss.java
            xCoord += 4;
========
            xCoord += MOVE_AMT;
>>>>>>>> origin/master:src/Slime.java
            if (yCoord == 925) {
                y = false;

                jumping = false;
                attack=false;
            }
        }
    }


    public void moveLeft() {
        if (xCoord - 3 >= 0) {
<<<<<<<< HEAD:src/Boss.java
            xCoord -= 4;
========
            xCoord -= MOVE_AMT;
>>>>>>>> origin/master:src/Slime.java
            if (yCoord==925) {
                y=false;
                jumping=false;
                attack=false;
            }
<<<<<<<< HEAD:src/Boss.java
        }}


    public void moveUp() {
        if (yCoord==925) {
            yCoord -= 100;
            y=false;
            jumping=true;
            attack=false;
        }
    }

    public void moveDown() {
        if (yCoord + MOVE_AMT <= 925) {
            yCoord += MOVE_AMT;
            if (yCoord==435) {
                y=false;
                jumping=false;
                attack=false;
            }  }
    }

========
        }
    }
>>>>>>>> origin/master:src/Slime.java
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
<<<<<<<< HEAD:src/Boss.java
            if (!attack) {
            return animation.getActiveFrame(); }else{
                return attacking.getActiveFrame();
            }
        //return death.getActiveFrame();
========
        if (dead) {
            return death.getActiveFrame();
        }
        if (hit){
            return takeHit.getActiveFrame();
        }
        return animation.getActiveFrame();
>>>>>>>> origin/master:src/Slime.java
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
<<<<<<<< HEAD:src/Boss.java
        xCoord=x;
    }

    public void death() {
========
       xCoord=x;
    }

    public void revive() {
        dead = false;
    }

    public void death() {
        death.resetCurrentFrame();
>>>>>>>> origin/master:src/Slime.java
        dead=true;
    }

    public boolean isdead() {
        return dead;
    }
<<<<<<<< HEAD:src/Boss.java
    public void setdead(boolean x) {
        dead=x;
    }

    public boolean isattack() {
        return attack;
    }
========
>>>>>>>> origin/master:src/Slime.java

    public boolean isfacingright(){
        return facingRight;
    }
<<<<<<<< HEAD:src/Boss.java

    public void setAttacking(boolean x) {    attack=x;
    }

========
>>>>>>>> origin/master:src/Slime.java
}