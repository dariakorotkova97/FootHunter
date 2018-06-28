import javax.swing.*;

public class JFrameApp extends JFrame{
    public JFrameApp(){

        setBounds(400,30,500,600);
        setTitle("HeadHunter");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new JPanelApp());
        setVisible(true);
        setResizable(false);
    }
}

