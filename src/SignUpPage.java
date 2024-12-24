import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUpPage {
    static String password, name, surname;
    static boolean pressed, backButtonPressed;
    public static void signUpPageRun(){
        pressed = false;
        password = "none";
        name = "none";
        JLabel dialogueLabel = new JLabel("Lutfen isminizi ve sifrenizi giriniz");
        JLabel nameLabel = new JLabel("isim");
        JLabel surnameLabel = new JLabel("soyisim");
        JLabel passwordLabel = new JLabel("sifre");
        JButton okButton = new JButton("Ok");
        JLabel warningLabel = new JLabel("bu isim kullanilmaktadir");
        JTextField nameTextField = new JTextField();
        JTextField surnameTextField = new JTextField();
        JPasswordField passwordPasswordField = new JPasswordField();
        JButton backButton = new JButton("geri");

        dialogueLabel.setBounds(130,200,500, 40);
        nameTextField.setBounds(180,300,100, 40);
        surnameTextField.setBounds(220,300,100, 40);
        nameLabel.setBounds(180,250,100, 40);
        surnameLabel.setBounds(220,250,100, 40);
        passwordPasswordField.setBounds(80,300,100, 40);
        passwordLabel.setBounds(80,250,100, 40);
        okButton.setBounds(80,400,100, 40);
        warningLabel.setBounds(80,400,100, 40);
        backButton.setBounds(80,400,100, 40);

        okButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                
                if ((!(nameTextField.getText().length() == (0))) && (!(surnameTextField.getText().length() == (0)))) {
                    System.out.println("(!(nameTextField.getText().equals(null)) && !(surnameTextField.getText().equals(null)))  :  " + (!(nameTextField.getText().equals(null)) && !(surnameTextField.getText().equals(null))));

                    boolean isThereSuchUser = false;
                    if (App.usersInitialized){
                        int id;
                        for (id = 0; (App.users.getNode(id).next != null); id++){
                            if (App.users.getNode(id).user.name.equals(nameTextField.getText())){
                                isThereSuchUser = true;
                            }
                        }
                        if (App.users.getNode(id).user.name.equals(nameTextField.getText())){
                            isThereSuchUser = true;
                        }
                    } /* else {
                        App.usersInitialized = true;
                    } */
                    //        EN SONUNCU KULLANICIYI KONTROL EDEBILIYO MUYUZ KONTROL ET

                    if (!isThereSuchUser){
                        name = nameTextField.getText();
                        surname = surnameTextField.getText();
                        password = new String(passwordPasswordField.getPassword());

                        //
                        System.out.println(password + " :password/name: " + name + " / and surname: " + surname);
                        //
                                
                        createNewUser(name, surname, password);
                        App.usersInitialized = true;
                        //     ?????? ^^^^^^^^

                        SwingMain.mainFrame.setVisible(false);
                        SwingMain.mainFrame.remove(dialogueLabel);
                        SwingMain.mainFrame.remove(nameTextField);
                        SwingMain.mainFrame.remove(surnameTextField);
                        SwingMain.mainFrame.remove(passwordPasswordField);
                        SwingMain.mainFrame.remove(okButton);
                        SwingMain.mainFrame.remove(nameLabel);
                        SwingMain.mainFrame.remove(surnameLabel);
                        SwingMain.mainFrame.remove(passwordLabel);
                        SwingMain.mainFrame.remove(warningLabel);
                        SwingMain.mainFrame.remove(backButton);
                        
                        pressed = true;
                    } else {
                        System.out.println("there is such a user already");
                        SwingMain.mainFrame.setVisible(false);
                        SwingMain.mainFrame.add(warningLabel);
                        SwingMain.mainFrame.setVisible(true);
                    }
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                SwingMain.mainFrame.setVisible(false);
                SwingMain.mainFrame.remove(dialogueLabel);
                SwingMain.mainFrame.remove(nameTextField);
                SwingMain.mainFrame.remove(surnameTextField);
                SwingMain.mainFrame.remove(passwordPasswordField);
                SwingMain.mainFrame.remove(okButton);
                SwingMain.mainFrame.remove(nameLabel);
                SwingMain.mainFrame.remove(surnameLabel);
                SwingMain.mainFrame.remove(passwordLabel);
                SwingMain.mainFrame.remove(warningLabel);
                SwingMain.mainFrame.remove(backButton);
                backButtonPressed = true;
                pressed = true;
            }
        });

        SwingMain.mainFrame.add(dialogueLabel);
        SwingMain.mainFrame.add(nameLabel);
        SwingMain.mainFrame.add(surnameLabel);
        SwingMain.mainFrame.add(passwordLabel);
        SwingMain.mainFrame.add(nameTextField);
        SwingMain.mainFrame.add(surnameTextField);
        SwingMain.mainFrame.add(passwordPasswordField);
        SwingMain.mainFrame.add(okButton);
        SwingMain.mainFrame.add(backButton);

        pressed = false;
        backButtonPressed = false;
        SwingMain.mainFrame.setVisible(true);

        while (!pressed){
            App.wait(50);

            dialogueLabel.setBounds(SwingMain.mainFrame.getWidth()*9/24,SwingMain.mainFrame.getHeight()/5,SwingMain.mainFrame.getWidth()/2, SwingMain.mainFrame.getHeight()/5);
            nameLabel.setBounds(SwingMain.mainFrame.getWidth()*15/48, SwingMain.mainFrame.getHeight()*3/10, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*2/15);
            surnameLabel.setBounds(SwingMain.mainFrame.getWidth()*11/24, SwingMain.mainFrame.getHeight()*3/10, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*2/15);
            passwordLabel.setBounds(SwingMain.mainFrame.getWidth()*29/48, SwingMain.mainFrame.getHeight()*3/10, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*2/15);
            nameTextField.setBounds(SwingMain.mainFrame.getWidth()*15/48, SwingMain.mainFrame.getHeight()*5/12, SwingMain.mainFrame.getWidth()/12, SwingMain.mainFrame.getHeight()*3/60);
            surnameTextField.setBounds(SwingMain.mainFrame.getWidth()*11/24, SwingMain.mainFrame.getHeight()*5/12, SwingMain.mainFrame.getWidth()/12, SwingMain.mainFrame.getHeight()*3/60);
            passwordPasswordField.setBounds(SwingMain.mainFrame.getWidth()*29/48, SwingMain.mainFrame.getHeight()*5/12, SwingMain.mainFrame.getWidth()/12, SwingMain.mainFrame.getHeight()*3/60);
            okButton.setBounds(SwingMain.mainFrame.getWidth()*11/24, SwingMain.mainFrame.getHeight()*6/12, SwingMain.mainFrame.getWidth()/15, SwingMain.mainFrame.getHeight()/20);
            warningLabel.setBounds(SwingMain.mainFrame.getWidth()*20/48, SwingMain.mainFrame.getHeight()*16/24, SwingMain.mainFrame.getWidth(), SwingMain.mainFrame.getHeight()/20);
            backButton.setBounds(SwingMain.mainFrame.getWidth()*11/24, SwingMain.mainFrame.getHeight()*7/12, SwingMain.mainFrame.getWidth()/15, SwingMain.mainFrame.getHeight()/20);


            dialogueLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
            nameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
            surnameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
            passwordLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
            warningLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));

        }

        if (!backButtonPressed){
            LogInPage.logInPageRun();
        } else {
            CustomerPage.customerPageRun();
        }
    }

    public static void createNewUser(String name, String surname, String password){

        System.out.println("users initialized: " + App.usersInitialized);

        if (!App.usersInitialized){
            FileHandler.writeFile((0 + "\n" + name + "\n" + surname + "\n" + password + "\n" + "-,-,-,-,-"), "C:\\CTPdata\\Users\\User0.txt");
            App.users = new UserLinkedListNode(0, name, surname, password, "-,-,-,-,-");
        } else {
            FileHandler.writeFile((App.users.count() + "\n" + name + "\n" + surname + "\n" + password + "\n" + "-,-,-,-,-"), "C:\\CTPdata\\Users\\User" + App.users.count() + ".txt");
            App.users.newUser(name, surname, password);
        }
    }
}
