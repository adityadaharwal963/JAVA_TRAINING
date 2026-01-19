public class Array {

    public static int[] resize(int[] arr,int capacity){
        int[] temp = new int[capacity];

        for(int i=0;i<capacity && i<arr.length;i++){
            temp[i] = arr[i];
        }
        return temp;

    }
    public static void main(String[] args) {
        int[] array = {8,9,7,9};
        array = resize(array,8);
        System.out.println(array.length);
    }
}
