package org.academiadecodigo.anderdogs.shootinghousegame;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class Controls implements MouseHandler {

    private Mouse mouse;
    private double x; //Variável que irá guardar o X do rato
    private double y; //Variável que irá guardar o Y do rato
    private boolean click;

    public Controls(){
        mouse = new Mouse(this);
        mouse.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    public void addEventListener(){

    }


    public double mouseX(){
        return x;
    }

    public double mouseY(){
        return y;
    }

    public boolean getClick(){
        return click;
    }

    public void resetPos(){
        x=0;
        y=0;
    }

    public void setClick(boolean a){
        click=a;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        x=mouseEvent.getX();
        y=mouseEvent.getY();
        click=true;
        System.out.println("X: " + mouseEvent.getX() + " Y: " + mouseEvent.getY());
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
