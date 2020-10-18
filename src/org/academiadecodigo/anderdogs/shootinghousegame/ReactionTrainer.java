package org.academiadecodigo.anderdogs.shootinghousegame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ReactionTrainer implements Games {

    //Properties
    private Picture reactionBackground;
    private Picture shot;
    private Picture menuButton;
    private Picture[] lives;
    private AudioPlayer shotSound;
    private String[] targets;
    private Controls mouse;
    private Text text;
    private Text results;
    private boolean endGame;
    private final int totalLives = 5;
    private int remainingLives;
    private long media;
    private long[] reactionTimes;

    public ReactionTrainer(Controls mouse, Picture background){
        this.mouse = mouse;
        this.reactionBackground = background;
        this.menuButton = new Picture(31,22,"resources/Icons/MenuButton.png");
        this.remainingLives = totalLives;
        this.reactionTimes = new long[5];
        this.shotSound = new AudioPlayer();
        this.text = new Text(620,100,"PLEASE WAIT FOR TARGET");
        text.grow(150,50);
        text.setColor(Color.WHITE);
    }


    public void initializeGame() throws InterruptedException {

        int rounds = 0;
        long start;
        long finale;

        while(true) {

            reactionBackground.load("resources/ReactionTrainer/Game reaction trainer.jpg");

            while(true){

                Thread.sleep(0);
                if (mouse.mouseX() >= 38 && mouse.mouseX() <= 63 && mouse.mouseY() >= 53 && mouse.mouseY() <= 76) {
                    //shotSound.awpClipin();
                    Thread.sleep(50);
                    return;
                }

                if (mouse.mouseX() >= 530 && mouse.mouseX() <= 747 && mouse.mouseY() >= 671 && mouse.mouseY() <= 721) {
                    //shotSound.awpClipin();
                    Thread.sleep(50);
                    break;
                }
                Thread.sleep(0);
            }

            mouse.resetPos();
            createTargets();

            while(true){

                reactionBackground.load("resources/HomePageMenuPrincipal/TRANSITION GAME SELECTION.jpg");
                menuButton.draw();
                createLives();

                while (rounds < 5) {

                    text.setText("PLEASE WAIT FOR TARGET");
                    text.draw();
                    drawLives();
                    mouse.setClick(false);
                    Thread.sleep(10);

                    if(tooSoon()){
                        if(endGame){
                            menuButton.delete();
                            endGame=false;
                            return;
                        }
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
                                finale = System.currentTimeMillis();
                                break;
                            }
                            if (mouse.mouseX() >= 578 && mouse.mouseX() <= 708 && mouse.mouseY() >= 255 && mouse.mouseY() <= 480) {
                                finale = System.currentTimeMillis();
                                break;
                            }

                            if (mouse.mouseX() >= 38 && mouse.mouseX() <= 63 && mouse.mouseY() >= 53 && mouse.mouseY() <= 76) {
                                deleteLives();
                                text.delete();
                                menuButton.delete();
                                //shotSound.awpClipin();
                                Thread.sleep(25);
                                return;
                            }
                            Thread.sleep(0);
                        }

                        reactionTimes[rounds] = (finale - start);
                        text.setText(reactionTimes[rounds] + " ms");

                        shot(mouse.mouseX(), mouse.mouseY());
                        rounds++;
                        Thread.sleep(2000);
                        shot.delete();
                        reactionBackground.load("resources/HomePageMenuPrincipal/TRANSITION GAME SELECTION.jpg");
                        }
                    }
                rounds = 0;
                deleteLives();
                menuButton.delete();
                if(remainingLives==0) {
                    gameOverMenu();
                } else {
                    resultsMenu();
                }
                remainingLives = totalLives;

                while(true){

                    Thread.sleep(0);
                    if (mouse.mouseX() >= 38 && mouse.mouseX() <= 63 && mouse.mouseY() >= 53 && mouse.mouseY() <= 76) {
                        results.delete();
                        //shotSound.awpClipin();
                        Thread.sleep(50);
                        return;
                    }

                    if (mouse.mouseX() >= 530 && mouse.mouseX() <= 747 && mouse.mouseY() >= 671 && mouse.mouseY() <= 721) {
                        //shotSound.awpClipin();
                        Thread.sleep(50);
                        break;
                    }
                    Thread.sleep(0);
                }
                mouse.resetPos();
                results.delete();
                }
            }
        }


    private void shootingEarly() throws InterruptedException {

        remainingLives--;
        lives[remainingLives].delete();
        shot(mouse.mouseX(), mouse.mouseY());
        mouse.resetPos();

        if (remainingLives == 0) {
            text.delete();
            shot.delete();
            Thread.sleep(100);
            return;
        }
        Thread.sleep(1000);
        shot.delete();
        reactionBackground.load("resources/HomePageMenuPrincipal/TRANSITION GAME SELECTION.jpg");
    }

    private boolean tooSoon() throws InterruptedException {

        int waitTime = 20+(int)Math.round(Math.random()*30);

        for(int i = 0; i<waitTime; i++){
            Thread.sleep(100);

            if (mouse.mouseX() >= 38 && mouse.mouseX() <= 63 && mouse.mouseY() >= 53 && mouse.mouseY() <= 76) {
                deleteLives();
                text.delete();
                endGame=true;
                Thread.sleep(50);
                return true;
            }

            if(mouse.getClick()){
                text.setText("TOO SOON");
                text.draw();
                return true;
            }
        }
        mouse.resetPos();
        return false;
    }

    private void resultsMenu(){
        reactionBackground.load("resources/ReactionTrainer/Game reaction trainer tryagain.jpg");
        text.delete();
        for(int i = 0; i<reactionTimes.length; i++){
            media+=reactionTimes[i];
        }
        media=(media/5);
        results = new Text(625, 340, media + " ms");
        results.grow(100,30);
        results.draw();
        media=0;
    }

    private void gameOverMenu(){
        reactionBackground.load("resources/ReactionTrainer/Game reaction trainer tryagain gameover.jpg");
    }

    /*private void createTargets(){
        targets = new String[5];
        targets[0] = "resources/ReactionTrainer/Game reaction trainer 2.jpg";
        targets[1] = "resources/ReactionTrainer/Game reaction trainer 3.jpg";
        targets[2] = "resources/ReactionTrainer/Game reaction trainer 4.jpg";
        targets[3] = "resources/ReactionTrainer/Game reaction trainer 5.jpg";
        targets[4] = "resources/ReactionTrainer/Game reaction trainer 6.jpg";
    }

     */

    /*private void createTargets() {
        int random;
        targets = new String[5];
        String[] randomizerArr = new String[5];
        randomizerArr[0] = "resources/ReactionTrainer/Game reaction trainer 2.jpg";
        randomizerArr[1] = "resources/ReactionTrainer/Game reaction trainer 3.jpg";
        randomizerArr[2] = "resources/ReactionTrainer/Game reaction trainer 4.jpg";
        randomizerArr[3] = "resources/ReactionTrainer/Game reaction trainer 5.jpg";
        randomizerArr[4] = "resources/ReactionTrainer/Game reaction trainer 6.jpg";
        for (int i = 0; i < randomizerArr.length; i++) {
            random = (int) Math.floor(Math.random() * 5);
            for(int j = 0; j<targets.length; j++){
                if (targets[j].equals(randomizerArr[random])) {
                    continue;
                }
            }
        }
    }
     */

    private void createTargets() {
        int random = (int) Math.floor(Math.random() * 6);
        targets = new String[5];
        switch (random){
            case 0:
                targets[0] = "resources/ReactionTrainer/Game reaction trainer 2.jpg";
                targets[1] = "resources/ReactionTrainer/Game reaction trainer 3.jpg";
                targets[2] = "resources/ReactionTrainer/Game reaction trainer 4.jpg";
                targets[3] = "resources/ReactionTrainer/Game reaction trainer 5.jpg";
                targets[4] = "resources/ReactionTrainer/Game reaction trainer 6.jpg";
                break;
            case 1:
                targets[1] = "resources/ReactionTrainer/Game reaction trainer 2.jpg";
                targets[3] = "resources/ReactionTrainer/Game reaction trainer 3.jpg";
                targets[2] = "resources/ReactionTrainer/Game reaction trainer 4.jpg";
                targets[0] = "resources/ReactionTrainer/Game reaction trainer 5.jpg";
                targets[4] = "resources/ReactionTrainer/Game reaction trainer 6.jpg";
                break;
            case 2:
                targets[4] = "resources/ReactionTrainer/Game reaction trainer 2.jpg";
                targets[1] = "resources/ReactionTrainer/Game reaction trainer 3.jpg";
                targets[3] = "resources/ReactionTrainer/Game reaction trainer 4.jpg";
                targets[2] = "resources/ReactionTrainer/Game reaction trainer 5.jpg";
                targets[0] = "resources/ReactionTrainer/Game reaction trainer 6.jpg";
                break;
            case 3:
                targets[3] = "resources/ReactionTrainer/Game reaction trainer 2.jpg";
                targets[2] = "resources/ReactionTrainer/Game reaction trainer 3.jpg";
                targets[1] = "resources/ReactionTrainer/Game reaction trainer 4.jpg";
                targets[4] = "resources/ReactionTrainer/Game reaction trainer 5.jpg";
                targets[0] = "resources/ReactionTrainer/Game reaction trainer 6.jpg";
                break;
            case 4:
                targets[2] = "resources/ReactionTrainer/Game reaction trainer 2.jpg";
                targets[4] = "resources/ReactionTrainer/Game reaction trainer 3.jpg";
                targets[0] = "resources/ReactionTrainer/Game reaction trainer 4.jpg";
                targets[3] = "resources/ReactionTrainer/Game reaction trainer 5.jpg";
                targets[1] = "resources/ReactionTrainer/Game reaction trainer 6.jpg";
                break;
            case 5:
                targets[4] = "resources/ReactionTrainer/Game reaction trainer 2.jpg";
                targets[3] = "resources/ReactionTrainer/Game reaction trainer 3.jpg";
                targets[2] = "resources/ReactionTrainer/Game reaction trainer 4.jpg";
                targets[1] = "resources/ReactionTrainer/Game reaction trainer 5.jpg";
                targets[0] = "resources/ReactionTrainer/Game reaction trainer 6.jpg";
                break;

        }

    }

    private void createLives(){
        lives = new Picture[5];

        for(int i = 0; i<totalLives; i++){
            lives[i] = new Picture (50+(30*i), 640, "resources/Icons/heart.png");
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

    private void shot(double x, double y) throws InterruptedException {
        shot = new Picture(x-45, y-75,"resources/Icons/SHOT2_50%.png");
        shot.draw();
        //shotSound.awp();
        Thread.sleep(800);
        //shotSound.awpClipin();
        mouse.setClick(false);
    }
}

//FALTA IMPLEMENTAR FINAL DE MÉDIA
//FALTA IMPLEMENTAR FINAL GAMEOVER