package org.academiadecodigo.anderdogs.shootinghousegame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ShootingHouse {

    private Controls mouse;
    private Games game;
    private Picture background;
    private GamesOption gameChose;

    public ShootingHouse(){
        mouse = new Controls();
    }

    public void start() throws InterruptedException {

        menuInitiation();

        while(true) {

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
                    return;
                }
                Thread.sleep(0);
            }

            mouse.resetPos();

            switch (gameChose) {
                case REACTION:
                    System.out.println("ola");
                    Thread.sleep(50);
                    game = new ReactionTrainer(mouse);
                    game.initializeGame();
                    break;
                case AIM:
                    System.out.println("alo");
                    Thread.sleep(50);
                    game = new AimTrainer(mouse);
                    game.initializeGame();
                    break;
            }
            mouse.resetPos();
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

}
