package com.llaminator.ghostline;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Polygon;


import java.util.Arrays;
import java.util.Random;



public class Route {
    //Random randomGenerator = new Random();
    final static int Size = 100;
    RouteStep Level [] = new RouteStep[Size];

    public Route() {
        InitLevel();
    }

    public RouteStep[] getLevel() {
        return Level;
    }

    public void setLevel(RouteStep[] level) {
        Level = level;
    }

    @Override
    public String toString() {
        return "Route{" +
                "Size=" + Size +
                ", Level=" + Arrays.toString(Level) +
                '}';
    }

    public void InitLevel() {
        Random randomGenerator = new Random();

       //Level[0] = new RouteStep(new Texture(Gdx.files.internal("routeImg.png")), 1);
        for(int i = 0; i < Size; i++) {
            Texture p = new Texture(Gdx.files.internal("routeImg.png"));
            int a = randomGenerator.nextInt(2);
            Level[i] = new RouteStep(p, a);
        }

    }

    public void ExpandLevel() {
        Random randomGenerator = new Random();
        for (int i = 0; i < Size - 1; i++)
            Level[i] = Level[i+1];
        Level[Size - 1] = new RouteStep((new Texture("routeImg.png")), randomGenerator.nextInt(2));
    }


}
