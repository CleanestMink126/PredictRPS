import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.KeyEvent;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Fight extends JPanel {
	BufferedImage rockpng = null;
	BufferedImage scissorspng = null;
	BufferedImage paperpng = null;
	double resize1 = .1;
	double resize2 = .15;
			
	AffineTransform tr = new AffineTransform();
	
	AffineTransform tp = new AffineTransform();
	
	AffineTransform ts = new AffineTransform();
	
	double translaterockx = 200;
	double translaterocky = 450;
	double translatepaperx = 200;
	double translatepapery = 450;
	double translatescissorsx = 200;
	double translatescissorsy = 450;
	
	double rockheight;
	double rockwidth;
	double paperheight;
	double paperwidth;
	double scissorsheight;
	double scissorswidth;
	
	int choice;
	int computerchoice;


	Fight(int choice){
		
		this.choice = choice;
		
		
		try {
		    scissorspng = ImageIO.read(new File("C:\\Users\\gsteelman\\Desktop\\Pursuits\\Eclipse\\PredictRPS\\PredictRPS\\Art\\scissors.png"));
		} catch (IOException e) {
		}
		
		try {
		    rockpng = ImageIO.read(new File("C:\\Users\\gsteelman\\Desktop\\Pursuits\\Eclipse\\PredictRPS\\PredictRPS\\Art\\rock.png"));
		} catch (IOException e) {
		}
		
		try {
		    paperpng = ImageIO.read(new File("C:\\Users\\gsteelman\\Desktop\\Pursuits\\Eclipse\\PredictRPS\\PredictRPS\\Art\\paper.png"));
		} catch (IOException e) {
		}
		
		rockheight = rockpng.getHeight() * resize2;
		rockwidth = rockpng.getWidth() * resize2;
		paperheight = paperpng.getHeight() * resize2;
		paperwidth = paperpng.getWidth() * resize2;
		scissorsheight = scissorspng.getHeight() * resize1;
		scissorswidth = scissorspng.getWidth() * resize1;
		
	}
	
	public void draw(Graphics g){
		tr.scale(resize2,resize2);
		tr.translate(translaterockx/resize2, translaterocky/resize2);
		
		tp.scale(resize2,resize2);
		tp.translate(translatepaperx/resize2, translatepapery/resize2);
		
		ts.scale(resize1,resize1);
		ts.translate(translatescissorsx/resize1, translatescissorsy/resize1);
		
		
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
		                RenderingHints.VALUE_RENDER_QUALITY);
		if(choice == 2){
			g2d.drawImage(rockpng, tr, null);
		}else if(choice == 3){
			g2d.drawImage(paperpng, tp, null);
		}else if (choice == 4){
			ts.rotate(3.1415,scissorspng.getWidth()/2,scissorspng.getHeight()/2);
			//ts.translate(scissorswidth,scissorsheight);
			g2d.drawImage(scissorspng, ts, null);
		}
		
		double rand = 3 * Math.random();
		if (rand < 1){
			computerchoice = 2;
		}
		if (rand> 1 &&  rand < 2){
			computerchoice= 3;
		}
		if (rand > 2){
			computerchoice = 4;
		}
		
		if(computerchoice == 2){
			tr.translate(500/resize2, 0);
			g2d.drawImage(rockpng, tr, null);
		}else if(computerchoice == 3){
			tp.translate(500/resize2, 0);
			g2d.drawImage(paperpng, tp, null);
		}else if (computerchoice == 4){
			if (choice == 4){
				ts.rotate(3.1415,scissorspng.getWidth()/2,scissorspng.getHeight()/2);
			}
			ts.translate(500/resize1, 0);
			
			//ts.translate(scissorswidth,scissorsheight);
			g2d.drawImage(scissorspng, ts, null);
		}
		
		if (choice == computerchoice){
			g2d.setColor(Color.WHITE);
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			g2d.drawString("TIE", 400, 100);
		}else if((choice > computerchoice || (choice == 2 && computerchoice == 4)) && !(choice == 4 && computerchoice == 2)){
			g2d.setColor(Color.GREEN);
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			g2d.drawString("WIN", 400, 100);
		}else if(choice < computerchoice || (choice == 4 && computerchoice == 2)){
			g2d.setColor(Color.RED);
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 50));
			g2d.drawString("LOSE", 400, 100);
		}
		
	



		
		
		
		
	
	}
	
	
}