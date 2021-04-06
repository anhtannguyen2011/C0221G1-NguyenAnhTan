public class TimGiaTriNhoNhatTrongMang {
    public static int minValue(int[] array){
        return -1;
    }
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 10, 6, 9};
        int min = arr[0];
        int index = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            if(min > arr[i]){
                 min = arr[i];
                index = i;
            }
        }

        System.out.println("The smallest element in the array is: " + arr[index]);
    }
}
