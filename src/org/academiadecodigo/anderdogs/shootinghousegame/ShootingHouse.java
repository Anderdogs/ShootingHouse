package org.academiadecodigo.anderdogs.shootinghousegame;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ShootingHouse /*implements MouseHandler*/ {

    private Controls mouse;
    //protected double mouseX; //Variável que irá guardar o X do rato
    //protected double mouseY; //Variável que irá guardar o Y do rato
    private Games game;
    private Picture background;
    private GamesOption gameChose;
    private MouseEventType eventType = MouseEventType.MOUSE_CLICKED;

    public ShootingHouse(){
        mouse = new Controls();
    }

    public void start() throws InterruptedException {

        menuInitiation();
        //mouseInit();

        while(true) {

            //mouse.addEventListener(eventType);
            background.load("resources/GAME_SELECTION_2.png");

            while (true) {

                Thread.sleep(0);
                if (mouse.mouseX() >= 170 && mouse.mouseX() <= 386 && mouse.mouseY() >= 270 && mouse.mouseY() <= 320) {
                    gameChose = GamesOption.REACTION;
                    break;
                }

                if (mouse.mouseX() >= 551 && mouse.mouseX() <= 767 && mouse.mouseY() >= 270 && mouse.mouseY() <= 320) {
                    gameChose = GamesOption.AIM;
                    break;
                }

                if (mouse.mouseX() >= 38 && mouse.mouseX() <= 63 && mouse.mouseY() >= 53 && mouse.mouseY() <= 76) {
                    System.out.println("QUIT");
                    //mouse.removeEventListener(eventType);
                    return;
                }
                Thread.sleep(0);
            }
            mouse.resetPos();

            switch (gameChose) {
                case REACTION:
                    System.out.println("ola");
                    //mouse.removeEventListener(eventType);
                    Thread.sleep(50);
                    game = new ReactionTrainer(mouse);
                    game.initializeGame();
                    break;
                case AIM:
                    System.out.println("alo");
                    //mouse.removeEventListener(eventType);
                    Thread.sleep(50);
                    game = new AimTrainer(mouse);
                    game.initializeGame();
                    break;
            }
            mouse.resetPos();
            //mouseX=0;
            //mouseY=0;
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

    /*public void mouseInit(){
        mouse = new Mouse(this);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        /*mouseX = mouseEvent.getX(); //Ver explicação nas properties
        mouseY = mouseEvent.getY(); //Ver explicação nas properties
        System.out.println("X: " + mouseX + "Y: " + mouseY); //APAGAR!! Informa o X e o Y quando existe um click no mouse
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }*/
}
