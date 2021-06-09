import java.io.*;
import java.util.ArrayList;

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

    public ArrayList<Book> readBooksData() throws IOException {

        file = new File("books_data.csv");

        if(file.exists()) {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<Book> books = new ArrayList<>();
            String row = null;
            Book book = null;
            while((row = bufferedReader.readLine())!=null){
                String[] book_data = row.split(";");
                book = new Book(0,Integer.parseInt(book_data[5]),
                        book_data[1],book_data[2],book_data[4],Float.parseFloat(book_data[3]),book_data[0]);
                books.add(book);
            }
            bufferedReader.close();
            return books;
        }
        else{
            return null;
        }
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
