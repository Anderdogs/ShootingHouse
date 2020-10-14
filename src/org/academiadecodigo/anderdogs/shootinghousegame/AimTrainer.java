package org.academiadecodigo.anderdogs.shootinghousegame;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class AimTrainer extends Games implements MouseHandler {

    private Mouse mouse;
    private double mouseX; //Variável que irá guardar o X do rato
    private double mouseY; //Variável que irá guardar o Y do rato


    /*
    //Properties
    private Picture aimTrainerPicture;
    private double mouseX; //Variável que irá guardar o X do rato
    private double mouseY; //Variável que irá guardar o Y do rato
    private Mouse mouse;

    //Constructor
    public AimTrainer(){
        aimTrainerPicture = new Picture(10,10,"resources/TRANSITION_GAME_SELECTION.png");
        aimTrainerPicture.draw();
    }

    //Methods

    @Override //Da super class Games
    public void initializeGame() throws InterruptedException {
        aimTrainerPicture.load("resources/Game_reaction_trainer_vazio.png");
        Thread.sleep(1000);
        aimTrainerPicture.load("resources/Game_Aim_trainer_rules.png");
        initMouse();
    }*/

    public void initMouse(){
        mouse = new Mouse(this); //Momento de instanciação DESTE mouse (o que está a ser utilizado pelo utilizador)
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED); //Momento em que damos atenção a um evento do mouse (Mouse_Clicked)
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("X: " + mouseX + "Y: " + mouseY);//APAGAR!! Informa o X e o Y quando existe um click no mouse
        mouseX = mouseEvent.getX();//Ver explicação nas properties
        mouseY = mouseEvent.getY();//Ver explicação nas properties
    }

}
