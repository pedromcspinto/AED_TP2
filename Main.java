import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Extract extract = new Extract("./input");
        String[][] strMatrixData = extract.getStrMatrixData();
        for(int i = 0,j=0; i<extract.getIntNumLines(); j++){
            System.out.print(strMatrixData[i][j]+" ");
            if(j==extract.getIntNumColumns()-1){
                i++;
                j=0;
                System.out.println();
            }
        }
    }
}
