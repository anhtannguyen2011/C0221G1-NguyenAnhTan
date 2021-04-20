package bai_tap;

public class InsertSort {
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
                    System.out.println("Di chuyển phần tử : " + arr[holePosition]);

                }
                if(holePosition != i){
                    System.out.println("Chèn phần tử " +valueToInsert+", tại vị trí: " +holePosition);
                    //chèn phần tử tại vị trí chèn
                    arr[holePosition] = valueToInsert;
                }
                System.out.println("Vòng lặp thứ : " +i);

            }
        }
    public void display(int[] arr){
        int i;
        System.out.print("[");
        //Duyệt qua tất cả các phần tử
        for(i = 0; i<arr.length; i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        int[] arr= {6, 7, 0, 2, 8, 1, 3, 9, 4, 5};
        InsertSort sapXepChen = new InsertSort();
        System.out.println("Mang du lieu dau vao: ");
        sapXepChen.display(arr);
        System.out.println("-----------------------------");
        sapXepChen.insertionSort(arr);
        System.out.println("-----------------------------");
        System.out.println("\nMang sau khi da sap xep: ");
        sapXepChen.display(arr);
    }
}
