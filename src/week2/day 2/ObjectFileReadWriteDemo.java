import java.io.*;

public class ObjectFileReadWriteDemo {

    static void readObjectFromFile(String file){
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
            Flope flope = (Flope) inputStream.readObject();
            System.out.println(flope);
        }catch (IOException | ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    static void writeObjectToFile(String file){
        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file));
            Flope flope = new Flope("GONE","HELLO  TEXT");
            System.out.println("Write: "+flope);
            outputStream.writeObject(flope);
            outputStream.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        writeObjectToFile("tempo.txt");
        readObjectFromFile("tempo.txt");
    }
}


class Flope implements Serializable {
    String name;
    String content;

    public Flope(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Flope {" +
                "name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}