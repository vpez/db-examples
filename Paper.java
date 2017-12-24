import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vahe Pezeshkian
 *         December 03, 2017
 */
public class Paper {
    private String id;
    private int year;
    private String journal;
    private int volume;
    private List<String> authors;
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append(year).append(" - ").append(title).append("\n");
        strBuilder.append(authors.stream().collect(Collectors.joining()));

        return strBuilder.toString();
    }
}
