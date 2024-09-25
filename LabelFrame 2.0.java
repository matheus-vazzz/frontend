
import java.awt.FlowLayout; // 
import javax.swing.JFrame; // 
import javax.swing.JLabel; // 
import javax.swing.SwingConstants; // 
import javax.swing.Icon; // 
import javax.swing.ImageIcon; // 

// a linha abaixo está declarando a classe LabelFrame. O 'extends' está herdando o componente 'Jframe'
public class LabelFrame extends JFrame
// a linha abaixo está iniciando o bloco de códigos da classe LabelFrame 
{
   private final JLabel label1; // declaração de variável (o private não exporta a variável, apenas pode ser usado dentro desse bloco. O final serve para declarar uma variável somente leitura. O JLabel é om tipo da variável. O label1 é o nome da variável)
   private final JLabel label2; // declaração de variável 
   private final JLabel label3; // declaração de variável 

   // Na linha abaixo, vemos o construtor, (tem que ser uma variável pública) - tem que ter o mesmo nome da classe, que tem que ter o mesmo nome do arquivo
   public LabelFrame()
 // na linha abaixo, o início do bloco de códigos do construtor  
   {
// com o super, estamos definindo o título da janela (o texto vai dentro de aspas duplas)      
      super("Testing JLabel");
// a linha abaixo define o desenho do quadro (o método está sendo invocado sem o ponto porque herdou-se ele). O FlowLayout é um parâmetro importado
      setLayout(new FlowLayout()); // 

      // o label1 está recebendo um novo objeto JLabel (é injetado um argumento dentro dos parênteses, um texto)
      label1 = new JLabel("Label with text");
      // o mesmo label1 está definindo um texto de dica (aparecerá quando o mouse for posicionao em cima do elemento)
      label1.setToolTipText("This is label1");
      add(label1); // está sendo adicionado o label1 definido acima, injetado

      // declaração da variável bug do tipo Icon (operador de atribuição = indica ), ImageIcon é um objeto novo, que está recebendo um parâmetro de coletar a classe, e invocar o recurso 'bug1.png'
      Icon bug = new ImageIcon(getClass().getResource("bug1.png"));
      // a linha abaixo recebe um novo objeto do tipo JLabel, onde se envia, além do texto (com a vírgula sendo o separador de parâmetros), o SwingConstants, que é um alinhamento espacial (para a esquerda)
      label2 = new JLabel("Label with text and icon", bug, 
         SwingConstants.LEFT);
      label2.setToolTipText("This is label2");
      add(label2); // está sendo adicionado o label2 definido acima, injetado

      // o objeto JLabel não acompanha o texto pois é definido logo abaixo pelo 'setText'
      label3 = new JLabel();
      label3.setText("Label with icon and text at bottom");
      label3.setIcon(bug); 
     // na linha abaixo, define-se a posição horizontal do texto (no centro) 
      label3.setHorizontalTextPosition(SwingConstants.CENTER);
     // na linha abaixo, define-se a posição vertical do texto (abaixo)  
      label3.setVerticalTextPosition(SwingConstants.BOTTOM);
      label3.setToolTipText("This is label3");
      add(label3); // adicionar label3 a JFrame
   } 
} // encerramento da classe JFrame


/**************************************************************************
 * (C) Copyright 1992-2014 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
