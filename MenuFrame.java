import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuFrame extends JFrame // declaração da classe, de livre exportação, chamada MenuFrame, herdando o JFrame (telinha padrão)
{
   private final Color[] colorValues = 
      {Color.BLACK, Color.BLUE, Color.RED, Color.GREEN}; // declaração da variável colorValues, que é uma matriz de cores, de uso exclusivo da classe, somente leitura, recebendo vetores das cores desejadas  
   private final JRadioButtonMenuItem[] colorItems; // declaração da variável colorItens
   private final JRadioButtonMenuItem[] fonts; // declaração da variável fonts
   private final JCheckBoxMenuItem[] styleItems; // declaração da variável styleItems
   private final JLabel displayJLabel; // declaração da variável displayJLabel
   private final ButtonGroup fontButtonGroup; // declaração da variável fontButtonGroup
   private final ButtonGroup colorButtonGroup; // declaração da variável colorButtonGroup
   private int style; // used to create style for font

   public MenuFrame() // declaração do construtor, de livre exportação
   {
      super("Using JMenus");     

      JMenu fileMenu = new JMenu("File"); // criação do novo objeto JMenu (botãozinho file la em cima na esquerda,)
      fileMenu.setMnemonic('F'); // definição do método setMnemonic, que é um atalho (se apertar alt + F, abrirá o menu)

      // create About... menu item
      JMenuItem aboutItem = new JMenuItem("About..."); // criação do novo objeto JMenuItem (que fica dentro do botãozinho file)
      aboutItem.setMnemonic('A'); // ciração do atalho alt + F + A = abrir o about direto
      fileMenu.add(aboutItem); // adiciona o about dentro de file
      aboutItem.addActionListener(
         new ActionListener() // objeto escutador da ação do usuário
         {  
            @Override
            public void actionPerformed(ActionEvent event) // invocação do método actionPerfomed, que recebe como parâmetro os eventos
            {
               JOptionPane.showMessageDialog(MenuFrame.this,
                  "This is an example\nof using menus", // contra barra quebra a linha para baixo
                  "About", JOptionPane.PLAIN_MESSAGE); // o JOptionPane (opções de painel) invoca o método para mostrar a mensagem de diálogo, e é enviado o primeiro parâmetro, o objeto que recebe o nome da prórpia classe
            } 
         } 
      ); 
 
      JMenuItem exitItem = new JMenuItem("Exit"); // criação do novo objeto JMenuItem (fica dentro do botãozinho file)
      exitItem.setMnemonic('x'); // criação do atalho alt + x (o x ta minúsculo porque o Exit tem o x minúsculo em sua palavra, enquanto o A de About é maiúsculo)
      fileMenu.add(exitItem); // adição do item Exit ao File
      exitItem.addActionListener(
         new ActionListener() // criação do objeto escutador de ação do usuário
         {  
            @Override
            public void actionPerformed(ActionEvent event) // declaração do método actionPerfomed, que vai receber os eventos de parâmetro
            {
               System.exit(0); // System.exit = saída do sistema (o parâmetro 0 funciona como o EXIT_ON_CLOSE)
            } 
         }
      ); 

      JMenuBar bar = new JMenuBar(); // criação da barrinha logo abaixo do título, que abriga o 'File' e 'Forgot'
      setJMenuBar(bar); // define o JMenuBar dentro do frame como sendo o próprio 'bar' (barra de menu)
      bar.add(fileMenu); // adiciona o 'File' dentro da barra de menu

      JMenu formatMenu = new JMenu("Format"); // criação de um novo menu (Format)
      formatMenu.setMnemonic('r'); // criação do atalho alt + r

      String[] colors = {"Black", "Blue", "Red", "Green"}; // criação da variável color, de texto, com 4 vetores

      JMenu colorMenu = new JMenu("Color"); // criação do menu Color, inserido dentro do Format
      colorMenu.setMnemonic('C'); // criação do atalho alt + r + C

      colorItems = new JRadioButtonMenuItem[colors.length]; // 
      colorButtonGroup = new ButtonGroup(); // criação do grupo de botões das cores
      ItemHandler itemHandler = new ItemHandler(); // criação de um manuseador de item

      for (int count = 0; count < colors.length; count++) // for = estrutura de repetição (como primeiro parâmetro, tem-se a variável inteira count, valendo 0, o segundo parâmetro seria enquanto o contador for menor que a quantidade de vetores da matriz color, ele soma mais um com o count++)
      {
         colorItems[count] = 
            new JRadioButtonMenuItem(colors[count]); // atribuição manual dos valores de cada vetor (recebendo a respectiva cor na ordem, e atribuindo desde o valor 0)
         colorMenu.add(colorItems[count]); // adiciona o item ao menu de cores
         colorButtonGroup.add(colorItems[count]); // adiciona também ao grupo de cor (adiciona cada botão das cores medidos pelos respectivos vetores)
         colorItems[count].addActionListener(itemHandler); // adicionado um escutador de ação
      } // o for, resumidamente, define o RadioButton, os botõeszinhos antes dos nomes das cores

      colorItems[0].setSelected(true); // método de seleção do vetor como verdadeiro, assim marca-se a bolinha

      formatMenu.add(colorMenu); // adicionado o menu de cores dentro do menu Format
      formatMenu.addSeparator(); // invocação do método addSeparatpr, que cria uma linha de separação entre os menus

      String[] fontNames = {"Serif", "Monospaced", "SansSerif"}; // declaração da variável fontNames, uma matriz de string, atribuindo três vetores a ela
      JMenu fontMenu = new JMenu("Font"); // criação do construtor JMenu, que cria o botãozinho da Font dentro de Format
      fontMenu.setMnemonic('n'); // adição do atalho alt + r + n

      fonts = new JRadioButtonMenuItem[fontNames.length]; // definição da matriz de botões de menu (os botões redondos) (definição do parâmetro da quantidade de vetores, a mesma quantidade de vetores da matriz)
      fontButtonGroup = new ButtonGroup(); // definição de um grupo de botões para as fontes

      for (int count = 0; count < fonts.length; count++) // nova estrutura de repetição pré-definida (contador recebe inicialmente o primeiro vetor, e enquanto o count for menor q o número de vetores, ele soma mais um)
      {
         fonts[count] = new JRadioButtonMenuItem(fontNames[count]); // no objeto declarado, será chamado o nome da fonte e seu respectivo valor
         fontMenu.add(fonts[count]); // o vetor da matriz fonte ser adicionado dentro do menu de fontes
         fontButtonGroup.add(fonts[count]); // adiciona ao grupo de botões
         fonts[count].addActionListener(itemHandler); // adiciona um escutador de ação em cada um dos vetores
      } 

      fonts[0].setSelected(true); // select first Font menu item
      fontMenu.addSeparator(); // adicionado uma linha separador dentro do menu fonte

      String[] styleNames = {"Bold", "Italic"}; // declaração da variável styleNames, recebendo dois vetores de matriz string
      styleItems = new JCheckBoxMenuItem[styleNames.length]; // atribuição do novo objeto JCheckBoxMenuItem, atribuindo que o número de vetores vai ser igual ao da variável styleNames
      StyleHandler styleHandler = new StyleHandler(); // criação do objeto manuseador dos estilos

      for (int count = 0; count < styleNames.length; count++) // laço de repetição pré-definido, igual aos outros só que adaptado ao styleNames 
      {
         styleItems[count] = 
            new JCheckBoxMenuItem(styleNames[count]); // for style
         fontMenu.add(styleItems[count]); // adiciona ao menu de estilos
         styleItems[count].addItemListener(styleHandler); // adicionado um escutador de ação em cada vetor
      }

      formatMenu.add(fontMenu); // adiciona o menu fonte dentro do 'Format'
      bar.add(formatMenu); // adiciona o 'Format' completo dentro da barra de menu
     
      displayJLabel = new JLabel("Sample Text", SwingConstants.CENTER); // a variável está recebendo um novo objeto JLabel, enviando o texto desejado e seu alinhamento
      displayJLabel.setForeground(colorValues[0]); // o primeiro vetor color.Black está sendo definido como parâmetro do set.Foreground
      displayJLabel.setFont(new Font("Serif", Font.PLAIN, 72)); // definição da fonte Serif

      getContentPane().setBackground(Color.CYAN); // é a mesma coisa que getContentPane = pedir para que seja selecionado o fundo, setBackground = defina o fundo com a cor CYAN
      add(displayJLabel, BorderLayout.CENTER); // está sendo adicionado o displayJLabel ao JFrame (na tela), definindo o BorderLayout
      setSize(500, 200);
      setVisible(true);
   } // acaba a linha de códigos do construtor

   // inner class to handle action events from menu items
   private class ItemHandler implements ActionListener 
   {
      // process color and font selections
      @Override
      public void actionPerformed(ActionEvent event)
      {
         // process color selection
         for (int count = 0; count < colorItems.length; count++)
         {
            if (colorItems[count].isSelected()) 
            {
               displayJLabel.setForeground(colorValues[count]);
               break;
            } 
         } 

         // process font selection
         for (int count = 0; count < fonts.length; count++)
         {
            if (event.getSource() == fonts[count]) 
            {
               displayJLabel.setFont(
                  new Font(fonts[count].getText(), style, 72));
            }
         }

         repaint(); // redraw application
      } 
   } // end class ItemHandler

   // inner class to handle item events from checkbox menu items
   private class StyleHandler implements ItemListener 
   {
      // process font style selections
      @Override
      public void itemStateChanged(ItemEvent e)
      {
         String name = displayJLabel.getFont().getName(); // current Font
         Font font; // new font based on user selections

         // determine which CheckBoxes are checked and create Font
         if (styleItems[0].isSelected() && 
              styleItems[1].isSelected())
            font = new Font(name, Font.BOLD + Font.ITALIC, 72);
         else if (styleItems[0].isSelected())
            font = new Font(name, Font.BOLD, 72);
         else if (styleItems[1].isSelected())
            font = new Font(name, Font.ITALIC, 72);
         else
            font = new Font(name, Font.PLAIN, 72);

         displayJLabel.setFont(font);
         repaint(); // redraw application
      } 
   } // end class StyleHandler
}

