package org.academiadecodigo.anderdogs.shootinghousegame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ReactionTrainer implements Games, MouseHandler {

    //Properties
    private Picture reactionBackground;
    private Picture shot;
    private Picture[] lives;
    private AudioPlayer shotsound;
    private String[] targets;
    private Mouse mouse2;
    private Controls mouse;
    private double mouseX;
    private double mouseY;
    private MouseEventType eventType;
    private Text text;
    private boolean tooSoon = false;
    private boolean click = false;
    private final int totalLives = 5;
    private int remainingLives;
    private int rounds;
    private long start = 0;
    private long finale = 0;
    private long media = 0;
    private long[] reactionTimes;
    //private PrincipalMenu principalMenu;

    public ReactionTrainer(Controls mouse){
        this.mouse=mouse;
        this.reactionBackground = new Picture(10,10,"resources/Game_reaction_trainer.png");
        this.remainingLives = totalLives;
        this.reactionTimes = new long[5];
        this.shotsound = new AudioPlayer();
        this.eventType = MouseEventType.MOUSE_CLICKED;
    }


    public void initializeGame() throws InterruptedException {

        text = new Text(620,100,"PLEASE WAIT FOR TARGET");
        text.grow(150,50);
        text.setColor(Color.WHITE);

        initMouse();
        mouse2.addEventListener(eventType);

        while(true) {
            // Menu de entrada
            reactionBackground.draw();
            // Espera para
            while(true){

                Thread.sleep(0);
                if (mouse.mouseX() >= 38 && mouse.mouseX() <= 63 && mouse.mouseY() >= 53 && mouse.mouseY() <= 76) {
                    System.out.println("QUIT");
                    reactionBackground.delete();
                    mouse2.removeEventListener(eventType);
                    Thread.sleep(50);
                    return;
                }

                if (mouse.mouseX() >= 530 && mouse.mouseX() <= 747 && mouse.mouseY() >= 671 && mouse.mouseY() <= 721) {
                    System.out.println("PLAY");
                    Thread.sleep(50);
                    mouse2.removeEventListener(eventType);
                    break;
                }
                Thread.sleep(0);
            }
            mouse.resetPos();
            mouseX=0;
            mouseY=0;

            createTargets();

            while(true){

                reactionBackground.load("resources/TRANSITION_GAME_SELECTION.png");
                createLives();

                while (rounds < 5) {
                    text.setText("PLEASE WAIT FOR TARGET");
                    text.draw();
                    drawLives();
                    click=false;
                    Thread.sleep(10);
                    mouse2.addEventListener(eventType);

                    if(tooSoon()){
                        shootingEarly();
                        if(remainingLives==0){
                            break;
                        }
                    } else {
                        reactionBackground.load(targets[rounds]);
                        text.setText("SHOOT NOW");
                        Thread.sleep(25);

                        start = System.currentTimeMillis();

                        while(true) {
                            Thread.sleep(0);
                            if (mouseX >= 485 && mouseX <= 790 && mouseY >= 480 && mouseY <= 760) {
                                finale = System.currentTimeMillis();
                                break;
                            }
                            if (mouseX >= 578 && mouseX <= 700 && mouseY >= 255 && mouseY <= 480) {
                                finale = System.currentTimeMillis();
                                break;
                            }
                            Thread.sleep(0);
                        }
                        reactionTimes[rounds] = (finale - start);
                        text.setText(reactionTimes[rounds] + " ms");
                        shot = new Picture(mouseX-40, mouseY-60,"resources/SHOT2.png");
                        shot.draw();
                        shotsound.pewpew();
                        click = false;
                        mouseX=0;
                        mouseY=0;
                        rounds++;
                        mouse2.removeEventListener(eventType);
                        Thread.sleep(2000);
                        shot.delete();
                        reactionBackground.load("resources/TRANSITION_GAME_SELECTION.png");
                        }
                    tooSoon = false;
                    }
                mouse2.addEventListener(eventType);
                rounds = 0;
                deleteLives();
                if(remainingLives==0) {
                    gameOverMenu();
                } else {
                    resultsMenu();
                }
                remainingLives = totalLives;

                while(true){

                    Thread.sleep(0);
                    if (mouseX >= 38 && mouseX <= 63 && mouseY >= 53 && mouseY <= 76) {
                        System.out.println("QUIT");
                        reactionBackground.delete();
                        text.delete();
                        mouse2.removeEventListener(eventType);
                        Thread.sleep(50);
                        return;
                    }

                    if (mouseX >= 530 && mouseX <= 747 && mouseY >= 671 && mouseY <= 721) {
                        System.out.println("PLAY");
                        Thread.sleep(50);
                        break;
                    }
                    Thread.sleep(0);
                }
                mouseX=0;
                mouseY=0;
                text.delete();
                mouse2.removeEventListener(eventType);
                }
            }
        }





    private void shootingEarly() throws InterruptedException {
        text.setText("TOO SOON");
        text.draw();
        remainingLives--;
        lives[remainingLives].delete();
        if (remainingLives == 0) {
            text.setText("GAME OVER");
            text.draw();
            Thread.sleep(2000);
            return;
        }
        mouse2.removeEventListener(eventType);
        Thread.sleep(2000);
        reactionBackground.load("resources/TRANSITION_GAME_SELECTION.png");
    }

    private boolean tooSoon() throws InterruptedException {

        int waitTime = 20+(int)Math.round(Math.random()*15);

        for(int i = 0; i<waitTime; i++){
            Thread.sleep(100);
            if(click){
                tooSoon=true;
                click=false;
                mouseX=0;
                mouseY=0;
                return true;
            }
        }
        Thread.sleep(100);
        return false;
    }

    private void resultsMenu(){
        reactionBackground.load("resources/Game_reaction_trainer.png");
        for(int i = 0; i<reactionTimes.length; i++){
            media+=reactionTimes[i];
        }
        media=(media/5);
        text.setText("Media: " + media + " ms");
        media=0;
    }

    private void gameOverMenu(){
        reactionBackground.load("resources/Game_reaction_trainer.png");
        tooSoon=false;
    }

    private void createTargets(){
        targets = new String[5];
        targets[0] = "resources/Game_reaction_trainer_2.png";
        targets[1] = "resources/Game_reaction_trainer_3.png";
        targets[2] = "resources/Game_reaction_trainer_4.png";
        targets[3] = "resources/Game_reaction_trainer_5.png";
        targets[4] = "resources/Game_reaction_trainer_6.png";
    }

    private void createLives(){
        lives = new Picture[5];
        for(int i = 0; i<totalLives; i++){
            lives[i]= new Picture (50+(25*i), 640, "resources/heart.png");
        }
    }

    private void drawLives(){
        for(int i = 0; i<remainingLives; i++){
            lives[i].draw();
        }
    }

    private void deleteLives(){
        for(int i = 0; i<remainingLives; i++ ){
            lives[i].delete();
        }
    }


    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public void initMouse(){
        mouse2 = new Mouse(this);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();//Ver explicação nas properties
        mouseY = mouseEvent.getY();//Ver explicação nas properties
        click=true;
        //shotsound.pewpew();
        //System.out.println("X: " + mouseEvent.getX() + "Y: " + mouseEvent.getY());//APAGAR!! Informa o X e o Y quando existe um click no mouse
    }
}
