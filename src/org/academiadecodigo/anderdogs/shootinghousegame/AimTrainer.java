package org.academiadecodigo.anderdogs.shootinghousegame;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class AimTrainer implements Games {

    private Controls mouse;
    private Picture aimBackground;
    private Picture shot;
    private Target[] target;
    private boolean click;
    private boolean endGame;
    private Picture testTarget;


    public AimTrainer(Controls mouse){
        this.mouse=mouse;
        this.aimBackground = new Picture(10,10,"resources/AimTrainer/Game Aim trainer rules.jpg");
        //this.shot
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

            testTarget = new Picture(623, 320, "resources/AimTrainer/Game aim trainer3.png");
            testTarget.draw();



            while(true){
                Thread.sleep(0);
            }

        }
    }

    public void createTargets(){
        target = new Target[15];
        //target[0] = new Target(520, 330, "resources/alvoAudreyV1");
        target[0] = new Target(80, 470, "resources/AimTrainer/Game aim trainer1.png");
        target[1] = new Target(522, 128, "resources/AimTrainer/Game aim trainer2.png");
        target[2] = new Target(623, 320, "resources/AimTrainer/Game aim trainer3.png");
        target[3] = new Target(543,363 , "resources/AimTrainer/Game aim trainer4.png");
        target[4] = new Target(779, 275, "resources/AimTrainer/Game aim trainer5.png");
        target[5] = new Target(605, 10, "resources/AimTrainer/Game aim trainer6.png");
        target[6] = new Target(967, 283, "resources/AimTrainer/Game aim trainer7.png");
        target[7] = new Target(425, 280, "resources/AimTrainer/Game aim trainer8.png");
        target[8] = new Target(684, 130, "resources/AimTrainer/Game aim trainer9.png");
        target[9] = new Target(993, 473, "resources/AimTrainer/Game aim trainer10.png");
        target[10] = new Target(273, 10, "resources/AimTrainer/Game aim trainer11.png");
        target[11] = new Target(800, 400, "resources/AimTrainer/Game aim trainer12.png");
        target[12] = new Target(10, 269, "resources/AimTrainer/Game aim trainer13.png");
        target[13] = new Target(852, 10, "resources/AimTrainer/Game aim trainer14.png");
        target[14] = new Target(317, 404, "resources/AimTrainer/Game aim trainer15.png");


    }

}

//FALTA IMPLEMENTAR GAME AIM TRAINER TRYAGAIN
//FALTA IMPLEMENTAR GAME aim TRAINER GAMEOVER