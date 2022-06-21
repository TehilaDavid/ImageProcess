import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainPanel extends JPanel {

    private ChromeDriver driver;


    private JButton searchButton;
    private JTextField searchTextField;

    private Font buttonFont;
    private ImageIcon bob;
    private ImageIcon bobFiltered;

    private JButton colorShiftRight;
    private JButton colorShiftLeft;
    private JButton grayscale;
    private JButton negative;
    private JButton sepia;
    private JButton lighter;

    private boolean click;
    private BufferedImage spongeBob;


    public MainPanel(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        buildPanel();


        this.buttonFont = new Font("David", Font.BOLD, Constants.BUTTON_FONT_SIZE);

        File file = new File("SpongeBob.jpg");
        try {
            this.spongeBob = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        System.setProperty("webdriver.chrome.driver",
//                "C:\\Users\\tehil\\Downloads\\chromedriver_win32\\chromedriver.exe");
//
//
//
//        this.searchButton.addActionListener((e -> {
//            this.driver = new ChromeDriver();
//            this.driver.get("https://www.facebook.com/" + this.searchTextField.getText()); //split with " " and add .
//        }));

        this.colorShiftRight.addActionListener((e -> {
            colorShiftRightOrLeft(true);
        }));

        this.colorShiftLeft.addActionListener((e -> {
            colorShiftRightOrLeft(false);
        }));

        this.grayscale.addActionListener((e -> {
            grayscale();
        }));

        this.negative.addActionListener((e -> {
            negative();
        }));

        this.sepia.addActionListener((e -> {
            sepia();
        }));

        this.lighter.addActionListener((e -> {
            lighter();
        }));
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

//        this.bob = new ImageIcon("SpongeBob.jpg");
//        this.bob.paintIcon(this, g, 30, 30);


        URL url = null;
        try {
            url = new URL("https://scontent.ftlv2-1.fna.fbcdn.net/v/t31.18172-8/13495603_10208804454302325_4957734764946397361_o.jpg?_nc_cat=104&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=1D8lt6BoBRkAX-rEH-p&_nc_ht=scontent.ftlv2-1.fna&oh=00_AT_XHN9X0tLdxwAk_RCueDVRJM0T4Ip-nu1Kebxs-6_wbQ&oe=62D5E22B");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        BufferedImage image = null;
        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon imageIcon = new ImageIcon(image);

        imageIcon.paintIcon(this, g, 30, 30);


//        this.bobFiltered = new ImageIcon("SpongeBob - Copy.jpg");
//        this.bobFiltered.paintIcon(this, g, this.searchButton.getX() + this.searchButton.getWidth() + 30, 30);
    }


    private void buildPanel() {
        this.searchTextField = new JTextField();
        this.searchTextField.setBounds((Constants.WINDOW_WIDTH / 2 - (Constants.BUTTON_WIDTH / 2)), Constants.WINDOW_HEIGHT / 10, Constants.BUTTON_WIDTH / 2, Constants.BUTTON_HEIGHT);
        this.add(this.searchTextField);


        this.searchButton = new JButton();
        this.searchButton.setBounds(this.searchTextField.getX() + this.searchTextField.getWidth(), this.searchTextField.getY(), Constants.BUTTON_WIDTH / 2, Constants.BUTTON_HEIGHT);
        this.searchButton.setText("search");
        this.searchButton.setFont(this.buttonFont);
        this.add(this.searchButton);


        this.colorShiftRight = new JButton();
        this.colorShiftRight.setBounds(this.searchTextField.getX(), this.searchTextField.getY() + Constants.BUTTON_HEIGHT + Constants.SPACE, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.colorShiftRight.setText("Color Shift Right");
        this.colorShiftRight.setFont(this.buttonFont);
        this.add(this.colorShiftRight);

        this.colorShiftLeft = new JButton();
        this.colorShiftLeft.setBounds(this.searchTextField.getX(), this.colorShiftRight.getY() + Constants.BUTTON_HEIGHT + Constants.SPACE, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.colorShiftLeft.setText("Color Shift Left");
        this.colorShiftLeft.setFont(this.buttonFont);
        this.add(this.colorShiftLeft);

        this.grayscale = new JButton();
        this.grayscale.setBounds(this.searchTextField.getX(), this.colorShiftLeft.getY() + Constants.BUTTON_HEIGHT + Constants.SPACE, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.grayscale.setText("Grayscale");
        this.grayscale.setFont(this.buttonFont);
        this.add(this.grayscale);

        this.negative = new JButton();
        this.negative.setBounds(this.searchTextField.getX(), this.grayscale.getY() + Constants.BUTTON_HEIGHT + Constants.SPACE, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.negative.setText("Negative");
        this.negative.setFont(this.buttonFont);
        this.add(this.negative);

        this.sepia = new JButton();
        this.sepia.setBounds(this.searchTextField.getX(), this.negative.getY() + Constants.BUTTON_HEIGHT + Constants.SPACE, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.sepia.setText("Sepia");
        this.sepia.setFont(this.buttonFont);
        this.add(this.sepia);

        this.lighter = new JButton();
        this.lighter.setBounds(this.searchTextField.getX(), this.sepia.getY() + Constants.BUTTON_HEIGHT + Constants.SPACE, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.lighter.setText("Lighter");
        this.lighter.setFont(this.buttonFont);
        this.add(this.lighter);

    }

    private void colorShiftRightOrLeft(boolean isRight) {
        try {
            for (int x = 0; x < this.spongeBob.getWidth(); x++) {
                for (int y = 0; y < this.spongeBob.getHeight(); y++) {
                    int current = this.spongeBob.getRGB(x, y);
                    Color pixel = new Color(current);

                    int red;
                    int green;
                    int blue;
                    if (isRight) {
                        red = pixel.getGreen();
                        green = pixel.getBlue();
                        blue = pixel.getRed();
                    } else {
                        red = pixel.getBlue();
                        green = pixel.getRed();
                        blue = pixel.getGreen();
                    }


                    Color newColor = new Color(red, green, blue);

                    this.spongeBob.setRGB(x, y, newColor.getRGB());
                }
            }

            File file1 = new File("SpongeBob - Copy.jpg");
            ImageIO.write(spongeBob, "jpg", file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void grayscale() {
        try {
            for (int x = 0; x < this.spongeBob.getWidth(); x++) {
                for (int y = 0; y < this.spongeBob.getHeight(); y++) {
                    int current = this.spongeBob.getRGB(x, y);
                    Color pixel = new Color(current);

                    int red = pixel.getRed();
                    int green = pixel.getGreen();
                    int blue = pixel.getBlue();
                    int pixel2 = (red + green + blue) / 3;

                    Color newColor = new Color(pixel2, pixel2, pixel2);

                    this.spongeBob.setRGB(x, y, newColor.getRGB());
                }
            }

            File file1 = new File("SpongeBob - Copy.jpg");
            ImageIO.write(this.spongeBob, "jpg", file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void negative() {
        for (int j = 0; j < this.spongeBob.getHeight(); j++) {
            for (int i = 0; i < this.spongeBob.getWidth(); i++) {
                Color currentColor = new Color(this.spongeBob.getRGB(i, j));
                Color negativeColor = new Color(255 - currentColor.getRed(), 255 - currentColor.getGreen(), 255 - currentColor.getBlue());
                this.spongeBob.setRGB(i, j, negativeColor.getRGB());
            }
        }
        File file1 = new File("SpongeBob - Copy.jpg");
        try {
            ImageIO.write(this.spongeBob, "jpg", file1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void sepia() {
        try {
            for (int x = 0; x < this.spongeBob.getWidth(); x++) {
                for (int y = 0; y < this.spongeBob.getHeight(); y++) {
                    int current = this.spongeBob.getRGB(x, y);
                    Color pixel = new Color(current);

                    int red = (int) ((0.393 * pixel.getRed()) + (0.769 * pixel.getRed()) + (0.189 * pixel.getBlue()));
                    int green = (int) ((0.349 * pixel.getRed()) + (0.686 * pixel.getRed()) + (0.168 * pixel.getBlue()));
                    int blue = (int) ((0.272 * pixel.getRed()) + (0.534 * pixel.getRed()) + (0.131 * pixel.getBlue()));

                    Color newColor = new Color(intenseColor(red), intenseColor(green), intenseColor(blue));

                    this.spongeBob.setRGB(x, y, newColor.getRGB());
                }
            }

            File file1 = new File("SpongeBob - Copy.jpg");
            ImageIO.write(spongeBob, "jpg", file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void lighter() {
        try {
            for (int x = 0; x < this.spongeBob.getWidth(); x++) {
                for (int y = 0; y < this.spongeBob.getHeight(); y++) {
                    int current = this.spongeBob.getRGB(x, y);
                    Color pixel = new Color(current);

                    int red = intenseColor(pixel.getRed() * 2);
                    int green = intenseColor(pixel.getGreen() * 2);
                    int blue = intenseColor(pixel.getBlue() * 2);

                    Color newColor = new Color(red, green, blue);

                    this.spongeBob.setRGB(x, y, newColor.getRGB());
                }
            }

            File file1 = new File("SpongeBob - Copy.jpg");
            ImageIO.write(spongeBob, "jpg", file1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int intenseColor(int originalColor) {
        if (originalColor > 255) {
            originalColor = 255;
        }
        return originalColor;
    }


}

