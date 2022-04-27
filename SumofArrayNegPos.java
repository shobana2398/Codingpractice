import java.io.*;
import java.util.*;
public class SumofArrayNegPos
{
public static int[] Add(int arr[])
{
	int pos=0,neg=0;
	int sum[]=new int[2];
for(int i=0;i<arr.length;i++)
{
if(arr[i]<0)
{
neg+=arr[i];
}
else
{
pos+=arr[i];
}
}
sum[0]=pos;
sum[1]=neg;

return sum;
}
public static void main(String args[])
{


int arr[]={2,5,79,-35,78,-45};
System.out.print(Arrays.toString(Add(arr)));


}
}