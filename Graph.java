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
            if(node.compareTo(wantedNode)>0)
                tmp = node;
        return tmp;
    }

    public Set<Node> getSet(){
        return nodes;
    }

    private void buildGraph(Table data){

        for(Hashtable<String,String> hashtable : data.getTable()){
            ArrayList<Node> nodeArraylist = new ArrayList<>();
            int index = 0;
            for(String key: hashtable.keySet()){
                Hashtable<String,String> tmp = new Hashtable<>();
                tmp.put(key, hashtable.get(key));
                Node node = new Node(tmp);
                if(this.getNode(node)!=null){
                    node = this.getNode(node);
                }
                nodes.add(node);
                nodeArraylist.add(node);
            }

            for(int i=0; i<nodeArraylist.size(); i++){
                if(nodeArraylist.get(i).getType().equals("order_id"))
                    index=i;
            }

            for(int i=0; i<nodeArraylist.size(); i++){
                if(i!=index){
                    nodeArraylist.get(index).addConnection(nodeArraylist.get(i));
                    nodeArraylist.get(i).addConnection(nodeArraylist.get(index));
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
