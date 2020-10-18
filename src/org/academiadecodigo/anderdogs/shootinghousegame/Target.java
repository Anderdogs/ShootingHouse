package org.academiadecodigo.anderdogs.shootinghousegame;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Target {

    private Picture target;
    private boolean isDestroyed;

    public Target(int a, int b, String picture){
        target = new Picture(a,b,picture);
    }

    public void drawTarget(){
        target.draw();
    }

    public int getX(){
        return target.getX();
    }

    public int getY(){
        return target.getY();
    }

    public int getWidth(){
        return (target.getX()+target.getWidth());
    }

    public int getHeight(){
        return (target.getY()+target.getHeight());
    }

    public void destroy(){
        isDestroyed=true;
        target.delete();
    }

    public boolean isDestroyed(){
        return isDestroyed;
    }
}
