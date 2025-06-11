import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Boss {
    private int MOVE_AMT = 3;
    private BufferedImage right;
    private boolean facingRight;
    private int xCoord;
    private int yCoord;
    private Animation animation;
    private Animation death;
    private Animation idle;
    private Animation getHit;
    private Animation attacking;
    private boolean isIdle;
    private boolean attack;
    private boolean dead;
    private boolean isHit;

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
            try {
                images.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


        ArrayList<BufferedImage> walk = new ArrayList<>();


        for (int i = 0; i < 12; i++) {
            String filename = "src\\images\\dwalk" + i + ".png";
            try {
                walk.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
/*        ArrayList<BufferedImage> attack =new ArrayList<>();
        for (int i=0; i<4; i++) {
            String filename = "src\\images\\dattack"+ i + ".png";
            try {
                attack.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ArrayList<BufferedImage> hit =new ArrayList<>();
        for (int i=0; i<5; i++) {
            String filename = "src\\images\\dhit"+ i + ".png";
            try {
                hit.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ArrayList<BufferedImage> dying =new ArrayList<>();
        for (int i=0; i<20; i++) {
            String filename = "src\\images\\ddeath"+ i + ".png";
            try {
                dying.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }*/
        animation = new Animation(walk, 450);
        idle = new Animation(images, 100);
   /*     getHit =new Animation(hit,50);
        attacking = new Animation(attack, 100 );
        death = new Animation(dying, 100);*/

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
                isIdle = false;
                attack=false;
            }}}


    public void moveLeft() {
        if (xCoord - 3 >= 0) {
            xCoord -= MOVE_AMT;
            if (yCoord==925) {
                isIdle =false;
                attack=false;
            }
        }}

    public void attack() {
        attack=true;
    }

    public BufferedImage getPlayerImage() {
        if (dead) {
            return death.getActiveFrame();
        } else if (attack) {
            return attacking.getActiveFrame();
        } else if (isIdle) {
            return idle.getActiveFrame();
        } else if (isHit) {
            return getHit.getActiveFrame();
        } else {
            return animation.getActiveFrame(); //wlaking
        }
    }


    public Rectangle playerRect() {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }

    public void idle() {
        isIdle =true;
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

    public boolean isfacingright(){
        return facingRight;
    }

    public void setMOVE_AMT(int i) {
        MOVE_AMT = i;
    }
}