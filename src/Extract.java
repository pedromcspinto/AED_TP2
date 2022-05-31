import java.io.*;
import java.util.Hashtable;

public class Extract{
    private final String[][] strMatrixData;
    private int intNumColumns, intNumLines;

    Extract(String strFilePath) throws IOException {
        countColumnsAndLines(strFilePath);
        this.strMatrixData = new String[this.intNumLines][this.intNumColumns];
        readFile(strFilePath);
    }

    private void readFile(String strFilePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(strFilePath));
        String strLine;
        for (int i = 0; (strLine = bufferedReader.readLine()) != null; i++){
            strLine = this.extractAspas(strLine);
            String[] strSplittedLine = strLine.split(",");
            for (int j = 0; j < strSplittedLine.length; j++){
                this.strMatrixData[i][j] = strSplittedLine[j];
            }
        }
        bufferedReader.close();
    }

    private void countColumnsAndLines(String strFilePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(strFilePath));
        String[] strSplittedLine = bufferedReader.readLine().split(",");
        int intCountLines;
        String strLine;
        this.intNumColumns = strSplittedLine.length;
        for (intCountLines = 1; (strLine = bufferedReader.readLine()) != null; intCountLines++);
        this.intNumLines = intCountLines;
        bufferedReader.close();
    }

    public String[][] getStrMatrixData(){return this.strMatrixData;}

    public String extractAspas(String line){
        char[] charArray = line.toCharArray();
        int flag = -1;
        for (int i = 0; i<charArray.length; i++) {
            if(charArray[i] == '"')
                flag*=-1;

            if(flag==1 && charArray[i] == ',')
                charArray[i]=' ';
        }
        return new String(charArray).replace("\"", "");
    }
}
