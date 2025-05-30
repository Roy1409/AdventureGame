import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GraphicsPanel extends JPanel implements ActionListener, KeyListener, MouseListener {
    private BufferedImage background;
    private Timer timer;
    private character player;
    private Slime slime;
    private boolean[] pressedKeys;
    private BufferedImage b0;
    private BufferedImage heart;

    private int x;
    private int count;
    private JTextField text;



    public GraphicsPanel() {
        text=new JTextField("0 Gold",10);
        count=0;
        timer = new Timer(2, this);
        timer.start();
       x=0;
        player= new character();
        slime=new Slime();
        slime.faceLeft();
        pressedKeys = new boolean[128]; // 128 keys on keyboard, max keycode is 127
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true); // this line of code + one below makes this panel active for keylistener events
        requestFocusInWindow(); // see comment above
        add(text);
        text.setLocation(0,50);

        try{

                 b0= ImageIO.read(new File("src\\images\\Background.png"));
                 heart = ImageIO.read(new File("src\\images\\heart.png"));


        }catch (IOException e) {
                System.out.println(e.getMessage());
            }


    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(b0,x,-475,null);
        g.drawImage(b0,x+1856,-475,null);
        g.drawImage(b0,x+(1856*2),-475,null);
        g.drawImage(b0,x+(1856*3),-475,null);
        g.drawImage(b0,x+(1856*4),-475,null);
        g.drawImage(b0,x+(1856*5),-475,null);
        g.drawImage(b0,x+(1856*6),-475,null);
        g.drawImage(b0,x+(1856*7),-475,null);
        g.drawImage(b0,x+(1856*8),-475,null);
        g.drawImage(b0,x+(1856*9),-475,null);
        g.drawImage(b0,x+(1856*10),-475,null);
        g.drawImage(b0,x+(1856*11),-475,null);
        g.drawImage(b0,x+(1856*12),-475,null);
        g.drawImage(b0,x+(1856*13),-475,null);
        g.drawImage(b0,x+(1856*14),-475,null);
        g.drawImage(b0,x+(1856*15),-475,null);
        text.setText(count+" Gold");

        g.drawImage(heart,25,50,null);
        g.drawImage(heart,100,50,null);
        g.drawImage(heart,175,50,null);












        player.idle();
        if(!slime.isdead()) {
            g.drawImage(slime.getPlayerImage(), slime.getxCoord(), slime.getyCoord(), slime.getWidth(), slime.getHeight(), null);
        }
        g.drawImage(player.getPlayerImage(), player.getxCoord(), player.getyCoord(), player.getWidth(), player.getHeight(), null);


if (player.getxCoord()>slime.getxCoord()) {
    slime.moveRight();
    slime.faceRight();
}
        if (player.getxCoord()<slime.getxCoord()) {
            slime.moveLeft();
            slime.faceLeft();

        }

        if (pressedKeys[65]) {
            player.faceLeft();
            player.moveLeft();
            x+=3;
        }


        // player moves right (D)
        if (pressedKeys[68]) {
            player.faceRight();
            player.moveRight();
            x-=3;
            }




        // player moves up (W)
        if (pressedKeys[87]) {
            player.moveUp();
        }


        // player moves down (S)
        if (pressedKeys[83]) {
            player.moveDown();
        }

        if (pressedKeys[69]) {
            player.attack();
        }

        if (slime.playerRect().intersects(player.playerRect())) {
            if (player.isfacingright()) {
                slime.faceRight();
            } else{
                slime.faceLeft();
            }

            if (player.isattacking()) {
                slime.death();
                count++;
            }
        }

        if (slime.isdead()) {
            slime.setdead(false);
            slime.setxCoord((int) (Math.random()*player.getxCoord()+2000));
        }

        requestFocusInWindow();
    }



    // ActionListener interface method
    @Override
    public void actionPerformed(ActionEvent e) {
        if (player!=null) {
        if (player.getyCoord()!=900) {
            player.fall();
        }else {
            player.setJumping(false);
        }}



        repaint();
    }

    // KeyListener interface methods
    @Override
    public void keyTyped(KeyEvent e) { } // unimplemented

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        pressedKeys[key] = false;
    }

    // MouseListener interface methods
    @Override
    public void mouseClicked(MouseEvent e) { }


    @Override
    public void mousePressed(MouseEvent e) { }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) { } // unimplemented

    @Override
    public void mouseExited(MouseEvent e) { } // unimplemented

}
