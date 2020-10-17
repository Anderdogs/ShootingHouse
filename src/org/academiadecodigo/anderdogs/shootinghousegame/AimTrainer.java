package org.academiadecodigo.anderdogs.shootinghousegame;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class AimTrainer implements Games {

    private AudioPlayer shotSound;
    private Controls mouse;
    private Picture aimBackground;
    private Picture shot;
    private Target[] target;
    private boolean click;
    private boolean endGame;
    private Picture testTarget;
    private int totalEnemies;
    private int targetsDestroyed;


    public AimTrainer(Controls mouse){
        this.mouse=mouse;
        this.aimBackground = new Picture(10,10,"resources/AimTrainer/Game Aim trainer rules.jpg");
        this.shotSound=new AudioPlayer();
        this.totalEnemies=30;
        target = new Target[30];
    }

    public void initializeGame() throws InterruptedException {

        double startTime;
        double endTime;
        double totalTime;
        double medianTime;
        Target currentTarget;

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
                startTime = System.currentTimeMillis();

                for (int i = 0; i<totalEnemies; i++) {
                    target[i].drawTarget();

                    while (true) {
                        if (mouse.mouseX()-10 >= target[i].getX() && mouse.mouseX()-10 <= (target[i].getWidth()) &&
                                mouse.mouseY()-30 >= target[i].getY() && mouse.mouseY()-30 <= (target[i].getHeight())) {
                            mouse.setClick(true);
                            shot(mouse.mouseX(), mouse.mouseY());
                            target[i].destroy();
                            targetsDestroyed++;
                            break;
                        }
                        Thread.sleep(10);
                    }
                    mouse.resetPos();
                    Thread.sleep(50);
                }
                mouse.setClick(false);
                mouse.resetPos();
                endTime = System.currentTimeMillis();
                totalTime = ((endTime - startTime) / 1000);
                medianTime = (totalTime / totalEnemies) * 1000;

                game2Results(totalTime, medianTime);

                while (true) {

                    Thread.sleep(0);
                    if (mouse.mouseX() >= 38 && mouse.mouseX() <= 63 && mouse.mouseY() >= 53 && mouse.mouseY() <= 76) {
                        System.out.println("QUIT");
                        aimBackground.delete();
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
                Thread.sleep(200);
                aimBackground.load("resources/ReactionTrainer/Game reaction trainer vazio.jpg");
            }
        }
    }

    public void createTargets(){
        int randomPos;
        for(int i = 0; i<30; i++) {
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

    private void game2Results(double totalTime, double median) throws InterruptedException {

        aimBackground.load("resources/AimTrainer/Game aim trainer tryagain_.jpg");
        Text text1 = new Text(150, 200, "Game ended in: " + totalTime + " seconds.");
        Text text2 = new Text(170, 225, "Median Time: " + median + " ms");
        text1.draw();
        text2.draw();
        Thread.sleep(1000);
    }

    private void shot(double x, double y) throws InterruptedException {
        shot = new Picture(x-40, y-60, "resources/Icons/SHOT2_50%.png");
        shot.draw();
        shotSound.awp();
        Thread.sleep(50);
        shot.delete();
    }
}

//FALTA IMPLEMENTAR GAME AIM TRAINER TRYAGAIN
//FALTA IMPLEMENTAR GAME aim TRAINER GAMEOVER