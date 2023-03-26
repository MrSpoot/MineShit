package engine.math;

public class Vector3f {
    private float x, y, z;

    public Vector3f(){
        this(0,0,0);
    }

    public Vector3f(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3f(Vector3f vec) {
        this.x = vec.getX();
        this.y = vec.getY();
        this.z = vec.getZ();
    }

    public Vector3f normalize(){
        this.x /= length();
        this.y /= length();
        this.z /= length();
        return this;
    }

    public float length(){
        return (float) Math.sqrt(x*x + y*y + z*z);
    }

    public Vector3f add(Vector3f vec){
      this.x += vec.getX();
        this.y += vec.getY();
        this.z += vec.getZ();
        return this;
    }

    public Vector3f sub(Vector3f vec){
        this.x -= vec.getX();
        this.y -= vec.getY();
        this.z -= vec.getZ();
        return this;
    }

    public Vector3f mul(Vector3f vec){
        this.x *= vec.getX();
        this.y *= vec.getY();
        this.z *= vec.getZ();
        return this;
    }

    public Vector3f div(Vector3f vec){
        this.x /= vec.getX();
        this.y /= vec.getY();
        this.z /= vec.getZ();
        return this;
    }

    public Vector3f addX(float v){
        this.x += v;
        return this;
    }

    public Vector3f subX(float v){
        this.x -= v;
        return this;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public Vector3f addY(float v){
        this.y += v;
        return this;
    }

    public Vector3f subY(float v){
        this.y -= v;
        return this;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Vector3f addZ(float v){
        this.z += v;
        return this;
    }

    public Vector3f subZ(float v){
        this.z -= v;
        return this;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
