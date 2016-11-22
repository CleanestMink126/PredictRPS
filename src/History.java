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

public class History extends JPanel {
	BufferedImage rockpng = null;
	BufferedImage scissorspng = null;
	BufferedImage paperpng = null;
	double resize1 = .05;
	double resize2 = .075;
			
	AffineTransform tr = new AffineTransform();
	
	AffineTransform tp = new AffineTransform();
	
	AffineTransform ts = new AffineTransform();
	
	int tpx = 125;
	int tpy = 100;
	
	
	int translatex1 = 0;
	int translatex2 = tpx;
	int translatex3 = tpx * 2;
	
	int translatey1 = 800;
	int translatey2 = 800 + tpy;
	int translatex[] = {translatex1,translatex2,translatex3};
	int translatey[] =  {translatey1,translatey2};
	
	double rockheight;
	double rockwidth;
	double paperheight;
	double paperwidth;
	double scissorsheight;
	double scissorswidth;
	
	int[][] hist = {{0,0,0},{0,0,0}};
	


	History(){
		
		
		
		
		
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
		int currentvaluex;
		int currentvaluey;
		int getrps;
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 2; j++){
				AffineTransform t = new AffineTransform();
				currentvaluex = i;
				currentvaluey = j ;
				getrps = hist[currentvaluey][currentvaluex];
				if (getrps == 2){
					t.scale(resize2, resize2);
					t.translate(translatex[currentvaluex]/resize2,translatey[currentvaluey]/resize2 );
					g2d.drawImage(rockpng, t, null);
				}else if (getrps == 3){
					t.scale(resize2, resize2);
					t.translate(translatex[currentvaluex]/resize2,translatey[currentvaluey]/resize2 );
					g2d.drawImage(paperpng, t, null);
				}else if (getrps == 4){
					t.scale(resize1, resize1);
					t.translate(translatex[currentvaluex]/resize1,translatey[currentvaluey]/resize1);
					g2d.drawImage(scissorspng, t, null);
				}
				
				
			}
		}
		
			
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		g2d.drawString("Opponent", tpx * 3, 850);
		g2d.drawString("You", tpx * 3, 950);
		
	
		
		
		
	
	
	}
	public void update(int newcomp, int newyou){
		for(int i = 0; i < 2; i++){
			hist[0][i] = hist[0][i+1];
			hist[1][i] = hist[1][i+1];
		}
		hist[0][2] = newcomp;
		hist[1][2] = newyou;
	}
	
	
}