package engine.math;

import java.util.Objects;

public class Vector2f {
    private float x, z;
    private int hashCode;

    public Vector2f(){
        this(0,0);
    }

    public Vector2f(float x, float z) {
        this.x = x;
        this.z = z;
        this.hashCode = Objects.hash(x, z);

    }

    public Vector2f(Vector2f vec) {
        this.x = vec.getX();
        this.z = vec.getZ();
    }

    public Vector2f normalize(){
        this.x /= length();
        this.z /= length();
        return this;
    }

    public float length(){
        return (float) Math.sqrt(x*x + z*z);
    }

    public Vector2f add(Vector2f vec){
      this.x += vec.getX();
        this.z += vec.getZ();
        return this;
    }

    public Vector2f sub(Vector2f vec){
        this.x -= vec.getX();
        this.z -= vec.getZ();
        return this;
    }

    public Vector2f mul(Vector2f vec){
        this.x *= vec.getX();
        this.z *= vec.getZ();
        return this;
    }

    public Vector2f div(Vector2f vec){
        this.x /= vec.getX();
        this.z /= vec.getZ();
        return this;
    }

    public Vector2f addX(float v){
        this.x += v;
        return this;
    }

    public Vector2f subX(float v){
        this.x -= v;
        return this;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public Vector2f addZ(float v){
        this.z += v;
        return this;
    }

    public Vector2f subZ(float v){
        this.z -= v;
        return this;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Vector2f that = (Vector2f) o;
        return x == that.x && z == that.z;
    }

    @Override
    public int hashCode() {
        return this.hashCode;
    }
}
