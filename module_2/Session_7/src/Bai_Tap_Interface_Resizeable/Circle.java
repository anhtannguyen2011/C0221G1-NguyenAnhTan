package Bai_Tap_Interface_Resizeable;

public class Circle extends Shape implements Resizeable {

        private double radius =1;
        private String color;

        public Circle() {
        }
        public Circle(double radius){
            this.radius = radius;
        }

        public Circle(double radius, String color) {
            this.radius = radius;
            this.color = color;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
        public double getArea(){
            return radius * radius * Math.PI;
        }

        @Override
        public String toString() {
            return "Circle{" +
                    "radius=" + getRadius() +
                    ", color='" + this.color +
                    ", are=" + getArea() +
                    '\'' +
                    '}';
        }

    @Override
    public void resize(double percent) {
        setRadius(getRadius() * (percent / 100));
    }
}
