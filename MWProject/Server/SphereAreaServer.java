import java.io.IOException;

public class SphereAreaServer {

////method to calculate area of a Sphere
	public float calculateSphereArea(float n) {
	        return (float)Math.PI*n*n*4;
	    }

    public static void main(String args[]) throws IOException {
        SphereAreaSkeleton sphere = new SphereAreaSkeleton();
        sphere.skeletonExecute();
    }
}
