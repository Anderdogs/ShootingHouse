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
                        audioInputStream = AudioSystem.getAudioInputStream(new File("resources/Sound/africa-toto.wav").getAbsoluteFile());
                        clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                        // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
                        // If you want to stop the sound, then use clip.stop();
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
        }

        public void suspanse() {
                try {
                        audioInputStream = AudioSystem.getAudioInputStream(new File("resources/Sound/teste.wav").getAbsoluteFile());
                        clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                        // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
                        // If you want to stop the sound, then use clip.stop();
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
        }

        public void pewpew() {
                try {
                        audioInputStream = AudioSystem.getAudioInputStream(new File("resources/Sound/PewPew.wav").getAbsoluteFile());
                        clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                        // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
                        // If you want to stop the sound, then use clip.stop();
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
        }

        public void awp() {
                try {

                        audioInputStream = AudioSystem.getAudioInputStream(new File("resources/Sound/awp1.wav").getAbsoluteFile());
                        clip = AudioSystem.getClip();
                        clip.open(audioInputStream);
                        clip.start();
                        // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
                        // If you want to stop the sound, then use clip.stop();
                } catch (Exception ex) {
                        ex.printStackTrace();
                }
        }
        public void awpClipin() {
                try {

                        audioInputStream = AudioSystem.getAudioInputStream(new File("resources/Sound/awp_clipin.wav").getAbsoluteFile());
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

