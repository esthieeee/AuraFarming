import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Sponsors {
    private ArrayList<BufferedImage> sponsors;
    private ArrayList<BufferedImage> currentSponsors;
    private ArrayList<Integer> usedSponsors;

    public Sponsors() {
        sponsors = new ArrayList<>();
        currentSponsors = new ArrayList<>();
        usedSponsors = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            try {
                String name = "src/MailImages/sponsors/" + i + ".png";
                BufferedImage image = ImageIO.read(new File(name));
                assert false;
                sponsors.add(image);
            }
            catch (IOException e){
                System.out.println(e.getMessage());
            }

        }
    }

    public ArrayList<BufferedImage> getRandomSponsors() {
        currentSponsors = new ArrayList<>();
        usedSponsors = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            int randint = (int) (Math.random() * 12) + 1;
            if (!used(randint)) {
                currentSponsors.add(sponsors.get(randint - 1));
                usedSponsors.add(randint);
            }
            else {
                i--;
            }
        }
        return currentSponsors;

    }

    public boolean used(int ind) {
        for (int i = 0; i < usedSponsors.size(); i++) {
            if (usedSponsors.get(i) == ind) {
                return true;
            }
        }
        return false;
    }


    public ArrayList<BufferedImage> getSponsors() {
        return sponsors;
    }

    public ArrayList<Integer> getUsedSponsors() {
        return usedSponsors;
    }
}
