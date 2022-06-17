import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Extract extract = new Extract("./Input");
        Transform transform = new Transform(extract.getStrMatrixData());
        Load load = new Load(transform.getGraph());
//        Set<Node> set = transform.getGraph().getSet();
//        for (Node node: set){
//            System.out.print("Node pai: ");
//            System.out.println(node.getIdentifier());
//            System.out.println("Connections:");
//            for(Node tmp: node.getConnections()){
//                System.out.println(tmp.getIdentifier());
//            }
//            System.out.println("End");
//            System.out.println();
//        }
        menu();
        getInput(scanner, load);
    }

    public static void menu(){
        System.out.println("Menu");
        System.out.println("1 - Recomendação Simples");
        System.out.println("2 - Recomendação com Filtro");
        System.out.println("3 - Query com Contagem");
        System.out.print("Escolha uma opção: ");
        System.out.println();
    }

    public static void getInput(Scanner scanner, Load load){
        int input = scanner.nextInt(); scanner.nextLine();
        String products;
        String filters;
        switch (input){
            case 1:
                System.out.println("Recomendação Simples");
                System.out.println("Dado os Produtos:");
                products = scanner.nextLine();
                Set<String> resultado = load.simpleRecommendation(products);
                for(String s : resultado){
                    System.out.println(s);
                }
                break;
            case 2:
                System.out.println("Recomendação com Filtro");
                System.out.println("Dado os Produtos:");
                products = scanner.nextLine();
                System.out.println("Dado o Filtro:");
                filters = scanner.nextLine();
                load.filterRecommendation(products, filters);
                break;
            case 3:
                System.out.println("Query com Contagem");
                System.out.println("Dada a Query:");
                filters = scanner.nextLine();
                System.out.println(load.queryRecommendation(filters));
                break;
            default:
        }
    }
}
