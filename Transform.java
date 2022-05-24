import java.util.*;

public class Transform {
    private ArrayList<Hashtable<String,String>> dataStorage;
    private int intNumLines;
    private int intNumCols;

    Transform(String[][]strMatrixData){
        this.dataStorage = new ArrayList<>();
        transformData(strMatrixData);
        this.intNumLines = strMatrixData.length-1;
        this.intNumCols = strMatrixData[0].length;
    }

    private void transformData(String[][] strMatrixData) {
        for(int j = 0; j<strMatrixData[0].length; j++){
            for(int i = 1; i<strMatrixData.length; i++){
                Hashtable<String,String> map = new Hashtable<>();
                map.put(strMatrixData[0][j], strMatrixData[i][j]);
                this.dataStorage.add(map);
            }
        }
    }

    public Table getDataStorage() {return new Table(this.dataStorage,this.intNumLines,this.intNumCols);}
}
