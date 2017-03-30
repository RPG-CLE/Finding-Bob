package extension;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import client.Case;
import client.Jeu;

public class FenetreJeu extends JFrame implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -478208599359849405L;
	JPanel panneau;
	GridLayout casesJeu; 
	CaseApparence casesApparence[][];
	
	Jeu jeu;

	public FenetreJeu(String nomJeu) {
		super(nomJeu);
		addKeyListener(this);
	}

	
	public void initialiserFenetre(Jeu jeu){
		this.jeu = jeu;
		casesJeu = new GridLayout(jeu.getMap().getLargeur(),jeu.getMap().getHauteur(), -1, -1);
		panneau = new JPanel(casesJeu);
		casesApparence = new CaseApparence[jeu.getMap().getLargeur()][jeu.getMap().getHauteur()];

		panneau.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
		this.add(panneau);
		//panneau.setBackground(Color.red);
		for(int y = 0; y < jeu.getMap().getHauteur(); y++){
			for(int x = 0; x < jeu.getMap().getLargeur(); x++){
				casesApparence[y][x]= new CaseApparence();
				casesApparence[y][x].setCaseJeu(jeu.getMap().getCase(x, y));
				panneau.add(casesApparence[y][x]);

			}
		}
		this.setMaximumSize(new Dimension(jeu.getMap().getLargeur()*32, jeu.getMap().getHauteur()*32));
		this.setResizable(false);
		
	}
	
	public void rechargerFenetre(){
		//this.removeAll();
		initialiserFenetre(jeu);
		
	}
	
	public void update(){
		if (!this.jeu.getGameOn()){
			System.out.println("Ici");

			this.remove(panneau);
	
			JPanel gameOverPanneau = new JPanel();
			Image image = this.getToolkit().createImage("data/GameOver.gif");//new ImageIcon(urlImage).getImage();
			JLabel gameOver = new JLabel (new ImageIcon(image));
			//JLabel gameOver = new JLabel (new ImageIcon((getScaledImage(image,jeu.getMap().getLargeur()*32, jeu.getMap().getHauteur()*32))));
	
			gameOverPanneau.add(gameOver);
			this.add(gameOverPanneau);
			
			this.revalidate();
			this.repaint();
		}
		else {
			for(int i = 0; i <casesApparence.length; i++){
				for(int j = 0; j < casesApparence[0].length; j++){
					casesApparence[i][j].update();
				}
			}
		}
	}


	@Override
	public void keyTyped(KeyEvent e) {
		((EntreeIhm)jeu.getEntree()).setTyped(e.getKeyChar());
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private Image getScaledImage(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}

}