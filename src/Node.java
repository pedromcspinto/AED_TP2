import java.util.*;

public class Node{
    private Hashtable<String,String> identifier;
    private ArrayList<Node> arConnectionNodes;

    public Node(Hashtable<String,String> identifier){
        this.identifier = identifier;
        arConnectionNodes = new ArrayList<>();
    }

    public void addConnection(Node node){
        arConnectionNodes.add(node);
    }

    public String getContent(){
        return identifier.get(identifier.keySet().iterator().next());
    }

    public ArrayList<Node> getContentBy(String key){
        ArrayList<Node> arNodeTemp = new ArrayList<>();
        for(Node node : this.arConnectionNodes){
            if(node.getType().equals(key))
                arNodeTemp.add(node);
        }
        return arNodeTemp;
    }

    public String getType(){
        return identifier.keySet().iterator().next();
    }

    public Hashtable<String,String> getIdentifier(){
        return identifier;
    }

    public ArrayList<Node> getConnections(){
        return arConnectionNodes;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Node)) return false;
        Node node = (Node) object;
        return getIdentifier().equals(node.getIdentifier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdentifier());
    }
}
