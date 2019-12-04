import com.dkatalis.constant.Command;
import com.dkatalis.dao.CommandInputProcessorDao;
import com.dkatalis.dao.CommandExecutorDao;
import com.dkatalis.dao.FileReaderProcessorDao;
import com.dkatalis.dao.impl.CommandInputProcessorDaoImpl;
import com.dkatalis.dao.impl.FileReaderProcessorDaoImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainApplication {
    private static BufferedReader bufferedReader;
    private static FileReaderProcessorDao reader = new FileReaderProcessorDaoImpl();
    private static CommandInputProcessorDao input = new CommandInputProcessorDaoImpl();

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader inputToRead;
            if(args.length == 0){
                System.out.print("$ ");
                inputToRead = new BufferedReader(new InputStreamReader(System.in));
                interactiveBased(input, inputToRead);
            }
            else fileBasedExecutor(reader, args[0]);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    private static void interactiveBased(CommandInputProcessorDao input, BufferedReader command) throws IOException {
        input.inputCommand(command);
    }

    private static void fileBasedExecutor(FileReaderProcessorDao reader, String arg) throws IOException {
        bufferedReader = Files.newBufferedReader(Paths.get(arg));
        reader.readCommand(bufferedReader);
    }
}
