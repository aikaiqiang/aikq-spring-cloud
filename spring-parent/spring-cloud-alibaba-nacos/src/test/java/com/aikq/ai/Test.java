package com.aikq.ai;

/**
 *  E
 * @author aikq
 * @date 2018年12月19日 13:38
 */
public class Test {
	public static void main(String[] args) {
		A p = new A();
		int[] a = {1,2,3};
		System.out.println("a1="+ a[0] + ",r=" + p.trycatch(a) + ",a2=" + a[0]);
	}
}

class A{
	public int trycatch(int[] array){

		try{
			array[0] = 0;
			throw new Exception();   //1
//			return 10;               //2
		}catch(Exception e){
			array[0] = 3;
			return 100;
		}finally {
			array[0] = 9;
//			return 1000;            //3
		}
	}

}
