package com.llaminator.ghostline;

public class Ghost {

    static boolean IsAlive;
    double x;
    double y;


    public Ghost(double x, double y) {
        this.x = x;
        this.y = y;
        IsAlive = true;
    }


    public double GetX(){
        return x;
    }

    public double GetY(){
        return y;
    }

    private void setDeath(){
        IsAlive = false;
    }

    public boolean IsAlive(){ // ask for next step with redrawing
        return IsAlive;
    }

    public void Death(){
        setDeath();
        //imageView.animate().translationYBy(100).alpha(0).setDuration(1000); what is it??(
        // smth for death
    }
}