import java.awt.event.*;
import javax.swing.*;
import java.awt.Font;

public class IntroPage {
    static String response;
    public static String runIntroPage(){
        
        while(!SwingMain.mainFrameReady){
            System.out.println("testing2");
        }

        //
        //System.out.println("testing3");
        //

        SwingMain.mainFrame.setVisible(false);

        JLabel dialogueLabel = new JLabel("Lutfen giris modunuzu seciniz.");
        JButton workerLoginButton = new JButton("Calisan");
        JButton customerLoginButton = new JButton("Musteri");
        dialogueLabel.setBounds(130,200,500, 40);
        workerLoginButton.setBounds(180,300,100, 40);
        customerLoginButton.setBounds(80,300,100, 40);
        workerLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                if (App.cargosInitialized){
                    response = "worker";
                }
            }
        });
        customerLoginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                response = "customer";
            }
        });

        SwingMain.mainFrame.add(dialogueLabel);
        SwingMain.mainFrame.add(workerLoginButton);
        SwingMain.mainFrame.add(customerLoginButton);

        response = "none";
        SwingMain.mainFrame.setVisible(true);

        while (response.equals("none")){

            App.wait(50);

            dialogueLabel.setBounds(SwingMain.mainFrame.getWidth()*9/24,SwingMain.mainFrame.getHeight()/5,SwingMain.mainFrame.getWidth()/2, SwingMain.mainFrame.getHeight()/5);
            workerLoginButton.setBounds(SwingMain.mainFrame.getWidth()/5, SwingMain.mainFrame.getHeight()*2/5, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*2/15);
            customerLoginButton.setBounds(SwingMain.mainFrame.getWidth()/2, SwingMain.mainFrame.getHeight()*2/5, SwingMain.mainFrame.getWidth()/4, SwingMain.mainFrame.getHeight()*2/15);
            dialogueLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, SwingMain.mainFrame.getHeight()/30));

        }

        SwingMain.mainFrame.remove(dialogueLabel);
        SwingMain.mainFrame.remove(workerLoginButton);
        SwingMain.mainFrame.remove(customerLoginButton);

        SwingMain.mainFrame.setVisible(false);
        if (response.equals("customer")){
            return "customer";
        } else if (response.equals("worker")){
            return "worker";
        } else {
            return "none";
        }
    }
}
