import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;


    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;

    }
   public double getA(){
        return this.a;
    }
   public double getB(){
        return this.b;
    }
   public double getC(){
        return this.c;
    }


   public double getDiscriminant(){
        return (Math.pow(b,2) - (4 * a * c)) ;
    }
    public double getDouble(){
        return ((-b) / (2 * a));
    }

   public double getRoot1(){
        return ((-b - Math.sqrt(getDiscriminant())) / (2 * a)) ;
    }
   public double getRoot2(){
        return ((-b + Math.sqrt(getDiscriminant())) / (2 * a)) ;

    }
    String show(){
        return "QuadraticEquation:  "+this.a+"x2 +"+this.b+"x +"+this.c+ "= 0";

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập a :");
        double a = sc.nextDouble();
        System.out.print("Nhập b :");
        double b = sc.nextDouble();
        System.out.print("Nhập c :");
        double c = sc.nextDouble();
        QuadraticEquation quard = new QuadraticEquation(a,b,c);
        System.out.println(quard.show());
        if(quard.getDiscriminant() == 0){
            System.out.println("Phương Trình Có Nghiệm Kép x1,x2 = " +quard.getDouble());
        }else if(quard.getDiscriminant() > 0){
            System.out.println("Phương Trình Có 2 Nghiệm = "+ "\n"+ "x1 : " +quard.getRoot1() +"\t x2:" +quard.getRoot2());
        }else {
            System.out.println("Phương Trình Vô Nghiệm");
        }


    }
}
