package org.academiadecodigo.anderdogs.shootinghousegame;


public class Main {
    public static void main(String[] args) throws InterruptedException {

        /*Games games;

        HomePage homePage = new HomePage();
        Thread.sleep(2000);
        PrincipalMenu principalMenu = new PrincipalMenu();
        games = principalMenu.chooseGame();
        games.initializeGame();*/


        /*AudioPlayer music = new AudioPlayer();
        music.suspanse();
         */

        ShootingHouse game = new ShootingHouse();
        game.start();

        //music.stop();

    }
}
