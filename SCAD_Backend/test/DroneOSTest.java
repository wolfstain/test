import co.s4n.scad.backend.entities.DroneOS;
import co.s4n.scad.backend.entities.InputFiles;
import co.s4n.scad.backend.entities.OutputFiles;
import org.junit.jupiter.api.Test;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

class DroneOSTest {

    private String inputTests=System.getProperty("user.dir")+"/resources/tests/inputs/";
    private String outputTests=System.getProperty("user.dir")+"/resources/tests/outputs/";
    private String expectedOutput=System.getProperty("user.dir")+"/resources/tests/expectedOutputs/";

    @Test
    public void TestCase() throws IOException {
        File f = new File(inputTests);
        File[] files = f.listFiles();

        for (int i = 0; i < files.length; i++) {
            InputFiles inpTest = new InputFiles(inputTests,"input_"+i+".txt");
            OutputFiles outTest = new OutputFiles(outputTests,"output_"+i+".txt");
            DroneOS drOS = new DroneOS(inpTest,outTest);
            File f1 = new File(outputTests+"/output_"+i+".txt");
            File f2 = new File(expectedOutput+"/expected_output_"+i+".txt");
            assert(FileUtils.contentEqualsIgnoreEOL(f1, f2, "utf-8"));
        }

    }


}