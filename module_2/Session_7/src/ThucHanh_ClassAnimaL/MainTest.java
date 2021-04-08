package ThucHanh_ClassAnimaL;

public class MainTest {
    public static void main(String[] args) {
        Fruit[] fruit = new Fruit[2];
        fruit[0] = new Orange();
        fruit[1] = new Apple();
        for(Fruit fruit1 : fruit){
            System.out.println(fruit1.howToEat());
        }

    }
}
