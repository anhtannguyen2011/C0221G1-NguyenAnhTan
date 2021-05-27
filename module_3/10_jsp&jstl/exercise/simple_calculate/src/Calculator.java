public class Calculator {
    public static float calculate(float fist, float second, String operator) {
        switch (operator) {
            case "+" :
                return (fist + second);
            case "-" :
                return (fist - second);
            case "*":
                return (fist * second);
            case "/":
                if (second != 0) {
                    return (fist / second);
                }else{
                        throw new ArithmeticException("Sai nguyên tăc / zero");
                }
            default:
                throw new RuntimeException("Không hợp lệ");
        }
    }
}
