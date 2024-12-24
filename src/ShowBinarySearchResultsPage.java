import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ShowBinarySearchResultsPage {
    static boolean pressed;
    public static void showBinarySearchResultsPageRun(int[] cargoIDs, int foundIndex){
        SwingMain.mainFrame.setVisible(false);

        JLabel resultsLabel = new JLabel("aratilan " + cargoIDs[foundIndex] + " id'sinin listedeki sirasi: " + (foundIndex+1) + " bu konumdaki urun: " + App.cargos.getNode(cargoIDs[foundIndex]).cargo.productName);
        JButton exitButton = new JButton("cikis");
        
        resultsLabel.setBounds(400, 250, 700, 40);
        exitButton.setBounds(400, 350, 700, 40);
        
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                SwingMain.mainFrame.setVisible(false);
                pressed = true;
            }
        });

        SwingMain.mainFrame.add(exitButton);
        SwingMain.mainFrame.add(resultsLabel);

        SwingMain.mainFrame.setVisible(true);

        pressed = false;
        while(!pressed){
            App.wait(100);

            resultsLabel.setBounds(SwingMain.mainFrame.getWidth()/8, SwingMain.mainFrame.getHeight()*13/40, SwingMain.mainFrame.getWidth(), SwingMain.mainFrame.getHeight()*2/15);
            exitButton.setBounds(SwingMain.mainFrame.getWidth()/8, SwingMain.mainFrame.getHeight()*19/40, SwingMain.mainFrame.getWidth()/5, SwingMain.mainFrame.getHeight()/20);

            resultsLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));


        }

        SwingMain.mainFrame.remove(exitButton);
        SwingMain.mainFrame.remove(resultsLabel);
    }
}
