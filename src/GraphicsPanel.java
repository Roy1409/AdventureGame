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
    private Witch witch;
    private BufferedImage hut;
    private BufferedImage heart;
    private int a;
    private int bckgX;
    private int count;
    private BufferedImage talk1;
    private BufferedImage talk3;
    private JTextField text;
    private int witchx;
    private boolean talk;
    private boolean talk2;
    private int hp;
    private int healthpot;
    private boolean show;
    private BufferedImage pot;
    private int count1;
    private boolean talk4;
    private BufferedImage talk5;
    private boolean moveunlocked;
    private Timer timer2;
    private BufferedImage sign;
    private int signx;
    private Rectangle rect;
    private BufferedImage word;
    private int signx2;
    private Rectangle rect2;
    private BufferedImage word2;
    private boolean bossroom;
    private BufferedImage b1;
    private boolean teleport;
    private Timer timer3;

    public GraphicsPanel() {
        bossroom=false;
        signx2=3000;
        signx=125;
        healthpot=0;
        hp=3;
        count1=0;
        a=2250;
        text=new JTextField("0 Gold",10);
        count=1000000;
        timer = new Timer(2, this);
        timer2=new Timer(2500,this);
        timer2.start();
        timer.start();
        timer3= new Timer(500,this);
        timer3.start();
        bckgX =0;
        witch=new Witch();
        player= new character();
        slime=new Slime();

        slime.faceLeft();
        pressedKeys = new boolean[128]; // 128 keys on keyboard, max keycode is 127
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true); // this line of code + one below makes this panel active for keylistener events
        requestFocusInWindow(); // see comment above
        add(text);
        text.setLocation(25,0);

        try{
            b1=ImageIO.read(new File("src\\images\\b1.jpg"));
            word2=ImageIO.read(new File("src\\images\\word2.png"));
            talk5=ImageIO.read(new File("src\\images\\talk5.png"));
            pot=ImageIO.read(new File("src\\images\\healthpot.png"));
            hut= ImageIO.read(new File("src\\images\\hut.png"));
            b0= ImageIO.read(new File("src\\images\\Background.png"));
            heart = ImageIO.read(new File("src\\images\\heart.png"));
            talk1= ImageIO.read(new File("src\\images\\talk1.png"));
            talk3=ImageIO.read(new File("src\\images\\talk3.png"));
            sign=ImageIO.read(new File("src\\images\\sign.png"));
            word=ImageIO.read(new File("src\\images\\word.png"));


        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }




@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
     rect = new Rectangle(signx, 925, 80, 80);
    rect2 = new Rectangle(signx2, 925, 80, 80);
if (!bossroom) {
    g.drawImage(b0, bckgX-1856, -475, null);
    g.drawImage(b0, bckgX, -475, null);
        g.drawImage(b0, bckgX +1856,-475,null);
        g.drawImage(b0, bckgX +(1856*2),-475,null);
        g.drawImage(b0, bckgX +(1856*3),-475,null);
        g.drawImage(b0, bckgX +(1856*4),-475,null);
        g.drawImage(b0, bckgX +(1856*5),-475,null);
        g.drawImage(b0, bckgX +(1856*6),-475,null);
        g.drawImage(b0, bckgX +(1856*7),-475,null);
        g.drawImage(b0, bckgX +(1856*8),-475,null);
        g.drawImage(b0, bckgX +(1856*9),-475,null);
        g.drawImage(b0, bckgX +(1856*10),-475,null);
        g.drawImage(b0, bckgX +(1856*11),-475,null);
        g.drawImage(b0, bckgX +(1856*12),-475,null);
        g.drawImage(b0, bckgX +(1856*13),-475,null);
        g.drawImage(b0, bckgX +(1856*14),-475,null);
        g.drawImage(b0, bckgX +(1856*15),-475,null);
        g.drawImage(sign,signx-100,925,null);
        g.drawImage(sign,signx2-100,925,null); } else{
    g.drawImage(b1, bckgX-2051, -0, null);

    g.drawImage(b1,bckgX,0,null);
    g.drawImage(b1, bckgX +(2051*2),-0,null);

        }
    text.setText(count + " Gold");
    if (healthpot==1) {
    g.drawImage(pot,0,125,null); }
    if (healthpot==2) {
        g.drawImage(pot,0,125,null);
        g.drawImage(pot,75,125,null); }
    if (healthpot>=3) {
        g.drawImage(pot,0,125,null);
        g.drawImage(pot,75,125,null);
        g.drawImage(pot,150,125,null);
    }


    if (!bossroom) {
        g.drawImage(hut, a, 700, null);
        g.drawImage(witch.getPlayerImage(), witch.getxCoord(), witch.getyCoord(), witch.getWidth(), witch.getHeight(), null);
    }
