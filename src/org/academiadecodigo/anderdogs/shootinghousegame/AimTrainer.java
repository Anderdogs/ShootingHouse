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
        this.aimBackground = new Picture(10,10,"resources/Game_Aim_trainer_rules.png");
        //this.shot
    }

    public void initializeGame() throws InterruptedException {

        double startTime;
        double endTime;
        double totalTime;
        double medianTime;

        //initMouse();
        //mouse.addEventListener(eventType);

        while (true) {
            // Menu de entrada
            aimBackground.load("resources/Game_Aim_trainer_rules.png");
            aimBackground.draw();
            // Espera para
            while (true) {

                Thread.sleep(0);
                if (mouse.mouseX() >= 38 && mouse.mouseX() <= 63 && mouse.mouseY() >= 53 && mouse.mouseY() <= 76) {
                    System.out.println("QUIT");
                    aimBackground.delete();
                    //mouse.removeEventListener(eventType);
                    Thread.sleep(50);
                    return;
                }

                if (mouse.mouseX() >= 530 && mouse.mouseX() <= 747 && mouse.mouseY() >= 671 && mouse.mouseY() <= 721) {
                    System.out.println("PLAY");
                    Thread.sleep(50);
                    //mouse.removeEventListener(eventType);
                    break;
                }
                Thread.sleep(0);
            }
            mouse.resetPos();

            aimBackground.load("resources/Game reaction trainer vazio.png");
            testTarget = new Picture(520, 330, "resources/alvoAudreyV1.png");
            testTarget.draw();

            while(true){
                Thread.sleep(0);
            }

            /*while(!endGame) {
                createNewTargets();
                //mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
                startTime = System.currentTimeMillis();

                for (int i = 0; i < 10; i++) {
                    target[i].drawTarget();
                    currentTarget = target[i];
                    //mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
                    while (true) {
                        //mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
                        if (shotX >= currentTarget.getX() && shotX <= (currentTarget.getWidth()) &&
                                shotY >= currentTarget.getY() && shotY <= (currentTarget.getHeight())) {
                            click=true;
                            currentTarget.destroy();
                            targetsDestroyed++;
                            shot.delete();
                            break;
                        }
                        Thread.sleep(100);
                        shot.delete();
                        //System.out.println("ola");
                    }
                    //System.out.println("TARGET DESTROYED");
                    Thread.sleep(100);
                    shot.delete();
                }
                //System.out.println("ola");
                click=false;
                endTime = System.currentTimeMillis();
                totalTime = ((endTime - startTime) / 1000);
                medianTime = (totalTime / 10) * 1000;

                game2Results(totalTime, medianTime);
                while(!click) {
                    //game2Results(totalTime, medianTime);
                }
                click=false;
                shot.delete();
            }
            area.delete();
            Thread.sleep(200);
        }*/
        }
    }

    public void createTargets(){

    }

    /*public void initMouse(){
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("X: " + mouseX + "Y: " + mouseY);//APAGAR!! Informa o X e o Y quando existe um click no mouse
        mouseX = mouseEvent.getX();//Ver explicação nas properties
        mouseY = mouseEvent.getY();//Ver explicação nas properties
    }*/

}
