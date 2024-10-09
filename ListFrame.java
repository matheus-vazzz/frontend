import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class ListFrame extends JFrame // declaração da classe de pública exportação, chamada ListFrame, herdando o JFrame (a telinha pronta) 
{
   
   private final JList<String> colorJList;
   
   private static final String[] colorNames = {"Black", "Blue", "Cyan",
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta",
      "Orange", "Pink", "Red", "White", "Yellow"}; // declaração da variável de uso exclusivo da classe, variável estática, e sem poder ter alteração de valor da variável (variável de apenas texto, com vetores de nomes de cores)
   private static final Color[] colors = {Color.BLACK, Color.BLUE,
      Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.GREEN, 
      Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK, 
      Color.RED, Color.WHITE, Color.YELLOW};// declaração de variável pelo sinal de atribuição, de uso excluisvo da classe, estática e sem ter alteração de valor (variável de cores)

   private final JList<String> tamanhoList;      
   private static final String[] tamanhoNames = {"Small", "Medium", "Big"};

   
   public ListFrame() // declaração do construtor, de livre exportação
   {
        super("List Test"); // super é a forma de definir o título
         setLayout(new FlowLayout());  // método de definir o layout, a forma de exibição, fluida, por ordem de renderização

         colorJList = new JList<String>(colorNames); // declaração do objeto JList, sendo uma matriz de String (nomes), e enviando por parâmetro os nomes das cores
         colorJList.setVisibleRowCount(5); // invocação do método setVisibleRowCount, que define a quantidade de linhas visíveis
      
         colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // invocação do método setSelectionMode, definindo o modo de seleção única, podendo selecionar um por vez

      add(new JScrollPane(colorJList));

         tamanhoList = new JList<String>(tamanhoNames);
         tamanhoList.setVisibleRowCount(3);
         tamanhoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

      add(new JScrollPane(tamanhoList));


      colorJList.addListSelectionListener(
         new ListSelectionListener() // // invocação do método escutador de lista de seleção, que vai gerenciar os acontecimentos
         {   
            @Override // sobrescrita do objeto ListSelectionListener
            public void valueChanged(ListSelectionEvent event)  // método de valor mudado, vai receber o parâmetro evento, do tipo ListSelectionEvent
            {               
               getContentPane().setBackground( // captura do conteúdo do painel, invocando o método de definição do fundo, tendo como parâmetro o envio de um valor, do índice selecionado pelo usuário
                  colors[colorJList.getSelectedIndex()]);
            } 
         } 
      ) ;
      
      tamanhoList.addListSelectionListener(
         new ListSelectionListener()
         { 
      @Override
      public void valueChanged(ListSelectionEvent event)
      {
         switch (tamanhoList.getSelectedIndex()) {
            case 0:
               setSize(350, 150);
               break;

            case 1:
               setSize(550, 350);
               break;

            case 2:
               setSize(750, 550);
               break;

            default:
               setSize(350,150);
               break; 
               }
       
            } 
         }
      ) ;
   } 
} 
