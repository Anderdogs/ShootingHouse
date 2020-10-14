package org.academiadecodigo.anderdogs.shootinghousegame;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class AudioPlayer {

        private AudioInputStream audioInputStream;
        private Clip clip;

        public void toto() {
                try {
                        audioInputStream = AudioSystem.getAudioInputStream(new File("resources/africa-toto.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                        // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
                        // If you want to stop the sound, then use clip.stop();
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
        }

        public void pewpew() {
                try {
                        audioInputStream = AudioSystem.getAudioInputStream(new File("resources/PewPew.wav"));
                        clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                        // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
                        // If you want to stop the sound, then use clip.stop();
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
        }

        public void stop(){
                clip.stop();
        }



}

