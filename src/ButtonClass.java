import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ButtonClass {
    private Player player;
    private JButton livestreamApp, nextButton, mailApp, bookBtn,
            editApp, powerOn, shopApp, gamesApp,
            endDay, accept, decline, next,
            ticTacToeApp, rpsGame, singleBtn, doubleBtn,
            shop, backBtnLS, backBtnRPS, backBtnTTT,
            backBtnEdit, returnBtn, backBtnEndDay, hundredAura,
            thousandAura, twoThousandAura, yes, no, mailback,
            startGameBtn;
    private JButton tic1,tic2, tic3, tic4, tic5, tic6, tic7, tic8, tic9, checkWinner, shopback, miniGameBtn;
    private JTextArea livestreamChat;
    private JScrollPane scrollPane;
    private Thread livestreamThread;
    private volatile boolean livestreamExited = false;
    private JTextField usernameText, passwordText;
    private JPanel btnPanel, mainPanel, redLine, blueLine;
    private Frame cardLayoutPanel;
    private JPanelAnimation animation;
    private java.util.List<JLabel> comments = new ArrayList<>();
    private Livestream livestream;
    private Sponsors sponsors;
    private Font pressStartFont;
    private TicTacToe ticTacToe;
    private JLabel TTTWin, TTTLose, TTTDraw, TTTNull, label, TTTotalWins, TTTtotalLosses, TTTAura;
    private JLabel followersGained, auraGained, totalFollowers, totalAura, aura, followersLS, auraLS,
            game0, game1, game2, game3, winLabel;
    private boolean[] pressedKeys;
    private int round, currentAds;
    private int wins;
    private int lose;
    private Timer timer;
    private Clip currentClip;
    private Timer blueLineTimer;
    private int blueLineX, roundMiniGame, winsMiniGame;
    private int blueLineDirection = 1;

    public ButtonClass(Frame cardLayoutPanel,Player player, JPanel mainPanel)  {
        livestream = new Livestream(player);
        this.mainPanel = mainPanel;
        btnPanel = new JPanel(new BorderLayout());
        this.cardLayoutPanel = cardLayoutPanel;
        this.player = player;
        sponsors = new Sponsors();
        ticTacToe = new TicTacToe(player);

        ticTacToe = new TicTacToe(player);
        aura = new JLabel(player.getAura() + "");
        aura.setFont(pressStartFont);
        aura.setBounds(400, 400, 1000, 400);

        followersLS = new JLabel(String.valueOf(player.getFollowers()));
        auraLS = new JLabel(String.valueOf(player.getAura()));
        auraLS = new JLabel(String.valueOf(player.getAura()));
        game0 = new JLabel(new ImageIcon("src/images/LSGame0.png"));
        game1 = new JLabel(new ImageIcon("src/images/LSGame1.png"));
        game2 = new JLabel(new ImageIcon("src/images/LSGame2.png"));
        game3 = new JLabel(new ImageIcon("src/images/LSGame3.png"));

        usernameText = new JTextField(15);
        passwordText = new JTextField(4);
        livestreamChat = new JTextArea(280,500);
        scrollPane = new JScrollPane(livestreamChat);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(604, 105, 180, 335);

        livestreamApp = new JButton();
        nextButton = new JButton();
        mailApp = new JButton();
        bookBtn = new JButton();
        accept = new JButton();
        decline = new JButton();
        next = new JButton();
        bookBtn.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("SPACE"), "none");
        nextButton.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("SPACE"), "none");
        //testing
        editApp = new JButton();
        powerOn = new JButton();
        shopApp = new JButton();
        gamesApp = new JButton();
        endDay = new JButton();
        shop = new JButton();
        shopback = new JButton();
        backBtnEndDay = new JButton();
        ticTacToeApp = new JButton();
        tic1 = ticTacToe.getButton(0);
        tic2 = ticTacToe.getButton(1);
        tic3 = ticTacToe.getButton(2);
        tic4 = ticTacToe.getButton(3);
        tic5 = ticTacToe.getButton(4);
        tic6 = ticTacToe.getButton(5);
        tic7 = ticTacToe.getButton(6);
        tic8 = ticTacToe.getButton(7);
        tic9 = ticTacToe.getButton(8);
        TTTWin = new JLabel(new ImageIcon("src/images/TicTacToeWin.png"));
        TTTLose = new JLabel(new ImageIcon("src/images/TicTacToeLose.png"));
        TTTDraw = new JLabel(new ImageIcon("src/images/TicTacToeDraw.png"));
        TTTNull = new JLabel(new ImageIcon("src/images/TicTacToeNull.png"));
        checkWinner = new JButton();
        rpsGame = new JButton();
        singleBtn = new JButton();
        doubleBtn = new JButton();
        backBtnLS = new JButton();
        backBtnEdit = new JButton();
        backBtnRPS = new JButton();
        backBtnTTT = new JButton();
        returnBtn = new JButton();
        hundredAura = new JButton();
        thousandAura = new JButton();
        twoThousandAura = new JButton();
        yes = new JButton();
        no = new JButton();
        miniGameBtn = new JButton();
        mailback = new JButton();

        round = 1;
        wins = 0;
        lose = 0;
        roundMiniGame = 0;
        winsMiniGame = 0;
        currentAds = 0;

        try {
            pressStartFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/PressStart2P-Regular.ttf"))
                    .deriveFont(Font.PLAIN, 24f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(pressStartFont);
        } catch (FontFormatException | IOException e1) {
            e1.printStackTrace();
        }

        ImageIcon acceptIcon = new ImageIcon();
        ImageIcon declineIcon = new ImageIcon();
        try {
            BufferedImage acceptImage = ImageIO.read(new File("src/MailImages/mails/accept.png"));
            BufferedImage declineImage = ImageIO.read(new File("src/MailImages/mails/decline.png"));
            acceptIcon = new ImageIcon(acceptImage);
            declineIcon = new ImageIcon(declineImage);
            //assert false;
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        accept.setIcon(acceptIcon);
        decline.setIcon(declineIcon);

        //set opaque
        //customizeButton(livestreamApp);

        customizeButton(nextButton);

        //setButtonOpaque(nextButton);

        //customizeButton(mailApp);
        customizeButton(mailApp);

        customizeButton(livestreamApp);

        customizeButton(editApp);

        customizeButton(gamesApp);

        customizeButton(shopApp);

        customizeButton(shop);

        customizeButton(endDay);

        customizeButton(bookBtn);

        customizeButton(accept);

        customizeButton(decline);

        customizeButton(backBtnEndDay);

        //setButtonOpaque(next);

        customizeButton(ticTacToeApp);

        customizeButton(rpsGame);

        customizeButton(singleBtn);

        customizeButton(doubleBtn);

        customizeButton(hundredAura);

        customizeButton(thousandAura);

        customizeButton(twoThousandAura);

        customizeButton(yes);

        customizeButton(no);

        customizeButton(shopback);

        customizeButton(backBtnEdit);
        customizeButton(backBtnLS);
        customizeButton(backBtnRPS);
        customizeButton(backBtnTTT);

        customizeButton(powerOn);

        customizeButton(returnBtn);

        customizeButton(tic1);

        customizeButton(tic2);

        customizeButton(tic3);

        customizeButton(tic4);

        customizeButton(tic5);

        customizeButton(tic6);

        customizeButton(tic7);

        customizeButton(tic8);

        customizeButton(tic9);

        customizeButton(checkWinner);

        //setButtonOpaque(miniGameBtn);
        customizeButton(miniGameBtn);

        //setButtonOpaque(startGameBtn);

        customizeButton(mailback);

        //customizeButton(next);

        livestreamChat.setEditable(true);
        livestreamChat.setLineWrap(true);

        usernameText.setFont(pressStartFont.deriveFont(45f));
        passwordText.setFont(pressStartFont);

        livestreamApp.setFont(new Font("Serif", Font.ITALIC, 15));

        //set button/text field size
        usernameText.setBounds(150,360,700,75);
        passwordText.setBounds(505,298,135,30);
        mailApp.setBounds(323, 220, 65, 65);
        livestreamApp.setBounds(460,220,65,65);
        gamesApp.setBounds(600,220,65,65);
        editApp.setBounds(323, 345, 65, 65);
        shopApp.setBounds(460,345,65,65);
        endDay.setBounds(600,345,65,65);

        nextButton.setBounds(725,480,210,85);

        bookBtn.setBounds(625, 285, 145, 125);
        powerOn.setBounds(680,455,80,18);
        ticTacToeApp.setBounds(380,275,65,65);
        rpsGame.setBounds(520,275,65,65);
        tic1.setBounds(240,160,87,85);
        tic2.setBounds(332,160,87,85);
        tic3.setBounds(425,160,87,85);
        tic4.setBounds(240,250,87,85);
        tic5.setBounds(332,250,87,85);
        tic6.setBounds(425,250,87,85);
        tic7.setBounds(240,335,87,85);
        tic8.setBounds(332,335,87,85);
        tic9.setBounds(425,335,87,85);
        checkWinner.setBounds(585,273,150,40);
        singleBtn.setBounds(395,265,205,75);
        doubleBtn.setBounds(395,360,205,75);
        backBtnEdit.setBounds(200,85,17,17);
        backBtnTTT.setBounds(200,85,17,17);
        backBtnRPS.setBounds(200,85,17,17);
        backBtnLS.setBounds(200,85,17,17);
        next.setBounds(50, 58, 280, 60);
        returnBtn.setBounds(450,450,100,50);
        backBtnEndDay.setBounds(610,130,30,30);
        miniGameBtn.setBounds(200,450,100,50);
        mailback.setBounds(40, 60, 270, 70);
        //startGameBtn.setBounds(200, 200, 200, 100);
//       hundredAura.setBounds(60, 450, 40, 200);
//        thousandAura.setBounds(150, 450, 40, 200);
//        twoThousandAura.setBounds(250, 450, 40, 200);

        //livestreamApp.setVisible(false);

        btnPanel.add(usernameText);
        btnPanel.add(passwordText);
        btnPanel.add(livestreamApp);
        btnPanel.add(nextButton);
        btnPanel.add(mailApp);
        btnPanel.add(bookBtn);
        btnPanel.add(editApp);
        btnPanel.add(powerOn);
        btnPanel.add(gamesApp);
        btnPanel.add(shopApp);
        btnPanel.add(endDay);
        btnPanel.add(ticTacToeApp);
        btnPanel.add(rpsGame);
        btnPanel.add(singleBtn);
        btnPanel.add(doubleBtn);
        btnPanel.add(tic1);
        btnPanel.add(tic2);
        btnPanel.add(tic2);
        btnPanel.add(tic3);
        btnPanel.add(tic4);
        btnPanel.add(tic5);
        btnPanel.add(tic6);
        btnPanel.add(tic7);
        btnPanel.add(tic8);
        btnPanel.add(tic9);
        btnPanel.add(checkWinner);
        btnPanel.add(backBtnEdit);
        btnPanel.add(backBtnLS);
        btnPanel.add(backBtnEdit);
        btnPanel.add(backBtnRPS);
        btnPanel.add(backBtnTTT);
        //btnPanel.add(next);
        btnPanel.add(returnBtn);
        btnPanel.add(miniGameBtn);
        //btnPanel.add(startGameBtn);
        //btnPanel.add(backBtnEndDay);

        addActionListeners();
    }

    private void addActionListeners() {
        usernameText.addActionListener(e -> {
            player.setUsername(usernameText.getText());
            System.out.println("username: " + player.getUsername());
            //cardLayoutPanel.showCard("Background");
            cardLayoutPanel.showCard("TutorialScreen");
        });

        passwordText.addActionListener(e -> {
            String input = passwordText.getText();

            if (input.matches("\\d{4}")) {
                int passwordInt = Integer.parseInt(input);
                player.setPassword(passwordInt);
                System.out.println("password: " + player.getPassword());
                addPassword();
                cardLayoutPanel.showCard("AppScreen");
            } else {
                JOptionPane.showMessageDialog(null, "Please enter exactly 4 digits.");
            }
        });

        passwordText.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();

                if (!Character.isDigit(c)) {
                    e.consume();
                }

                if (passwordText.getText().length() >= 4) {
                    e.consume();
                }
            }
        });

        powerOn.addActionListener(e -> {
            //cardLayoutPanel.showCard("LoginInScreen");
            //cardLayoutPanel.showCard("AppScreen");

            JLabel usernameLabel = new JLabel(player.getUsername());
            usernameLabel.setFont(pressStartFont);
            usernameLabel.setForeground(Color.WHITE);
            usernameLabel.setBounds(300, 250, 300, 50);
            usernameLabel.setHorizontalAlignment(SwingConstants.CENTER);

            JPanel loginInScreen = cardLayoutPanel.getLoginInScreen();
            loginInScreen.setLayout(null);
            loginInScreen.add(usernameLabel);
            loginInScreen.revalidate();
            loginInScreen.repaint();

            cardLayoutPanel.showCard("LoginInScreen");
        });

        timer = new Timer(1500, e -> {
            int randomIncrement = (int) (Math.random() * 1001);
            player.addFollowers(randomIncrement);
            followersLS.setText(String.valueOf(player.getFollowers()));
            auraLS.setText(String.valueOf(player.getAura()));
        });

        backBtnLS.addActionListener(e -> {
            timer.stop();
            cardLayoutPanel.getLivestreamScreen().remove(auraLS);
            cardLayoutPanel.showCard("AppScreen");
        });

        livestreamApp.addActionListener(e -> {
            int randomGame = (int) (Math.random() * 5);
            if (randomGame == 0) {
                game0.setBounds(202,100,380,240);
                cardLayoutPanel.getLivestreamScreen().add(game0);
            } else if (randomGame == 1) {
                game1.setBounds(202,100,380,240);
                cardLayoutPanel.getLivestreamScreen().add(game1);
            } else if (randomGame == 2) {
                game2.setBounds(202,100,380,240);
                cardLayoutPanel.getLivestreamScreen().add(game2);
            } else {
                game3.setBounds(202,100,380,240);
                cardLayoutPanel.getLivestreamScreen().add(game3);
            }

            cardLayoutPanel.getLivestreamScreen().add(followersLS);
            followersLS.setFont(pressStartFont.deriveFont(15f));
            followersLS.setForeground(Color.decode("#31529b"));
            followersLS.setBounds(440, 365, 200, 60);

            cardLayoutPanel.getLivestreamScreen().add(auraLS);
            auraLS.setFont(pressStartFont.deriveFont(15f));
            auraLS.setForeground(Color.decode("#31529b"));
            auraLS.setBounds(387, 383, 200, 60);

            timer.start();

            livestreamExited = true;
            if (livestreamThread != null && livestreamThread.isAlive()) {
                livestreamThread.interrupt();
            }
            livestreamExited = false;

            livestreamThread = new Thread(() -> {
                while (!livestreamExited) {
                    spawnComment();
                    SwingUtilities.invokeLater(() -> {
//                        livestreamChat.append(finalTextToAppend);
//                        livestreamChat.setCaretPosition(livestreamChat.getDocument().getLength());
                        cardLayoutPanel.getLivestreamScreen().revalidate();
                        cardLayoutPanel.getLivestreamScreen().repaint();
                    });

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException f) {
                        break;
                    }
                }
            });
            livestreamThread.start();
            cardLayoutPanel.showCard("LivestreamScreen");
        });

        editApp.addActionListener(e -> {
            if (currentClip != null && currentClip.isRunning()) {
                currentClip.stop();
                currentClip.close();
            }
            currentClip = SoundUtils.playSound("src/Rick Astley - Never Gonna Give You Up (Official Music Video).wav");

            buildEditAppScreen();
            cardLayoutPanel.showCard("EditAppScreen");
        });

        mailApp.addActionListener(e -> {
            //animation
            ArrayList<BufferedImage> mailImages = new ArrayList<>();
            for (int i = 1; i < 15; i++) {
                try {
                    String file = "src/MailImages/" + i + ".png";
                    BufferedImage mailImg = ImageIO.read(new File(file));
                    mailImages.add(mailImg);
                }
                catch (IOException exception) {
                    System.out.println(exception.getMessage());
                }
            }
            JPanelAnimation mailScreenAnimation = new JPanelAnimation(cardLayoutPanel, "MailScreen", mailImages, 50, 1);
            cardLayoutPanel.getMainPanel().add(mailScreenAnimation, "MailScreenAnimation");

            cardLayoutPanel.showCard("MailScreenAnimation");

        });

        nextButton.addActionListener(e -> {
            cardLayoutPanel.showCard("Background");
        });

        accept.addActionListener(e -> {
            int added = player.addAura();
            player.addAds(1);
            label = new JLabel("You gained " + added + " aura!");
            label.setFont(pressStartFont);
            label.setBounds(280, 150, 1000, 400);
            //cardLayoutPanel.getAuraInfo().add(label);
            cardLayoutPanel.showCard("auraInfo");
            new javax.swing.Timer(2000, ex -> {
                cardLayoutPanel.showCard("AppScreen");
                ((javax.swing.Timer) ex.getSource()).stop();
            }).start();
            cardLayoutPanel.getAuraInfo().revalidate();
            cardLayoutPanel.getAuraInfo().repaint();
            //cardLayoutPanel.showCard("AppScreen");
        });

        decline.addActionListener(e -> {
            int deleted = player.deleteAura();
            label = new JLabel("You lost " + deleted + " aura!");
            label.setFont(pressStartFont);
            label.setBounds(280, 150, 1000, 400);
            //cardLayoutPanel.getAuraInfo().add(label);
            cardLayoutPanel.showCard("auraInfo");
            new javax.swing.Timer(2000, ex -> {
                cardLayoutPanel.showCard("AppScreen");
                ((javax.swing.Timer) ex.getSource()).stop();
            }).start();
            cardLayoutPanel.getAuraInfo().revalidate();
            cardLayoutPanel.getAuraInfo().repaint();
            //cardLayoutPanel.showCard("AppScreen");
        });

        next.addActionListener(e -> {
            cardLayoutPanel.showCard("AppScreen");
        });

        gamesApp.addActionListener(e -> {
            cardLayoutPanel.showCard("GamesScreen");
        });

        rpsGame.addActionListener(e -> {
            cardLayoutPanel.showCard("RockPaperScissors");
        });

        ticTacToeApp.addActionListener(e -> {
            TTTotalWins = new JLabel(String.valueOf(ticTacToe.getWins()));
            TTTotalWins.setFont(pressStartFont.deriveFont(15f));
            TTTotalWins.setForeground(Color.decode("#31529b"));
            TTTotalWins.setBounds(635, 343, 200, 60);

            TTTtotalLosses = new JLabel(String.valueOf(ticTacToe.getLosses()));
            TTTtotalLosses.setFont(pressStartFont.deriveFont(15f));
            TTTtotalLosses.setForeground(Color.decode("#31529b"));
            TTTtotalLosses.setBounds(655, 365, 200, 60);

            TTTAura = new JLabel(String.valueOf(ticTacToe.getAuraGained()));
            TTTAura.setFont(pressStartFont.deriveFont(15f));
            TTTAura.setForeground(Color.decode("#31529b"));
            TTTAura.setBounds(705, 388, 200, 60);

            cardLayoutPanel.getTicTacToe().add(TTTotalWins);
            cardLayoutPanel.getTicTacToe().add(TTTtotalLosses);
            cardLayoutPanel.getTicTacToe().add(TTTAura);
            cardLayoutPanel.showCard("TicTacToe");
        });

        checkWinner.addActionListener(e -> {
            if (!ticTacToe.getGameEnded()) {
                if (ticTacToe.getWinner().equals("You win")) {
                    ticTacToe.setGameEnded(true);
                    TTTWin.setBounds(570,170,175,52);
                    cardLayoutPanel.getTicTacToe().add(TTTWin);
                    TTTNull.setVisible(false);
                    cardLayoutPanel.getTicTacToe().revalidate();
                    cardLayoutPanel.getTicTacToe().repaint();
                } else if (ticTacToe.getWinner().equals("AI wins")) {
                    ticTacToe.setGameEnded(true);
                    TTTLose.setBounds(573,170,170,50);
                    cardLayoutPanel.getTicTacToe().add(TTTLose);
                    TTTNull.setVisible(false);
                    cardLayoutPanel.getTicTacToe().revalidate();
                    cardLayoutPanel.getTicTacToe().repaint();
                } else if (ticTacToe.getWinner().equals("Draw")) {
                    ticTacToe.setGameEnded(true);
                    TTTDraw.setBounds(570,170,170,50);
                    cardLayoutPanel.getTicTacToe().add(TTTDraw);
                    TTTNull.setVisible(false);
                    cardLayoutPanel.getTicTacToe().revalidate();
                    cardLayoutPanel.getTicTacToe().repaint();
                } else {
                    TTTNull.setBounds(565,170,195,48);
                    TTTNull.setVisible(true);
                    cardLayoutPanel.getTicTacToe().add(TTTNull);
                    cardLayoutPanel.getTicTacToe().revalidate();
                    cardLayoutPanel.getTicTacToe().repaint();
                }
            }
            cardLayoutPanel.getTicTacToe().remove(TTTotalWins);
            cardLayoutPanel.getTicTacToe().remove(TTTtotalLosses);
            cardLayoutPanel.getTicTacToe().remove(TTTAura);

            TTTotalWins = new JLabel(String.valueOf(ticTacToe.getWins()));
            TTTotalWins.setFont(pressStartFont.deriveFont(15f));
            TTTotalWins.setForeground(Color.decode("#31529b"));
            TTTotalWins.setBounds(635, 343, 200, 60);

            TTTtotalLosses = new JLabel(String.valueOf(ticTacToe.getLosses()));
            TTTtotalLosses.setFont(pressStartFont.deriveFont(15f));
            TTTtotalLosses.setForeground(Color.decode("#31529b"));
            TTTtotalLosses.setBounds(655, 365, 200, 60);

            TTTAura = new JLabel(String.valueOf(ticTacToe.getAuraGained()));
            TTTAura.setFont(pressStartFont.deriveFont(15f));
            TTTAura.setForeground(Color.decode("#31529b"));
            TTTAura.setBounds(705, 388, 200, 60);

            cardLayoutPanel.getTicTacToe().add(TTTotalWins);
            cardLayoutPanel.getTicTacToe().add(TTTtotalLosses);
            cardLayoutPanel.getTicTacToe().add(TTTAura);
        });

        backBtnTTT.addActionListener(e -> {
            ticTacToe.resetGame();
            cardLayoutPanel.getTicTacToe().remove(TTTWin);
            cardLayoutPanel.getTicTacToe().remove(TTTLose);
            cardLayoutPanel.getTicTacToe().remove(TTTDraw);
            cardLayoutPanel.getTicTacToe().remove(TTTNull);
            cardLayoutPanel.getTicTacToe().remove(TTTotalWins);
            cardLayoutPanel.getTicTacToe().remove(TTTtotalLosses);
            cardLayoutPanel.getTicTacToe().remove(TTTAura);

            cardLayoutPanel.getTicTacToe().revalidate();
            cardLayoutPanel.getTicTacToe().repaint();
            cardLayoutPanel.showCard("AppScreen");
        });

        singleBtn.addActionListener(e -> {
            pressedKeys = new boolean[128];
            //hasPlayedIntroAnimation = true;
            vsAnimation();
        });

        doubleBtn.addActionListener(e -> {
            pressedKeys = new boolean[128];
            vsAnimation();
        });

        shopApp.addActionListener( e -> {
            cardLayoutPanel.showCard("shopScreen");
        });

        shop.addActionListener(e -> {
            ArrayList<BufferedImage> shopImages = new ArrayList<>();
            for (int i = 2; i < 9; i++) {
                try {
                    String file = "src/shopimages/" + i + ".png";
                    BufferedImage shopImg = ImageIO.read(new File(file));
                    shopImages.add(shopImg);
                }
                catch (IOException exception) {
                    System.out.println(exception.getMessage());
                }
            }
            JPanelAnimation shopAnimation = new JPanelAnimation(cardLayoutPanel, "shop", shopImages, 50, 1);
            System.out.println(player.getAura());
            cardLayoutPanel.getMainPanel().add(shopAnimation, "shopAnimation");

            cardLayoutPanel.showCard("shopAnimation");
        });

        backBtnRPS.addActionListener(e -> {
            cardLayoutPanel.showCard("AppScreen");
        });

        backBtnEndDay.addActionListener(e -> {
            cardLayoutPanel.showCard("AppScreen");
        });

        endDay.addActionListener(e -> {
            cardLayoutPanel.getEndDay().removeAll();

            followersGained = new JLabel(String.valueOf(player.getFollowersGained()));
            followersGained.setFont(pressStartFont.deriveFont(15f));
            followersGained.setForeground(Color.decode("#31529b"));
            followersGained.setBounds(555, 213, 200, 60);

            auraGained = new JLabel(String.valueOf(player.getAuraGained()));
            auraGained.setFont(pressStartFont.deriveFont(15f));
            auraGained.setForeground(Color.decode("#31529b"));
            auraGained.setBounds(500, 238, 200, 60);

            totalFollowers = new JLabel(String.valueOf(player.getFollowers()));
            totalFollowers.setFont(pressStartFont.deriveFont(15f));
            totalFollowers.setForeground(Color.decode("#31529b"));
            totalFollowers.setBounds(545, 265, 200, 60);

            totalAura = new JLabel(String.valueOf(player.getAura()));
            totalAura.setFont(pressStartFont.deriveFont(15f));
            totalAura.setForeground(Color.decode("#31529b"));
            totalAura.setBounds(485, 293, 200, 60);

            cardLayoutPanel.getEndDay().add(followersGained);
            cardLayoutPanel.getEndDay().add(auraGained);
            cardLayoutPanel.getEndDay().add(totalFollowers);
            cardLayoutPanel.getEndDay().add(totalAura);
            cardLayoutPanel.getEndDay().add(backBtnEndDay);

            player.endDay();

            cardLayoutPanel.showCard("EndDayScreen");

            if (player.getDay() >= 30) {
                System.out.println("hi");
                if (player.getFollowers() >= 100000) {
                    System.out.println("bye");
                    cardLayoutPanel.showCard("VictoryScreen");
                } else {
                    System.out.println("loser");
                    cardLayoutPanel.showCard("LosingScreen");
                }
            }
        });

        hundredAura.addActionListener(e -> {
            if (player.getAura() < 100) {
                cardLayoutPanel.showCard("notenough");
                Timer timer = new Timer(1000, ex -> cardLayoutPanel.showCard("shop"));
                timer.setRepeats(false);
                timer.start();
            } else {
                player.setCurrent(1000);
                player.setCurrentAura(100);
                cardLayoutPanel.showCard("areyousure");
            }
        });

        thousandAura.addActionListener(e -> {
            if (player.getAura() < 1000) {
                cardLayoutPanel.showCard("notenough");
                Timer timer = new Timer(1000, ex -> cardLayoutPanel.showCard("shop"));
                timer.setRepeats(false);
                timer.start();
            } else {
                player.setCurrent(10000);
                player.setCurrentAura(1000);
                cardLayoutPanel.showCard("areyousure");
            }
        });

        twoThousandAura.addActionListener(e -> {
            if (player.getAura() < 2000) {
                cardLayoutPanel.showCard("notenough");
                Timer timer = new Timer(1000, ex -> cardLayoutPanel.showCard("shop"));
                timer.setRepeats(false);
                timer.start();
            } else {
                player.setCurrent(20000);
                player.setCurrentAura(2000);
                cardLayoutPanel.showCard("areyousure");
            }
        });

        yes.addActionListener(e -> {
            player.addFollowers(player.getCurrent());
            player.deleteAura(player.getCurrentAura());
            cardLayoutPanel.showCard("success");
            Timer timer = new Timer(2000, ex -> cardLayoutPanel.showCard("AppScreen"));
            timer.setRepeats(false);
            timer.start();
        });

        no.addActionListener(e -> {
            cardLayoutPanel.showCard("AppScreen");
        });

        shopback.addActionListener(e -> {
            cardLayoutPanel.showCard("AppScreen");
        });

        miniGameBtn.addActionListener(e -> {

        });

        mailback.addActionListener(e -> {
            cardLayoutPanel.showCard("AppScreen");
        });
    }

    private void customizeButton(JButton button) {
        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
    }

    private void setButtonOpaque(JButton button) {
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorderPainted(true);
    }

    public JPanel getBtnPanel() {
        return btnPanel;
    }

    public JButton getLivestreamApp() {
        return livestreamApp;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getBookBtn() {
        return bookBtn;
    }

    public JTextField getUsernameText() {
        return usernameText;
    }

    public JTextField getPasswordText() {
        return passwordText;
    }

    public JTextArea getLivestreamChat() {
        return livestreamChat;
    }

    public JButton getMailApp() {
        return mailApp;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JButton getEditApp() {
        return editApp;
    }

    public JButton getPowerOn() {
        return powerOn;
    }

    public JButton getGamesApp() {
        return gamesApp;
    }

    public JButton getShopApp() {
        return shopApp;
    }

    public JButton getEndDay() {
        return endDay;
    }

    public JButton getAccept() {
        return accept;
    }

    public JButton getDecline() {
        return decline;
    }

    public JButton getTicTacToeApp() {
        return ticTacToeApp;
    }

    public JButton getRpsGame() {
        return rpsGame;
    }

    public JButton getSingleBtn() {
        return singleBtn;
    }

    public JButton getDoubleBtn() {
        return doubleBtn;
    }

    public JButton getTic1() {
        return tic1;
    }

    public JButton getTic2() {
        return tic2;
    }

    public JButton getTic3() {
        return tic3;
    }

    public JButton getTic4() {
        return tic4;
    }

    public JButton getTic5() {
        return tic5;
    }

    public JButton getTic6() {
        return tic6;
    }

    public JButton getTic7() {
        return tic7;
    }

    public JButton getTic8() {
        return tic8;
    }

    public JButton getTic9() {
        return tic9;
    }

    public JButton getCheckWinner() {
        return checkWinner;
    }

    public JButton getShop() {
        return shop;
    }

    public JButton getNext() {
        return next;
    }

    public JButton getBackBtnLS() {
        return backBtnLS;
    }

    public JButton getBackBtnRPS() {
        return backBtnRPS;
    }

    public JButton getBackBtnTTT() {
        return backBtnTTT;
    }

    public JButton getBackBtnEdit() {
        return backBtnEdit;
    }

    public JButton getHundredAura() {
        return hundredAura;
    }

    public JButton getThousandAura() {
        return thousandAura;
    }

    public JButton getTwoThousandAura() {
        return twoThousandAura;
    }

    public JButton getYes() {
        return yes;
    }

    public JButton getNo() {
        return no;
    }
    public JLabel getLabel() {
        return label;
    }

    public JLabel getAura() {
        return aura;
    }

    public int getPlayerAura() {
        return player.getAura();
    }

    public Font getPressStartFont() {
        return pressStartFont;
    }

    public JButton getShopback() {
        return shopback;
    }

    public JButton getMailback() {
        return mailback;
    }

    public JButton getStartGameBtn() {
        return startGameBtn;
    }

    public void addPassword() {
        JLabel passwordLabel = new JLabel(String.valueOf(player.getPassword()));
        passwordLabel.setFont(pressStartFont);
        Color color = Color.decode("#1a37ac");
        passwordLabel.setForeground(color);
        passwordLabel.setBounds(40, 325, 100, 50);

        JPanel appScreen = cardLayoutPanel.getAppScreen();
        appScreen.setLayout(null);
        appScreen.add(passwordLabel);
        appScreen.revalidate();
        appScreen.repaint();
    }


    public void vsAnimation() {
        ArrayList<BufferedImage> vsAnimation = new ArrayList<>();
        for (int i = 0; i < 29; i++) {
            String fileName = "src/images/RockPaperScissorsGame/vsAnimation/frame_" + i + ".jpg";
            try {
                vsAnimation.add(ImageIO.read(new File(fileName)));
            } catch (IOException e2) {
                System.out.println(e2.getMessage());
            }
        }

        JPanelAnimation animationPanel = new JPanelAnimation(this.cardLayoutPanel, "RoundScreen", vsAnimation, 100, 1);
        this.mainPanel.add(animationPanel, "animation");
        this.cardLayoutPanel.showCard("animation");

        SoundUtils.playSound("src/Round 1 Fight! (Mortal Kombat Meme) - Sound Effect for editing.wav");

        animationPanel.setOnComplete(() -> {
            this.mainPanel.remove(animationPanel);
            this.mainPanel.revalidate();
            this.mainPanel.repaint();

            JPanel roundScreen = cardLayoutPanel.getRoundScreen();
            roundScreen.setLayout(null);

            JLabel roundLabel = new JLabel("Round " + round);
            roundLabel.setFont(pressStartFont.deriveFont(45f));
            roundLabel.setForeground(Color.decode("#5d31b8"));
            roundLabel.setBounds(335, 310, 500, 50);

            JLabel winLabelPlayer1 = new JLabel("Wins: " + wins);
            winLabelPlayer1.setFont(pressStartFont.deriveFont(25f));
            winLabelPlayer1.setForeground(Color.decode("#5d31b8"));
            winLabelPlayer1.setBounds(430, 430, 200, 60);

            JLabel winLabelPlayer2 = new JLabel("Wins: " + lose);
            winLabelPlayer2.setFont(pressStartFont.deriveFont(25f));
            winLabelPlayer2.setForeground(Color.decode("#5d31b8"));
            winLabelPlayer2.setBounds(15, 25, 200, 60);

            JLabel usernameLabel = new JLabel(usernameText.getText());
            usernameLabel.setFont(pressStartFont.deriveFont(45f));
            usernameLabel.setForeground(Color.decode("#a589e8"));
            usernameLabel.setBounds(610, 600, 200, 50);

            roundScreen.removeAll();
            roundScreen.add(roundLabel);
            roundScreen.add(usernameLabel);
            roundScreen.add(winLabelPlayer1);
            roundScreen.add(winLabelPlayer2);
            roundScreen.revalidate();
            roundScreen.repaint();

            roundScreen.requestFocusInWindow();

            setupRoundScreenKeyListener(roundScreen);
        });
    }

    private void switchToResult(String move) {
        int ai = aiPlayer();
        String result;

        if (ai == 1) {
            result = move + "Tie";
        } else if (ai == 2) {
            wins++;
            result = move + "Win";
        } else {
            lose++;
            result = move + "Lose";
        }

        if (wins == 2) {
            ArrayList<BufferedImage> vsAnimation2 = new ArrayList<>();
            for (int i = 0; i < 24; i++) {
                String fileName = "src/images/RockPaperScissorsGame/winAnimation/frame" + i + ".jpg";
                try {
                    vsAnimation2.add(ImageIO.read(new File(fileName)));
                } catch (IOException e2) {
                    System.out.println(e2.getMessage());
                }
            }

            JPanelAnimation animationPanel2 = new JPanelAnimation(this.cardLayoutPanel, "EndScreen", vsAnimation2, 100, 2);

            this.mainPanel.add(animationPanel2, "animation2");
            this.cardLayoutPanel.showCard("animation2");

            animationPanel2.setOnComplete(() -> {
                this.mainPanel.remove(animationPanel2);
                this.mainPanel.revalidate();
                this.mainPanel.repaint();

                cardLayoutPanel.showCard("RPSWinPage");
                JPanel rpsWinPage = cardLayoutPanel.getRpsWinPage();
                rpsWinPage.setLayout(null);
                JButton returnBtn = new JButton("Return");
                returnBtn.setBounds(650, 407, 125, 45);
                returnBtn.setFont(pressStartFont.deriveFont(20f));
                //setButtonOpaque(returnBtn);
                customizeButton(returnBtn);

                int num = player.addAura();

                JLabel auraGained = new JLabel(String.valueOf(num));
                auraGained.setFont(pressStartFont.deriveFont(18f));
                auraGained.setForeground(Color.decode("#ffcc00"));
                auraGained.setBounds(510, 245, 100, 50);

                int num2 = player.getFollowers();

                JLabel totalFollowers = new JLabel(String.valueOf(num2));
                totalFollowers.setFont(pressStartFont.deriveFont(18f));
                totalFollowers.setForeground(Color.decode("#ffcc00"));
                totalFollowers.setBounds(560, 275, 100, 50);

                int num3 = player.getAura();

                JLabel totalAura = new JLabel(String.valueOf(num3));
                totalAura.setFont(pressStartFont.deriveFont(18f));
                totalAura.setForeground(Color.decode("#ffcc00"));
                totalAura.setBounds(500, 297, 100, 50);

                round = 1;
                wins = 0;
                lose = 0;

                returnBtn.addActionListener(e -> {
                    rpsWinPage.removeAll();
                    rpsWinPage.revalidate();
                    rpsWinPage.repaint();
                    cardLayoutPanel.showCard("AppScreen");
                });

                rpsWinPage.add(returnBtn);
                rpsWinPage.add(auraGained);
                rpsWinPage.add(totalFollowers);
                rpsWinPage.add(totalAura);
                rpsWinPage.revalidate();
                rpsWinPage.repaint();
            });
            return;
        } else if (lose == 2) {
            cardLayoutPanel.showCard("RPSLoseScreen");

            javax.swing.SwingUtilities.invokeLater(() -> {
                new javax.swing.Timer(5000, e -> {
                    JPanel rpsLosePage = cardLayoutPanel.getRpsLoseScreen();
                    rpsLosePage.setLayout(null);

                    JButton returnBtn = new JButton("Return");
                    returnBtn.setBounds(650, 407, 125, 45);
                    returnBtn.setFont(pressStartFont.deriveFont(20f));
                    setButtonOpaque(returnBtn);

                    int num = player.addAura();
                    JLabel auraGained = new JLabel(String.valueOf(num));
                    auraGained.setFont(pressStartFont.deriveFont(18f));
                    auraGained.setForeground(Color.decode("#ffcc00"));
                    auraGained.setBounds(510, 245, 100, 50);

                    int num2 = player.getFollowers();
                    JLabel totalFollowers = new JLabel(String.valueOf(num2));
                    totalFollowers.setFont(pressStartFont.deriveFont(18f));
                    totalFollowers.setForeground(Color.decode("#ffcc00"));
                    totalFollowers.setBounds(560, 275, 100, 50);

                    int num3 = player.getAura();
                    JLabel totalAura = new JLabel(String.valueOf(num3));
                    totalAura.setFont(pressStartFont.deriveFont(18f));
                    totalAura.setForeground(Color.decode("#ffcc00"));
                    totalAura.setBounds(500, 297, 100, 50);

                    round = 1;
                    wins = 0;
                    lose = 0;

                    returnBtn.addActionListener(evt -> {
                        rpsLosePage.removeAll();
                        rpsLosePage.revalidate();
                        rpsLosePage.repaint();
                        cardLayoutPanel.showCard("AppScreen");
                    });

                    rpsLosePage.add(returnBtn);
                    rpsLosePage.add(auraGained);
                    rpsLosePage.add(totalFollowers);
                    rpsLosePage.add(totalAura);
                    rpsLosePage.revalidate();
                    rpsLosePage.repaint();

                    cardLayoutPanel.showCard("RPSLosePage");
                    ((javax.swing.Timer) e.getSource()).stop();
                }).start();
            });
        }
        cardLayoutPanel.showCard(result);

        new javax.swing.Timer(3000, e -> {
            round++;
            updateRoundScreen();
            cardLayoutPanel.showCard("RoundScreen");
            ((javax.swing.Timer) e.getSource()).stop();
        }).start();
    }

    private void updateRoundScreen() {
        JPanel roundScreen = cardLayoutPanel.getRoundScreen();
        roundScreen.setLayout(null);
        roundScreen.removeAll();

        JLabel roundLabel = new JLabel("Round " + round);
        roundLabel.setFont(pressStartFont.deriveFont(45f));
        roundLabel.setForeground(Color.decode("#5d31b8"));
        roundLabel.setBounds(335, 310, 500, 50);

        JLabel winLabelPlayer1 = new JLabel("Wins: " + wins);
        winLabelPlayer1.setFont(pressStartFont.deriveFont(25f));
        winLabelPlayer1.setForeground(Color.decode("#5d31b8"));
        winLabelPlayer1.setBounds(430, 430, 200, 60);

        JLabel winLabelPlayer2 = new JLabel("Wins: " + lose);
        winLabelPlayer2.setFont(pressStartFont.deriveFont(25f));
        winLabelPlayer2.setForeground(Color.decode("#5d31b8"));
        winLabelPlayer2.setBounds(15, 25, 200, 60);

        JLabel usernameLabel = new JLabel(usernameText.getText());
        usernameLabel.setFont(pressStartFont.deriveFont(45f));
        usernameLabel.setForeground(Color.decode("#a589e8"));
        usernameLabel.setBounds(610, 600, 200, 50);

        roundScreen.add(roundLabel);
        roundScreen.add(usernameLabel);
        roundScreen.add(winLabelPlayer1);
        roundScreen.add(winLabelPlayer2);

        roundScreen.revalidate();
        roundScreen.repaint();

        setupRoundScreenKeyListener(roundScreen);

        SwingUtilities.invokeLater(roundScreen::requestFocusInWindow);
    }

    void setupRoundScreenKeyListener(JPanel roundScreen) {
        roundScreen.setFocusable(true);
        roundScreen.requestFocusInWindow();

        for (KeyListener kl : roundScreen.getKeyListeners()) {
            roundScreen.removeKeyListener(kl);
        }

        roundScreen.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Key pressed: " + e.getKeyChar());
                int key = e.getKeyCode();
                if (key == KeyEvent.VK_A) {
                    switchToResult("Rock");
                } else if (key == KeyEvent.VK_S) {
                    switchToResult("Paper");
                } else if (key == KeyEvent.VK_D) {
                    switchToResult("Scissors");
                } else {
                    System.out.println("Invalid key");
                }
            }
        });
    }

    public void spawnComment() {
        String textToAppend;
        int goodOrBad = (int) (Math.random() * 2);
        if (goodOrBad == 0) {
            textToAppend = livestream.getRandomGood();
        } else {
            textToAppend = livestream.getRandomBad();
        }
        String finalTextToAppend = textToAppend;
        JLabel comment = new JLabel(finalTextToAppend);
        comment.setOpaque(true);
        comment.setSize(178, 24);

        if (goodOrBad == 0) {
            comment.setBackground((Color.decode("#f5fff3")));
        } else {
            comment.setBackground(Color.decode("#fff0f0"));
        }

        comment.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (goodOrBad == 0) {
                    player.deleteAura();
                } else {
                    player.addAura();
                }

                cardLayoutPanel.getLivestreamScreen().remove(comment);
                comments.remove(comment);
                repositionComments();
                cardLayoutPanel.getLivestreamScreen().repaint();
            }
        });

        comments.add(0, comment); // New comments go to the top of the list
        cardLayoutPanel.getLivestreamScreen().add(comment);

        if (comments.size() > 13) {
            JLabel removed = comments.remove(comments.size() - 1);
            cardLayoutPanel.getLivestreamScreen().remove(removed);
        }

        repositionComments();
        cardLayoutPanel.getLivestreamScreen().repaint();
    }

    private void repositionComments() {
        int startY = 110;
        int centerX = 606;
        for (int i = 0; i < comments.size(); i++) {
            JLabel comment = comments.get(i);
            comment.setLocation(centerX, startY + i * (24 + 1));
        }
    }

    public JButton getBackBtnEndDay() {
        return backBtnEndDay;
    }

    private int aiPlayer() {
        return (int) (Math.random() * 3) + 1;
    }

    public JButton getReturnBtn() {
        return returnBtn;
    }

    public JButton getMiniGameBtn() {
        return miniGameBtn;
    }

    private void buildEditAppScreen() {
        JPanel editScreen = cardLayoutPanel.getEditAppScreen();
        editScreen.removeAll();
        editScreen.setLayout(null);

        // Re-add back button
        JButton backBtnEdit = new JButton();
        backBtnEdit.setBounds(200,85,17,17);
        customizeButton(backBtnEdit);
        backBtnEdit.addActionListener(e -> {
            if (currentClip != null && currentClip.isRunning()) {
                currentClip.stop();
                currentClip.close();
            }
            cardLayoutPanel.showCard("AppScreen");
        });
        customizeButton(backBtnEdit);
        editScreen.add(backBtnEdit);

        winLabel = new JLabel(winsMiniGame + " / 5");
        winLabel.setFont(pressStartFont.deriveFont(18f));
        winLabel.setForeground(Color.GREEN);
        winLabel.setBounds(230, 420, 200, 30);
        editScreen.add(winLabel);

        JButton uploadBtn = new JButton();
        uploadBtn.setBounds(390, 380, 165, 50);
        uploadBtn.addActionListener(ev -> {
            if (winsMiniGame >= 5) {
                JOptionPane.showMessageDialog(editScreen, "Upload complete! You gained " + player.addAura() + " aura");
                winsMiniGame = 0;
                winLabel.setText(winsMiniGame + " / 5");
            }
        });
        customizeButton(uploadBtn);
        editScreen.add(uploadBtn);

        JButton startBtn = new JButton();
        startBtn.setBounds(200,365,150,45);
        startBtn.addActionListener(e -> {
            if (redLine != null) {
                editScreen.remove(redLine);
            }

            redLine = new JPanel();
            redLine.setBackground(Color.decode("#ffcc00"));
            int num = (int)(Math.random() * (500 - 270 + 1)) + 270;
            redLine.setBounds(num, 270, 10, 30);
            editScreen.add(redLine);

            if (blueLine != null) {
                editScreen.remove(blueLine);
            }
            if (blueLineTimer != null && blueLineTimer.isRunning()) {
                blueLineTimer.stop();
            }

            blueLine = new JPanel();
            blueLine.setBackground(Color.decode("#ff3131"));
            blueLine.setBounds(270, 255, 10, 60);
            editScreen.add(blueLine);

            blueLineX = 270;
            blueLineDirection = 1;

            blueLineTimer = new Timer(20, ev -> {
                blueLineX += blueLineDirection * 2;
                if (blueLineX >= 500) {
                    blueLineX = 500;
                    blueLineDirection = -1;
                } else if (blueLineX <= 270) {
                    blueLineX = 270;
                    blueLineDirection = 1;
                }
                blueLine.setBounds(blueLineX, 255, 10, 60);
                editScreen.repaint();
            });
            blueLineTimer.start();

            editScreen.revalidate();
            editScreen.repaint();
        });
        customizeButton(startBtn);
        editScreen.add(startBtn);

        JButton stopBtn = new JButton();
        stopBtn.setBounds(353, 305, 80, 25);
        stopBtn.addActionListener(ev -> {
            if (blueLineTimer != null && blueLineTimer.isRunning()) {
                blueLineTimer.stop();
            }

            if (redLine != null && blueLine != null) {
                int redX = redLine.getX();
                int blueX = blueLine.getX();
                int threshold = 10;

                if (Math.abs(blueX - redX) <= threshold) {
                    if (winsMiniGame < 5) {
                        winsMiniGame++;
                        winLabel.setText(winsMiniGame + " / 5");
                    }
                } else {
                }
            }
        });
        customizeButton(stopBtn);
        editScreen.add(stopBtn);

        JLabel availableLabel = new JLabel(String.valueOf(player.getAds()));
        availableLabel.setFont(pressStartFont.deriveFont(25f));
        availableLabel.setForeground(Color.decode("#5d31b8"));
        availableLabel.setBounds(675, 177, 500, 50);
        editScreen.add(availableLabel);

        JLabel currentLabel = new JLabel(String.valueOf(currentAds));
        currentLabel.setFont(pressStartFont.deriveFont(25f));
        currentLabel.setForeground(Color.decode("#5d31b8"));
        currentLabel.setBounds(675, 290, 500, 50);
        editScreen.add(currentLabel);

        JButton addBtn = new JButton();
        addBtn.setBounds(715, 365, 50, 50);
        addBtn.addActionListener(e -> {
            if (player.getAds() > 0) {
                currentAds++;
                player.addAds(-1);
                availableLabel.setText(String.valueOf(player.getAds()));
                currentLabel.setText(String.valueOf(currentAds));
            }
        });
        customizeButton(addBtn);
        editScreen.add(addBtn);

        JButton subtractBtn = new JButton();
        subtractBtn.setBounds(630, 365, 50, 50);
        subtractBtn.addActionListener(e -> {
            if (currentAds > 0) {
                currentAds--;
                currentLabel.setText(String.valueOf(currentAds));
            }
        });
        customizeButton(subtractBtn);
        editScreen.add(subtractBtn);

        editScreen.revalidate();
        editScreen.repaint();
    }
}
