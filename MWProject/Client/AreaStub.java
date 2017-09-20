

import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AreaStub {

   int port;
   ObjectOutputStream OS;
   ObjectInputStream OI;

//creating the constructor of the AreaStub.java class
public AreaStub(String shape){
    try {
        port = getPortNo(shape);

        if(shape=="Circle"){
			System.out.println("The client is conneted to CircleAreaServer through port 3000");
		}
		else{
			System.out.println("The client is conneted to SphereAreaServer through port 4000");
		}

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AreaStub.class.getName()).log(Level.SEVERE, null, ex);
        }
        Socket s;

       try {
           s = new Socket("localhost",port);
           OS=new ObjectOutputStream(s.getOutputStream());
           OI=new ObjectInputStream(s.getInputStream());

       } catch (IOException ex) {
           Logger.getLogger(AreaStub.class.getName()).log(Level.SEVERE, null, ex);
       }

    }
//Method used to locate the server port number based on the shape
public final int getPortNo(String shape) throws ClassNotFoundException {

    File registry = new File("Registry.txt");
    String port="";
	Scanner get = null;

    try {
		get = new Scanner(registry);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AreaStub.class.getName()).log(Level.SEVERE, null, ex);
        }

       while (get.hasNextLine()) {
           String[] line = get.nextLine().split(" ");
           if (shape.equals(line[0])) {
           port=line[1];
           break;
	   }
   }
   int portNo=Integer.parseInt(port);
   return portNo;
    }

//Server method signatures in the stub to guarantee access transparency
public float calculateCircleArea(float n) throws IOException {

   float area = 0;
   Marshalling shapes = new Marshalling(n,area);
   OS.writeObject(shapes);
   OS.flush();
   area = OI.readFloat();
   return area;
}


public float calculateSphereArea(float n) throws IOException {
   float area = 0;
   Marshalling shapes = new Marshalling(n,area);
   OS.writeObject(shapes);
   OS.flush();
   area = OI.readFloat();
   return area;
 }
}
