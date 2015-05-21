package math;
import static tools.UtilMy.*;
/**
 * 描述：<>
 * @author zn
 * @CreateTime 2015-4-14下午8:51:16
 */
public class ExcelSheetColumnTitle {

	/**
	 * TODO:<>
	 * @param args 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(new ExcelSheetColumnTitle().convertToTitle(28));
	}
	//将10进制 转化成26进制
	public String convertToTitle(int n) {
		String result = "";
		int x = n;
		//0->25 : 1->26
		while(x>0){
			x--;
			char c = (char)(x%26+'A');
			result = c+result;
			x /= 26;
		}
		return result;
	}
}
