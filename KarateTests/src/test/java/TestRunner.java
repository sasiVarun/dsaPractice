import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 *
 * 
 */
public class TestRunner {

	public static final Logger _logger = LoggerFactory.getLogger(TestRunner.class.getName());
    @Test
    public void testParallel() {
    	_logger.info("karate.environment = " + System.getProperty("karate.environment"));
    	if(System.getProperty("karate.environment") == null) {
    		System.setProperty("karate.environment", "dev");
    		System.out.println("Environment defaulted to: " + System.getProperty("karate.environment"));
    	}
    	
    	_logger.info("parallel.count = " + System.getProperty("parallel.count"));
    	if(System.getProperty("parallel.count") == null) {
    		System.setProperty("parallel.count", "1");
    		System.out.println("Parallel count defaulted to: " + System.getProperty("parallel.count"));
    	}
    	
    	List<String> paths = new ArrayList<String>();
    	paths.add("classpath:apitests");
    	
    	_logger.info("karate.options = " + System.getProperty("karate.options"));
        Results results = Runner.path(paths)
        		.outputCucumberJson(true)
        		.outputJunitXml(true)
        		.tags(System.getProperty("karate.options"))
//        		.tags("@a1")
        		.parallel(Integer.valueOf(System.getProperty("parallel.count")));
        generateReport(results.getReportDir());
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }

    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        
        Configuration config = new Configuration(new File("target"), System.getProperty("karate.environment"));
        config.addClassifications("Environment", System.getProperty("karate.environment"));
        config.addClassifications("Parallel.Count",System.getProperty("parallel.count"));        
        
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }

}