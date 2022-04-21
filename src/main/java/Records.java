import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

public class Records
{

    static File file = new File("/var/log/auth.log");

    public static List GetLastRecords(File file, int count) throws IOException
    {
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        Stream<String> stream = reader.lines();
        List<String> result = stream.toList();

        fr.close();
        reader.close();

        return result.subList(result.size() - count,result.size());
    }

    public static ArrayList<String> CheckFile(Path path, String fileName) throws IOException, InterruptedException
    {
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService,ENTRY_MODIFY, ENTRY_DELETE);

        WatchKey key = watchService.take();
        int nom = 0; // number of modifications

        for(WatchEvent<?> event : key.pollEvents())
        {
            if(event.kind() == ENTRY_MODIFY)
            {
                Path filePath = ((WatchEvent<Path>) event).context();

                if(filePath.endsWith(fileName))
                {
                    System.out.println("File " + filePath + " was modified" );
                    nom++;
                }
            }
            else if(event.kind() == ENTRY_DELETE) {
                System.out.println("File " + ((WatchEvent<Path>) event).context() + " was deleted");
            }
            else {
                System.out.println("Unsupported event kind");
            }
        }
        key.reset();

        //GetLastRecords(file,nom).forEach(System.out::println);
       // GetLastRecords(file,nom).forEach((log) - creareAsset);
        //createAsset();

        return (ArrayList<String>)GetLastRecords(file,nom);

    }
}
