
import javax.swing.JFrame;

// declaração da classe ButtonTest
public class ButtonTest 
// inicia o bloco de códigos da classe ButtonTest
{   
   // declaração do método executor 'main'
   public static void main(String[] args)
   // início do bloco de códigos do método
   { 
      // declaração da variável buttonFrame, do tipo ButtonFrame, cujo valor será atribuído um novo objeto ButtonFrame
      ButtonFrame buttonFrame = new ButtonFrame(); 
      // define a saída ao fechar
      buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // define tamanho (altura e largura)
      buttonFrame.setSize(275, 110); 
      // definição da visibilidade da tela (verdadeira)
      buttonFrame.setVisible(true); 
   } 
}
