import java.awt.Color;

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

public class Choose extends JPanel {
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
	double translatepaperx = 450;
	double translatepapery = 450;
	double translatescissorsx = 600;
	double translatescissorsy = 450;
	
	double rockheight;
	double rockwidth;
	double paperheight;
	double paperwidth;
	double scissorsheight;
	double scissorswidth;
		


	Choose(){
		tr.scale(resize2,resize2);
		tr.translate(translaterockx/resize2, translaterocky/resize2);
		tp.scale(resize2,resize2);
		tp.translate(translatepaperx/resize2, translatepapery/resize2);
		ts.scale(resize1,resize1);
		ts.translate(translatescissorsx/resize1, translatescissorsy/resize1);
		
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
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
		                RenderingHints.VALUE_RENDER_QUALITY);
		
		g2d.drawImage(rockpng, tr, null);
		g2d.drawImage(paperpng, tp, null);
		g2d.drawImage(scissorspng, ts, null);
		g2d.drawString("CHOOSE", 500, 100);
	
	}
	
	
}