if (talk) {
    g.drawImage(talk1,witch.getxCoord(),775,null);
}
if (talk2) {
    g.drawImage(talk3,witch.getxCoord(),775,null);

}
if (talk4) {
    g.drawImage(talk5,witch.getxCoord(),775,null);
}
if (hp==3) {
    g.drawImage(heart, 25, 50, null);
    g.drawImage(heart, 100, 50, null);
    g.drawImage(heart, 175, 50, null);
}



    if (hp==2) {
        g.drawImage(heart, 25, 50, null);
        g.drawImage(heart, 100, 50, null);

     }
    if (hp==1) {
        g.drawImage(heart, 25, 50, null);
    }



    if (!slime.isdead()) {
        if (!bossroom) {
        g.drawImage(slime.getPlayerImage(), slime.getxCoord(), slime.getyCoord(), slime.getWidth(), slime.getHeight(), null);
    }}
    if (hp>0) {
        g.drawImage(player.getPlayerImage(), player.getxCoord(), player.getyCoord(), player.getWidth(), player.getHeight(), null);
    }

    if (player.getxCoord() > slime.getxCoord()) {
        slime.moveRight();
        slime.faceRight();
    }
    if (player.getxCoord() < slime.getxCoord()) {
        slime.moveLeft();
        slime.faceLeft();

    }
    if (!pressedKeys[65] || !pressedKeys[68] || !pressedKeys[87] || !pressedKeys[69] || !pressedKeys[83]) {
        player.idle();
    }

    if (pressedKeys[65]) {
        player.faceLeft();
        player.moveLeft();
        bckgX += 3;
        witch.setxCoord(witch.getxCoord() + 3);
        a += 3;
        signx+=3;
        signx2+=3;
    }

    if (player.isfacingright() && !slime.isfacingright()) {
        slime.moveLeft();
    }


    // player moves right (D)
    if (pressedKeys[68]) {
        player.faceRight();
        player.moveRight();
            bckgX -= 3;
            a -= 3;
            signx-=3;
            signx2-=3;

            witch.setxCoord(witch.getxCoord() - 3);

        }

        if (talk2 && pressedKeys[49] && count>=15) {
            if (!talk4) {

            healthpot++;



                count-=15;
            show=true;
            count1=0;
            talk2=false;
            talk4=true;

        }  }

    if (talk2 && pressedKeys[50] && count>=20) {
        if (!talk4) {
            moveunlocked=true;
            count-=15;
            show=true;
            count1=0;
            talk2=false;
            talk4=true;
        }  }



if (!bossroom) {
        if (pressedKeys[69]) {
            if (player.playerRect().intersects(witch.playerRect())) {
                talk=true;
                talk4=false;
            }
        } }

        if (talk && pressedKeys[66]) {
            talk=false;
            talk2=true;
            talk4=false;
        }





    if (!player.playerRect().intersects(witch.playerRect())) {
        count1=0;
        talk=false;
        talk2=false;
        talk4=false;
    }
        if (slime.playerRect().intersects(player.playerRect())) {
            if (player.isfacingright()) {
                slime.faceRight();
            } else {
                slime.faceLeft();
            }

            if (player.isattacking() || player.isSmash()) {
                slime.death();
                count++;
            }

        }

        if (slime.isdead()) {
            slime.setdead(false);
            slime.setxCoord((int) (Math.random() * player.getxCoord() + 2000));
        }
    //PLAYER CLICKS U
    if (pressedKeys[85] && healthpot>=1 && hp<3) {

        healthpot--;
        hp++;
        repaint();
    }

    if (player.playerRect().intersects(rect)) {
        if (!bossroom)  {
        g.drawImage(word,signx-175,800,null); }
    }
    if (player.playerRect().intersects(rect2)) {
        if (!bossroom){
        g.drawImage(word2,signx2-200,800,null); }

        if (pressedKeys[69]) {
            bossroom=true;
            slime.setxCoord(99999);
            player.setxCoord(50);
            bckgX=0;
        }
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
            }
        }

        if (e.getSource()==timer2) {
            if (slime.playerRect().intersects(player.playerRect())) {

        if (!player.isattacking() && !player.isSmash()) {

            player.hit(true);
            hp--;

        }
            }else {
                player.hit(false);
        }}

if (e.getSource()==timer3) {
        if (pressedKeys[81]) {
            teleport=true;
            if (player.isfacingright()) {
                player.setxCoord(player.getxCoord()+100);
        }

    }}


        repaint();}

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
        if (e.getButton() == MouseEvent.BUTTON1) {
            player.attack();
        }
        if (moveunlocked) {
        if (e.getButton() == MouseEvent.BUTTON3){
            player.smash();
        } }
    }


    @Override
    public void mouseEntered(MouseEvent e) { } // unimplemented

    @Override
    public void mouseExited(MouseEvent e) { } // unimplemented

}

