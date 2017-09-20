import java.io.IOException;

public class CircleAreaServer {

//method to calculate area of a Circle
	public float calculateCircleArea(float n) {
	        return (float)Math.PI*n*n;
	    }

    public static void main(String args[]) throws IOException {
        CircleAreaSkeleton circle = new CircleAreaSkeleton();
        circle.skeletonExecute();
    }
}
