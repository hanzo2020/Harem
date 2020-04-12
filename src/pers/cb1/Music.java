package pers.cb1;

import java.applet.Applet;
import java.applet.AudioClip;

import java.io.File;
import java.net.MalformedURLException;

public class Music {
	File soundFile = new File("sounds/12.wav");
	AudioClip sound;
	public Music(){
		super();
	}
	/*
	 * 播放音乐
	 */
	public void playSound(){
		try {
			sound = Applet.newAudioClip(soundFile.toURL());
			sound.play();
			//sound.stop();
			System.out.println("播放成功");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void stopSound(){
		sound.stop();
		System.out.println("关闭");
	}
}
