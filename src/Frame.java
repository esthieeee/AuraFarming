import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class Frame extends JFrame implements ActionListener {
    private JPanel mainPanel, livestreamScreen, mail2, loginInScreen, auraInfo,
            ticTacToe, gamesScreen, appScreen, roundScreen, shopScreen, shop, endDay,
            rpsWinPage, rpsLoseScreen, editAppScreen;
    private JScrollPane scrollPane;
    private ButtonClass buttonClass;
    private CardLayout cardLayout;
    private JPanelAnimation mailPanel;
    private Sponsors sponsors;
    private SpacebarImageSwitcher switcher;
    private SpacebarImageSwitcher switcher2;
    private Player player;

    public Frame() throws IOException {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        player = new Player();
        buttonClass = new ButtonClass(this,player,mainPanel);
        sponsors = new Sponsors();
        scrollPane = buttonClass.getScrollPane();

        JPanel startScreen = PanelClass.createPanel("src/images/enteruser.png", buttonClass, this);
        JPanel tutorialScreen = PanelClass.createPanel("src/images/tutorial.jpeg", buttonClass, this);
        JPanel backgroundScreen = PanelClass.createPanel("src/images/background.png", buttonClass, this);
        loginInScreen = PanelClass.createPanel("src/images/loginInScreen.png", buttonClass, this);
        appScreen = PanelClass.createPanel("src/images/appScreen.png", buttonClass, this);
        editAppScreen = PanelClass.createPanel("src/images/EditAppScreen.png",buttonClass, this);
        livestreamScreen = PanelClass.createPanel("src/images/livestreambg.png", buttonClass, this);
        JPanel mailScreen = PanelClass.createPanel("src/MailImages/mailhomepage.png", buttonClass, this);
        auraInfo = PanelClass.createPanel("src/images/auraInfo.png", buttonClass, this);
        JPanel gamesScreen = PanelClass.createPanel("src/images/GamesScreen.png", buttonClass, this);
        ticTacToe = PanelClass.createPanel("src/images/TicTacToe.png", buttonClass, this);
        JPanel rpsScreen = PanelClass.createPanel("src/images/RockPaperScissorsGame/startScreen.png", buttonClass, this);
        roundScreen = PanelClass.createPanel("src/images/RockPaperScissorsGame/roundScreen.png", buttonClass, this);
        shopScreen = PanelClass.createPanel("src/shopimages/shop.png", buttonClass, this);
        shop = PanelClass.createPanel("src/shopimages/shop2.png", buttonClass, this);
        JPanel rockTie = PanelClass.createPanel("src/images/RockPaperScissorsGame/RockTie.png", buttonClass, this);
        JPanel rockWin = PanelClass.createPanel("src/images/RockPaperScissorsGame/RockWin.png", buttonClass, this);
        JPanel rockLose = PanelClass.createPanel("src/images/RockPaperScissorsGame/RockLose.png", buttonClass, this);
        endDay = PanelClass.createPanel("src/images/endDayPage.png", buttonClass, this);
        JPanel paperTie = PanelClass.createPanel("src/images/RockPaperScissorsGame/Paper/PaperTie.png", buttonClass, this);
        JPanel paperWin = PanelClass.createPanel("src/images/RockPaperScissorsGame/Paper/PaperWin.png", buttonClass, this);
        JPanel paperLose = PanelClass.createPanel("src/images/RockPaperScissorsGame/Paper/PaperLose.png", buttonClass, this);
        JPanel scissorsTie = PanelClass.createPanel("src/images/RockPaperScissorsGame/Scissors/ScissorsTie.png", buttonClass, this);
        JPanel scissorsWin = PanelClass.createPanel("src/images/RockPaperScissorsGame/Scissors/ScissorsWin.png", buttonClass, this);
        JPanel scissorsLose = PanelClass.createPanel("src/images/RockPaperScissorsGame/Scissors/ScissorsLose.png", buttonClass, this);
        rpsWinPage = PanelClass.createPanel("src/images/RockPaperScissorsGame/WinPage.png", buttonClass, this);
        JPanel areyousure = PanelClass.createPanel("src/shopimages/areyousure.png", buttonClass, this);
        JPanel success = PanelClass.createPanel("src/shopimages/success.png", buttonClass, this);
        JPanel notenough = PanelClass.createPanel("src/shopimages/notenough.png", buttonClass, this);
        JPanel victoryScreen = PanelClass.createPanel("src/images/VictoryScreen.png", buttonClass, this);
        JPanel losingScreen = PanelClass.createPanel("src/images/LosingScreen.png", buttonClass, this);
        JPanel rpsLosePage = PanelClass.createPanel("src/images/RockPaperScissorsGame/LoseScreen.png", buttonClass, this);
        rpsLoseScreen = PanelClass.createPanel("src/images/RockPaperScissorsGame/LosePage.png", buttonClass, this);

        ImageIcon tutorialImageIcon = new ImageIcon("src/DesktopPetImages/book.png");
        JLabel tutorialLabel = new JLabel(tutorialImageIcon);
        tutorialLabel.setBounds(0, 0, tutorialImageIcon.getIconWidth(), tutorialImageIcon.getIconHeight());
        tutorialScreen.add(tutorialLabel);

        ImageIcon tutorialSkipImageIcon = new ImageIcon("src/images/skip.png");
        JLabel tutorialSkipLabel = new JLabel(tutorialSkipImageIcon);
        tutorialSkipLabel.setBounds(0, 0, tutorialSkipImageIcon.getIconWidth(), tutorialSkipImageIcon.getIconHeight());
        tutorialScreen.add(tutorialSkipLabel);

        ArrayList<BufferedImage> startingImages = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            String fileName = "src/images/starting" + i + ".png";
            try {
                startingImages.add(ImageIO.read(new File(fileName)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        ArrayList<BufferedImage> animationFrames = new ArrayList<>();
        ArrayList<BufferedImage> animationFrames2 = new ArrayList<>();
        ArrayList<BufferedImage> animationFrames3 = new ArrayList<>();
        BufferedImage img = ImageIO.read(new File("src/DesktopPetImages/Ivan1/ivan11.png"));
        animationFrames3.add(img);
        ArrayList<BufferedImage> animationFrames4 = new ArrayList<>();


        initailizeIvanImages(animationFrames,0,7,"Ivan1");
        initailizeIvanImages(animationFrames2,7,11,"Ivan1");
        initailizeIvanImages(animationFrames4,12,14,"Ivan1");

        JPanelAnimation startPanel = new JPanelAnimation(this, "StartScreen" ,startingImages, 300, 3);
        mainPanel.add(startPanel, "AnimatedStartScreen");
        showCard("AnimatedStartScreen");

        ImageAnimation animation = new ImageAnimation(animationFrames, 300, 100, 200);
        tutorialScreen.add(animation.getAnimationPanel());

        ArrayList<BufferedImage> animationFrames5 = new ArrayList<>();
        initailizeIvanImages(animationFrames5,15,22,"Ivan2");

        ArrayList<BufferedImage> animationFrames6 = new ArrayList<>();
        BufferedImage img2 = ImageIO.read(new File("src/DesktopPetImages/Ivan1/ivan14.png"));
        animationFrames6.add(img2);

        ImageAnimation animation2 = new ImageAnimation(animationFrames5, 300,175,125);
        backgroundScreen.add(animation2.getAnimationPanel());

        ArrayList<BufferedImage> speechImages = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            String fileName = "src/DesktopPetImages/Speech/speech" + i + ".png";
            try {
                speechImages.add(ImageIO.read(new File(fileName)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        ArrayList<BufferedImage> speechImages2 = new ArrayList<>();
        for (int i = 8; i < 12; i++) {
            String fileName = "src/DesktopPetImages/Speech2/speech" + i + ".png";
            try {
                speechImages2.add(ImageIO.read(new File(fileName)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

        switcher = new SpacebarImageSwitcher(speechImages);
        switcher.setBounds(360, 200, 200, 100);
        tutorialScreen.add(switcher);

        switcher.setDialogueChangeListener(pressCount -> {

            if (pressCount == 1) {
                animation.updateFrames(animationFrames2);
            }

            if (pressCount == 4) {
                switcher.setSwitcherActive(false);
            }

            if (pressCount >= 5) {
                if (pressCount == 5) {
                    animation.updateFrames(animationFrames3);
                }
                if (pressCount > 5) {
                    animation.updateFrames(animationFrames4);
                    if (pressCount > 7) {
                        showCard("Background");
                    }
                }
            }
        });

        switcher2 = new SpacebarImageSwitcher(speechImages2);
        switcher2.setBounds(450, 175, 200, 100);
        backgroundScreen.add(switcher2);

        ArrayList<BufferedImage> arrowAnimation = new ArrayList<>();
        try {
            BufferedImage img3 = ImageIO.read(new File("src/DesktopPetImages/arrow0.png"));
            BufferedImage img4 = ImageIO.read(new File("src/DesktopPetImages/arrow1.png"));
            arrowAnimation.add(img3);
            arrowAnimation.add(img4);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final boolean[] arrowAdded = {false};

        switcher2.setDialogueChangeListener(pressCount -> {

            if (pressCount == 3 && !arrowAdded[0]) {
                arrowAdded[0] = true;

                ImageAnimation arrowAnim = new ImageAnimation(arrowAnimation, 500, 495, 250);
                arrowAnim.getAnimationPanel().setOpaque(false);
                backgroundScreen.setLayout(null);
                backgroundScreen.add(arrowAnim.getAnimationPanel());
                backgroundScreen.revalidate();
                backgroundScreen.repaint();

                animation2.updateLocation(450, 265);
                animation2.updateFrames(animationFrames6);
                switcher2.setBounds(700, 275, 200, 100);
                switcher2.setSwitcherActive(false);
            }
        });

        buttonClass.getBookBtn().addActionListener(e -> {
            switcher.setSwitcherActive(true);  // or switcher.setEnabled(true); if you didn't rename
            System.out.println("Book button clicked. Dialogue resumed.");
        });

        startScreen.setLayout(null);
        tutorialScreen.setLayout(null);
        backgroundScreen.setLayout(null);
        loginInScreen.setLayout(null);
        appScreen.setLayout(null);
        editAppScreen.setLayout(null);
        livestreamScreen.setLayout(null);
        mailScreen.setLayout(null);
        auraInfo.setLayout(null);
        gamesScreen.setLayout(null);
        rpsScreen.setLayout(null);
        ticTacToe.setLayout(null);
        roundScreen.setLayout(null);
        appScreen.setLayout(null);
        rockTie.setLayout(null);
        rockLose.setLayout(null);
        rockWin.setLayout(null);
        paperTie.setLayout(null);
        paperLose.setLayout(null);
        paperWin.setLayout(null);
        scissorsTie.setLayout(null);
        scissorsLose.setLayout(null);
        scissorsWin.setLayout(null);
        endDay.setLayout(null);
        rpsWinPage.setLayout(null);
        areyousure.setLayout(null);
        success.setLayout(null);
        notenough.setLayout(null);
        rpsLosePage.setLayout(null);
        rpsLoseScreen.setLayout(null);

        startScreen.add(buttonClass.getUsernameText());
        tutorialScreen.add(buttonClass.getNextButton());
        tutorialScreen.add(buttonClass.getBookBtn());
        backgroundScreen.add(buttonClass.getPowerOn());
        loginInScreen.add(buttonClass.getPasswordText());
        appScreen.add(buttonClass.getLivestreamApp());
        appScreen.add(buttonClass.getMailApp());
        appScreen.add(buttonClass.getEditApp());
        appScreen.add(buttonClass.getGamesApp());
        appScreen.add(buttonClass.getShopApp());
        appScreen.add(buttonClass.getEndDay());
        editAppScreen.add(buttonClass.getBackBtnEdit());
        editAppScreen.add(buttonClass.getMiniGameBtn());
        gamesScreen.add(buttonClass.getTicTacToeApp());
        livestreamScreen.add(buttonClass.getBackBtnLS());
//        livestreamScreen.add(buttonClass.getScrollPane(), BorderLayout.CENTER);
        gamesScreen.add(buttonClass.getRpsGame());
        ticTacToe.add(buttonClass.getBackBtnTTT());
        ticTacToe.add(buttonClass.getTic1());
        ticTacToe.add(buttonClass.getTic2());
        ticTacToe.add(buttonClass.getTic3());
        ticTacToe.add(buttonClass.getTic4());
        ticTacToe.add(buttonClass.getTic5());
        ticTacToe.add(buttonClass.getTic6());
        ticTacToe.add(buttonClass.getTic7());
        ticTacToe.add(buttonClass.getTic8());
        ticTacToe.add(buttonClass.getTic9());
        ticTacToe.add(buttonClass.getCheckWinner());
        rpsScreen.add(buttonClass.getBackBtnRPS());
        rpsScreen.add(buttonClass.getSingleBtn());
        rpsScreen.add(buttonClass.getDoubleBtn());
        shopScreen.add(buttonClass.getShop());
        mailScreen.add(buttonClass.getNext());
        auraInfo.add(buttonClass.getNext());
        rpsWinPage.add(buttonClass.getReturnBtn());
        rpsLoseScreen.add(buttonClass.getReturnBtn());
        areyousure.add(buttonClass.getYes());
        areyousure.add(buttonClass.getNo());
        mailScreen.add(buttonClass.getMailback());

        mainPanel.add(startScreen, "StartScreen");
        mainPanel.add(tutorialScreen, "TutorialScreen");
        mainPanel.add(backgroundScreen, "Background");
        mainPanel.add(loginInScreen,"LoginInScreen");
        mainPanel.add(editAppScreen,"EditAppScreen");
        mainPanel.add(livestreamScreen, "LivestreamScreen");
        mainPanel.add(mailScreen, "MailScreen");
        mainPanel.add(appScreen, "AppScreen");
        mainPanel.add(auraInfo, "auraInfo");
        mainPanel.add(gamesScreen, "GamesScreen");
        mainPanel.add(ticTacToe, "TicTacToe");
        mainPanel.add(rpsScreen,"RockPaperScissors");
        mainPanel.add(roundScreen,"RoundScreen");
        buttonClass.setupRoundScreenKeyListener(roundScreen);
        mainPanel.add(shopScreen, "shopScreen");
        mainPanel.add(rockTie,"RockTie");
        mainPanel.add(rockWin,"RockWin");
        mainPanel.add(rockLose,"RockLose");
        mainPanel.add(paperTie,"PaperTie");
        mainPanel.add(paperWin,"PaperWin");
        mainPanel.add(paperLose,"PaperLose");
        mainPanel.add(scissorsTie,"ScissorsTie");
        mainPanel.add(scissorsWin,"ScissorsWin");
        mainPanel.add(scissorsLose,"ScissorsLose");
        mainPanel.add(shop, "shop");
        mainPanel.add(endDay, "EndDayScreen");
        mainPanel.add(rpsWinPage,"RPSWinPage");
        mainPanel.add(rpsLosePage,"RPSLoseScreen");
        mainPanel.add(rpsLoseScreen,"RPSLosePage");
        mainPanel.add(areyousure, "areyousure");
        mainPanel.add(success, "success");
        mainPanel.add(notenough, "notenough");
        mainPanel.add(victoryScreen, "VictoryScreen");
        mainPanel.add(losingScreen, "LosingScreen");

//        livestreamScreen.add(scrollPane);

        ArrayList<BufferedImage> currentSponsor = sponsors.getRandomSponsors();
        ArrayList<Integer> usedSponsor = sponsors.getUsedSponsors();
        int y = 138;
        for (int i = 0; i < currentSponsor.size(); i++) {
            BufferedImage image = currentSponsor.get(i);
            ImageIcon icon = new ImageIcon(image);
            JButton button = new JButton();
            button.setIcon(icon);
            button.setOpaque(true);
            button.setContentAreaFilled(true);
            button.setBorderPainted(true);
            int num = usedSponsor.get(i);
            button.setActionCommand("sponsor" + num);
            button.addActionListener(this);
            mailScreen.add(button);
            button.setBounds(33, y, 938, 93);
            y += 82;
        }

        Container pane = getContentPane();
        pane.add(mainPanel, BorderLayout.CENTER);
        pane.add(buttonClass.getBtnPanel(), BorderLayout.SOUTH);

        setTitle("Aura Farming Simulator");
        setSize(1000, 700); // Set the size of the window
        setResizable(false); // Disable resizing the window
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window on the screen
        setVisible(true);

        //create custom cursor
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("src/images/cursor.png");
        Point hotSpot = new Point(0, 0);

        Cursor customCursor = toolkit.createCustomCursor(image, hotSpot, "MyCursor");
        mainPanel.setCursor(customCursor);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JPanel getAuraInfo() {
        return auraInfo;
    }

    public void showCard(String cardName) {
        cardLayout.show(mainPanel, cardName);
    }


    public static Frame createFrame() throws IOException {
        return new Frame();
    }

    public JPanel getMailScreen() {
        return mainPanel;
    }

    public JPanel getLoginInScreen() {
        return loginInScreen;
    }

    private void initailizeIvanImages (ArrayList<BufferedImage> frames, int start, int end, String src) {
        for (int i = start; i < end; i++) {
            try {
                BufferedImage img = ImageIO.read(new File("src/DesktopPetImages/" + src + "/ivan" + i + ".png"));
                frames.add(img);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public JPanel getLivestreamScreen() {
        return livestreamScreen;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        String num = command.replaceAll("\\D+", "");
        String panelName = "mail" + num;

        // Only add if not already added
        if (!((CardLayout) mainPanel.getLayout()).toString().contains(panelName)) {
            JPanel mailPanel = PanelClass.createPanel("src/MailImages/mails/" + num + ".png", buttonClass, this);
            mailPanel.setLayout(null);
            mainPanel.add(mailPanel, panelName);
            buttonClass.getAccept().setBounds(400, 590, 150, 40);
            buttonClass.getDecline().setBounds(650,590, 150,40);
            if (buttonClass.getAccept().getParent() != null) {
                buttonClass.getAccept().getParent().remove(buttonClass.getAccept());
            }
            if (buttonClass.getDecline().getParent() != null) {
                buttonClass.getDecline().getParent().remove(buttonClass.getDecline());
            }
            mailPanel.add(buttonClass.getAccept());
            mailPanel.add(buttonClass.getDecline());
            mailPanel.revalidate();
            mailPanel.repaint();
        }

        showCard(panelName);
    }

    public JPanel getAppScreen() {
        return appScreen;
    }

    public JPanel getTicTacToe() {
        return ticTacToe;
    }

    public JPanel getRoundScreen() {
        return roundScreen;
    }

    public JPanel getRpsWinPage() {
        return rpsWinPage;
    }

    public JPanel getShop() {
        return shop;
    }

    public JPanel getEndDay() {
        return endDay;
    }

    public JPanel getRpsLoseScreen() {
        return rpsLoseScreen;
    }

    public JPanel getEditAppScreen() {
        return editAppScreen;
    }
}
