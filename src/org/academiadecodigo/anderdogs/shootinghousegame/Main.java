package org.academiadecodigo.anderdogs.shootinghousegame;

import org.academiadecodigo.simplegraphics.mouse.Mouse;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Games games;

        HomePage homePage = new HomePage();
        Thread.sleep(3000);
        PrincipalMenu principalMenu = new PrincipalMenu();
        games = principalMenu.chooseGame();
        games.initializeGame();

    }
}
