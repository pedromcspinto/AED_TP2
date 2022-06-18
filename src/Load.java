import java.util.*;

public class Load {
    private Graph graph;

    /**
     * Construtor da classe Load.
     */
    public Load(Graph graph){
        this.graph = graph;
    }

    /**
     * Método para fazer uma recomendação simples de produtos.
     * Recebe os produtos e retorna os produtos que customam ser comprados em conjunto dos produtos recebidos.
     *
     * @param products String de produtos juntos por vírgulas Eg.("sku24,sku21").
     * @return Set de String coms os produtos que customam ser comprados em conjunto dos produtos recebidos.
     */
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

    /**
     * Método para fazer uma recomendação de produtos através de um filtro.
     * Recebe os produtos e um filtro.
     * Retorna os produtos que customam ser comprados em conjunto dos produtos recebidos que se aplicam no filtro.
     *
     * @param products String de produtos juntos por vírgulas Eg.("sku24,sku21").
     * @param filter String com o filtro de recomendação.
     * @return Set de String coms os produtos que customam ser comprados em conjunto dos produtos recebidos que se aplicam no filtro.
     */
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

    /**
     * Método para fazer a contagem de faturas com os filtros em comum.
     * Recebe os filtros e retorna a contagem de Faturas com filtros em comum.
     *
     * @param filters String de filtros juntos por vírgulas Eg.("NY-2,afternoon").
     * @return int Contagem de Faturas com filtros em comum.
     */
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
