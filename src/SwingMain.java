import javax.swing.*;
public class SwingMain {

    public static JFrame mainFrame;
    public static boolean mainFrameReady;
    public static void startSwing(){
        mainFrame = new JFrame("CTP");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrameReady = true;
        mainFrame.setSize(1500,800);
        mainFrame.setLayout(null);
        mainFrame.setResizable(true);
    }
    public static void stopSwing(){
        mainFrame.dispose();
    }
}
