import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Extract extract = new Extract("./input");
        Transform transform = new Transform(extract.getStrMatrixData());
        ArrayList<Hashtable<String,String>> temp = transform.getDataStorage().getTable();
        for(Hashtable<String, String> hashtable : temp){
            System.out.println(hashtable.entrySet());
        }

//        for(int i = 0,j=0; i<extract.getIntNumLines(); j++){
//            System.out.print(strMatrixData[i][j]+" ");
//            if(j==extract.getIntNumColumns()-1){
//                i++;
//                j=0;
//                System.out.println();
//            }
//        }
    }
}
