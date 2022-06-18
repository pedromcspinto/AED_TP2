
import java.util.*;

public class Graph {
    private Set<Node> setNodes;

    public Graph(Table data){
        this.setNodes = new HashSet<>();
        this.buildGraph(data);
    }

    private Node getNode(Node wantedNode){
        Node nodeTemp=null;
        for(Node node : setNodes)
            if(node.equals(wantedNode))
                nodeTemp = node;
        return nodeTemp;
    }
    public Node getNodebyString(String wantedNode){
        Node nodeTemp=null;
        for(Node node : setNodes)
            if(node.getContent().equals(wantedNode))
                nodeTemp = node;
        return nodeTemp;
    }

    private void buildGraph(Table data){
        for(HashMap<String,String> hashmap : data.getTable()){
            ArrayList<Node> nodeArraylist = new ArrayList<>();
            this.addNodeToArray(hashmap, nodeArraylist);
            this.setConnections(nodeArraylist);
        }
    }

    private void setConnections(ArrayList<Node> nodeArrayList){
        for(int i = 0; i<nodeArrayList.size(); i++){
            if(i!=0) {
                nodeArrayList.get(0).addConnection(nodeArrayList.get(i));
                nodeArrayList.get(i).addConnection(nodeArrayList.get(0));
            }
        }
    }

    private void addNodeToArray(HashMap<String,String> hashmap, ArrayList<Node> nodeArrayList){
        for(String key: hashmap.keySet()){
            if(key.equals("items")){
                String[] items = hashmap.get(key).split(" ");
                for(String item : items){
                    this.metodo(key, item, nodeArrayList);
                }
            }
            else{
                this.metodo(key, hashmap.get(key), nodeArrayList);
            }
        }
    }

    private void metodo(String key, String value, ArrayList<Node> nodeArrayList){
        Hashtable<String,String> hashTableTemp = new Hashtable<>();
        hashTableTemp.put(key, value);
        Node node = new Node(hashTableTemp);
        if(!setNodes.add(node)){
            node = this.getNode(node);
        }
        nodeArrayList.add(node);
    }
}
