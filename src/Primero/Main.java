package Primero;

import java.io.*;

public class Main {

    public static void lectura(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            // Primero.Alumno a = (Primero.Alumno) ois.readObject();
            Alumno a[] =(Alumno[])ois.readObject();
            // System.out.println(a);
            System.out.println();

        } catch (IOException|ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void escritura(String ruta) {
        try (FileOutputStream fos = new FileOutputStream(ruta)) {
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            // Primero.Alumno a = new Primero.Alumno(1, 10);
            Alumno a[] = {new Alumno(1,10), new Alumno(2,5)};
            oos.writeObject(a);
            oos.close();
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String ruta = "alumno.bin";
        escritura(ruta);
        lectura(ruta);

    }
}
