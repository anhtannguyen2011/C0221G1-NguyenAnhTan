package bai_tap;

public class SearchBinary {

    //    static int binarySearch(int arr[], int check,int high){
//         int low = 0;
//         high = arr.length -1;
//         while (high >= low){
//             int mid = (low + high) / 2;
//             if(check < arr[mid]){
//                 high = mid -1;
//             }else if(check == arr[mid]){
//                 return mid;
//             }else {
//                 low = mid + 1;
//             }
//         }
//         return -1;
//
//    }
//
//    public static void main(String[] args) {
//
//        int array[] ={3,4,5,6,7,8,9};
//        int n = array.length;
//        int check = 7;
//        int result = SearchBinary.binarySearch(array,check,n);
//        if(result == -1){
//            System.out.println("Not Found");
//        }else {
//            System.out.println("Element found at index " +result);
//        }
//
//    }
    int binarySearch(int array[], int x, int low, int high) {

        if (high >= low) {
            int mid = (low + high) /2;
            if (array[mid] == x){
                return mid;
            }

            if (array[mid] > x){
                return binarySearch(array, x, low, mid - 1);
            }
            return binarySearch(array, x, mid + 1, high);
        }

        return -1;
    }

    public static void main(String args[]) {
        SearchBinary ob = new SearchBinary();
        int array[] = {3, 4, 5, 6, 7, 8, 9};
        int n = array.length;
        int x = 8;
        int result = ob.binarySearch(array, x, 0, n - 1);
        if (result == -1)
            System.out.println("Not found");
        else
            System.out.println("Element found at index " + result);
    }
}
