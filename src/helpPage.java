import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class helpPage implements ActionListener{
	
	JFrame f;
	JButton backbutton;
	JTextArea aboutprogram;
	JLabel bg,aboutlabel;
	
	helpPage(){
		f = new JFrame("Help");
		
		ImageIcon background = new ImageIcon("startbg.png");
		bg = new JLabel(background);
		bg.setBounds(0,0,800,800);
		
		ImageIcon back = new ImageIcon("backicon.png");
		backbutton = new JButton(back);
		backbutton.setBackground(Color.white);
		backbutton.setBorderPainted(false);
		backbutton.setBounds(20,20,65,69);
		backbutton.addActionListener(this);
		
		aboutlabel = new JLabel("HELP");
		aboutlabel.setFont(new Font("PixelGameFont",Font.PLAIN,60));
		aboutlabel.setBounds(325,200,300,100);
		
		aboutprogram = new JTextArea("To start the test, click the start button in this window.\n"
					+ "Once you are in, click the start button to start the timer.\n"
					+ "Start typing the appeared random paragraphs on the top\n"
					+ "continuously and type many as you can until the timer stop.\n"
					+ "Your result will be recorded on the score board.\n"
					+ "Enjoy! Have fun.");
		aboutprogram.setEditable(false);
		aboutprogram.setFont(new Font("PixelGameFont",Font.PLAIN,23));
		aboutprogram.setBounds(90,300,700,200);
		
		
		f.add(backbutton);f.add(aboutlabel);f.add(aboutprogram);
		f.add(bg);
		
		f.setResizable(false);
		f.setSize(815,839);
		f.setLayout(null);
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		new helpPage();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backbutton) {
			f.dispose();
		}
		
	}

}

