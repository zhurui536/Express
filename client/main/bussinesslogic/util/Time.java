package main.bussinesslogic.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Time implements Comparable<Time>,Serializable{

        private static final long serialVersionUID = 1L;

        private static final SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        private Date date;
        
        public Time() {
                date = new Date();
        }
        
        public Time(String time) {
                SimpleDateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
                try {
                        date = fmt.parse(time);
                } catch (ParseException e) {
                        e.printStackTrace();
                        date = new Date();
                }
        }

        public long sub(Time time) {
                long diff = date.getTime() - time.date.getTime();
                return diff / (1000 * 60 * 60 * 24);
        }
        
        @Override
        public String toString() {
                return dateFormater.format(date);
        }

        public boolean equalsWithDay(Time o) {
            SimpleDateFormat fmt =new SimpleDateFormat("yyyy-MM-dd");
            return fmt.format(o.date).equals(fmt.format(date));
        }
        
        @Override
        public int compareTo(Time o) {
                if (date.before(o.date)) {
                        return -1;
                }
                else if(o.date.before(date)){
                        return 1;
                }
                return 0;
        }
        
//        public static void main(String[] args) {
//            Time time1 = new Time("2015-12-7");
//            Time time2 = new Time();
//            System.out.println(time1);
//            System.out.println(time2);
//            System.out.println(time1.equalsWithDay(time2));
//        }

}
