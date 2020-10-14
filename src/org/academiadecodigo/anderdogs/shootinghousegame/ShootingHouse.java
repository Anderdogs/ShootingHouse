package org.academiadecodigo.anderdogs.shootinghousegame;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ShootingHouse implements MouseHandler {

    protected Mouse mouse;
    protected double mouseX; //Variável que irá guardar o X do rato
    protected double mouseY; //Variável que irá guardar o Y do rato
    private ReactionTrainer reaction;
    private AimTrainer aim;
    private Picture background;
    private GamesOption gameChose;
    private MouseEventType eventType = MouseEventType.MOUSE_CLICKED;


    public void start() throws InterruptedException {

        menuInitiation();
        mouseInit();

        while(true) {

            mouse.addEventListener(eventType);
            background.load("resources/GAME_SELECTION_2.png");

            while (true) {

                Thread.sleep(0);
                if (mouseX >= 170 && mouseX <= 386 && mouseY >= 270 && mouseY <= 320) {
                    gameChose = GamesOption.REACTION;
                    break;
                }

                if (mouseX >= 551 && mouseX <= 767 && mouseY >= 270 && mouseY <= 320) {
                    gameChose = GamesOption.AIM;
                    break;
                }

                if (mouseX >= 38 && mouseX <= 63 && mouseY >= 53 && mouseY <= 76) {
                    System.out.println("QUIT");
                    mouse.removeEventListener(eventType);
                    return;
                }
                Thread.sleep(0);
            }

            switch (gameChose) {
                case REACTION:
                    System.out.println("ola");
                    mouse.removeEventListener(eventType);
                    Thread.sleep(50);
                    reaction = new ReactionTrainer();
                    reaction.start();
                    break;
                case AIM:
                    System.out.println("alo");
                    mouse.removeEventListener(eventType);
                    break;
                case QUIT:
                    System.out.println("QUIT");
                    mouse.removeEventListener(eventType);
                    return;
            }
            mouseX=0;
            mouseY=0;
            gameChose=null;
        }
    }



    public void menuInitiation() throws InterruptedException {

        background = new Picture(10,10,"resources/HOME.png");//Momento de instanciação do PrincipalMenu,recebe uma imagem e coordenadas tendo em atenção Padding do Simple Graphics
        background.draw(); //Desenha a primeira imagem de apresentação(definida no construtor)...
        Thread.sleep(2000);
        background.load("resources/HOME2.png"); //Completa com o titulo de apresentação
        Thread.sleep(2000);
        background.load("resources/GAME_SELECTION_1.png");
        Thread.sleep(500);

    }

    public void mouseInit(){
        mouse = new Mouse(this);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX(); //Ver explicação nas properties
        mouseY = mouseEvent.getY(); //Ver explicação nas properties
        System.out.println("X: " + mouseX + "Y: " + mouseY); //APAGAR!! Informa o X e o Y quando existe um click no mouse
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
