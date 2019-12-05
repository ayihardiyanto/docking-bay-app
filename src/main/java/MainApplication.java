import com.dkatalis.constant.Command;
import com.dkatalis.dao.CommandInputProcessorDao;
import com.dkatalis.dao.FileReaderProcessorDao;
import com.dkatalis.dao.impl.CommandInputProcessorDaoImpl;
import com.dkatalis.dao.impl.FileReaderProcessorDaoImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainApplication {
    private static BufferedReader bufferedReader;
    private static FileReaderProcessorDao file = new FileReaderProcessorDaoImpl();
    private static CommandInputProcessorDao input = new CommandInputProcessorDaoImpl();

    public static void main(String[] args) throws IOException {
        String getInput;
        try {
            if(args.length == 0){
                do {
                    System.out.print("$: ");
                    Scanner commandLine = new Scanner(System.in);
                    getInput = commandLine.nextLine();
                    interactiveBased(input, getInput);
                }while(getInput!= Command.EXIT);
            }
            else fileBasedExecutor(file, args[0]);
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    private static void interactiveBased(CommandInputProcessorDao input, String commandInput) throws IOException {
        input.inputCommand(commandInput);
    }

    private static void fileBasedExecutor(FileReaderProcessorDao reader, String arg) throws IOException {
        bufferedReader = Files.newBufferedReader(Paths.get(arg));
        reader.readCommand(bufferedReader);
    }
}
