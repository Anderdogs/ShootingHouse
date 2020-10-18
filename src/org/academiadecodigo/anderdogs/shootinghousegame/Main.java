package org.academiadecodigo.anderdogs.shootinghousegame;


public class Main {
    private static Sound sound= new Sound("/resources/Sound/teste1.wav");


    public static void main(String[] args) throws InterruptedException {
        //Sound Start
        sound.play(true);
        sound.loopIndef();
        //Game Start
        ShootingHouse game = new ShootingHouse();
        game.start();
        //Sound Stop
        sound.stop();

    }
}
