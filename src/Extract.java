import java.io.*;

public class Extract{
    private final String[][] strMatrixData;
    private int intNumColumns, intNumLines;

    /**
     * Contrutor da classe Extract.
     * Recebe o ficheiro e guarda o seu número de linhas e colunas.
     * Inicializa uma matriz onde vai ser guardado o conteúdo do ficheiro.
     * Lê o ficheiro e guarda conteúdo na matris.
     *
     * @param strFilePath destino do ficheiro a ser usado.
     * @throws IOException exceção lançada caso ficheiro não exista.
     */
    Extract(String strFilePath) throws IOException {
        countColumnsAndLines(strFilePath);
        this.strMatrixData = new String[this.intNumLines][this.intNumColumns];
        readFile(strFilePath);
    }

    /**
     * Método para ler o ficheiro e guardar conteúdo na matriz.
     * Percorre o ficheiro e guarda cada elemento na matriz.
     *
     * @param strFilePath destino do ficheiro a ser percorrido.
     * @throws IOException exceção lançada caso ficheiro não exista.
     */
    private void readFile(String strFilePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(strFilePath));
        String strLine;
        for (int i = 0; (strLine = bufferedReader.readLine()) != null; i++){
            strLine = this.extractAspas(strLine);
            String[] strSplittedLine = strLine.split(",");
            for (int j = 0; j < strSplittedLine.length; j++){
                this.strMatrixData[i][j] = strSplittedLine[j];
            }
        }
        bufferedReader.close();
    }

    /**
     * Método para contar número de linhas e colunas do ficheiro csv.
     * Percorre o ficheiro e guarda o número de linhas e colunas.
     *
     * @param strFilePath destino do ficheiro a ser ppercorrido.
     * @throws IOException exceção lançada caso ficheiro não exista.
     */
    private void countColumnsAndLines(String strFilePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(strFilePath));
        String[] strSplittedLine = bufferedReader.readLine().split(",");
        int intCountLines;
        String strLine;
        this.intNumColumns = strSplittedLine.length;
        for (intCountLines = 1; (strLine = bufferedReader.readLine()) != null; intCountLines++);
        this.intNumLines = intCountLines;
        bufferedReader.close();
    }

    /**
     * Método para retornar a matriz com conteúdo da tabela.
     *
     * @return Matriz de strings com conteúdo do ficheiro.
     */
    public String[][] getStrMatrixData(){return this.strMatrixData;}

    /**
     * Método para retornar a String sem as aspas
     *
     * @param line String da linha a ser transformada
     * @return String transformada
     */
    public String extractAspas(String line){
        char[] charArray = line.toCharArray();
        int flag = -1;
        for (int i = 0; i<charArray.length; i++) {
            if(charArray[i] == '"')
                flag*=-1;

            if(flag==1 && charArray[i] == ',')
                charArray[i]=' ';
        }
        return new String(charArray).replace("\"", "");
    }
}
