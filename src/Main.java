import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        Extract extract = new Extract("./Input");
        Transform transform = new Transform(extract.getStrMatrixData());
        ArrayList<Hashtable<String,String>> temp = transform.getDataStorage().getTable();
        for(Hashtable<String, String> hashtable : temp){
            System.out.println(hashtable.entrySet());
        }
        Graph graph = new Graph(transform.getDataStorage());
        Set<Node> set = graph.getSet();
        for (Node node: set){
            System.out.print("Node pai: ");
            System.out.println(node.getIdentifier());
            System.out.println("Connections:");
            for(Node tmp: node.getConnections()){
                System.out.println(tmp.getIdentifier());
            }
            System.out.println("End");
            System.out.println();
        }


//            Hashtable<String,String> hashtable1 = new Hashtable<String, String>();
//            hashtable1.put("order_Id", "30245");
//
//            Node node = new Node(hashtable1);
//
//            System.out.println(node.getType());
    }
}
