package com.mygdx.game.vue.vue_liveobject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.mygdx.game.model.LiveObject;
import com.mygdx.game.vue.vue_carte.TiledMapClickListener;

public class LiveObjectActor extends Actor {

    LiveObject liveObject;

    Sprite sprite;

    public LiveObjectActor(LiveObject liveObject) {
        this.liveObject = liveObject;
        sprite = new Sprite(new Texture(Gdx.files.internal("Tiles/character.png")));
        EventListener eventListener = new LiveObjectClickListener(this);
        addListener(eventListener);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        setBounds(liveObject.getX()*sprite.getHeight(), liveObject.getY()*sprite.getHeight(), sprite.getWidth(), sprite.getHeight());
        batch.draw(sprite, liveObject.getX()*sprite.getWidth(), liveObject.getY()*sprite.getHeight());
    }
}
