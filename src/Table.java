import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Table {
    private ArrayList<HashMap<String,String>> table;
    private int intNumLines;
    private int intNumCols;

    public Table(ArrayList<HashMap<String,String>> data, int intNumLines, int intNumCols){
        this.table = data;
        this.intNumLines = intNumLines;
        this.intNumCols = intNumCols;
    }


    public int getIntNumLines() {return intNumLines;}


    public int getIntNumCols() {return intNumCols;}


    public ArrayList<HashMap<String, String>> getTable() {return table;}
}
