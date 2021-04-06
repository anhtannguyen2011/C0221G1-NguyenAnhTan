public class TongDuongCheoMaTranVuong {
    public static void main(String[] args){
        int arr[][] = {
                {1,2,3},
                {2,3,4},
                {2,3,4}
        };
        int total = 0;
        for(int i = 0 ; i < arr.length ; i++){
            for(int j = 0; j< arr.length ; j++){
                if( i == j){
                    total += arr[i][j];
                }
            }
        }
        System.out.println("Tổng Ma Trận Vuông Là : " +total);
    }
}
