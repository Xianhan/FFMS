import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class test {
public static void main(String[] args) {
	Date date=new Date();

    Calendar   calendar   =   new   GregorianCalendar(); 

    calendar.setTime(date); 

    calendar.add(calendar.DATE,-1);//把日期往后增加一天.整数往后推,负数往前移动 

    date=calendar.getTime();   //这个时间就是日期往后推一天的结果 
	System.out.println(new java.sql.Date(date.getTime()).toString());
}
}
