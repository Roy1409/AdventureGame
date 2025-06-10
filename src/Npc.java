import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Npc {
    private int MOVE_AMT = 2;
    private BufferedImage right;
    private boolean facingRight;
    private int xCoord;
    private int yCoord;
    private Animation animation;


    public Npc() {
        facingRight = false;
        xCoord = 450;
        yCoord = 775;
/*
        try {
            right = ImageIO.read(new File("src\\images\\widle1.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
*/


        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            String filename = "src\\images\\bidle"+ i + ".png";
            try {
                images.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }



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
    public BufferedImage getPlayerImage() {

        return animation.getActiveFrame();
    }



    public Rectangle playerRect() {
        int imageHeight = getPlayerImage().getHeight();
        int imageWidth = getPlayerImage().getWidth();
        Rectangle rect = new Rectangle(xCoord, yCoord, imageWidth, imageHeight);
        return rect;
    }


    public boolean isfacingright(){
        return facingRight;
    }
}