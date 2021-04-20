package bai_tap;

public class InsertSortMethod {
    public void insertionSort(int[] arr){
        int valueToInsert;
        int holePosition;
        int i;
        for(i = 1; i <arr.length;i++){
            valueToInsert =arr[i];//Giá trị đã chèn
            holePosition = i;//Vị trí chèn
            while (holePosition > 0 && arr[holePosition -1 ] > valueToInsert){
                arr[holePosition] = arr[holePosition -1 ];
                holePosition--;


            }
            if(holePosition != i){
                //chèn phần tử tại vị trí chèn
                arr[holePosition] = valueToInsert;
            }


        }
        int j;
        System.out.print("[");
        //Duyệt qua tất cả các phần tử
        for(j = 0; j<arr.length; j++){
            System.out.print(arr[j]+ " ");
        }
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,4,7,2,9,10};
        InsertSortMethod insertSortMethod = new InsertSortMethod();
        insertSortMethod.insertionSort(arr);
    }
}
