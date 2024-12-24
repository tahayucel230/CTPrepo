import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;

public class LogInPage {

    static String name, password, continueMode;
    static boolean valid, pressed, end, backButtonPressed;
    static JLabel dialogueLabel;
    static JLabel nameLabel;
    static JLabel passwordLabel;
    static JLabel warningLabel;
    static JButton logInButton;
    static JButton backButton;
    static JTextField nameTextField;
    static JPasswordField passwordPasswordField;
    static int userID;

    public static void logInPageRun(){

        SwingMain.mainFrame.setVisible(false);
        dialogueLabel = new JLabel("Lutfen isminizi ve sifrenizi giriniz");
        nameLabel = new JLabel("isim");
        passwordLabel = new JLabel("sifre");
        logInButton = new JButton("giriş yap");
        nameTextField = new JTextField();
        passwordPasswordField = new JPasswordField();
        warningLabel = new JLabel("Lutfen dogru giris yaptiginizdan emin olunuz");
        backButton = new JButton("geri");

        dialogueLabel.setBounds(130,200,500, 40);
        nameTextField.setBounds(180,300,100, 40);
        nameLabel.setBounds(180,250,100, 40);
        passwordPasswordField.setBounds(80,300,100, 40);
        passwordLabel.setBounds(80,250,100, 40);
        logInButton.setBounds(80,400,100, 40);
        warningLabel.setBounds(130,100,500, 40);
        backButton.setBounds(130,150,500, 40);

        logInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                pressed = true;
            }
        });
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                pressed = true;
                backButtonPressed = true;
            }
        });

        SwingMain.mainFrame.add(dialogueLabel);
        SwingMain.mainFrame.add(nameLabel);
        SwingMain.mainFrame.add(passwordLabel);
        SwingMain.mainFrame.add(logInButton);
        SwingMain.mainFrame.add(nameTextField);
        SwingMain.mainFrame.add(passwordPasswordField);
        SwingMain.mainFrame.add(backButton);

        valid = false;
        continueMode = "none";
        while (!valid){
            pressed = false;
            backButtonPressed = false;
            SwingMain.mainFrame.setVisible(true);

            while (!pressed){
                App.wait(50);

                dialogueLabel.setBounds(SwingMain.mainFrame.getWidth()*9/24,SwingMain.mainFrame.getHeight()/5,SwingMain.mainFrame.getWidth()/2, SwingMain.mainFrame.getHeight()/5);
                nameTextField.setBounds(SwingMain.mainFrame.getWidth()*9/24, SwingMain.mainFrame.getHeight()*5/12, SwingMain.mainFrame.getWidth()/12, SwingMain.mainFrame.getHeight()*3/60);
                nameLabel.setBounds(SwingMain.mainFrame.getWidth()*9/24, SwingMain.mainFrame.getHeight()*3/10, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*2/15);
                passwordPasswordField.setBounds(SwingMain.mainFrame.getWidth()/2, SwingMain.mainFrame.getHeight()*5/12, SwingMain.mainFrame.getWidth()/12, SwingMain.mainFrame.getHeight()*3/60);
                passwordLabel.setBounds(SwingMain.mainFrame.getWidth()/2, SwingMain.mainFrame.getHeight()*3/10, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*2/15);
                logInButton.setBounds(SwingMain.mainFrame.getWidth()*9/24, SwingMain.mainFrame.getHeight()/2, SwingMain.mainFrame.getWidth()/12, SwingMain.mainFrame.getHeight()*3/60);
                warningLabel.setBounds(SwingMain.mainFrame.getWidth()*9/24, SwingMain.mainFrame.getHeight()*7/12, SwingMain.mainFrame.getWidth()/2, SwingMain.mainFrame.getHeight()*3/60);
                backButton.setBounds(SwingMain.mainFrame.getWidth()/2, SwingMain.mainFrame.getHeight()/2, SwingMain.mainFrame.getWidth()/12, SwingMain.mainFrame.getHeight()*3/60);

                dialogueLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
                nameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
                passwordLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
                warningLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));

            }

            if (!backButtonPressed){
                name = nameTextField.getText();
                password = new String(passwordPasswordField.getPassword());

                end = false;
                for (userID = 0; end == false; userID++){
                    
                    //
                    System.out.println("test7 userID: " + userID + "null?" + (App.users.getNode(userID).next == null));
                    App.wait(100);
                    //

                    if ((App.users.getNode(userID).user.name).equals(name) && (App.users.getNode(userID).user.password).equals(password)){
                        SwingMain.mainFrame.setVisible(false);
                        end = true;
                        valid = true;
                        continueMode = "log in info ready";
                    } else if (App.users.getNode(userID).next == null){
                        end = true;
                        SwingMain.mainFrame.setVisible(false);
                        SwingMain.mainFrame.add(warningLabel);
                    }
                }
            } else {
                SwingMain.mainFrame.setVisible(false);
                valid = true;
                continueMode = "back";
            }
        }

        if (continueMode.equals("log in info ready")){
            SwingMain.mainFrame.remove(dialogueLabel);
            SwingMain.mainFrame.remove(nameLabel);
            SwingMain.mainFrame.remove(passwordLabel);
            SwingMain.mainFrame.remove(logInButton);
            SwingMain.mainFrame.remove(nameTextField);
            SwingMain.mainFrame.remove(passwordPasswordField);
            SwingMain.mainFrame.remove(warningLabel);
            SwingMain.mainFrame.remove(backButton);
            UserMenu.userMenuRun(name);
        } else if(continueMode.equals("back")){
            SwingMain.mainFrame.remove(dialogueLabel);
            SwingMain.mainFrame.remove(nameLabel);
            SwingMain.mainFrame.remove(passwordLabel);
            SwingMain.mainFrame.remove(logInButton);
            SwingMain.mainFrame.remove(nameTextField);
            SwingMain.mainFrame.remove(passwordPasswordField);
            SwingMain.mainFrame.remove(warningLabel);
            SwingMain.mainFrame.remove(backButton);
            CustomerPage.customerPageRun();
        } else {
            System.out.println("error");
        }
    }
}
