import java.util.*;

public class Load {
    private Graph graph;
    public Load(Graph graph){
        this.graph = graph;
    }

    public Set<String> simpleRecommendation(String products){
        Set<String> set = new HashSet<>();
        String[] separatedProduct = products.split(",");
        ArrayList<String> listOfProducts = new ArrayList<>();
        ArrayList<Node> faturas = new ArrayList<>();
        ArrayList<Node> nodes = new ArrayList<>();
        Set<String> resultado = new HashSet<>();
        for(String s : separatedProduct){
            listOfProducts.add(s);
            faturas.addAll(this.graph.getNodebyString(s).getConnections());
        }
        for (Node fatura: faturas){
            nodes.addAll(fatura.getContentBy("items"));
        }
        for(Node node : nodes){
            if(!set.add(node.getContent())){
                resultado.add(node.getContent());
            }
        }
        resultado.removeAll(listOfProducts);
        return resultado;
    }

    public void filterRecommendation(String products, String filters){
        String[] separatedProduct = products.split(",");
        Node node = this.graph.getNodebyString(filters);
        ArrayList<Node> faturas = new ArrayList<>();
        Set<Node> faturasComProdutos = new HashSet<>();
        faturas.addAll(node.getConnections());
//        for(Node fatura : faturas){
//            ArrayList<Node> items = new ArrayList<>();
//            boolean found = false;
//            for(Node item : fatura.getContentBy("items")){
//                if()
//            }
//        }
    }

    public int queryRecommendation(String filters){
        String[] separatedFilters = filters.split(",");
        ArrayList<Node> faturas = new ArrayList<>();
        Set<Node> faturasComuns = new HashSet<>();
        Set<Node> Resultado = new HashSet<>();
        for(String s : separatedFilters){
            faturas.addAll(this.graph.getNodebyString(s).getConnections());
        }
        for (Node node : faturas){
            if(!faturasComuns.add(node))
                Resultado.add(node);
        }
        return Resultado.size();
    }
}
