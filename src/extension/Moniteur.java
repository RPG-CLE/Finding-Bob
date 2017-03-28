package extension;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import framework.MethodAutorun;


@MethodAutorun(run="jeMeLance")
public class Moniteur implements Observer {

	private String historique= "" ;
	private JFrame myFrame = new JFrame();
	
	public void jeMeLance(){
		System.out.println("je suis LE( THE) moniteur et je me lance");
		myFrame.setTitle("Moniteur");
		myFrame.setSize(500, 300);
		myFrame.setLocationRelativeTo(null);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.myFrame.setVisible(true);
	}
	
	@Override
	public void update(Observable o, Object arg) {
  		historique += arg.toString() + "\n";
		JPanel pannel = new JPanel();
		JTextArea text = new JTextArea(historique);
		pannel.add(text);
		this.myFrame.getContentPane().setVisible(false);
		this.myFrame.getContentPane().removeAll();
		this.myFrame.getContentPane().add(pannel);
		this.myFrame.getContentPane().setVisible(true);
	}
	
}
