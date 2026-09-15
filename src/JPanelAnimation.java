import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class JPanelAnimation extends JPanel implements ActionListener {
    private Frame cardLayoutPanel;
    private String nextCard;
    private ArrayList<BufferedImage> frames;
    private Timer timer;
    private int currentFrame;
    private int loopCount;
    private int maxLoops;
    private Runnable onComplete;

    public JPanelAnimation(Frame cardLayoutPanel, String nextCard , ArrayList<BufferedImage> frames, int delay, int maxLoops) {
        this.cardLayoutPanel = cardLayoutPanel;
        this.nextCard = nextCard;
        this.frames = frames;
        currentFrame = 0;
        loopCount = 0;
        this.maxLoops = maxLoops;
        timer = new Timer(delay, this);
        timer.start();
        setFocusable(false);
        setRequestFocusEnabled(false);
    }

    public void setOnComplete(Runnable onComplete) {
        this.onComplete = onComplete;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (frames.get(currentFrame) != null) {
            g.drawImage(frames.get(currentFrame), 0, 0, this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentFrame++;
        if (currentFrame >= frames.size()) {
            currentFrame = 0;
            loopCount++;

            if (loopCount >= maxLoops) {
                timer.stop();
                cardLayoutPanel.showCard(nextCard);
                if (onComplete != null) onComplete.run();
            }
        }
        repaint();
    }
}
