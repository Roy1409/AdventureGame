import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class water extends Character {
    private final int MOVE_AMT = 3;
    private BufferedImage right;
    private boolean facingRight;
    private int xCoord;
    private int yCoord;
    private int score;
    private Animation animation;
    private Animation idle;
    private boolean y;


    public water() {
        facingRight = true;
        xCoord = 50;
        yCoord = 435;
        score = 0;

        ArrayList<BufferedImage> images = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            String filename = "src\\wwalk_"+ i + ".png";
            try {
                images.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        ArrayList<BufferedImage> x = new ArrayList<>();


        for (int i = 1; i < 9; i++) {
            String filename = "src\\widle" + i + ".png";
            try {
                x.add(ImageIO.read(new File(filename)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }


        animation = new Animation(images, 50);
        idle = new Animation(x, 50);
    }}