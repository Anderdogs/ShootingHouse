package org.academiadecodigo.anderdogs.shootinghousegame.notUsed;

import org.academiadecodigo.anderdogs.shootinghousegame.AimTrainer;
import org.academiadecodigo.anderdogs.shootinghousegame.Games;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class PrincipalMenu implements KeyboardHandler, MouseHandler {

    //Properties
    private Picture homePage1; //Variável que guarda a imagem que aparece desde a primeira até ao incio do Menu
    private Mouse mouse; //Variável que guardará o input de rato
    private double mouseX;//Variável que irá guardar o X do rato
    private double mouseY;//Variável que irá guardar o Y do rato
    private boolean mouseClick;//Variável que irá guardar se o click no rato existiu ou não
    private String gameOption;//Variável que irá guardar o case referente a cada jogo para mais tarde invocar o método desse jogo através de um switch
    private Games games;


    //Constructor - default
    public PrincipalMenu() throws InterruptedException {
        homePage1 = new Picture(10,10,"resources/GAME_SELECTION_1.png");//Momento de instanciação do PrincipalMenu,recebe uma imagem e coordenadas tendo em atenção Padding do Simple Graphics
        homePage1.draw(); //Desenha a primeira imagem de apresentação(definida no construtor)...
        principalMenuInitiation();
    }

    //Methods
    public void principalMenuInitiation() throws InterruptedException{
        Thread.sleep(500);
        homePage1.load("resources/GAME_SELECTION_2.png");//Completa com os jogos
        initMouse();
    }

    public Games chooseGame() throws InterruptedException{
        initMouse();
        while(!isMouseClick()){
            Thread.sleep(10); //Só para o compilador esperar quando existe um click no rato
        }
        switch (getGameOption()){ //Mediante o case, instancia um novo jogo
            case "ReactionTrainer":
                //games = new ReactionTrainer();
                break;
            case "AimTrainer":
                games = new AimTrainer();
                break;
            /*case "UnderDevelopment":
                games = new UnderDevelopment();
                break;
               //EM COMENTÁRIO PARA NÃO DEVOLVER ESTE VALOR QUE NÃO FAZ NADA (DEPOIS FICAMOS SEM PODER CLICAR)
             */
        }
        return games;
    }

    public void initMouse(){
       mouse = new Mouse(this);//Momento de instanciação DESTE mouse (o que está a ser utilizado pelo utilizador)
       mouse.addEventListener(MouseEventType.MOUSE_CLICKED);//Momento em que damos atenção a um evento do mouse (Mouse_Clicked)
    }

    public boolean isMouseClick() {
        return mouseClick;
    }
    public String getGameOption(){
        return gameOption;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        mouseX = mouseEvent.getX();//Ver explicação nas properties
        mouseY = mouseEvent.getY();//Ver explicação nas properties
        System.out.println("X: " + mouseX + "Y: " + mouseY);//APAGAR!! Informa o X e o Y quando existe um click no mouse
        if(mouseX >= 242 && mouseX <= 561 && mouseY >= 440 && mouseY <= 514){
            mouseClick = true;//Ver explicação nas properties
            gameOption = "ReactionTrainer";//Ver explicação nas properties (ver método chooseGame)
        }
        if(mouseX >= 812 && mouseX <= 1134 && mouseY >= 440 && mouseY <= 514){
            mouseClick = true;//Ver explicação nas properties
            gameOption = "AimTrainer";//Ver explicação nas properties (ver método chooseGame)
        }
        /*if(mouseX >= 1382 && mouseX <= 1705 && mouseY >= 440 && mouseY <= 514){
            mouseClick = true;//Ver explicação nas properties
            gameOption = "UnderDevelopment";//Ver explicação nas properties (ver método chooseGame) - NOTA: Nome do jogo

        } //EM COMENTÁRIO PARA NÃO DEVOLVER ESTE VALOR QUE NÃO FAZ NADA (DEPOIS FICAMOS SEM PODER CLICAR)

         */
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
