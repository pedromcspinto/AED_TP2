import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    Node node;
    Node connection;
    Hashtable<String,String> identifier;
    Hashtable<String,String> connectionIdentifier;

    NodeTest(){
        connectionIdentifier = new Hashtable<>();
        connectionIdentifier.put("A", "B");
        connection = new Node(connectionIdentifier);
        identifier = new Hashtable<>();
        identifier.put("items", "sku20");
        node = new Node(identifier);
        node.addConnection(connection);
    }

    @org.junit.jupiter.api.Test
    void addConnection() {
        node.addConnection(connection);
        assertEquals(1, node.getConnections().size());
    }

    @org.junit.jupiter.api.Test
    void getContent() {
        assertEquals("sku20", node.getContent());
    }

    @org.junit.jupiter.api.Test
    void getContentBy() {
        assertEquals(1, node.getContentBy(connection.getType()).size());
    }

    @org.junit.jupiter.api.Test
    void getType() {
        assertEquals("items", node.getType());
    }

    @org.junit.jupiter.api.Test
    void getIdentifier() {
        Hashtable<String,String> tmp = new Hashtable<>();
        tmp.put("items", "sku20");
        assertEquals(tmp, node.getIdentifier());
    }

    @org.junit.jupiter.api.Test
    void getConnections() {
        node.addConnection(connection);
        assertEquals(connection, node.getConnections().get(0));
    }
}