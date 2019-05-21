package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Plaine extends Environnement{

    public Plaine(int x, int y) {
        super(x, y, "Plaine");
    }

        
    public Plaine(int x, int y, LiveObject object) {
        super(x, y, "Plaine", object);
    }

}
