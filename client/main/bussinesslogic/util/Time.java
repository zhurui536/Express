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

        @Override
        public String toString() {
                return dateFormater.format(date);
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
        

}
