package com.mygdx.game.model;

public class Buisson extends EnvironnementCollectable {
	public Buisson(int x, int y) {
		super(x,y,"Buisson", new Nourriture(10000000));
	}
}
