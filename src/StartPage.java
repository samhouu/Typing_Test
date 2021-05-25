import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class StartPage implements ActionListener{

    JFrame f;
    JButton startb,aboutb,helpb;
    JLabel title,bg;
    JMenuBar mb;
    JMenu start;
    JMenuItem about,play,help;


    StartPage(){
        f = new JFrame("Typing Test");

        ImageIcon strtb1 = new ImageIcon("starthome.png");
        startb = new JButton(strtb1);
        startb.setBackground(Color.white);
        startb.setBorderPainted(false);
        startb.setBounds(350,350,120,50);
        //startb.setContentAreaFilled(false);

        ImageIcon helpicon = new ImageIcon("helphome.png");
        helpb = new JButton(helpicon);
        helpb.setBackground(Color.white);
        helpb.setBorderPainted(false);
        helpb.setBounds(350,420,120,50);

        ImageIcon abouticon = new ImageIcon("abouthome.png");
        aboutb = new JButton(abouticon);
        aboutb.setBackground(Color.white);
        aboutb.setBorderPainted(false);
        aboutb.setBounds(350,490,120,50);

        mb = new JMenuBar();
        start = new JMenu("Start");
        help = new JMenuItem("Help");
        about = new JMenuItem("About");
        play = new JMenuItem("Play");

        mb.add(start);
        start.add(play);start.add(help);start.add(about);

        play.addActionListener(this);
        help.addActionListener(this);
        about.addActionListener(this);
        startb.addActionListener(this);
        helpb.addActionListener(this);
        aboutb.addActionListener(this);

        title = new JLabel("Typing Test");
        title.setFont(new Font("North",Font.PLAIN,56));
        title.setForeground(Color.black);
        title.setBounds(180,190,600,100);

        ImageIcon strtb = new ImageIcon("startbg.png");
        bg = new JLabel(strtb);
        bg.setIcon(strtb);
        bg.setBounds(0,0,800,800);


        f.add(aboutb); f.add(startb); f.add(title);
        f.setJMenuBar(mb);f.add(helpb);
        f.add(bg);

        f.setResizable(false);
        f.setSize(815,839);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new StartPage();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==startb) {
            //new typingTest();
            TypingTest.main(null);
        }else if(e.getSource()==helpb) {
            helpPage.main(null);
        }else if(e.getSource()==aboutb) {
            aboutPage.main(null);
        }


        if(e.getSource()==play) {
            TypingTest.main(null);

        }else if(e.getSource()==help) {
            helpPage.main(null);

        }else if(e.getSource()==about) {
            aboutPage.main(null);

        }
    }

}
