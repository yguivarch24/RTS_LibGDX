package com.mygdx.game.model;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** Classe représentant une plaine */

public class Plaine extends Environnement{

	/** Constructeur d'une plaine
	 * @param x abscisse de la plaine
	 * @param y ordonnée de la plaine
	 */
    public Plaine(int x, int y) {
        super(x, y, "Plaine");
    }

    /** Constructeur d'une plaine
     * @param x abscisse de la plaine
     * @param y ordonnée de la plaine
     * @param object LiveObject présent sur la plaine
     */
    public Plaine(int x, int y, LiveObject object) {
        super(x, y, "Plaine", object);
    }

}
