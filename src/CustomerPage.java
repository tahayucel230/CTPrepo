import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;

public class CustomerPage {
    
    //
    public static String logInSignUp;    
    //

    public static void customerPageRun(){
        //System.out.println("customerpagethings\n");
        
        JLabel dialogueLabel = new JLabel("kayit olun veya giris yapin");
        JButton logInButton = new JButton("giris yap");
        JButton signUpButton = new JButton("kayit ol");
        /* JButton backButton = new JButton("geri"); */

        dialogueLabel.setBounds(130,200,500, 40);
        logInButton.setBounds(180,300,100, 40);
        signUpButton.setBounds(80,300,100, 40);
        /* backButton.setBounds(130,400,100, 40); */
        logInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                logInSignUp = "giris yap";
            }
        });
        signUpButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                logInSignUp = "kayit ol";
            }
        });
        /* backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                logInSignUp = "geri";
            }
        }); */

        SwingMain.mainFrame.add(dialogueLabel);
        SwingMain.mainFrame.add(logInButton);
        SwingMain.mainFrame.add(signUpButton);
        /* SwingMain.mainFrame.add(backButton); */

        logInSignUp = "none";
        SwingMain.mainFrame.setVisible(true);

        while (!(logInSignUp.equals("kayit ol")) && !(logInSignUp.equals("giris yap")) && !(logInSignUp.equals("geri"))){

            App.wait(50);

            dialogueLabel.setBounds(SwingMain.mainFrame.getWidth()*9/24,SwingMain.mainFrame.getHeight()/5,SwingMain.mainFrame.getWidth()/2, SwingMain.mainFrame.getHeight()/5);
            logInButton.setBounds(SwingMain.mainFrame.getWidth()/5, SwingMain.mainFrame.getHeight()*2/5, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*2/15);
            signUpButton.setBounds(SwingMain.mainFrame.getWidth()/2, SwingMain.mainFrame.getHeight()*2/5, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*2/15);
            /* backButton.setBounds(SwingMain.mainFrame.getWidth()*35/100, SwingMain.mainFrame.getHeight()*3/5, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*2/15); */
            dialogueLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
        }

        SwingMain.mainFrame.setVisible(false);
        SwingMain.mainFrame.remove(signUpButton);
        SwingMain.mainFrame.remove(logInButton);
        SwingMain.mainFrame.remove(dialogueLabel);
        /* SwingMain.mainFrame.remove(backButton); */

        if (logInSignUp.equals("giris yap") && App.usersInitialized){
            LogInPage.logInPageRun();
        } else if (logInSignUp.equals("kayit ol")){
            SignUpPage.signUpPageRun();
        }/*  else if (logInSignUp.equals("geri")){
            IntroPage.runIntroPage();
        } */ else {
            System.out.println("error");
        }
    }
}