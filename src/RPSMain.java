import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;



public class RPSMain extends JFrame {


	public RPSMain() {

        initUI();
    }

    private void initUI() {
    	
        add(new Board());
        
        
        

        setSize(1000, 1000);
        setResizable(false);

        setTitle("RPS");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLocationRelativeTo(null);
    }    
    
    public static void main(String[] args) {
        
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                RPSMain ex = new RPSMain();
                ex.setVisible(true);
            }
        });
    }
    
}