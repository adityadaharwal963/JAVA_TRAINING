import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;


class User{
    String name;
}
class FileUser extends User{

}

class Group extends User{

    HashSet<User> users;

//    void addFile(FileProperties file,int ) {
//
//    }
}
class FileProperties{
    File file;
    String Owner;
    HashMap<String,FileProperties> files;
    public FileProperties(File file, String Owner) {
        this.file = file;
        this.Owner = Owner;
        this.files = new HashMap<>();
    }
    public boolean hasPermission(User user,String permissionType){
        return true;
    }
}

class File{
    String fileName;
    String Owner;
    String content;
    File(String fileName, String content,String Owner) {
        this.fileName = fileName;
        this.content = content;
    }

    void readFile(){
        System.out.println(content);
    }

    void writeFile(String content){
        this.content = content;
    }
    void executeFile(){
        System.out.println("Executed File:"+fileName);
    }
}


public class FileSystem {
    static int byteToInt(int byteCode){
        int result = 0;
        while (byteCode > 0){
            result += (byteCode/10)*2;
            byteCode /= 10;
        }
        return result;
    }
    static int permissiontoByte(String permission){
        if(permission.length()!=9){ // invalid input
            return 0; // no permission
        }else {
            int result = 0;

            int index = 0;
            for(int j=0;j<3;j++){
                int byteCode = 0;
                for(int i=index;i<index+3;i++){
                    if(permission.charAt(i)!='-'){
                        byteCode += 1;
                    }
                    byteCode *= 10;
                }
            result += byteToInt(byteCode);
            result *= 10;
            index+=3;
            }
            return result;
        }
    }
    static void main() {
//        //  create Users
//        User user = new User("admin");
//        User user1 = new User("manager");
//        User user2 = new User("manager1");
//        User user3 = new User("manager2");
//        User user4 = new User("manager3");
//        // create files
//        File[] files = new File[10];
//        for(int i = 0; i < files.length; i++){
//            files[i] = new File(String.valueOf("File"+i),"File data "+1,"admin");
//        }
//
//        Group groups1 = new Group();
//        Group groups2 = new Group();
//
//        // grant readwrite permission to group1 on file 0 to 2
//        for(int i = 0; i < 3; i++){
//            groups1.addFile();
//        }

        System.out.println(permissiontoByte("rwxr-xr--"));

    }
}
