package org.academiadecodigo.anderdogs.shootinghousegame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ShootingHouse {

    private Controls mouse;
    private Games game;
    private Picture background;
    private GamesOption gameChose;
    private Sound sound;

    public ShootingHouse(){
        mouse = new Controls();
        sound = new Sound("/resources/Sound/awp_clipin.wav");
    }

    public void start() throws InterruptedException {

        menuInitiation();

        while(true) {

            background.load("resources/HomePageMenuPrincipal/GAME SELECTION 2.jpg");

            while (true) {

                Thread.sleep(0);
                if (mouse.mouseX() >= 357 && mouse.mouseX() <= 571 && mouse.mouseY() >= 279 && mouse.mouseY() <= 325) {
                    sound.play(true);
                    gameChose = GamesOption.REACTION;
                    break;
                }

                if (mouse.mouseX() >= 737 && mouse.mouseX() <= 952 && mouse.mouseY() >= 279 && mouse.mouseY() <= 325) {
                    sound.play(true);
                    gameChose = GamesOption.AIM;
                    break;
                }

                if (mouse.mouseX() >= 1245 && mouse.mouseX() <= 1268 && mouse.mouseY() >= 60 && mouse.mouseY() <= 82) {
                    sound.play(true);
                    background.load("resources/Goodbye/HOME TITLE thanks.jpg");
                    return;
                }
                Thread.sleep(0);
            }

            mouse.resetPos();

            switch (gameChose) {
                case REACTION:
                    Thread.sleep(25);
                    game = new ReactionTrainer(mouse, background);
                    game.initializeGame();
                    break;
                case AIM:
                    Thread.sleep(25);
                    game = new AimTrainer(mouse, background);
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
        background.load("resources/HomePageMenuPrincipal/GAME SELECTION 2.jpg");
        Thread.sleep(200);
    }
}

