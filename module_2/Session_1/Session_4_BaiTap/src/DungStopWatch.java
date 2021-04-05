import java.util.Arrays;
import java.util.Scanner;

public class DungStopWatch {
    private long startTime;
    private long endTime;

    long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
    DungStopWatch(){
        this.startTime = System.currentTimeMillis();
    }

    void start() {
        startTime = System.currentTimeMillis();
    }

    void end() {
        endTime = System.currentTimeMillis();
    }


    long getElapsedTime() {
        return (endTime - startTime);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DungStopWatch duration = new DungStopWatch();
        duration.start();
        System.out.println(duration.getStartTime());
//        int input;
//        int count = 1;
//        do {
//            System.out.println("Nhập vào số cần đếm :");
//            input = scanner.nextInt();
//            count++;
//            if(count > 3){
//                break;
//            }
//
//        }while (true);
        int[] arr = new int[500];
        for(int i = 0 ; i < arr.length; i++){
            arr[i] =(int) (Math.random() * 100);
        }
        Arrays.sort(arr);
        for (int i = 0 ; i < arr.length; i++){
            System.out.print(arr[i] + ",");
        }
        System.out.println("\b");
        duration.end();
        System.out.println(duration.getEndTime());
        System.out.println(duration.getElapsedTime());
    }
}
