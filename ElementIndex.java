import java.io.*;
import java.util.*;
public class ElementIndex
{
public static int index(int arr[],int n)
{
int index;
for(int i=0;i<arr.length;i++)
{
if(arr[i]==n)
{
return i;
}
}
return -1;
}

public static void main(String args[])
{
int arr[]={52,85,46,75,6,95};
Scanner sc=new Scanner(System.in);
int searchele=sc.nextInt();
System.out.print(index(arr,searchele));
}
}