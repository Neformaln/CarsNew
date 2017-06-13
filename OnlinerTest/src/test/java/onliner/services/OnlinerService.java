package onliner.services;



import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 11.06.2017.
 */
public class OnlinerService {

    private static final String BROWSER_PROPERTIES_PATH="config.properties";

    private static final String OPINIONS_FILE_PATH="src/main/resources/opinions.csv";

    private static Logger logger = Logger.getLogger(OnlinerService.class);

    public Properties readProperties(){
        logger.info("Create csv file");
        File ff = new File(getClass().getClassLoader().getResource(BROWSER_PROPERTIES_PATH).getFile());
        Properties property = new Properties();
        try (FileInputStream fis = new FileInputStream(ff)){
            property.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return property;
    }

    /**
     *  search opinions
     *
     */
    public Set findClassesForOpinions(String pageSourse) {
        logger.info("Seeking opinions through regular expressions");
        Pattern p = Pattern.compile("([b]\\-[a-z_2-]+\\_(green|blue|red))");
        Matcher m = p.matcher(pageSourse);
        Set<String> classes= new LinkedHashSet<>();
        while(m.find()) {
            classes.add(pageSourse.substring(m.start(), m.end()));
        }
        return classes;
    }

    public void saveOpinionsInCsv(List data){
        logger.info("Save opinions on csv file");
        Path path = Paths.get(OPINIONS_FILE_PATH);
        try {
            Files.write(path, data);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
