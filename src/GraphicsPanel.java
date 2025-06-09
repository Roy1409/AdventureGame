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
    private Boss boss;
    private boolean[] pressedKeys;
    private BufferedImage b0;
    private Witch witch;
    private BufferedImage hut;
    private BufferedImage heart;
    private int witchX;
    private int bckgX;
    private int count;
    private BufferedImage talk1;
    private BufferedImage talk3;
    private JTextField text;
    private boolean talk;
    private boolean talk2;
    private int hp;
    private int healthpot;
    private boolean show;
    private BufferedImage pot;
    private boolean h;
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
    private BufferedImage door;
    private BufferedImage slot;
    private int slotx;
    private Rectangle rect3;
    private BufferedImage word3;
    private boolean show1;
    private BufferedImage win;
    private BufferedImage draw;
    private BufferedImage lose;
    private BufferedImage notenough;
    private boolean move;
    private boolean DO;
    private int x;
    private BufferedImage door1;
    private Timer attackAnimationTimer;
    private Timer smashAnimationTimer;
    private Timer hitAnimationTimer;
    private boolean animationPlaying;
    private int scene;
    private Timer deas;
    private Timer slimeDeathTimer;
    private BufferedImage death;


    public GraphicsPanel() {
        scene = 1;
        animationPlaying = false;
        bossroom=false; //edit
        slotx=850;
        signx2=1600;
        signx=125;
        healthpot=0;
        hp=3;
        count1=0;
        witchX=1150;
        text=new JTextField("0 Gold",10);
        attackAnimationTimer = new Timer(1105, this); // delete this
        attackAnimationTimer.setRepeats(false);
        smashAnimationTimer = new Timer(1445, this); // edit this
        smashAnimationTimer.setRepeats(false);
        count=100;
        deas=new Timer(1000,this);
        hitAnimationTimer = new Timer(200, this);
        slimeDeathTimer = new Timer(200, this);
        hitAnimationTimer.setRepeats(false);
        timer = new Timer(2, this);
        timer2=new Timer(2500,this);
        timer2.start();
        timer.start();
        deas.start();
        timer3= new Timer(500,this);
        timer3.start();
        bckgX =0;
        witch=new Witch();
        player= new character();
        slime=new Slime();
        boss = new Boss();
        slime.faceLeft();
        pressedKeys = new boolean[128]; // 128 keys on keyboard, max keycode is 127
        addKeyListener(this);
        addMouseListener(this);
        setFocusable(true); // this line of code + one below makes this panel active for keylistener events
        requestFocusInWindow(); // see comment above
        add(text);
        text.setLocation(25,0);
        boss.faceRight();

        try{
            notenough=ImageIO.read(new File("src\\images\\notenough.png"));
            word3=ImageIO.read(new File("src\\images\\word3.png"));
            slot=ImageIO.read(new File("src\\images\\slot.png"));
            door=ImageIO.read(new File("src\\images\\door.png"));
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
        rect2 = new Rectangle(signx2, 800, 155, 200);
        rect3=new Rectangle(slotx,750,172,250);
        if (!bossroom) {
            g.drawImage(b0, 20, -470, null);
            if (scene == 1) {
                player.setWalkLimitR(0, 1930);
                g.drawImage(sign, signx - 100, 925, null);

        if (!h) {
            g.drawImage(slime.getPlayerImage(), slime.getxCoord(), slime.getyCoord(), slime.getWidth(), slime.getHeight(), null);

        }
            }
            else if (scene == 2) {
                player.setWalkLimitR(-100, 1930);
                g.drawImage(hut, witchX, 700, null);
                g.drawImage(slot, slotx, 750, null);
                g.drawImage(witch.getPlayerImage(), witch.getxCoord(), witch.getyCoord(), witch.getWidth(), witch.getHeight(), null);
            }
            else if (scene == 3) {
                player.setWalkLimitR(-100, 1910);
                g.drawImage(door, signx2 - 100, 800, null);
                g.drawImage(sign, signx2 - 100, 800, null);
            }
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
        if (bossroom){
            g.drawImage(boss.getPlayerImage(), boss.getxCoord(), boss.getyCoord(), boss.getWidth(), boss.getHeight(), null);
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

        if (!slime.isdead()) {
            if (!bossroom) {
                g.drawImage(slime.getPlayerImage(), slime.getxCoord(), slime.getyCoord(), slime.getWidth(), slime.getHeight(), null);
            }}
        if (hp>0) {
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
            g.drawImage(player.getPlayerImage(), player.getxCoord(), player.getyCoord(), player.getWidth(), player.getHeight(), null);
        }
        if (!slime.isdead()) {
            if (Math.abs(player.getxCoord() - slime.getxCoord()) < 500) {
                if (player.getxCoord() - 20 > slime.getxCoord()) {
                    slime.faceRight();
                    slime.moveRight();
                } else {
                    slime.faceLeft();
                    slime.moveLeft();
                }
            } else {
                slime.setMOVE_AMT(2);
                if (slime.isfacingright()) {
                    slime.moveRight();
                    if (slime.getxCoord() >= 1600) {
                        slime.faceLeft();
                    }
                } else {
                    slime.moveLeft();
                    if (slime.getxCoord() <= 1300) {
                        slime.faceRight();
                    }
                }
            }
        }


        if (!player.isfacingright() && !boss.isfacingright()) {
            boss.moveRight();
        }

        if (Math.abs(player.getxCoord()-boss.getxCoord())<700)  {
            move=true;
            if (player.getxCoord()-50> boss.getxCoord()) {

                boss.moveRight();
                boss.faceLeft();
            }
            if (player.getxCoord()< boss.getxCoord()) {
                boss.moveLeft();
                boss.faceRight();

            }
        }
        if (!pressedKeys[65] || !pressedKeys[68] || !pressedKeys[87] || !pressedKeys[69] || !pressedKeys[83]) {
            player.idle();
        }

        if (pressedKeys[65]) {
            player.faceLeft();
            player.moveLeft();;
            if (player.getxCoord() <= 0) {
                scene--;
            }
        }
        // player moves right (D)
        if (pressedKeys[68]) {
            player.faceRight();
            player.moveRight();
            if (player.getxCoord() >= 1920) {
                scene++;
                player.setxCoord(50);

            }

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
                slimeDeathTimer.start();
                slime.death();
                count++;
            }

        }



        //PLAYER CLICKS U
        if (pressedKeys[85] && healthpot>=1 && hp<3) {

            healthpot--;
            hp++;
            repaint();
        }

        if (!player.playerRect().intersects(rect3)) {
            DO=true;
            try{
                word3=ImageIO.read(new File("src\\images\\word3.png"));
            }catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        if (player.playerRect().intersects(rect3)) {
            if (!bossroom && !show1) {
                g.drawImage(word3, slotx, 700, null);
            }

            if (pressedKeys[69]) {

                if (DO) {
                    if (!(count>=5)) {
                        try{
                            word3=ImageIO.read(new File("src\\images\\notenough.png"));
                        }catch (IOException e) {
                            System.out.println(e.getMessage());
                        }

                    } else{
                        x=(int) (Math.random()*101)+1;
                        count-=5;
                        if (x>90) {
                            count+=25;
                            try{
                                word3=ImageIO.read(new File("src\\images\\win.png"));
                            }catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                        } else if (x>70
                        ) {
                            count+=5;
                            try{
                                word3=ImageIO.read(new File("src\\images\\draw.png"));
                            }catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                        } else {
                            try {
                                word3 = ImageIO.read(new File("src\\images\\lose.png"));
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            }

                        }}}
                DO=false;
            }
        }

        if (player.playerRect().intersects(rect)) {
            if (!bossroom)  {
                g.drawImage(word,signx-175,800,null); }
        }
        if (player.playerRect().intersects(rect2)) {
            if (!bossroom){
                g.drawImage(word2,signx2-150,700,null); }

            if (pressedKeys[69]) {
                bossroom=true;
                slime.setxCoord(99999);
                player.setxCoord(50);
                boss.setxCoord(1000);
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
        if (e.getSource() == hitAnimationTimer) {
            player.hit(false);
            slime.setMOVE_AMT(2);
            hitAnimationTimer.stop();
        }

        if (e.getSource()==timer2) {
            if (slime.playerRect().intersects(player.playerRect())) {
                slime.setMOVE_AMT(0);
                slime.attack();
                if (!player.isattacking() && !player.isSmash()) {
                    player.hit(true);
                    hitAnimationTimer.start();
                    repaint();
                    hp--;
                    if (player.isHit()) {
                        if (slime.isfacingright()) {
                            player.setxCoord(player.getxCoord() - 20);
                        } else {
                            player.setxCoord(player.getxCoord() + 20);
                        }
                    }

                }

            }else {
                player.hit(false);
            }
        }
if (e.getSource()==deas && slime.isdead()) {
    h=true;
    repaint();
}
        if (e.getSource() == attackAnimationTimer) {
            player.setAttacking(false);
            player.idle();
            attackAnimationTimer.stop();
            animationPlaying = false;
        }
        if (e.getSource() == smashAnimationTimer) {
            player.setSmash(false);
            player.idle();
            smashAnimationTimer.stop();
            animationPlaying = false;
        }
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
        if (!animationPlaying && !player.isHit()) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                player.attack();
                attackAnimationTimer.start();
                animationPlaying = true;
            }
            if (moveunlocked) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    player.smash();
                    smashAnimationTimer.start();
                    animationPlaying = true;
                }
            }
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) { } // unimplemented

    @Override
    public void mouseExited(MouseEvent e) { } // unimplemented

}

