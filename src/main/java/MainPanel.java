import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    private ChromeDriver driver;


    private JButton searchButton;
    private JTextField searchTextField;

    private Font buttonFont;

    private JButton filter1Button;
    private JButton filter2Button;
    private JButton filter3Button;
    private JButton filter4Button;
    private JButton filter5Button;
    private JButton filter6Button;


    public MainPanel(int x, int y, int width, int height) {
        this.setLayout(null);
        this.setBounds(x, y, width, height);
        buildPanel();
        this.buttonFont = new Font("David", Font.BOLD, Constants.BUTTON_FONT_SIZE);


        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\tehil\\Downloads\\chromedriver_win32\\chromedriver.exe");



        this.searchButton.addActionListener((e -> {
            this.driver = new ChromeDriver();
            this.driver.get("https://www.facebook.com/" + this.searchTextField.getText()); //split with " " and add .
        }));
    }


    private void buildPanel() {
        this.searchTextField = new JTextField();
        this.searchTextField.setBounds((Constants.WINDOW_WIDTH - (Constants.BUTTON_WIDTH / 2))/ 2, Constants.WINDOW_HEIGHT / 10, Constants.BUTTON_WIDTH / 2, Constants.BUTTON_HEIGHT);
        this.add(this.searchTextField);


        this.searchButton = new JButton();
        this.searchButton.setBounds(this.searchTextField.getX() + this.searchTextField.getWidth(), this.searchTextField.getY(), Constants.BUTTON_WIDTH / 2, Constants.BUTTON_HEIGHT);
        this.searchButton.setText("search");
        this.searchButton.setFont(this.buttonFont);
        this.add(this.searchButton);


        this.filter1Button = new JButton();
        this.filter1Button.setBounds(this.searchTextField.getX(), this.searchTextField.getY() + Constants.BUTTON_HEIGHT + Constants.SPACE, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.filter1Button.setText("Filter1");
        this.filter1Button.setFont(this.buttonFont);
        this.add(this.filter1Button);

        this.filter2Button = new JButton();
        this.filter2Button.setBounds(this.searchTextField.getX(), this.filter1Button.getY() + Constants.BUTTON_HEIGHT + Constants.SPACE, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.filter2Button.setText("Filter2");
        this.filter2Button.setFont(this.buttonFont);
        this.add(this.filter2Button);

        this.filter3Button = new JButton();
        this.filter3Button.setBounds(this.searchTextField.getX(), this.filter2Button.getY() + Constants.BUTTON_HEIGHT + Constants.SPACE, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.filter3Button.setText("Filter3");
        this.filter3Button.setFont(this.buttonFont);
        this.add(this.filter3Button);

        this.filter4Button = new JButton();
        this.filter4Button.setBounds(this.searchTextField.getX(), this.filter3Button.getY() + Constants.BUTTON_HEIGHT + Constants.SPACE, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.filter4Button.setText("Filter4");
        this.filter4Button.setFont(this.buttonFont);
        this.add(this.filter4Button);

        this.filter5Button = new JButton();
        this.filter5Button.setBounds(this.searchTextField.getX(), this.filter4Button.getY() + Constants.BUTTON_HEIGHT + Constants.SPACE, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.filter5Button.setText("Filter5");
        this.filter5Button.setFont(this.buttonFont);
        this.add(this.filter5Button);

        this.filter6Button = new JButton();
        this.filter6Button.setBounds(this.searchTextField.getX(), this.filter5Button.getY() + Constants.BUTTON_HEIGHT + Constants.SPACE, Constants.BUTTON_WIDTH, Constants.BUTTON_HEIGHT);
        this.filter6Button.setText("Filter6");
        this.filter6Button.setFont(this.buttonFont);
        this.add(this.filter6Button);

    }
}
