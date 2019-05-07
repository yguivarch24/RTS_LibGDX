package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Mer extends Environnement{

    public Mer(int x, int y) {
        super(x, y, "Mer");
        object = null;
    }

    public Mer(int x, int y, LiveObject object) {
        super(x, y, "Mer", object);
    }

    @Override
    public boolean action() {
        return true;
    }
}
