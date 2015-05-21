package string;
//静态引入
import static tools.UtilMy.*;

public class CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(new CountAndSay().countAndSay(1));
	}
	public String countAndSay(int n) {
		String s = "1";
		for(int i=1; i<n; i++){
			s = count(s);
	    }
		return s;
	}
	//对s count and say
	public String count(String s){
		//可以用正则表达式
		StringBuilder sb = new StringBuilder();
		//相同的字符出现了多少次 
		int count = 1;
		//记录上个字符
		char oldChar = s.charAt(0);
		for(int i=1; i<s.length(); i++){
			char c = s.charAt(i);
			if(c==oldChar){
				count++;
			}
			//遇到不同的字符，重新开始计数
			else{
				sb.append(""+count+oldChar);
				count = 1;
				oldChar = c;
			}
		}
		sb.append(""+count+oldChar);
		return sb.toString();
	}
}
