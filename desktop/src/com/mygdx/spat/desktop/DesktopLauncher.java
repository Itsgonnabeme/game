package com.mygdx.spat.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.spat.MyGdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "SpaceAttack";
		config.width = 640;
		config.height = 480;
		config.resizable = false;
		config.fullscreen = false;
		new LwjglApplication(new MyGdxGame(), config);
	}
}
