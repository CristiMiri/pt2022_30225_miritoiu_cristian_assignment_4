package MODEL;

import java.io.*;

public class Serializator {

    public static void Serialization(Object o, String name) {
        String file = name+ ".ser";
        try {
            FileOutputStream fout=new FileOutputStream(file);
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(o);
            out.flush();
            //closing the stream
            out.close();
            fout.close();
            System.out.println("Object "+name+" Serialized");
        } catch (IOException  i) {
            i.printStackTrace();
        }
    }

    public static Object Deserialization(String file) {
        Object o = null;
        try {
            FileInputStream fileIn = new FileInputStream(file + ".ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            o = in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Object "+file+" Deserialized");
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return o;
    }
}
