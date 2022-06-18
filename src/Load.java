import java.util.*;

public class Load {
    private Graph graph;
    public Load(Graph graph){
        this.graph = graph;
    }

    public Set<String> simpleRecommendation(String products){
        Set<String> setTemp = new HashSet<>();
        String[] arStrProducts = products.split(",");
        ArrayList<String> listOfProducts = new ArrayList<>();
        ArrayList<Node> arNodeFaturas = new ArrayList<>();
        ArrayList<Node> arNodeItems = new ArrayList<>();
        Set<String> setResultado = new HashSet<>();
        for(String strProduct : arStrProducts){
            listOfProducts.add(strProduct);
            arNodeFaturas.addAll(this.graph.getNodebyString(strProduct).getConnections());
        }
        for (Node nodeFatura: arNodeFaturas){
            arNodeItems.addAll(nodeFatura.getContentBy("items"));
        }
        for(Node nodeItem : arNodeItems){
            if(!setTemp.add(nodeItem.getContent())){
                setResultado.add(nodeItem.getContent());
            }
        }
        listOfProducts.forEach(setResultado::remove);
        return setResultado;
    }

    public Set<String> filterRecommendation(String products, String filter){
        ArrayList<String> listOfProducts = new ArrayList<>(Arrays.asList(products.split(",")));
        Node filterNode = this.graph.getNodebyString(filter);
        ArrayList<Node> arNodeFaturas = new ArrayList<>(filterNode.getConnections());
        ArrayList<Node> arNodeItems = new ArrayList<>();
        HashSet<String> setResultado = new HashSet<>();

        for(Node nodeFatura : arNodeFaturas){
            for(Node nodeItem : nodeFatura.getContentBy("items")){
                for (String strProduct : listOfProducts) {
                    if(nodeItem.getContent().equals(strProduct)){
                        arNodeItems.addAll(nodeFatura.getContentBy("items"));
                    }
                }
            }
        }
        for (Node nodeItem: arNodeItems) {
            setResultado.add(nodeItem.getContent());
        }
        listOfProducts.forEach(setResultado::remove);
        return  setResultado;
    }

    public int queryRecommendation(String filters){
        String[] arStrFilters = filters.split(",");
        ArrayList<Node> arNodeFaturas = new ArrayList<>();
        Set<Node> setFaturasComuns = new HashSet<>();
        Set<Node> setResultado = new HashSet<>();
        for(String strFilter : arStrFilters){
            arNodeFaturas.addAll(this.graph.getNodebyString(strFilter).getConnections());
        }
        for (Node nodeFatura : arNodeFaturas){
            if(!setFaturasComuns.add(nodeFatura))
                setResultado.add(nodeFatura);
        }
        return setResultado.size();
    }
}
