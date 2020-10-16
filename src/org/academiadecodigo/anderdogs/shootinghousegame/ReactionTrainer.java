package org.academiadecodigo.anderdogs.shootinghousegame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ReactionTrainer implements Games {

    //Properties
    private Picture reactionBackground;
    private Picture shot;
    private Picture[] lives;
    private AudioPlayer shotsound;
    private String[] targets;
    private Controls mouse;
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

    public ReactionTrainer(Controls mouse){
        this.mouse = mouse;
        this.reactionBackground = new Picture(10,10,"resources/Game_reaction_trainer.png");
        this.remainingLives = totalLives;
        this.reactionTimes = new long[5];
        this.shotsound = new AudioPlayer();
    }


    public void initializeGame() throws InterruptedException {

        text = new Text(620,100,"PLEASE WAIT FOR TARGET");
        text.grow(150,50);
        text.setColor(Color.WHITE);

        while(true) {

            reactionBackground.draw();

            while(true){

                Thread.sleep(0);
                if (mouse.mouseX() >= 38 && mouse.mouseX() <= 63 && mouse.mouseY() >= 53 && mouse.mouseY() <= 76) {
                    System.out.println("QUIT");
                    reactionBackground.delete();
                    Thread.sleep(50);
                    return;
                }

                if (mouse.mouseX() >= 530 && mouse.mouseX() <= 747 && mouse.mouseY() >= 671 && mouse.mouseY() <= 721) {
                    System.out.println("PLAY");
                    Thread.sleep(50);
                    break;
                }
                Thread.sleep(0);
            }

            mouse.resetPos();
            createTargets();

            while(true){

                reactionBackground.load("resources/TRANSITION_GAME_SELECTION.png");
                createLives();

                while (rounds < 5) {

                    text.setText("PLEASE WAIT FOR TARGET");
                    text.draw();
                    drawLives();
                    mouse.setClick(false);
                    Thread.sleep(10);

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
                            if (mouse.mouseX() >= 485 && mouse.mouseX() <= 790 && mouse.mouseY() >= 480 && mouse.mouseY() <= 760) {
                                System.out.println("body");
                                finale = System.currentTimeMillis();
                                break;
                            }
                            if (mouse.mouseX() >= 578 && mouse.mouseX() <= 708 && mouse.mouseY() >= 255 && mouse.mouseY() <= 480) {
                                System.out.println("headshot");
                                finale = System.currentTimeMillis();
                                break;
                            }
                            Thread.sleep(0);
                        }

                        reactionTimes[rounds] = (finale - start);

                        text.setText(reactionTimes[rounds] + " ms");

                        shot = new Picture(mouse.mouseX()-40, mouse.mouseY()-60,"resources/SHOT2.png");
                        shot.draw();

                        shotsound.pewpew();

                        mouse.setClick(false);
                        rounds++;
                        Thread.sleep(2000);
                        shot.delete();

                        reactionBackground.load("resources/TRANSITION_GAME_SELECTION.png");
                        }
                    tooSoon = false;
                    }

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
                    if (mouse.mouseX() >= 38 && mouse.mouseX() <= 63 && mouse.mouseY() >= 53 && mouse.mouseY() <= 76) {
                        System.out.println("QUIT");
                        reactionBackground.delete();
                        text.delete();
                        Thread.sleep(50);
                        return;
                    }

                    if (mouse.mouseX() >= 530 && mouse.mouseX() <= 747 && mouse.mouseY() >= 671 && mouse.mouseY() <= 721) {
                        System.out.println("PLAY AGAIN");
                        Thread.sleep(50);
                        break;
                    }
                    Thread.sleep(0);
                }
                mouse.resetPos();
                text.delete();
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

        Thread.sleep(2000);
        reactionBackground.load("resources/TRANSITION_GAME_SELECTION.png");
    }

    private boolean tooSoon() throws InterruptedException {

        int waitTime = 15+(int)Math.round(Math.random()*25);

        for(int i = 0; i<waitTime; i++){
            Thread.sleep(100);
            if(mouse.getClick()){
                tooSoon=true;
                mouse.setClick(false);
                mouse.resetPos();
                return true;
            }
        }
        mouse.resetPos();
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
            lives[i] = new Picture (50+(25*i), 640, "resources/heart.png");
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

}
