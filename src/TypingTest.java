import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;


public class TypingTest implements ActionListener {
    static JFrame f;
    static JButton startButton,resetButton;
    public static JTextArea userInput,paragraphsToType;
    static JLabel l1,l2;
    static JLabel secondsTimer,l3;
    static TimerTask task1;
    static TimerTask task2;
    static JTable scoreTable;
    static String playerName;
    static JLabel name,score,scoreboard;
    static DefaultTableModel model = new DefaultTableModel();

    TypingTest(){

        f = new JFrame("Typing Test");
        ImageIcon icon1 = new ImageIcon("Start.png");
        startButton = new JButton(icon1);
        startButton.setBackground(new Color(57,186,186));
        ImageIcon icon2 = new ImageIcon("Reset.png");
        startButton.setBorderPainted(false);

        resetButton = new JButton(icon2);
        resetButton.setBackground(new Color(57,186,186));
        resetButton.setBorderPainted(false);

        userInput = new JTextArea();
        userInput.setLineWrap(true);
        userInput.setEditable(false);

        scoreTable = new JTable();
        String [] columnName = {"Name","Score"};
        model.setColumnIdentifiers(columnName);
        scoreTable.setModel(model);

        name = new JLabel("Name");
        name.setFont(new Font("ADAM.CG PRO",Font.PLAIN,12));
        name.setForeground(Color.white);
        name.setBounds(35,580,100,20);

        score = new JLabel("WPM");
        score.setFont(new Font("ADAM.CG PRO",Font.PLAIN,12));
        score.setForeground(Color.white);
        score.setBounds(125,580,100,20);

        scoreboard = new JLabel("Score Board");
        scoreboard.setFont(new Font("North",Font.PLAIN,20));
        scoreboard.setForeground(Color.white);
        scoreboard.setBounds(10,540,200,30);


        l1 = new JLabel("Typing Test"); //LOGO LABEL
        l1.setFont(new Font("ADAM.CG PRO",Font.PLAIN,22));
        l1.setForeground(Color.white);

        paragraphsToType = new JTextArea("");
        paragraphsToType.setBackground(new Color(44,140,140));
        paragraphsToType.setFont(new Font("Keep Calm Medium",Font.PLAIN,20));
        paragraphsToType.setForeground(Color.white);
        paragraphsToType.setEditable(false);
        paragraphsToType.setLineWrap(true);

        secondsTimer = new JLabel("60");
        secondsTimer.setFont(new Font("ADAM.CG PRO",Font.PLAIN,60));
        secondsTimer.setForeground(Color.white);

        l3 = new JLabel("Seconds Left:");
        l3.setFont(new Font("The Bold Font",Font.PLAIN,25));
        l3.setForeground(Color.white);

        startButton.setBounds(300,690,100,48);
        resetButton.setBounds(550,690,100,48);
        userInput.setBounds(220,220,540,450);
        l1.setBounds(20,20,180,30);
        paragraphsToType.setBounds(220,30,540,150);
        l3.setBounds(10,200,200,30);
        secondsTimer.setBounds(55,250,100,100);

        scoreTable.getColumnModel().getColumn(1).setPreferredWidth(30);
        scoreTable.setBounds(10,600,180,152);
        scoreTable.setBackground(new Color(57,186,186));
        scoreTable.setForeground(Color.white);
        scoreTable.setFont(new Font("North",Font.PLAIN,12));
        scoreTable.setRowHeight(25);

        JPanel panel1 = new JPanel();
        panel1.setBounds(0,0,200,800);
        panel1.setBackground(new Color(32,104,104));


        JPanel panel2 = new JPanel();
        panel2.setBounds(200,0,600,200);
        panel2.setBackground(new Color(44,140,140));

        JPanel panel3 = new JPanel();
        panel3.setBounds(200,200,600,600);
        panel3.setBackground(new Color(57,186,186));

        //Frame Components
        f.add(userInput);f.add(startButton);f.add(resetButton);f.add(l3);f.add(scoreTable);
        f.add(name); f.add(score);f.add(scoreboard);
        f.add(l1);f.add(paragraphsToType); f.add(secondsTimer);
        f.add(panel1);f.add(panel2);f.add(panel3);

        f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
        f.setResizable(false);
        //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        new TypingTest();

        startButton.addActionListener(new ActionListener(){ //Start Button
            public  void actionPerformed(ActionEvent e) {
                randomSentence();
                userInput.setText("");
                startButton.setEnabled(false);
                userInput.setEditable(true);

                Timer time = new Timer();
                task1 = new TimerTask() {
                    public void  run() {
                        String words;
                        if (calculateWPM() == 1) {
                            words = " words ";
                        } else {
                            words = " word ";
                        }
                        Object [] row = new Object[2];
                        String result = "You typed " + calculateWPM() + words + "correctly in 60 seconds.\n" + "Enter your name";
                        playerName = JOptionPane.showInputDialog(f, result,"Your Result",JOptionPane.INFORMATION_MESSAGE);
                        row [0] = playerName;
                        row [1] = Integer.toString(calculateWPM());

                        model.addRow(row);
                    }
                };
                countDown();
                time.schedule(task1, 60000); // 60 seconds before showing the jOptionPane



            }
        });
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                secondsTimer.setText("60");

                task1.cancel();
                task2.cancel();
                startButton.setEnabled(true);
                userInput.setText("");
                userInput.setEditable(false);
            }
        });
    }


    public static void randomSentence() {
        Random r = new Random();
        String [] toType = new String[6];
        toType[0] = "Peter Piper picked a peck of pickled peppers. "
                + "A peck of pickled peppers Peter Piper picked "
                + "If Peter Piper picked a peck of pickled peppers "
                + "Where’s the peck of pickled peppers Peter "
                + "Piper picked? ";
        toType[1] = "Betty Butter bought some butter. But she said "
                + "the butter’s bitter. If I put it in my batter, it "
                + "will make my batter bitter. But a bit of better "
                + "butter will make my batter better. So ‘twas better "
                + "Betty Butter bought a bit of better butter. ";
        toType[2] = "How much wood would a woodchuck chuck "
                + "if a wood chuck could chuck wood? "
                + "He would chuck, he would, as much as he "
                + "could, and chuck as much wood. As a "
                + "woodchuck would if a woodchuck "
                + "could chuck wood. ";
        toType[3] = "Through three cheese trees, three "
                + "free fleas flew. While these fleas flew, "
                + "a freezy breeze blew. Freezy breeze "
                + "made these three trees freeze. Freezy trees "
                + "made these trees’ cheese freeze. That’s "
                + "what made these three free fleas sneeze. ";
        toType[4] = "O sit in solemn silence in a dull, dark dock, "
                + "In a pestilential prison, with a life-long lock, "
                + "Awaiting the sensation of a short, sharp "
                + "shock, from a cheap and chippy chopper on "
                + "a big black block! ";
        toType[5] = "Yellow butter, purple jelly, red jam, black bread. "
                + "Spread it thick, say it quick! "
                + "Yellow butter, purple jelly, red jam, black bread. "
                + "Spread it thicker, say it quicker! "
                + "Yellow butter, purple jelly, red jam, black bread. "
                + "Don’t eat with your mouth full! ";
        int num = r.nextInt(5);
        paragraphsToType.setText(toType[num]);
    }
    public static void countDown() {
        Timer t2 = new Timer();
        task2 = new TimerTask() {
            int secLeft = 59;

            public void run() {
                String seconds = String.valueOf(secLeft);
                if(secLeft < 10) {
                    seconds = "0" + seconds;
                }
                secondsTimer.setText(seconds);
                secLeft -= 1;

                if (secLeft < 0) {
                    task2.cancel();
                    startButton.setEnabled(true);
                    userInput.setEditable(false);
                }
            }
        };
        t2.schedule(task2, 1000,1000); //delay loop
    }

    public static int calculateWPM() {
        String correctWords [] = paragraphsToType.getText().split(" ");
        String typedWords [] = userInput.getText().split(" ");
        double repeats = Math.ceil(typedWords.length / (double) correctWords.length);
        ArrayList <String> repeated = new ArrayList<>(2);
        int correctInput = 0;

        for(int j = 0; j < repeats;j++) { //check kung ilan ung tinype para ma produce kung ilan
            for(int x = 0; x < correctWords.length; x++) {  //ung igegenerate na pang checheck
                repeated.add(correctWords[x]);//totype stock repeated kung ilan ung repeats
            }
        }

        for(int i = 0; i < typedWords.length; i++) {
            if(repeated.get(i).equals(typedWords[i])) {
                correctInput++;
            }
        }
        return correctInput;//count of typed correct
    }


    @Override
    public void actionPerformed(ActionEvent e) {


    }


    public void setVisible(boolean b) {


    }

}
