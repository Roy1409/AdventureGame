import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File; import java.io.IOException;
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
    private int attackFrame = 13;
    private Animation smashing;
    private int smashFrame = 17;
    public Animation hit;
    private boolean isIdle;
    private boolean jumping;
    private boolean attack;
    private boolean smash;
    private boolean isHit;
    private int WalkLimitR;
    private int WalkLimitL;


    public character() {
        WalkLimitR = 1930;
        WalkLimitL = -10;
        facingRight = true;
        xCoord = 50;
        yCoord = 900;
        score = 0;
        try {
            right = ImageIO.read(new File("src\\images\\idle1.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<BufferedImage> gotHit = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String filename = "src\\images\\hit" + i + ".png";
            try {
                gotHit.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            String filename = "src\\images\\run" + i + ".png";
            try {
                images.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ArrayList<BufferedImage> atk = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            String filename = "src\\images\\thrust" + i + ".png";
            try {
                atk.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ArrayList<BufferedImage> atk2 = new ArrayList<>();
        for (int i = 0; i < 17; i++) {
            String filename = "src\\images\\smash" + i + ".png";
            try {
                atk2.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        ArrayList<BufferedImage> x = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            String filename = "src\\images\\idle" + i + ".png";
            try {
                x.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }



        smashing = new Animation(atk2, 100);
        animation = new Animation(images, 100);
        attacking = new Animation(atk, 100);
        idle = new Animation(x, 100);
        hit = new Animation(gotHit, 150);
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

    public void setWalkLimitR(int left, int right){
        WalkLimitR = right;
        WalkLimitL = left;
    }

    public void moveRight() {
        if (xCoord <= WalkLimitR) {
            xCoord += 5;
        }
        if (yCoord == 900) {
            isIdle = false;
            jumping = false;
        }
    }


    public void moveLeft() {
        if (xCoord >= WalkLimitL) {// was - 3
            xCoord -= 5;
            if (yCoord == 900) {
                isIdle = false;
                jumping = false;
            }
        }
    }



    public void attack() {
        attacking.resetCurrentFrame();
        if (!isattacking()) {
            this.attack = true;
        }
    }

    public void smash() {
        smashing.resetCurrentFrame();
        if (!isSmash()) {
            this.smash = true;
        }
    }

    public void hit(boolean bool) {
        isHit = bool;
    }

    public boolean isHit() {
        return isHit;
    }

    public BufferedImage getPlayerImage() {
        if (attack) {
            return attacking.getActiveFrame();
        }
        if (smash) {
            if (smashing.getCurrentFrameIndex() >= 8 && smashing.getCurrentFrameIndex() <= 13) { // fix here
                yCoord = 750;

            } else if (smashing.getCurrentFrameIndex() >= 14) {
                yCoord = 900;
            }else {
                yCoord = 900;
            }
            return smashing.getActiveFrame();
        }

        if (isHit) {
            return hit.getActiveFrame();
        }
        if (!isIdle) {
            return animation.getActiveFrame();
        }
        return idle.getActiveFrame();

    }

    public Rectangle playerRect() {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }

    public void setxCoord(int x){
        xCoord = x;
    }

    public void setyCoord(int y) {
        yCoord = y;
    }

    public void idle() {
        isIdle = true;
    }

    public void setJumping(boolean x) {
        jumping = x;
    }

    public void fall() {
        yCoord++;
    }

    public boolean isattacking() {
        return attack;
    }

    public boolean isSmash() {
        return smash;
    }


    public boolean isfacingright() {
        return facingRight;
    }

    public void setAttacking(boolean x) {
        attack = x;
    }

    public void setSmash(boolean x) {
        smash = x;
    }
}