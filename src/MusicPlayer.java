import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {

    private static Clip clip;

    public static void playSound(File soundFile) {
        try {
            AudioInputStream originalAudio = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat baseFormat = originalAudio.getFormat();

            AudioFormat decodedFormat = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false
            );

            AudioInputStream decodedAudio = AudioSystem.getAudioInputStream(decodedFormat, originalAudio);

            clip = AudioSystem.getClip();
            clip.open(decodedAudio);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.err.println("Could not play audio file: " + soundFile.getAbsolutePath());
            e.printStackTrace();
        }
    }
}

