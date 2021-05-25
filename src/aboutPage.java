import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class aboutPage implements ActionListener{
	
	JFrame f;
	JButton backbutton;
	JTextArea instruction;
	JLabel bg,helplabel;
	
	aboutPage(){
		f = new JFrame("ABOUT");
		
		ImageIcon background = new ImageIcon("startbg.png");
		bg = new JLabel(background);
		bg.setBounds(0,0,800,800);
		
		ImageIcon back = new ImageIcon("backicon.png");
		backbutton = new JButton(back);
		backbutton.setBackground(Color.white);
		backbutton.setBorderPainted(false);
		backbutton.setBounds(20,20,65,69);
		backbutton.addActionListener(this);
		
		helplabel = new JLabel("ABOUT");
		helplabel.setFont(new Font("PixelGameFont",Font.PLAIN,60));
		helplabel.setBounds(290,200,300,100);
		
		instruction = new JTextArea("This program will test you typing speed or WPM\n"
				+ "means Words Per Minute. It is a measurement\n"
				+ "of the output speed on a keyboard.\n"
				+ "\n"
				+ "Programmed by:\n"
				+ "Rovick Ken Mangande\n"
				+ "Samuel Alcala\n"
				+ "Bryan Madrigalejos");
		instruction.setEditable(false);
		instruction.setFont(new Font("PixelGameFont",Font.PLAIN,23));
		instruction.setBounds(120,300,700,300);
		
		
		f.add(backbutton);f.add(helplabel);f.add(instruction);
		f.add(bg);
		
		f.setResizable(false);
		f.setSize(815,839);
		f.setLayout(null);
		f.setVisible(true);
		
	}
	public static void main(String[] args) {
		new aboutPage();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backbutton) {
			f.dispose();
		}
		
	}

}
