package BaiTap;

import java.util.Arrays;

public class MoveablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;

    public MoveablePoint() {
    }

    public MoveablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] arr = new float[4];
        arr[0] = this.getX();
        arr[1] = this.getY();
        arr[2] = this.getxSpeed();
        arr[3] = this.getySpeed();
        return arr;
    }

    @Override
    public String toString() {
        return "MoveablePoint{" +
                "Tọa độ(x,y)=" + Arrays.toString(getXY()) +
                ",Tọa độ(xSpeed,ySpeed)=" + Arrays.toString(getSpeed()) +
                '}';
    }

    public MoveablePoint move() {
        super.x += xSpeed;
        super.y += ySpeed;
        return this;
    }
}
