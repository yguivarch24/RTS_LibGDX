package com.mygdx.game.vue.vue_liveobject;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class LiveObjectClickListener extends ClickListener {

    private LiveObjectActor actor;

    public LiveObjectClickListener(LiveObjectActor actor) {
        this.actor = actor;
    }

    @Override
    public void clicked(InputEvent event, float x, float y) {
        System.out.println(actor.liveObject + " has been clicked.");
        if (actor != null)
        {

        }
    }
}
