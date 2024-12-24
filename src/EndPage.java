import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EndPage {
    static boolean pressed, exit;
    
    public static boolean runEndPage(){
        SwingMain.mainFrame.setVisible(false);

        JLabel dialogue1Label = new JLabel("Islemleriniz gerceklestirildi");
        JLabel dialogue2Label = new JLabel("Ana Menuye donebilir veya uygulamayi kapatabilirsiniz");
        JButton exitButton = new JButton("cikis");
        JButton menuButton = new JButton("menu");

        dialogue1Label.setBounds(400,50, 300, 40);
        dialogue2Label.setBounds(400, 125, 300, 40);
        exitButton.setBounds(400, 400, 300, 40);
        menuButton.setBounds(400, 200, 300, 40);

        SwingMain.mainFrame.add(dialogue1Label);
        SwingMain.mainFrame.add(dialogue2Label);
        SwingMain.mainFrame.add(exitButton);
        SwingMain.mainFrame.add(menuButton);

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                SwingMain.mainFrame.setVisible(false);
                pressed = true;
                exit = true;
            }
        });
        menuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                SwingMain.mainFrame.setVisible(false);
                pressed = true;
                exit = false;
            }
        });

        SwingMain.mainFrame.setVisible(true);
        pressed = false;
        exit = true;
        while (!pressed){
            App.wait(100);

            dialogue1Label.setBounds(SwingMain.mainFrame.getWidth()*17/48, SwingMain.mainFrame.getHeight()*10/40, SwingMain.mainFrame.getWidth(), SwingMain.mainFrame.getHeight()*2/15);
            dialogue2Label.setBounds(SwingMain.mainFrame.getWidth()*17/48, SwingMain.mainFrame.getHeight()*13/40, SwingMain.mainFrame.getWidth(), SwingMain.mainFrame.getHeight()*2/15);
            menuButton.setBounds(SwingMain.mainFrame.getWidth()*17/48, SwingMain.mainFrame.getHeight()*18/40, SwingMain.mainFrame.getWidth()/5, SwingMain.mainFrame.getHeight()/20);
            exitButton.setBounds(SwingMain.mainFrame.getWidth()*17/48, SwingMain.mainFrame.getHeight()*21/40, SwingMain.mainFrame.getWidth()/5, SwingMain.mainFrame.getHeight()/20);

            dialogue1Label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));
            dialogue2Label.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));

        }

        SwingMain.mainFrame.remove(dialogue1Label);
        SwingMain.mainFrame.remove(dialogue2Label);
        SwingMain.mainFrame.remove(menuButton);
        SwingMain.mainFrame.remove(exitButton);
        return exit;
    }
}
