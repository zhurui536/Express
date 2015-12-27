package presentation.logisticsui;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {
        
        private InputChecker() {}
        /**
         * 判断字符串是否包含中文字符
         * @param str 待检测字符串
         * @return 
         */
        public static boolean isChineseChar(String str){
                Pattern p=Pattern.compile("[\u4e00-\u9fa5]");
                Matcher m=p.matcher(str);
                return m.find();
            }
        /**
         * 判断字符串是否为纯数字
         * @param str 待检测字符串
         * @return
         */
        public static boolean isNum(String str){
                return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
        }
        /**
         * 判断字符串是否为纯英文字符
         * @param str 待检测字符串
         * @return
         */
        public static boolean isChar(String str) {
                return str.matches("[a-zA-Z]");
        }
        
        /**
         * 判断字符串数字是否为负数
         * @param str 字符串数字
         * @return
         */
        public static boolean isMinus(String str) {
        	return isNum(str) && str.charAt(0) == '-';
        }
        
        /**
         * 判断字符串是否为合法的身份证号
         * @param str 长度为18的字符串
         * @return
         */
        public static boolean isIdNum(String str) {
//                str = str.toLowerCase();
                return isNum(str) || (isNum(str.substring(0,str.length()-1))&& str.charAt(str.length() - 1) == 'x');
        }
}
