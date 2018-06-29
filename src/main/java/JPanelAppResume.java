import javax.swing.*;
import java.awt.*;

public class JPanelAppResume extends JPanel {
    public static  JPanel panelResume = new JPanel();
    public JPanelAppResume(){

        panelResume.setLayout(null);
        panelResume.setBounds(50, 50, 400,500);
        JLabel title = new JLabel("Список подходящих резюме");
        title.setBounds(80,30, 300, 30);
        title.setFont(new Font("Serif",Font.BOLD,20));
        panelResume.add(title);

    }

}
