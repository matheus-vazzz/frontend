// Na linha abaixo está importando a biblioteca (pacote) javax, o módulo swing e o componente JOptionPane
import javax.swing.JOptionPane; 

// Na linha abaixo, está sendo declarada a classe Addition
public class Addition 
// Na linha abaixo, está sendo aberto o bloco de códigos da classe Addition
{
   // Na linha abaixo, está sendo declarado o método "main" (principal) que vai executar a aplicação
   public static void main(String[] args) 
   {
// Na linha abaixo, está sendo declarada a variável firstNumber, e String é o seu tipo. O símbolo de igual é um operador de atribuição (onde se tem este, há declaração de variável)      
      String firstNumber = 
         JOptionPane.showInputDialog("Digite o primeiro número inteiro");
      String secondNumber =
          JOptionPane.showInputDialog("Digite o segundo número inteiro");

      int number1 = Integer.parseInt(firstNumber); 
      int number2 = Integer.parseInt(secondNumber);

      int sum = number1 + number2; // add numbers

      JOptionPane.showMessageDialog(null, "The sum is " + sum, 
         "Sum of Two Integers", JOptionPane.PLAIN_MESSAGE);
   } 
} // end class Addition


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
