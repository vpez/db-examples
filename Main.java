package am.aua.idx;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Vahe Pezeshkian
 *         December 03, 2017
 */
public class Main {

    static String file = "/Users/vahepezeshkian/Desktop/papers.lst";

    public static void main(String[] args) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(file));

        List<Paper> papers = lines.map(PaperMapper.objectMapper)
                .filter(paper -> paper.getYear() > 0)
                .sorted(Comparator.comparing(Paper::getYear))
                .collect(Collectors.toList());

        FileWriter writer = new FileWriter(file + ".sql");

        write(writer, "USE VPEZESHKIAN");
        write(writer, "DROP TABLE Paper");
        write(writer, "CREATE TABLE Paper (id CHAR(32), year INT, title VARCHAR(200))");

        for (int i = 0; i < papers.size(); i++) {
            if (i % 100 == 0) write(writer, "START TRANSACTION");
            write(writer, PaperMapper.sqlMapper.apply(papers.get(i)));
            if (i % 100 == 99) write(writer, "COMMIT");
        }

        if (papers.size() % 100 != 99) write(writer, "COMMIT");

        writer.close();
    }

    private static void write(FileWriter writer, String line) {
        try {
            writer.write(line + ";\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
