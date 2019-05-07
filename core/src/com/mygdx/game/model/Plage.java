package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Plage extends Environnement{

    public Plage(int x, int y) {
        super(x, y, "Plage");
        object = null;
    }

    public Plage(int x, int y, LiveObject object) {
        super(x, y, "Plage", object);
    }

    @Override
    public boolean action() {
        return true;
    }
}
