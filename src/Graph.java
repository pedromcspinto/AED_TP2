import java.util.*;

public class Graph {
    private Set<Node> setNodes;

    /**
     * Construtor da classe Graph
     * Recebe uma Table e cria o grafo.
     *
     * @param data Table com os dados para criar o grafo.
     */
    public Graph(Table data){
        this.setNodes = new HashSet<>();
        this.buildGraph(data);
    }

    /**
     * Método retorna o Node do grafo apartir de um Node.
     *
     * @param wantedNode Node a ser encontrado.
     * @return Node do grafo apartir do Node introduzido.
     */
    private Node getNode(Node wantedNode){
        Node nodeTemp=null;
        for(Node node : setNodes)
            if(node.equals(wantedNode))
                nodeTemp = node;
        return nodeTemp;
    }

    /**
     * Método que retorna o Node correspondente á string introduzida.
     *
     * @param wantedNode String do conteudo do Node a ser encontrado.
     * @return Node com o conteudo correspondente á string introduzida.
     */
    public Node getNodebyString(String wantedNode){
        Node nodeTemp=null;
        for(Node node : setNodes)
            if(node.getContent().equals(wantedNode))
                nodeTemp = node;
        return nodeTemp;
    }

    /**
     * Método que cria o grafo.
     *
     * @param data Table com a informação do grafo a ser criado.
     */
    private void buildGraph(Table data){
        for(HashMap<String,String> hashmap : data.getTable()){
            ArrayList<Node> nodeArraylist = new ArrayList<>();
            this.addNodesToArray(hashmap, nodeArraylist);
            this.setConnections(nodeArraylist);
        }
    }

    /**
     * Método que adiciona as conexões a uma ArrayList de Nodes.
     *
     * @param nodeArrayList ArrayList de Nodes a ser criada as conexões.
     */
    private void setConnections(ArrayList<Node> nodeArrayList){
        for(int i = 0; i<nodeArrayList.size(); i++){
            if(i!=0) {
                nodeArrayList.get(0).addConnection(nodeArrayList.get(i));
                nodeArrayList.get(i).addConnection(nodeArrayList.get(0));
            }
        }
    }

    /**
     * Método que adiciona os dados do Nodes do hashmap para a ArrayList de Nodes.
     *
     * @param hashmap HashMap com as informações dos Nodes.
     * @param nodeArrayList ArrayList de Nodes onde vão ser adicionados os Nodes.
     */
    private void addNodesToArray(HashMap<String,String> hashmap, ArrayList<Node> nodeArrayList){
        for(String key: hashmap.keySet()){
            if(key.equals("items")){
                String[] items = hashmap.get(key).split(" ");
                for(String item : items){
                    this.addNodeToArrayList(key, item, nodeArrayList);
                }
            }
            else{
                this.addNodeToArrayList(key, hashmap.get(key), nodeArrayList);
            }
        }
    }

    /**
     * Método que cria um Node e adiciona-o a uma ArrayList.
     *
     * @param key String da key do Node a ser criado.
     * @param value String do valor do Node a ser criado.
     * @param nodeArrayList ArrayList de Nodes onde vão ser adicionados os Nodes.
     */
    private void addNodeToArrayList(String key, String value, ArrayList<Node> nodeArrayList){
        Hashtable<String,String> hashTableTemp = new Hashtable<>();
        hashTableTemp.put(key, value);
        Node node = new Node(hashTableTemp);
        if(!setNodes.add(node)){
            node = this.getNode(node);
        }
        nodeArrayList.add(node);
    }
}
