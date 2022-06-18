import java.util.ArrayList;
import java.util.HashMap;

public class Table {
    private ArrayList<HashMap<String,String>> table;
    private int intNumLines;
    private int intNumCols;

    /**
     * Construtor da classe Table.
     * Inicializa com os dados lidos do ficheiro o número de linhas e colunas.
     *
     * @param data dados lidos do ficheiro
     * @param intNumLines número de linha
     * @param intNumCols número de colunas
     */
    public Table(ArrayList<HashMap<String,String>> data, int intNumLines, int intNumCols){
        this.table = data;
        this.intNumLines = intNumLines;
        this.intNumCols = intNumCols;
    }

    /**
     *  Devolve os dados do ficheiro
     *
     * @return ArrayList de hashmaps que contem os dados
     */
    public ArrayList<HashMap<String, String>> getTable() {return table;}
}
