package com.llaminator.ghostline;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Random;


public class Route {
    //Random randomGenerator = new Random();
    final static int Dirs = 2;
    ArrayList<RouteStep> Level = new ArrayList<RouteStep>();

    public Route() {
        InitLevel();
    }



    public void InitLevel() {
        Random randomGenerator = new Random();

       //Level[0] = new RouteStep(new Texture(Gdx.files.internal("routeImg.png")), 1);
        for(int i = 0; i < 100; i++) {
            Level.add(i, new RouteStep(new Texture(Gdx.files.internal("routeImg.png")), randomGenerator.nextInt(Dirs)));
        }

    }

    public void ExpandLevel() {
        Random randomGenerator = new Random();
        Level.add(new RouteStep(new Texture(Gdx.files.internal("routeImg.png")), randomGenerator.nextInt(Dirs)));
    }

}
