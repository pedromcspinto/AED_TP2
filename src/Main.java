import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Extract objExtract = new Extract("./Input");
        Transform objTransform = new Transform(objExtract.getStrMatrixData());
        Load objLoad = new Load(objTransform.getGraph());
        printMenu();
        getInput(objLoad);
    }

    public static void printMenu(){
        System.out.println("Menu");
        System.out.println("\t1 - Recomendação Simples");
        System.out.println("\t2 - Recomendação com Filtro");
        System.out.println("\t3 - Query com Contagem");
        System.out.print("\nEscolha uma opção: ");
    }

    public static void getInput(Load objLoad){
        Scanner scanner = new Scanner(System.in);
        int intMenuOption = scanner.nextInt();scanner.nextLine();
        Set<String> setResultado;
        switch (intMenuOption){
            case 1:
                System.out.println("Recomendação Simples");
                System.out.println("Dado os Produtos:");
                setResultado = objLoad.simpleRecommendation(scanner.nextLine());
                for(String s : setResultado){
                    System.out.println(s);
                }
                break;
            case 2:
                System.out.println("Recomendação com Filtro");
                System.out.println("Dado os Produtos:");
                String products = scanner.nextLine();
                System.out.println("Dado o Filtro:");
                String filters = scanner.nextLine();
                setResultado = objLoad.filterRecommendation(products, filters);
                for(String string : setResultado){
                    System.out.println(string);
                }
                break;
            case 3:
                System.out.println("Query com Contagem");
                System.out.println("Dada a Query:");
                System.out.println(objLoad.queryRecommendation(scanner.nextLine()));
                break;
            default:
        }
    }
}
