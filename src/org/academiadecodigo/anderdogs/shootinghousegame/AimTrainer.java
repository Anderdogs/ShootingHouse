package org.academiadecodigo.anderdogs.shootinghousegame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class AimTrainer implements Games {

    private AudioPlayer shotSound;
    private Controls mouse;
    private Picture aimBackground;
    private Picture shot;
    private Target[] target;
    private Picture testTarget;
    private int totalEnemies;
    private int remainingTargets;
    private Text text1;
    private Text text2;
    private Text text3;


    public AimTrainer(Controls mouse){
        this.mouse=mouse;
        this.aimBackground = new Picture(10,10,"resources/AimTrainer/Game Aim trainer rules.jpg");
        this.shotSound=new AudioPlayer();
        this.totalEnemies=20;
        this.target = new Target[totalEnemies];
    }

    public void initializeGame() throws InterruptedException {

        double startTime;
        double endTime;
        double totalTime;
        double medianTime;

        while(true) {

            aimBackground.load("resources/AimTrainer/Game Aim trainer rules.jpg");
            aimBackground.draw();

            while (true) {

                Thread.sleep(0);
                if (mouse.mouseX() >= 38 && mouse.mouseX() <= 63 && mouse.mouseY() >= 53 && mouse.mouseY() <= 76) {
                    System.out.println("QUIT");
                    aimBackground.delete();
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

            aimBackground.load("resources/ReactionTrainer/Game reaction trainer vazio.jpg");

            /*testTarget = new Picture(623, 320, "resources/AimTrainer/Game aim trainer3.png");
            testTarget.draw();
            while(true){
                Thread.sleep(0);
            }*/

            while(true) {

                createTargets();
                remainingTargets=totalEnemies;
                text3 = new Text(600, 25, "Remaining Targets: " + remainingTargets);
                text3.grow(100,10);
                text3.setColor(Color.WHITE);
                text3.draw();

                startTime = System.currentTimeMillis();

                for (int i = 0; i<totalEnemies; i++) {
                    target[i].drawTarget();
                    mouse.resetPos();

                    while (true) {
                        if (mouse.mouseX()-10 >= target[i].getX() && mouse.mouseX()-10 <= (target[i].getWidth()) &&
                                mouse.mouseY()-30 >= target[i].getY() && mouse.mouseY()-30 <= (target[i].getHeight())) {
                            mouse.setClick(true);
                            shot(mouse.mouseX(), mouse.mouseY());
                            target[i].destroy();
                            remainingTargets--;
                            text3.setText("Remaining Targets: " + remainingTargets);
                            text3.draw();
                            break;
                        }
                        Thread.sleep(10);
                    }
                    Thread.sleep(25);
                }
                text3.delete();
                mouse.setClick(false);
                mouse.resetPos();
                endTime = System.currentTimeMillis();
                totalTime = ((endTime - startTime) / 1000);
                medianTime = ((endTime - startTime) / totalEnemies);

                aimTrainerResults(totalTime, medianTime);

                while (true) {

                    if (mouse.mouseX() >= 38 && mouse.mouseX() <= 63 && mouse.mouseY() >= 53 && mouse.mouseY() <= 76) {
                        System.out.println("QUIT");
                        text1.delete();
                        text2.delete();
                        aimBackground.delete();
                        return;
                    }

                    if (mouse.mouseX() >= 530 && mouse.mouseX() <= 747 && mouse.mouseY() >= 671 && mouse.mouseY() <= 721) {
                        System.out.println("PLAY AGAIN");
                        break;
                    }
                    Thread.sleep(0);
                }
                Thread.sleep(0);
                text1.delete();
                text2.delete();
                aimBackground.load("resources/ReactionTrainer/Game reaction trainer vazio.jpg");
            }
        }
    }

    public void createTargets(){
        int randomPos;
        for(int i = 0; i<totalEnemies; i++) {
            randomPos = (int) Math.floor(Math.random() * 15);

            switch(randomPos) {
                case 0:
                    target[i] = new Target(80, 470, "resources/AimTrainer/Game aim trainer1.png");
                    break;
                case 1:
                    target[i] = new Target(522, 128, "resources/AimTrainer/Game aim trainer2.png");
                    break;
                case 2:
                    target[i] = new Target(623, 320, "resources/AimTrainer/Game aim trainer3.png");
                    break;
                case 3:
                    target[i] = new Target(543, 363, "resources/AimTrainer/Game aim trainer4.png");
                    break;
                case 4:
                    target[i] = new Target(779, 275, "resources/AimTrainer/Game aim trainer5.png");
                    break;
                case 5:
                    target[i] = new Target(605, 10, "resources/AimTrainer/Game aim trainer6.png");
                    break;
                case 6:
                    target[i] = new Target(967, 283, "resources/AimTrainer/Game aim trainer7.png");
                    break;
                case 7:
                    target[i] = new Target(425, 280, "resources/AimTrainer/Game aim trainer8.png");
                    break;
                case 8:
                    target[i] = new Target(684, 130, "resources/AimTrainer/Game aim trainer9.png");
                    break;
                case 9:
                    target[i] = new Target(993, 473, "resources/AimTrainer/Game aim trainer10.png");
                    break;
                case 10:
                    target[i] = new Target(273, 10, "resources/AimTrainer/Game aim trainer11.png");
                    break;
                case 11:
                    target[i] = new Target(800, 400, "resources/AimTrainer/Game aim trainer12.png");
                    break;
                case 12:
                    target[i] = new Target(10, 269, "resources/AimTrainer/Game aim trainer13.png");
                    break;
                case 13:
                    target[i] = new Target(852, 10, "resources/AimTrainer/Game aim trainer14.png");
                    break;
                case 14:
                    target[i] = new Target(317, 404, "resources/AimTrainer/Game aim trainer15.png");
                    break;
            }
        }
    }

    private void aimTrainerResults(double totalTime, double median) throws InterruptedException {

        aimBackground.load("resources/AimTrainer/Game aim trainer tryagain_.jpg");
        text1 = new Text(608, 340, totalTime + " seconds");
        text2 = new Text(620, 450, median + " ms");
        text1.grow(60,10);
        text2.grow(40,10);
        text1.draw();
        text2.draw();
        Thread.sleep(1000);
    }

    private void shot(double x, double y) throws InterruptedException {
        shot = new Picture(x-45, y-75, "resources/Icons/SHOT2_50%.png");
        shot.draw();
        shotSound.awp();
        Thread.sleep(50);
        shot.delete();
    }
}

//FALTA IMPLEMENTAR GAME AIM TRAINER TRYAGAIN
//FALTA IMPLEMENTAR GAME aim TRAINER GAMEOVER