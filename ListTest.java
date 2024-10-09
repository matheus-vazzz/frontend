
// importando classes de componente da biblioteca javax
import javax.swing.JFrame;

// declaração da classe ListTest
public class ListTest 
{
   // declaração do método main (string = matriz de texto)
   public static void main(String[] args)
   { 
      // declaração da variável listFrame do tipo ListFrame, que vai receber um novo objeto
      ListFrame listFrame = new ListFrame(); // create ListFrame
      listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      listFrame.setSize(350, 150); 
      listFrame.setVisible(true); 
   } 
}
