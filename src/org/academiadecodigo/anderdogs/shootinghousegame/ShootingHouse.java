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

        background = new Picture(10,10,"resources/HomePageMenuPrincipal/GAME SELECTION 2.jpg");//Momento de instanciação do PrincipalMenu,recebe uma imagem e coordenadas tendo em atenção Padding do Simple Graphics
        background.draw(); //Desenha a primeira imagem de apresentação(definida no construtor)...
        //menuInitiation();

        while(true) {

            background.load("resources/HomePageMenuPrincipal/GAME SELECTION 2.jpg");

            while (true) {

                Thread.sleep(0);
                if (mouse.mouseX() >= 357 && mouse.mouseX() <= 571 && mouse.mouseY() >= 279 && mouse.mouseY() <= 325) {
                    gameChose = GamesOption.REACTION;
                    break;
                }

                if (mouse.mouseX() >= 737 && mouse.mouseX() <= 952 && mouse.mouseY() >= 279 && mouse.mouseY() <= 325) {
                    gameChose = GamesOption.AIM;
                    break;
                }

                if (mouse.mouseX() >= 1245 && mouse.mouseX() <= 1268 && mouse.mouseY() >= 60 && mouse.mouseY() <= 82) {
                    background.load("resources/Goodbye/HOME TITLE thanks.jpg");
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
                    game = new ReactionTrainer(mouse, background);
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
        background = new Picture(10,10,"resources/HomePageMenuPrincipal/HOME.jpg");//Momento de instanciação do PrincipalMenu,recebe uma imagem e coordenadas tendo em atenção Padding do Simple Graphics
        background.draw(); //Desenha a primeira imagem de apresentação(definida no construtor)...
        Thread.sleep(2000);
        background.load("resources/HomePageMenuPrincipal/HOME TITLE.jpg"); //Completa com o titulo de apresentação
        Thread.sleep(2000);
        background.load("resources/HomePageMenuPrincipal/TRANSITION GAME SELECTION.jpg");
        Thread.sleep(500);
        background.load("resources/HomePageMenuPrincipal/GAME SELECTION 1.jpg");
        Thread.sleep(500);
        background.load("resources/HomePageMenuPrincipal/GAME SELECTION 2.jpg");
        Thread.sleep(500);

    }

}

//FALTA IMPLEMENTAR TRANSITION GAME SELECTION - DEPOIS DO HOME TITLE
//FALTA IMPLEMENTAR GAME SELECTION 1 - DEPOIS DO TRANSITION GAME SELECTION E ANTES DO GAME SELECTION 2
