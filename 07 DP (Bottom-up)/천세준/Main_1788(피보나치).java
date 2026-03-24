import java.util.*;

public class Main_1788 {
    static final int DIV = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        if (N == 0) {
            System.out.println(0);
            System.out.println(0);
        } else if (N == 1) {
            System.out.println(1);
            System.out.println(1);
        } else {
            if (N > 0) {
                // 양수 방향 피보나치: F(n) = F(n-1) + F(n-2)
                int n = 2;
                int front = 1; // F(1)
                int back = 0;  // F(0)
                int current = 0;
                while(n <= N) {
                    current = (front + back) % DIV;
                    back = front;
                    front = current;
                    n++;
                }
                System.out.println(1); // N > 0 이면 항상 양수
                System.out.println(front);
            } else {
                // 음수 방향 피보나치: F(n-2) = F(n) - F(n-1)
                int n = -1;
                int f_curr = 0; // F(0)
                int f_next = 1; // F(1)
                int res = 0;
                
                while(n >= N) {
                    res = (f_next - f_curr) % DIV;
                    f_next = f_curr;
                    f_curr = res;
                    n--;
                }
                

                if (res > 0) System.out.println(1);
                else if (res < 0) System.out.println(-1);
                else System.out.println(0);
                
                System.out.println(Math.abs(res));
            }
        }
        sc.close();
    }
}
