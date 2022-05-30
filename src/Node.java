import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class Node implements Comparable<Node>{
    private Hashtable<String,String> identifier;
    private ArrayList<Node> connections;

    public Node(Hashtable<String,String> identifier){
        this.identifier = identifier;
        connections = new ArrayList<>();
    }

    public void addConnection(Node node){
        connections.add(node);
    }

    public String getType(){
        return identifier.keySet().iterator().next();
    }

    public Hashtable<String,String> getIdentifier(){
        return identifier;
    }

    public ArrayList<Node> getConnections(){
        return connections;
    }

    @Override
    public int compareTo(Node other) {
        int flag=-1;
        if(this.identifier.equals(other.identifier))
            flag*=-1;
        return flag;
    }
}
