import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class JPanelApp extends JPanel{

    public static JFrame jFrame = new JFrame();
    static String TextSkils;
    static int flag = 0;
    static int N = 0;
    static String from;
    static String to;

    public JPanelApp(){
        setLayout(null);

        JLabel title = new JLabel("HeadHunter");
        title.setBounds(180,30, 200, 35);
        title.setFont(new Font("Serif",Font.BOLD,30));
        add(title);

        final JLabel skilsLabel = new JLabel("Ключевые навыки");
        skilsLabel.setBounds(50,127, 200, 30);
        skilsLabel.setFont(new Font("Serif",Font.PLAIN,20));
        add(skilsLabel);

        JLabel experienceLabel = new JLabel("Опыт");
        experienceLabel.setBounds(50,187, 100, 30);
        experienceLabel.setFont(new Font("Serif",Font.PLAIN,20));
        add(experienceLabel);

        final TextField skilsText = new TextField();
        skilsText.setBounds(250,130,180,30);
        add(skilsText);

        final JRadioButton skilsRB1 = new JRadioButton("нет опыта", false);
        skilsRB1.setBounds(250,187, 190, 30);
        skilsRB1.setFont(new Font("Serif",Font.PLAIN,16));
        add(skilsRB1);

        final JRadioButton skilsRB2 = new JRadioButton("от 1 года до 3 лет", false);
        skilsRB2.setBounds(250,217, 190, 30);
        skilsRB2.setFont(new Font("Serif",Font.PLAIN,16));
        add(skilsRB2);

        final JRadioButton skilsRB3 = new JRadioButton("от 3 лет до 6 лет", false);
        skilsRB3.setBounds(250,247, 190, 30);
        skilsRB3.setFont(new Font("Serif",Font.PLAIN,16));
        add(skilsRB3);

        final JRadioButton skilsRB4 = new JRadioButton("более 6 лет", false);
        skilsRB4.setBounds(250,277, 190, 30);
        skilsRB4.setFont(new Font("Serif",Font.PLAIN,16));
        add(skilsRB4);

        JLabel salaryLabel = new JLabel("Зарплата");
        salaryLabel.setBounds(50,320, 90, 30);
        salaryLabel.setFont(new Font("Serif",Font.PLAIN,20));
        add(salaryLabel);

        JLabel showLabel = new JLabel("Количество работников");
        showLabel.setBounds(50,390, 210, 30);
        showLabel.setFont(new Font("Serif",Font.PLAIN,20));
        add(showLabel);

        JLabel fromLabel = new JLabel("от");
        fromLabel.setBounds(250,320, 20, 30);
        fromLabel.setFont(new Font("Serif",Font.PLAIN,20));
        add(fromLabel);

        final TextField salaryTextFrom = new TextField();
        salaryTextFrom.setBounds(280,320,60,30);
        add(salaryTextFrom);

        JLabel toLabel = new JLabel("до");
        toLabel.setBounds(360,320, 20, 30);
        toLabel.setFont(new Font("Serif",Font.PLAIN,20));
        add(toLabel);

        final TextField salaryTextTo = new TextField();
        salaryTextTo.setBounds(390,320,60,30);
        add(salaryTextTo);

        final TextField showText = new TextField();
        showText.setBounds(280,390,60,30);
        add(showText);

        JButton search = new JButton("Найти");
        search.setBounds(330,470, 120, 50);
        search.setFont(new Font("Serif",Font.PLAIN,20));
        add(search);

        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    JPanel panelResume =new JPanelAppResume();
                    if (skilsRB1.isSelected()) flag =1;
                    if (skilsRB2.isSelected()) flag =2;
                    if (skilsRB3.isSelected()) flag =3;
                    if (skilsRB4.isSelected()) flag =4;
                    from = salaryTextFrom.getText();
                    to = salaryTextTo.getText();
                    TextSkils = skilsText.getText();
                    N = Integer.parseInt(showText.getText());
                    jFrame.setBounds(400,30,500,600);
                    jFrame.setTitle("Результаты поиска");
                    jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                    jFrame.add(JPanelAppResume.panelResume);
                    jFrame.setResizable(false);
                    SearchBase.searchData();
                    jFrame.setVisible(true);

                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });

      // final Panel labPanel = new Panel();
       // final JScrollPane scrollPane = new JScrollPane(labPanel);
       //labPanel.setLayout(new BoxLayout(labPanel, BoxLayout.Y_AXIS));

    }

}
