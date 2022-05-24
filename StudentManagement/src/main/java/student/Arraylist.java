package student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		List<Integer> l=new ArrayList<Integer>();
        l.add(num);
        
        System.out.println(l);
	}

}
