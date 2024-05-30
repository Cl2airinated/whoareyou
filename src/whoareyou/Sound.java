package whoareyou;

import javax.swing.*;
import javax.sound.sampled.*;
import java.io.*;

public class Sound
{
	
	private Clip clip;
	
	public void playmusic(String musicfile) {
		File soundFile = new File(musicfile);
		try {
			if(musicfile.equals("stop")){
				clip.stop();
			}
			else {
				clip = AudioSystem.getClip();

			AudioInputStream inputStream= AudioSystem.getAudioInputStream(soundFile);
			clip.open(inputStream);
			//clip.loop(clip.LOOP_CONTINUOUSLY);
			clip.start();
		}}
	catch(Exception e)
		{
		System.out.println(e);
		}
	}
}