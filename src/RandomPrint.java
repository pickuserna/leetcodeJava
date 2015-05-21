import java.util.Random;


public class RandomPrint {
	public int nextInt(int n){
		Random rnd = new Random();
		return rnd.nextInt(n);
	}
	
	public void init(Boolean[] bs){
		for(int i=0; i<bs.length; i++){
			bs[i] = false;
		}
	}
	
	public void printRand(int n, int m){
		Boolean[] bs = new Boolean[n];
		init(bs);
		for(int i=0; i<m; ){
			int t = nextInt(n);
			if(bs[t]==false){
				i++;
				bs[t] = true;
				System.out.println(t);
			}
		}
	}
	public static void main(String[] args){
		RandomPrint s = new RandomPrint();
		s.printRand(1000, 900);
	}
}
