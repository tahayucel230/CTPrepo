import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.*;

public class UserMenu {
    static User currentUser;
    static String pressed;
    public static void userMenuRun(String name){
        
        //
        System.out.println("user menu stuff: " + name);
        //

        SwingMain.mainFrame.setVisible(false);

        int userID;
        boolean userFound = false;
        for (userID = 0; userID < App.users.count(); userID++){
            if (App.users.getNode(userID).user.name.equals(name)){
                userFound = true;
                currentUser = App.users.getNode(userID).user;
            }
        }

        if (userFound){

            if (FileHandler.userFileExists(name)){
                pressed = "none";
                JButton newCargoButton = new JButton("yeni kargo");
                JButton seeCargoHistoryButton = new JButton("kargo gecmisini gor");
                JLabel nameLabel = new JLabel(name);

                newCargoButton.setBounds(130,200,500, 40);
                seeCargoHistoryButton.setBounds(130,300,500, 40);
                nameLabel.setBounds(130,100,500, 40);

                SwingMain.mainFrame.add(newCargoButton);
                SwingMain.mainFrame.add(seeCargoHistoryButton);
                SwingMain.mainFrame.add(nameLabel);

                newCargoButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        pressed = "new cargo button";
                    }
                });
                seeCargoHistoryButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        pressed = "see cargo history button";
                    }
                });

                SwingMain.mainFrame.setVisible(true);
                
                pressed = "none";
                while ((!(pressed.equals("see cargo history button") && App.cargosInitialized)) && !pressed.equals("new cargo button")){
                    App.wait(50);

                    nameLabel.setBounds(SwingMain.mainFrame.getWidth()*11/24, SwingMain.mainFrame.getHeight()*5/20, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*2/15);
                    newCargoButton.setBounds(SwingMain.mainFrame.getWidth()*10/24, SwingMain.mainFrame.getHeight()*8/20, SwingMain.mainFrame.getWidth()/8, SwingMain.mainFrame.getHeight()*3/60);
                    seeCargoHistoryButton.setBounds(SwingMain.mainFrame.getWidth()*10/24, SwingMain.mainFrame.getHeight()*10/20, SwingMain.mainFrame.getWidth()/8, SwingMain.mainFrame.getHeight()*3/60);

                    nameLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));

                }

                SwingMain.mainFrame.setVisible(false);
                SwingMain.mainFrame.remove(newCargoButton);
                SwingMain.mainFrame.remove(seeCargoHistoryButton);
                SwingMain.mainFrame.remove(nameLabel);

                if (pressed.equals("new cargo button")){
                    NewCargoPage.newCargoPageRun(currentUser);
                } else if (pressed.equals("see cargo history button") && App.cargosInitialized){
                    SeeCargoHistoryPage.seeCargoHistoryPageRun(currentUser);
                } else {
                    System.out.println("error no button pressed");
                }

            } else {
                System.out.println("error user file not found");
            }

        } else {
            System.out.println("error user not found");
        }
    }
}
