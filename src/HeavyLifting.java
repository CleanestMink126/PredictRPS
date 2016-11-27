import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

public class HeavyLifting {
	ArrayList<Integer> pastinput;
	ArrayList<Integer> pastresult;
	
	ArrayList<Integer> loseLast;
	ArrayList<Integer> tieLast;
	ArrayList<Integer> winLast;
	ArrayList<Integer> AppearanceW;
	ArrayList<Integer> AppearanceT;
	ArrayList<Integer> AppearanceL;
	ArrayList<Integer> ResultW;
	ArrayList<Integer> ResultT;
	ArrayList<Integer> ResultL;
	double[] thetaW ;
	double[] thetaT ;
	double[] thetaL ;
	int whoswinning;
	int timecounter;
	String percent;
	
	//ArrayList<Integer> Overall;
	
	HeavyLifting(){
		pastinput = new ArrayList<Integer>(0);
		pastresult = new ArrayList<Integer>(0);
		loseLast = new ArrayList<Integer>(0);
		winLast = new ArrayList<Integer>(0);
		tieLast = new ArrayList<Integer>(0);
		AppearanceW = new ArrayList<Integer>(0);
		AppearanceT = new ArrayList<Integer>(0);
		AppearanceL = new ArrayList<Integer>(0);
		ResultW = new ArrayList<Integer>(0);
		ResultT = new ArrayList<Integer>(0);
		ResultL = new ArrayList<Integer>(0);
		thetaW = new double[4];
		thetaT = new double[4];
		thetaL = new double[4];
		whoswinning = 0;
		timecounter = 0;
		percent = "NA";
	}
	
