package main.bussinesslogic.util;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Time implements Comparable<Time>,Serializable{

        private static final long serialVersionUID = 1L;

        private static final SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

        private Date date;
        
        public Time() {
                date = new Date();
        }
        
        public Date getDate() {
                return date;
        }

        @Override
        public String toString() {
                return dateFormater.format(date);
        }

        @Override
        public int compareTo(Time o) {
                if (date.before(o.getDate())) {
                        return -1;
                }
                else if(o.getDate().before(date)){
                        return 1;
                }
                return 0;
        }
        

}
