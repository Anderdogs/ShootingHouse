package org.academiadecodigo.anderdogs.shootinghousegame;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ReactionTrainer extends Games implements MouseHandler {

    //Properties
    private Picture reactionTrainerPicture;
    private double mouseX;//Variável que irá guardar o X do rato
    private double mouseY;//Variável que irá guardar o Y do rato
    private Mouse mouse;
    private PrincipalMenu principalMenu;

    //Constructor
    public ReactionTrainer(){
        reactionTrainerPicture = new Picture(10,10,"resources/TRANSITION_GAME_SELECTION.png");
        reactionTrainerPicture.draw();
    }

    //Methods
    @Override //Da super class Games
    public void initializeGame() throws InterruptedException {
        reactionTrainerPicture.load("resources/Game_reaction_trainer_vazio.png");
        Thread.sleep(1000);
        reactionTrainerPicture.load("resources/Game_reaction_trainer.png");
        initMouse();
    }


    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    public void initMouse(){
        mouse = new Mouse(this);//Momento de instanciação DESTE mouse (o que está a ser utilizado pelo utilizador)
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);//Momento em que damos atenção a um evento do mouse (Mouse_Clicked)
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();//Ver explicação nas properties
        mouseY = mouseEvent.getY();//Ver explicação nas properties
        System.out.println("X: " + mouseX + "Y: " + mouseY);//APAGAR!! Informa o X e o Y quando existe um click no mouse
        if(mouseX >= 43 && mouseX <= 75 && mouseY >= 113 && mouseY <= 145) {
            try {
                principalMenu = new PrincipalMenu();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
