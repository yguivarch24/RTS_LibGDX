package com.mygdx.game.vue;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class MyGdxGameRTSLauncher extends Game {

	protected float musicVolume;
	protected MainMenuScreen mainMenuScreen;
	protected Map1 map1;
	protected MapOption mapOption;
	protected Music mp3Music;

	@Override
	public void create() {
		musicVolume = 0.5f;
	    mp3Music = Gdx.audio.newMusic(Gdx.files.internal("GloriousMorning.mp3"));
		mainMenuScreen = new MainMenuScreen(this);
		mapOption = new MapOption(this);
		map1 = new Map1(this);
		setScreen(mainMenuScreen);
	}

	@Override
	public void dispose() {
		Gdx.app.exit();
	}
}
