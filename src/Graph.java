
import java.util.*;

public class Graph {
    private Set<Node> nodes;

    public Graph(Table data){
        this.nodes = new HashSet<>();
        this.buildGraph(data);
    }

    private Node getNode(Node wantedNode){
        Node tmp=null;
        for(Node node : nodes)
            if(node.equals(wantedNode))
                tmp = node;
        return tmp;
    }
    public Node getNodebyString(String wantedNode){
        Node tmp=null;
        for(Node node : nodes)
            if(node.getContent().equals(wantedNode))
                tmp = node;
        return tmp;
    }

    public Set<Node> getSet(){
        return nodes;
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
        Hashtable<String,String> tmp = new Hashtable<>();
        tmp.put(key, value);
        Node node = new Node(tmp);
        if(!nodes.add(node)){
            node = this.getNode(node);
        }
        nodeArrayList.add(node);
    }
}
