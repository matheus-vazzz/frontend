// a linha abaixo está importando o componente 'JFrame' da biblioteca 'javax'
import javax.swing.JFrame;

// a linha abaixo declara a classe 'TextFieldTest' (que tem o mesmo nome do arquivo)
public class TextFieldTest

// a linha abaixo inicia o bloco de códigos da classe 'TextFieldTest'
{
   // a linha abaixo declara o método 'main'
   public static void main(String[] args)
   // início do bloco de códigos do método
   { 
      // declaração da variável 'TextFieldFrame', com o tipo tendo o mesmo nome (diferença: T maiúsculo), está também sendo apresentado um novo objeto (sempre no new, há um novo objeto)
      TextFieldFrame textFieldFrame = new TextFieldFrame(); 
      // definir operação de fechamento padrão
      textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // size define o tamanho
      textFieldFrame.setSize(350, 100); 
      // trabalha com a visibilidade (true = verdadeiro)
      textFieldFrame.setVisible(true); 
   // fim do bloco de código do método
   }
// fim do bloco de códigos da classe
} 
