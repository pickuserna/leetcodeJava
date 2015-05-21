//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Comparator;
//import java.util.Iterator;
//import java.util.List;
//
//
//
///**
// * 描述：<>
// * @author zn
// * @CreateTime 2015-3-10下午5:32:47
// */
//class CmporInterval implements Comparator<Interval>{
//
//	@Override
//	public int compare(Interval o1, Interval o2) {
//		// TODO Auto-generated method stub
//		return o1.start-o2.start;
//	}
//	
//}
//public class MergeIntervals {
//	
//	public static List<Interval> merge(List<Interval>intervals, Interval newInterval){
//		Iterator<Interval> iter = intervals.iterator();
//		
//		while(iter.hasNext()){
//			Interval interval = iter.next();
//			if(interval.start<newInterval.start);
//		}
//		while(iter.hasNext()){
//			Interval interval = iter.next();
//		}
//	}
//	/**
//	 * TODO:<>
//	 * @param args 
//	 */
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		List<Interval> intervals = new ArrayList<Interval>();
//		createList(intervals);
//		Collections.sort(intervals, new CmporInterval());
//		
//		//outputList(intervals);
//		outputList(merge(intervals));
//	}
//	 public static List<Interval> merge(List<Interval> intervals) {
//	        Collections.sort(intervals, new Comparator<Interval>() {
//	        	public int compare(Interval o1, Interval o2) {
//	        		// TODO Auto-generated method stub
//	        		return o1.start-o2.start;
//	        	}
//			});
//	        List <Interval> result = new ArrayList<Interval>();
//	        int len = intervals.size();
//	        //len==0
//	        if(len==0) return intervals;
//	        Interval i2 = null;
//	        Interval i1 = intervals.get(0);
//			int i = 1;
//	        while( i<len ){
//				//遍历两个Interval，找到重叠的区间并合并
//				 i2 = intervals.get(i++);
//				if(i1.end>=i2.start){
//					i1.end = i2.end>i1.end?i2.end:i1.end;
//				}
//				else{
//					result.add(i1);
//					i1 = i2;
//				}
//			}
//	        //无论如何都需要 add i1
//	        result.add(i1);
//			return result;
//	 }
//	
//	 static boolean isOverlap(Interval i1, Interval i2){
//		 if(i1.end>i2.start)
//			 return true;
//		 return false;
//	 }
//	static void outputList(List<Interval> l){
//		int i =0 ;
//		Iterator<Interval> iter =l.iterator();
//		while(iter.hasNext()){
//			Interval il = iter.next();
//			System.out.println(i+++":["+il.start+", "+il.end+"]");
//		}
//	}
//	static void createList(List<Interval> l){
//		l.add(new Interval(8,10));
//		l.add(new Interval(2, 6));
//		Interval i = new Interval(1,3);
//		l.add(i);
//		l.add(new Interval(15,21));
//	}
//	
//}
