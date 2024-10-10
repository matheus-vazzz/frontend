import java.awt.FlowLayout;
import java.awt.event.*;
import javax.swing.*;

public class MultipleSelectionFrame extends JFrame // declaração da classe MultipleSelectionFrame, de livre exportação, herdando o JFrame (telinha padrão)
{
   private final JList<String> colorJList; // declaração da variável colorJList, de uso exclusivo da classe, sem poder alterar seus valores, e do tipo string (texto)
   private final JList<String> copyJList; // declaração da variável copyList, de uso exclusivo da classe, sem poder alterar seus valores, e do tipo string (texto)
   private JButton copyJButton; // declaração da variável copyJButton, do tipo JButton (botão)
   private static final String[] colorNames = {"Black", "Blue", "Cyan", // declaração da variável colorNames, de uso exclusivo da classe, estática, sem poder alterar seus valores, de matriz String, com seus vetores especificados dentro das chaves
      "Dark Gray", "Gray", "Green", "Light Gray", "Magenta", "Orange", 
      "Pink", "Red", "White", "Yellow"};
   
   private final JList<String> fruitsJList;
   private final JList<String> copyFruitsJList;
   private JButton copyFruitsJButton;
   private static final String[] fruitsNames = {"Apple", "Banana", "Orange", 
      "Pear", "Grape", "Cherry", "Lemon"};
   
   public MultipleSelectionFrame() // declaração do construtor, de livre exportação
   {
      super("Multiple Selection Lists"); // usa-se o 'super' (método) para definir o título
      setLayout(new FlowLayout()); // definir a forma de renderização (vai sendo colocado na tela a medida que renderiza primeiro)

      colorJList = new JList<String>(colorNames); // atribuição do objeto JList a variável colorJList, recebendo os valores de colorNames
      colorJList.setVisibleRowCount(5); // invoca o método setVisibleRowCount para definir quantas linhas serão mostradas
      colorJList.setSelectionMode(
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // invoca o método setSelectionMode, definindo como múltiplas seleções
      add(new JScrollPane(colorJList)); // adiciona o colorJList na tela (JScrollPane = barra de rolagem)

      copyJButton = new JButton("Copy >>>"); // atribuição a variável copyJButton um novo objeto JButton (botão que recebe o texto Copy>>>)
      copyJButton.addActionListener(
         new ActionListener() // anonymous inner class 
         {  
            // handle button event
            @Override
            public void actionPerformed(ActionEvent event) // definição do método actionPerformed, de livre exportação, sem retorno de valor (a ação executada) (o parâmetro recebe os eventos)
            {               
               copyJList.setListData( // configura os dados da lista
                  colorJList.getSelectedValuesList().toArray(
                     new String[0])); // responsável por pegar os valores selecionados da lista, e converter em matriz de string, pegando desde o vetor 0
            }
         } 
      ); 

      add(copyJButton); // add copy button to JFrame

      copyJList = new JList<String>(); // list to hold copied color names
      copyJList.setVisibleRowCount(5); // mostrar 5 linhas
      copyJList.setFixedCellWidth(100); // definir largura
      copyJList.setFixedCellHeight(15); // definir tamanho
      copyJList.setSelectionMode(
         ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      add(new JScrollPane(copyJList)); // add list with scrollpane

      fruitsJList = new JList<String>(fruitsNames);
      fruitsJList.setVisibleRowCount(5);
      fruitsJList.setSelectionMode(
         ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
      add(new JScrollPane(fruitsJList)); 

      copyFruitsJButton = new JButton("Copy >>>"); 
      copyFruitsJButton.addActionListener(
         new ActionListener()  
         {             
            @Override
            public void actionPerformed(ActionEvent event)
            {               
               copyFruitsJList.setListData( // configura os dados da lista
                  fruitsJList.getSelectedValuesList().toArray(
                     new String[0]));
            }
         } 
      ); 


      add(copyFruitsJButton); // add copy button to JFrame

      copyFruitsJList = new JList<String>(); // list to hold copied color names
      copyFruitsJList.setVisibleRowCount(5); // mostrar 5 linhas
      copyFruitsJList.setFixedCellWidth(100); // definir largura
      copyFruitsJList.setFixedCellHeight(15); // definir tamanho
      copyFruitsJList.setSelectionMode(
         ListSelectionModel.SINGLE_INTERVAL_SELECTION);
      add(new JScrollPane(copyFruitsJList)); // add list with scrollpane
   } 
}