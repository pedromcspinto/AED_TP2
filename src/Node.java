import java.util.*;

public class Node{
    private Hashtable<String,String> identifier;
    private ArrayList<Node> arConnectionNodes;

    /**
     * Construtor da classe Node.
     * Guarda o identifier e cria uma arrayList de conexões.
     *
     * @param identifier Hashtable com os dados do identifier do Node.
     */
    public Node(Hashtable<String,String> identifier){
        this.identifier = identifier;
        arConnectionNodes = new ArrayList<>();
    }

    /**
     * Método que adiciona um Node á arrayList de conexões.
     *
     * @param node Node a ser adicionado á lista de conexões.
     */
    public void addConnection(Node node){
        arConnectionNodes.add(node);
    }

    /**
     * Método que retorna o contéudo do Node.
     *
     * @return String do conteúdo do Node.
     */
    public String getContent(){
        return identifier.get(identifier.keySet().iterator().next());
    }

    /**
     * Método que retorna uma arrayList de Nodes com todos os Nodes do tipo introduzido.
     *
     * @param key String do tipo do Node.
     * @return ArrayList de Nodes com todos os Nodes do tipo introduzido.
     */
    public ArrayList<Node> getContentBy(String key){
        ArrayList<Node> arNodeTemp = new ArrayList<>();
        for(Node node : this.arConnectionNodes){
            if(node.getType().equals(key))
                arNodeTemp.add(node);
        }
        return arNodeTemp;
    }

    /**
     * Método que retorna o tipo do Node.
     *
     * @return String com o tipo do Node.
     */
    public String getType(){
        return identifier.keySet().iterator().next();
    }

    /**
     * Método que retorna o identifier do Node.
     *
     * @return Hashtable do identifier do Node.
     */
    public Hashtable<String,String> getIdentifier(){
        return identifier;
    }

    /**
     * Método que retorna a lista de conexões do Node.
     *
     * @return ArrayList de Nodes das conexões do Node.
     */
    public ArrayList<Node> getConnections(){
        return arConnectionNodes;
    }

    /**
     * Método que retorna um booleano com o valor se os objetos são iguais.
     *
     * @param object a ser comparado.
     * @return booleano com o valor se os objetos são iguais.
     */
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Node)) return false;
        Node node = (Node) object;
        return getIdentifier().equals(node.getIdentifier());
    }

    /**
     * Método que retorna o hash code do identifier.
     *
     * @return int com o hash code do identifier.
     */
    @Override
    public int hashCode() {
        return Objects.hash(getIdentifier());
    }
}
