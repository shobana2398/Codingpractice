import java.util.Arrays;
 
public class MergeSort
{
public static void main(String[] args)
{
int[] input = { 87, 57, 370, 110, 90, 610, 02, 710, 140, 203, 150 };

System.out.println(Arrays.toString(input));
}
public static void mergesort(int[] input)
{
mergesortArray(input, 0, input.length - 1);
}
private static void mergesortArray(int[] input, int start, int end)
{
 int mid = (start + end) / 2;
 if (start < end)
 {
 mergesortArray(input, start, mid);
 mergesortArray(input, mid + 1, end);
 }
 int i = 0,
 first = start,
 last = mid + 1;
 int[] tmp = new int[end - start + 1];
 while (first <= mid && last <= end)
 {
 tmp[i++] = input[first] < input[last] ? input[first++] : input[last++];
 }
 while (first <= mid)
 {
 tmp[i++] = input[first++];
 }
 while (last <= end)
 {
 tmp[i++] = input[last++];
 }
 i = 0;
 while (start <= end)
 {
 input[start++] = tmp[i++];
 }
 }
 }


