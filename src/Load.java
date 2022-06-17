import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Load {
    private Graph graph;
    public Load(Graph graph){
        this.graph = graph;
    }

    public ArrayList<String> simpleRecommendation(String products){
        Set<String> set = new HashSet<>();
        Set<Node> nodesFaturas = new HashSet<>();
        String[] separatedProduct = products.split(",");
        ArrayList<Node> faturas = new ArrayList<>();
        ArrayList<Node> nodes = new ArrayList<>();
        ArrayList<String> resultado = new ArrayList<>();
        for(String prod : separatedProduct){
            faturas.addAll(this.graph.getNodebyString(prod).getConnections());
        }
        for (Node fatura: faturas){
            nodesFaturas.add(fatura);
        }
        for(Node fatura : nodesFaturas){
            nodes.addAll(fatura.getContentBy("items"));
        }
        for(Node node : nodes){
            if(!set.add(node.getContent())){
                resultado.add(node.getContent());
            }
        }
        return resultado;
    }

    public void filterRecommendation(String products, String filters){

    }

    public void queryRecommendation(String filters){

    }
}
