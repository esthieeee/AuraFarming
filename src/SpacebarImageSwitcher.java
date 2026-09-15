import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SpacebarImageSwitcher extends JPanel {
    private ImageIcon[] images;
    private int currentIndex;
    private int spacePressCount;
    private DialogueChangeListener dialogueChangeListener;
    private boolean isSwitcherActive;

    public interface DialogueChangeListener {
        void onSpacePressed(int pressCount);
    }

    public SpacebarImageSwitcher(ArrayList<BufferedImage> imagePaths) {
        this.setFocusable(true);
        this.setLayout(null);
        setOpaque(false);

        images = new ImageIcon[imagePaths.size()];
        for (int i = 0; i < imagePaths.size(); i++) {
            images[i] = new ImageIcon(imagePaths.get(i));
        }

        currentIndex = 0;
        spacePressCount = 0;
        isSwitcherActive = true;
        setupKeyBinding();
    }

    private void setupKeyBinding() {
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0), "nextImage");

        actionMap.put("nextImage", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("[DEBUG] Space pressed. isSwitcherActive = " + isSwitcherActive);
                if (!isSwitcherActive) {
                    System.out.println("[DEBUG] Space ignored because switcher is disabled.");
                    return;
                }

                currentIndex = (currentIndex + 1) % images.length;
                repaint();

                spacePressCount++;

                if (dialogueChangeListener != null) {
                    dialogueChangeListener.onSpacePressed(spacePressCount);
                }
            }
        });
    }

    public void setDialogueChangeListener(DialogueChangeListener listener) {
        this.dialogueChangeListener = listener;
    }

    public void setSwitcherActive(boolean active) {
        this.isSwitcherActive = active;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (images[currentIndex] != null) {
            Image img = images[currentIndex].getImage();
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }
}


