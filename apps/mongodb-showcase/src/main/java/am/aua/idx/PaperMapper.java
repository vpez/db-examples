package am.aua.idx;

import java.util.Arrays;
import java.util.UUID;
import java.util.function.Function;

/**
 * @author Vahe Pezeshkian
 *         December 03, 2017
 */
public class PaperMapper {

    public static Function<String, Paper> objectMapper = line -> {
        try {
            Paper paper = new Paper();

            String yearStr = line.substring(0, 4);
            String authors = line.substring(24, line.indexOf(','));
            String title = line.substring(line.indexOf(',') + 2);

            paper.setId(UUID.randomUUID().toString().replace("-", ""));
            paper.setYear(Integer.valueOf(yearStr));
            paper.setTitle(title);

            String[] split = authors.split("&");
            paper.setAuthors(Arrays.asList(split));

            return paper;
        } catch (Exception e) {
            System.out.println("Exception on line " + line);
            e.printStackTrace();
        }
        return new Paper();
    };


    public static Function<Paper, String> sqlMapper = paper -> {
        StringBuilder sqlBuilder = new StringBuilder();

        sqlBuilder.append("INSERT INTO Paper(id, year, title) VALUES (")
                .append("'").append(paper.getId()).append("', ")
                .append(paper.getYear()).append(", ")
                .append("'").append(paper.getTitle().replace('\'', ' ')).append("'")
                .append(")");

        return sqlBuilder.toString();
    };
}
