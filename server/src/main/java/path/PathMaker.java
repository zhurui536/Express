package path;

public class PathMaker {
	//这个类通过创建自身的对象来获得自身的绝对路径，从而获得存储文件额绝对路径
	
	public PathMaker(){
		
	}
	
	public static String getPath(){
		PathMaker maker = new PathMaker();
		
		String path = maker.getClass().getResource("") + "";
		
		String[] subs = path.split("/");
		
		path = "";
		
		for(int i=1;i<subs.length-1;i++){
			path = path + subs[i] + "/";
		}
		
		return path;
	}
	
	public static void main(String[] args){
		System.out.println(getPath());
		//下一行是上面的静态方法中不取子字符串输出的结果
		//  file:/C:/Users/Administrator/Documents/GitHub/Express/server/target/classes/path/
		//下一行是取了子字符串后输出的结果
		//  C:/Users/Administrator/Documents/GitHub/Express/server/target/classes/
	}
}
