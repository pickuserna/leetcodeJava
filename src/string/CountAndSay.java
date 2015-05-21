package string;
//��̬����
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
	//��s count and say
	public String count(String s){
		//������������ʽ
		StringBuilder sb = new StringBuilder();
		//��ͬ���ַ������˶��ٴ� 
		int count = 1;
		//��¼�ϸ��ַ�
		char oldChar = s.charAt(0);
		for(int i=1; i<s.length(); i++){
			char c = s.charAt(i);
			if(c==oldChar){
				count++;
			}
			//������ͬ���ַ������¿�ʼ����
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
