import java.util.*;

public class Graph {
    private Set<Node> nodes;

    public Graph(Table data){
        this.nodes = new HashSet<>();
        this.buildGraph(data);
    }

    public Node getNode(Node wantedNode){
        Node tmp=null;
        for(Node node : nodes)
            if(node.equals(wantedNode))
                tmp = node;
        return tmp;
    }

    public Set<Node> getSet(){
        return nodes;
    }

    private void buildGraph(Table data){

        for(HashMap<String,String> hashtable : data.getTable()){
            ArrayList<Node> nodeArraylist = new ArrayList<>();
            int index = 0;
            for(String key: hashtable.keySet()){
                Hashtable<String,String> tmp = new Hashtable<>();
                tmp.put(key, hashtable.get(key));
                Node node = new Node(tmp);
                if(!nodes.add(node)){
                    node = this.getNode(node);
                }
                nodes.add(node);
                nodeArraylist.add(node);
            }

            for(int i=0; i<nodeArraylist.size(); i++){
                if(i!=0){
                    nodeArraylist.get(0).addConnection(nodeArraylist.get(i));
                    nodeArraylist.get(i).addConnection(nodeArraylist.get(0));
                }
            }
        }


//        ArrayList<Node> tmp;
//        int counter=0;
//        for(Hashtable<String,String> table : data.getTable()){
//             tmp = new ArrayList<>();
//            if(table.containsKey("items")){
//                String[] values = table.get("items").split(" ");
//                for(String splitted: values){
//                    Hashtable<String, String> hashtable = new Hashtable<>();
//                    hashtable.put("items",splitted);
//                    tmp.add(new Node(hashtable));
//                }
//            }else{
//                tmp.add(new Node(table));
//            }
//            if(counter%5==0 && counter!=0){
//
//            }
//            counter++;
//        }
    }
}
