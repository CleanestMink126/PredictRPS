import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.EventListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements MouseListener{
	 private final int B_WIDTH = 350;
	    private final int B_HEIGHT = 350;
	    private final int INITIAL_X = -40;
	    private final int INITIAL_Y = -40;    
	    private final int INITIAL_DELAY = 100;
	    private final int PERIOD_INTERVAL = 25;
    
	    
	    private final int DELAY = 25;
	    
	    private Timer timer;
	    private int x, y;
	    double size = 1;
	
	    int numextension = 100;
	    Choose chooseRPS = null;
	    
	    public Board(){
		
		initBoard();
		
		
		
	}
	
	public void initBoard(){
		
		addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
			 	x = e.getX();
			 	y = e.getY();
		        if( x > chooseRPS.translaterockx &&  x < chooseRPS.translaterockx + chooseRPS.rockwidth  && y > chooseRPS.translaterocky && y < chooseRPS.translaterocky + chooseRPS.rockheight){
		        	chooseRPS.tr.translate(1000, 1000);
		        }
		        
		        
		        if( x > chooseRPS.translatepaperx &&  x < chooseRPS.translatepaperx + chooseRPS.paperwidth  && y > chooseRPS.translatepapery && y < chooseRPS.translatepapery + chooseRPS.paperheight){
		        	chooseRPS.tp.translate(1000, 1000);
		        }
		        if( x > chooseRPS.translatescissorsx &&  x < chooseRPS.translatescissorsx + chooseRPS.scissorswidth  && y > chooseRPS.translatescissorsy && y < chooseRPS.translatescissorsy + chooseRPS.scissorsheight){
		        	chooseRPS.ts.translate(1000, 1000);
		        }
		       repaint();
		        
		    }
		 	
		 


			@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			
		}

			@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			
		}

			@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		
			
		}

			@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		 
			
			
			
			
			
		});
		chooseRPS = new Choose();
		
		setBackground(Color.BLACK);
		
		//timer = new Timer(DELAY,this);
		//timer.start();
        //timer.scheduleAtFixedRate(new ScheduleTask(), 
                //INITIAL_DELAY, PERIOD_INTERVAL); 
	}
	
	 public void paintComponent(Graphics g) {

	        super.paintComponent(g);
	        chooseRPS.draw(g);
	 }

	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 @Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	    
	 
	


	/*
	@Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        drawDonut(g);
    }

    
    private void drawDonut(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh
                = new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        rh.put(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        g2d.setRenderingHints(rh);

        Dimension size = getSize();
        double w = size.getWidth();
        double h = size.getHeight();

        Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.gray);

        for (double deg = 0; deg < 360; deg += 1) {
            AffineTransform at
                    = AffineTransform.getTranslateInstance(w/2, h/2);
            at.rotate(Math.toRadians(deg));
            g2d.draw(at.createTransformedShape(e));
        }
    }
    */
}