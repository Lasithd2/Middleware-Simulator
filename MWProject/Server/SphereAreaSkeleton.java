
import java.io.*;
import java.net.*;

public class SphereAreaSkeleton {
    private static Socket socket;

    public void skeletonExecute() throws IOException {

         ServerSocket serverSocket = new ServerSocket(4000);
//while loop used to handle multiple requests
         while(true){
         socket = serverSocket.accept();

        try {
            ObjectOutputStream OS = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream OI = new ObjectInputStream(socket.getInputStream());

            Marshalling serialObject = (Marshalling) OI.readObject();

			System.out.println("Input radius by client is " + serialObject.n);
            SphereAreaServer sphere = new SphereAreaServer();
            serialObject.area = sphere.calculateSphereArea(serialObject.n);
            OS.writeFloat(serialObject.area);
            OS.flush();

            socket.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
		}
        }
    }
}