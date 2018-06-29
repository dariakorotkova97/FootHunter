import javax.swing.*;

public class JFrameApp extends JFrame{

    public static JFrame frame = new JFrame();

    public JFrameApp(){
        frame.setBounds(400,30,500,600);
        frame.setTitle("HeadHunter");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(new JPanelApp());
        frame.setVisible(true);
        frame.setResizable(false);
    }
}

