

public class CacSoNguyenToNhoHonMotTram {
    public static void main(String[] args) {

        int n = 2;

        while (n < 100) {
            boolean check = true;
            if (n < 2) {
                check = false;
            } else {
                for (int i = 2; i < n; i++) {
                    if (n % i == 0) {
                        check = false;
                        break;
                    }
                }
            }
            if (check) {
                System.out.print(n + " ");
            }
            n++;
        }
    }
}

