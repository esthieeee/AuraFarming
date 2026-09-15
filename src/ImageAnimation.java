import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ImageAnimation implements ActionListener {
    private ArrayList<BufferedImage> frames;
    private Timer timer;
    private int currentFrame;
    private JPanel animationPanel;

    public ImageAnimation(ArrayList<BufferedImage> frames, int delay,int x, int y) {
        this.frames = frames;
        currentFrame = 0;

        animationPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                BufferedImage frame = getActiveFrame();
                if (frame != null) {
                    g.drawImage(frame, 0, 0, getWidth(), getHeight(), null);
                }
            }
        };
        animationPanel.setOpaque(false);
        animationPanel.setBounds(x, y, 300, 300);

        timer = new Timer(delay, this);
        timer.start();
    }

    public BufferedImage getActiveFrame() {
        return frames.get(currentFrame);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        currentFrame = (currentFrame + 1) % frames.size();
        animationPanel.repaint();
    }

    public void updateFrames(ArrayList<BufferedImage> newFrames) {
        this.frames = newFrames;
        currentFrame = 0;
        animationPanel.repaint();
    }

    public JPanel getAnimationPanel() {
        return animationPanel;
    }

    public void updateLocation(int x, int y) {
        animationPanel.setBounds(x, y, animationPanel.getWidth(), animationPanel.getHeight());
    }

}


