import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Table {
    private ArrayList<HashMap<String,String>> table;
    private int intNumLines;
    private int intNumCols;
//    private TableFormatter tableFormatter;


//    public Table(Table data){
//        this.table = data.getTable();
//        this.intNumLines = data.getIntNumLines();
//        this.intNumCols = data.getIntNumCols();
//        this.tableFormatter = new TableFormatter(this.getTable(),this.intNumLines,this.intNumCols);
//    }


    public Table(ArrayList<HashMap<String,String>> data, int intNumLines, int intNumCols){
        this.table = data;
        this.intNumLines = intNumLines;
        this.intNumCols = intNumCols;
//        this.tableFormatter = new TableFormatter(this.getTable(),this.intNumLines,this.intNumCols);
    }


    public int getIntNumLines() {return intNumLines;}


    public int getIntNumCols() {return intNumCols;}


//    public void printTable() throws NoLinesTableException {this.tableFormatter.printTable();}


    public ArrayList<HashMap<String, String>> getTable() {return table;}
}
