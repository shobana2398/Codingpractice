import java.io.*;
import java.util.*;
public class CountNegPosofArray
{

public static int[] count(int arr[])
{
int pos=0,neg=0;
int count[]=new int[2];
for(int i=0;i<arr.length;i++)
{
if(arr[i]<0)
{
neg++;
}
else
{
pos++;
}
}
count[0]=pos;
count[1]=neg;

return count;
}
public static void main(String args[])
{
int arr[]={2,5,79,-35,78,-45};


System.out.print(Arrays.toString(count(arr)));
}
}