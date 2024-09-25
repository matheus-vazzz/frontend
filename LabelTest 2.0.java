// Na linha abaixo, será importado o componente JFrame do módulo Swing da biblioteca (pacote) javax
import javax.swing.JFrame;

// A linha abaixo está declarando a classe LabelTest
public class LabelTest 
// A linha abaixo iniciará o bloco de código da classe LabelTest
{
// A linha abaixo está delcarando o ... do main
   public static void main(String[] args)
   { 
// a linha abaixo está declarando a variável labelFrame, que é do tipo Labelframe. Essa variável vai receber um objeto LabelFrame que é um construtor      
      LabelFrame labelFrame = new LabelFrame();
// a linha abaixo está invocano o método (ponto pra direita sempre declara o método). Está sendo definido uma operação de fechamento padrão. Dentro do parênteses, há parâmetros (EXIT_ON_CLOSE - NÃO É POSSÍVEL ALTERAR)      
      labelFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// na linha abaixo, está sendo definido o tamanho (largura: 260 pixels e altura: 180 pixels)
      labelFrame.setSize(260, 180); 
// Na linha abaixo, está tornando visível
      labelFrame.setVisible(true); 
// a linha abaixo encerra o bloco de códigos do método
   } 
// a linha abaixo encerra o bloco de códigos da classe   
}
