import java.io.*;

public class FileManager {

    private File file = null;

    public FileManager() {
        file = new File("RememberUserCredentials.txt");
    }

    public void writeUserId(int userId) throws IOException{
        FileWriter fileWriter =  new FileWriter("RememberUserCredentials.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(userId);
        bufferedWriter.close();
    }

    public int readUserId() throws IOException{

        if(file.exists()) {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            int userId;
            userId = bufferedReader.read();
            bufferedReader.close();
            return userId;
        }
        else{
            return -1;
        }
    }

}