	public void add(int i,int r){
		int x = 0;
		if (i == r){
			x =0;
			tieLast.add(1);
			winLast.add(0);
			loseLast.add(0);
		}else if((i > r || (i == 2 && r == 4)) && !(i == 4 && r == 2)){
			x = 1;
			tieLast.add(0);
			winLast.add(1);
			loseLast.add(0);
			whoswinning += x;
		}else if(i < r || (i == 4 && r == 2)){
			x = -1;
			tieLast.add(0);
			winLast.add(0);
			loseLast.add(1);
		}
		
		
		pastinput.add(i);
		pastresult.add(x);
		
		if (x != 0){
			timecounter++;
		}
		if (pastinput.size() > 1){
			int y = pastinput.get(pastinput.size() - 1);
			int yp = pastinput.get(pastinput.size() - 2);
			
			
			
			if (y == yp){
				
				ResultW.add(0);
				ResultT.add(1);
				ResultL.add(0);
			}else if((y > yp || (y == 2 && yp == 4)) && !(y == 4 && yp == 2)){
				ResultW.add(1);
				ResultT.add(0);
				ResultL.add(0);
			}else if(y < yp || (y == 4 && yp == 2)){
				ResultW.add(0);
				ResultT.add(0);
				ResultL.add(1);
			}
			
		}
		
		
		if (pastinput.size() > 3){
		
			int ym1 = pastinput.get(pastinput.size() - 2);
			int ym2 = pastinput.get(pastinput.size() - 3);
			int ym3 = pastinput.get(pastinput.size() - 4);
			
			int countW = 0;
			int countT = 1;
			int countL = 0;
			
			if (ym2 == ym1){
				countT++;
				
			}else if((ym2 > ym1 || (ym2 == 2 && ym1 == 4)) && !(ym2 == 4 && ym1 == 2)){
				countW++;
			}else if(ym2 < ym1 || (ym2 == 4 && ym1 == 2)){
				countL++;
			}
			
			
			if (ym3 == ym1){
				countT++;
				
			}else if((ym3 > ym1 || (ym3 == 2 && ym1 == 4)) && !(ym3 == 4 && ym1 == 2)){
				countW++;
			}else if(ym3 < ym1 || (ym3 == 4 && ym1 == 2)){
				countL++;
			}
			AppearanceW.add(countW);
			AppearanceT.add(countT);
			AppearanceL.add(countL);
			
		}
		System.out.println("BREAK--------------");
		System.out.println(pastinput);
		System.out.println(pastresult);
		System.out.println(winLast);
		System.out.println(AppearanceW);
		System.out.println(ResultW);
		
		
	}
	/*
	while true 
    for i = 1:numvar 
        cost(i) =  gradientghoul(input,answers(j,:), theta, i);     
    end
    error = costghoul(input,answers(j,:), theta);


    tot = 0;
    allmin = true;
    for i = 1 : numvar
        tot = tot + abs(cost(i));
        if  error <= nerror &&  abs(cost(i)) / abs(ncost(i)) < indivaccu
            allmin = false; 

        end


    end



   
    nerror = error;
    ntot = tot;
    ncost = cost;



    theta = theta - ncost
`*/




	
	public void crunchW(){
		double indivaccu = .99;
		double learnrate = .1;
		int datasize = ResultW.size() - 2;
		double guess = 0;
		double gradient = 0;
		double gradient1 = 0;
		double gradient2 = 0;
		double gradient3 = 0;
		double gradient4 = 0;
		double cost = 0;
		
		double ngradient = 10000;
		double ngradient1 = 0;
		double ngradient2 = 0;
		double ngradient3 = 0;
		double ngradient4 = 0;
		double ncost = 100000;
		
		
		while(true){
			for(int i = 0; i < datasize; i++){
				
				int one = winLast.get(i+2);
				int two = tieLast.get(i+2);
				int three = loseLast.get(i+2);
				int four = AppearanceW.get(i);
				int res = ResultW.get(i+2);
				
				int[] m = {one, two, three, four};
				
				double determine = -thetaW[0] * m[0] + -thetaW[1] * m[1] + -thetaW[2] * m[2] + - thetaW[3] * m[3]; 
			    
				guess = 1 / (1 + Math.exp(determine));
				
				gradient1 += (guess - res) * one;
				gradient2 += (guess - res) * two;
				gradient3 += (guess - res) * three;
				gradient4 += (guess - res) * four;
			
				cost += -res * Math.log10(guess) - (1-res) * Math.log10(1-guess);
			
				
			    
			}
			gradient1 = learnrate * gradient1 / datasize;
			gradient2 = learnrate * gradient2 / datasize;
			gradient3 = learnrate * gradient3 / datasize;
			gradient4 = learnrate * gradient4 / datasize;
			cost /= datasize;
			
			/*
			System.out.println(gradient1);
			System.out.println(gradient2);
			System.out.println(gradient3);
			System.out.println(gradient4);
			*/
			//System.out.println(cost);
			
			
			boolean alltrue = true;
			
			/*
			if (gradient1/ ngradient1 < indivaccu ){
				alltrue = false;
			}
			if (gradient2 / ngradient2 < indivaccu ){
				alltrue = false;
			}
			
			if (gradient3 / ngradient3 < indivaccu ){
				alltrue = false;
			}
			
			if (gradient4 / ngradient4 < indivaccu ){
				alltrue = false;
			}
			*/
			gradient = Math.abs(gradient1) +Math.abs(gradient2) + Math.abs(gradient3) + Math.abs(gradient4);
			if (Math.abs(cost) < Math.abs(ncost) && gradient / ngradient < indivaccu){
				alltrue = false;
			}
			
			
			//System.out.println("ITS RUNNNING");
			if (alltrue){
				break;
			}
			
			ngradient = gradient;
			ngradient1 = gradient1;
			ngradient2 = gradient2;
			ngradient3 = gradient3;
			ngradient4 = gradient4;
			ncost = cost;
			
			
			thetaW[0] -= gradient1;
			thetaW[1] -= gradient2;
			thetaW[2] -= gradient3;
			thetaW[3] -= gradient4;
			
			gradient1 = 0;
			gradient2 = 0;
			gradient3 = 0;
			gradient4 = 0;
			cost = 0;
			
		}
		
	}
	public void crunchT(){
		double indivaccu = .99;
		double learnrate = .1;
		int datasize = ResultT.size() - 2;
		double guess = 0;
		double gradient = 0;
		double gradient1 = 0;
		double gradient2 = 0;
		double gradient3 = 0;
		double gradient4 = 0;
		double cost = 0;
		
		double ngradient = 10000;
		double ngradient1 = 0;
		double ngradient2 = 0;
		double ngradient3 = 0;
		double ngradient4 = 0;
		double ncost = 100000;
		
		
		while(true){
			for(int i = 0; i < datasize; i++){
				
				int one = winLast.get(i+2);
				int two = tieLast.get(i+2);
				int three = loseLast.get(i+2);
				int four = AppearanceT.get(i);
				int res = ResultT.get(i+2);
				
				int[] m = {one, two, three, four};
				
				double determine = -thetaT[0] * m[0] + -thetaT[1] * m[1] + -thetaT[2] * m[2] + - thetaT[3] * m[3]; 
			    
				guess = 1 / (1 + Math.exp(determine));
				
				gradient1 += (guess - res) * one;
				gradient2 += (guess - res) * two;
				gradient3 += (guess - res) * three;
				gradient4 += (guess - res) * four;
			
				cost += -res * Math.log10(guess) - (1-res) * Math.log10(1-guess);
			
				
			    
			}
			gradient1 = learnrate * gradient1 / datasize;
			gradient2 = learnrate * gradient2 / datasize;
			gradient3 = learnrate * gradient3 / datasize;
			gradient4 = learnrate * gradient4 / datasize;
			cost /= datasize;
			
			/*
			System.out.println(gradient1);
			System.out.println(gradient2);
			System.out.println(gradient3);
			System.out.println(gradient4);
			*/
			//System.out.println(cost);
			
			
			boolean alltrue = true;
			
			/*
			if (gradient1/ ngradient1 < indivaccu ){
				alltrue = false;
			}
			if (gradient2 / ngradient2 < indivaccu ){
				alltrue = false;
			}
			
			if (gradient3 / ngradient3 < indivaccu ){
				alltrue = false;
			}
			
			if (gradient4 / ngradient4 < indivaccu ){
				alltrue = false;
			}
			*/
			gradient = Math.abs(gradient1) +Math.abs(gradient2) + Math.abs(gradient3) + Math.abs(gradient4);
			if (Math.abs(cost) < Math.abs(ncost) && gradient / ngradient < indivaccu){
				alltrue = false;
			}
			
			
			//System.out.println("ITS RUNNNING");
			if (alltrue){
				break;
			}
			
			ngradient = gradient;
			ngradient1 = gradient1;
			ngradient2 = gradient2;
			ngradient3 = gradient3;
			ngradient4 = gradient4;
			ncost = cost;
			
			
			thetaT[0] -= gradient1;
			thetaT[1] -= gradient2;
			thetaT[2] -= gradient3;
			thetaT[3] -= gradient4;
			
			gradient1 = 0;
			gradient2 = 0;
			gradient3 = 0;
			gradient4 = 0;
			cost = 0;
			
		}
		
	}
	public void crunchL(){
		double indivaccu = .99;
		double learnrate = .1;
		int datasize = ResultL.size() - 2;
		double guess = 0;
		double gradient = 0;
		double gradient1 = 0;
		double gradient2 = 0;
		double gradient3 = 0;
		double gradient4 = 0;
		double cost = 0;
		
		double ngradient = 10000;
		double ngradient1 = 0;
		double ngradient2 = 0;
		double ngradient3 = 0;
		double ngradient4 = 0;
		double ncost = 100000;
		
		
		while(true){
			for(int i = 0; i < datasize; i++){
				
				int one = winLast.get(i+2);
				int two = tieLast.get(i+2);
				int three = loseLast.get(i+2);
				int four = AppearanceL.get(i);
				int res = ResultL.get(i+2);
				
				int[] m = {one, two, three, four};
				
				double determine = -thetaL[0] * m[0] + -thetaL[1] * m[1] + -thetaL[2] * m[2] + - thetaL[3] * m[3]; 
			    
				guess = 1 / (1 + Math.exp(determine));
				
				gradient1 += (guess - res) * one;
				gradient2 += (guess - res) * two;
				gradient3 += (guess - res) * three;
				gradient4 += (guess - res) * four;
			
				cost += -res * Math.log10(guess) - (1-res) * Math.log10(1-guess);
			
				
			    
			}
			gradient1 = learnrate * gradient1 / datasize;
			gradient2 = learnrate * gradient2 / datasize;
			gradient3 = learnrate * gradient3 / datasize;
			gradient4 = learnrate * gradient4 / datasize;
			cost /= datasize;
			
			/*
			System.out.println(gradient1);
			System.out.println(gradient2);
			System.out.println(gradient3);
			System.out.println(gradient4);
			*/
			//System.out.println(cost);
			
			
			boolean alltrue = true;
			
			/*
			if (gradient1/ ngradient1 < indivaccu ){
				alltrue = false;
			}
			if (gradient2 / ngradient2 < indivaccu ){
				alltrue = false;
			}
			
			if (gradient3 / ngradient3 < indivaccu ){
				alltrue = false;
			}
			
			if (gradient4 / ngradient4 < indivaccu ){
				alltrue = false;
			}
			*/
			gradient = Math.abs(gradient1) +Math.abs(gradient2) + Math.abs(gradient3) + Math.abs(gradient4);
			if (Math.abs(cost) < Math.abs(ncost) && gradient / ngradient < indivaccu){
				alltrue = false;
			}
			
			
			//System.out.println("ITS RUNNNING");
			if (alltrue){
				break;
			}
			
			ngradient = gradient;
			ngradient1 = gradient1;
			ngradient2 = gradient2;
			ngradient3 = gradient3;
			ngradient4 = gradient4;
			ncost = cost;
			
			
			thetaL[0] -= gradient1;
			thetaL[1] -= gradient2;
			thetaL[2] -= gradient3;
			thetaL[3] -= gradient4;
			
			gradient1 = 0;
			gradient2 = 0;
			gradient3 = 0;
			gradient4 = 0;
			cost = 0;
			
		}	
	}
	
	
	public double chanceW(){
		int one = winLast.get(winLast.size()-1);
		int two = tieLast.get(winLast.size()-1);
		int three = loseLast.get(winLast.size()-1);
		
		
		int ym1 = pastinput.get(pastinput.size() - 1);
		int ym2 = pastinput.get(pastinput.size() - 2);
		int ym3 = pastinput.get(pastinput.size() - 3);
		
		int countW = 0;
		
		if (ym2 == ym1){
			
			
		}else if((ym2 > ym1 || (ym2 == 2 && ym1 == 4)) && !(ym2 == 4 && ym1 == 2)){
			countW++;
		}else if(ym2 < ym1 || (ym2 == 4 && ym1 == 2)){
			
		}	
		if (ym3 == ym1){
			
			
		}else if((ym3 > ym1 || (ym3 == 2 && ym1 == 4)) && !(ym3 == 4 && ym1 == 2)){
			countW++;
		}else if(ym3 < ym1 || (ym3 == 4 && ym1 == 2)){
			
		}
		
		int four = countW;
		
		
		
		
		int[] m = {one, two, three, four};
		
		double determine = -thetaW[0] * m[0] + -thetaW[1] * m[1] + -thetaW[2] * m[2] + - thetaW[3] * m[3]; 
	    System.out.println(1 / (1 + Math.exp(determine)));
		return 1 / (1 + Math.exp(determine));
	}
	public double chanceT(){
		int one = winLast.get(winLast.size()-1);
		int two = tieLast.get(winLast.size()-1);
		int three = loseLast.get(winLast.size()-1);
		
		
		int ym1 = pastinput.get(pastinput.size() - 1);
		int ym2 = pastinput.get(pastinput.size() - 2);
		int ym3 = pastinput.get(pastinput.size() - 3);
		
		int countT = 1;
		
		if (ym2 == ym1){
			countT++;
			
		}else if((ym2 > ym1 || (ym2 == 2 && ym1 == 4)) && !(ym2 == 4 && ym1 == 2)){
			
		}else if(ym2 < ym1 || (ym2 == 4 && ym1 == 2)){
			
		}	
		if (ym3 == ym1){
			countT++;
			
		}else if((ym3 > ym1 || (ym3 == 2 && ym1 == 4)) && !(ym3 == 4 && ym1 == 2)){
			
		}else if(ym3 < ym1 || (ym3 == 4 && ym1 == 2)){
			
		}
		
		int four = countT;
		
		
		
		
		int[] m = {one, two, three, four};
		
		double determine = -thetaT[0] * m[0] + -thetaT[1] * m[1] + -thetaT[2] * m[2] + - thetaT[3] * m[3]; 
	    System.out.println(1 / (1 + Math.exp(determine)));
		return 1 / (1 + Math.exp(determine));
	}
	public double chanceL(){
		int one = winLast.get(winLast.size()-1);
		int two = tieLast.get(winLast.size()-1);
		int three = loseLast.get(winLast.size()-1);
		
		
		int ym1 = pastinput.get(pastinput.size() - 1);
		int ym2 = pastinput.get(pastinput.size() - 2);
		int ym3 = pastinput.get(pastinput.size() - 3);
		
		int countL = 1;
		
		if (ym2 == ym1){
			
			
		}else if((ym2 > ym1 || (ym2 == 2 && ym1 == 4)) && !(ym2 == 4 && ym1 == 2)){
			
		}else if(ym2 < ym1 || (ym2 == 4 && ym1 == 2)){
			countL++;
		}	
		if (ym3 == ym1){
			
			
		}else if((ym3 > ym1 || (ym3 == 2 && ym1 == 4)) && !(ym3 == 4 && ym1 == 2)){
			
		}else if(ym3 < ym1 || (ym3 == 4 && ym1 == 2)){
			countL++;
		}
		
		int four = countL;
		
		
		
		
		int[] m = {one, two, three, four};
		
		double determine = -thetaL[0] * m[0] + -thetaL[1] * m[1] + -thetaL[2] * m[2] + - thetaL[3] * m[3]; 
	    System.out.println(1 / (1 + Math.exp(determine)));
		return 1 / (1 + Math.exp(determine));
	}
	
	public void returnPercent(){
		if(timecounter != 0){
			double p = 100 * (double)whoswinning / (double)timecounter ;
			
			percent =  Integer.toString((int)p);
		}
		
	}
	public void draw(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

		g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
		                RenderingHints.VALUE_RENDER_QUALITY);
		
		
		g2d.setColor(Color.WHITE);
		g2d.setFont(new Font("TimesRoman", Font.PLAIN, 50));
		g2d.drawString(percent, 100, 100);
		
	
	}
	
}




