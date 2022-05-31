import java.util.*;

public class Node{
    private Hashtable<String,String> identifier;
    private ArrayList<Node> connections;

    public Node(Hashtable<String,String> identifier){
        this.identifier = identifier;
        connections = new ArrayList<>();
    }

    public void addConnection(Node node){
        connections.add(node);
    }

//    public String getContent(){
//        return identifier.get(identifier.keySet().iterator().next());
//    }
//
//    public String getType(){
//        return identifier.keySet().iterator().next();
//    }

    public Hashtable<String,String> getIdentifier(){
        return identifier;
    }

    public ArrayList<Node> getConnections(){
        return connections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        return getIdentifier().equals(node.getIdentifier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdentifier());
    }
}
