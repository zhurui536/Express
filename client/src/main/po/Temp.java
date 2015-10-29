package main.po;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

import main.bussinesslogic.util.ExpressType;
import main.bussinesslogic.util.PackageType;

public class Temp {

	public static void main(String[] args) throws IOException{
		GoodsPO goods = new GoodsPO(10010, "zhr", "nanjing", "sihong", 1, 3, PackageType.CARTONS, ExpressType.ECONOMIC);
		StorePlacePO place = new StorePlacePO(1, 1, 1, 1);
		
		InStorePO instore = new InStorePO(goods, goods.getDestination(), place);
		
		System.out.println(instore.getDate().getTime());
	}
}
