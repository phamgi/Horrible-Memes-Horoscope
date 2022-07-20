package main.java;



import java.io.FileNotFoundException;
import java.util.ArrayList;

public class main {
    // these will be aggregated by dynamoDB
public static int amountOfMemesInDB;
public static long longValueOfHoroscope;
    public static void main(String[] args) throws FileNotFoundException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        long seed = Long.parseLong(dtf.format(now).replaceAll("/", ""));
        System.out.println(seed);
        Random random = new Random((seed/longValueOfHoroscope));
        int indexOfMeme = random.nextInt(amountOfMemesInDB);
        // next step grab meme from DB with indexOfMeme
        // due to random seeding all users of the same horoscope will receive the same meme
        // due to constant date pulling meme will change daily
        jsonParser jsonParser = new jsonParser();
        ArrayList urls = jsonParser.parse();
        MemeDao memeDao = new MemeDao();
        memeDao.saveMemeList(urls);
    }
}
