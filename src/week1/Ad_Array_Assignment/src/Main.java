
import java.util.Arrays;

public class Main {

    public static void problem1(int[] arr){
//      LongestConsecutiveSequence
        Arrays.sort(arr);
        int n = arr.length , max=Integer.MIN_VALUE , count =1 ;
        int num=0;
        for(int i =1;i<n;i++){
            if(arr[i]==arr[i-1]+1){
                count++;
            }else{
                if(count>max){
                    max= count ;
                    num=arr[i-1];

                }
                count =1;
            }

        }

        for(int i= num-max+1 ;i<=num;i++){
            System.out.print(i + " ");
        }


    }

    public static void problem2(int[][] arr) {
//      RotateMatrixBy90Degrees
        int n = arr.length;
        int m = arr[0].length;
        for(int i =0;i<n;i++){
            for(int j =i+1 ;j<m;j++){
                int temp = arr[i][j];
                arr[i][j]=arr[j][i];
                arr[j][i] =temp ;

            }
        }
        int left =0 , right =m-1;
        while(left<=right) {
            for (int i = 0; i < n; i++) {
                int temp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right]=temp ;
            }
            left++;
            right--;
        }
        for(int[] a : arr){
            System.out.println(Arrays.toString(a));

        }

    }

    public static void problem3(String s ){
//        FirstNonRepeatingCharacter
        int n = s.length();
        int[] arr  = new int[26];
        Arrays.fill(arr, 0);
        boolean check=false;
        for(int i =0;i<n;i++){
            arr[s.charAt(i)-'a']++;

        }
        for(int i =0;i<n;i++){
            if(arr[s.charAt(i)-'a']==0){
                System.out.println(s.charAt(i));
                check=true;
                break;
            }

        }
        if(!check){
            System.out.println(-1);
        }

    }

    public static String  problem6(String s ){
        // StringCompression
        String ans ="";
        int n = s.length();
        int count =1;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                count++;
            }else{
                if(count==1){
                    ans += s.charAt(i-1);

                }else{
                    ans += s.charAt(i-1) + count;
                }
                count=1;
            }

        }
        if(count==1){
            ans+=s.charAt(n-1);

        }else{
            ans = ans + s.charAt(n-1) +"" + count;
        }
        return ans.length()>s.length()?  s : ans ;
    }

    public static int problem7(int[] nums) {
//    Eqillibrium Index
        int sum =0 , n = nums.length;
        for(int i : nums){
            sum+=i;
        }

        int left = 0 ;
        sum-=nums[0];
        if(left==sum){
            return 0;
        }

        for(int i =1;i<n;i++){
            left+=nums[i-1];
            sum-=nums[i];
            if(left==sum){
                return i;
            }

        }
        return -1 ;
    }
    public static void main(String[] args) {

        //problem 7
        int [] arr3={1,9,3,6,3,6};
        System.out.println(problem7(arr3));

    }
}
