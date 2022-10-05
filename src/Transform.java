import java.util.*;

public class Transform {
    private final Graph graph;
    private ArrayList<HashMap<String,String>> dataStorage;
    private int intNumLines;
    private int intNumCols;

    /**
     * Construtor da classe Transform.
     * Recebe a uma matriz de strings e num Grafo.
     *
     * @param strMatrixData matriz de strings com conteúdo da tabela.
     */
    Transform(String[][]strMatrixData){
        this.dataStorage = new ArrayList<>();
        transformData(strMatrixData);
        this.intNumLines = strMatrixData.length-1;
        this.intNumCols = strMatrixData[0].length;
        this.graph = new Graph(this.getDataStorage());
    }

    /**
     * Método que converte uma matriz de String's para uma ArrayList de HashMap's.
     * Percorre a matriz e adiciona os elementos na ArrayList de HashMap's.
     *
     * @param strMatrixData matriz de strings com conteúdo da tabela.
     */
    private void transformData(String[][] strMatrixData) {
        for(int i = 1; i<strMatrixData.length; i++){
            HashMap<String,String> map = new LinkedHashMap<>();
            for(int j = 0; j<strMatrixData[0].length; j++){
                map.put(strMatrixData[0][j], strMatrixData[i][j]);
            }
            this.dataStorage.add(map);
        }
    }

    /**
     * Método que retorna uma Tabela.
     *
     * @return objeto tabela com o conteúdo da matriz.
     */
    public Table getDataStorage() {return new Table(this.dataStorage,this.intNumLines,this.intNumCols);}

    /**
     * Método que retorna o Grafo.
     *
     * @return Graph grafo criado através dos dados.
     */
    public Graph getGraph(){
        return this.graph;
    }
}
