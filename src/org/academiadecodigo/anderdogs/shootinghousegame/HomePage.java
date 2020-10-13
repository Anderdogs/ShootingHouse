package org.academiadecodigo.anderdogs.shootinghousegame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class HomePage {

    //Properties
    private Picture homePagePicture;

    //Constructor
    public HomePage() throws InterruptedException {
        homePagePicture = new Picture(10,10,"resources/HOME.png");//Momento de instanciação do PrincipalMenu,recebe uma imagem e coordenadas tendo em atenção Padding do Simple Graphics
        homePagePicture.draw(); //Desenha a primeira imagem de apresentação(definida no construtor)...
        principalMenuInitiation();
    }

    //Methods
    public void principalMenuInitiation() throws InterruptedException{
        Thread.sleep(2500);
        homePagePicture.load("resources/HOME2.png"); //Completa com o titulo de apresentação
    }
}
