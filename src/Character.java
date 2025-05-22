import java.awt.*;
import java.awt.image.BufferedImage;

public class Character {
    private final int MOVE_AMT = 3;
    private boolean facingRight;
    private int xCoord;
    private int yCoord;
    private int score;
    private Animation animation;
    private Animation idle;
    private boolean y;

    public Character() {
        facingRight = true;
        xCoord = 50; // starting position is (50, 435), right on top of ground
        yCoord = 435;
        score = 0;
    }

    //This function is changed from the previous version to let the player turn left and right
    //This version of the function, when combined with getWidth() and getHeight()
    //Allow the player to turn without needing separate images for left and right
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
