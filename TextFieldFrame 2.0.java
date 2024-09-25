// todos seguem o mesmo padrão: componente, módulo e bilbioteca (alguns com 4 possuem submódulos)
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

// declaração da classe 'TextFieldFrame', que está herdando o componente JFrame
public class TextFieldFrame extends JFrame 
{
   // as 4 linhas abaixo são declarações de variáveis
   private final JTextField textField1; 
   private final JTextField textField2; 
   private final JTextField textField3; 
   private final JPasswordField passwordField; 

   // esse 'TextFieldFrame' é o construtor, e o 'public' é o exportador
   public TextFieldFrame()
   {
      // 'super' é a definição do título da janela
      super("Testing JTextField and JPasswordField");
      // o que for renderizado primeiro, vai aparecendo na tela primeiro
      setLayout(new FlowLayout());

      // declaração de variável, mas puxa mais pra atribuição (é possível alterar pelo caso do java aceitar mudanças vendo como um objeto)
      textField1 = new JTextField(10); 
      // adiciona o textField1 ao quadro
      add(textField1); 

      // declaração de variável puxando para atribuição (entende como texto direto)
      textField2 = new JTextField("Enter text here");
      add(textField2); // add textField2 to JFrame

      // atribuição de um novo JTextField com texto e colunas
      textField3 = new JTextField("Uneditable text field", 21);
      // define que o textField3 não pode ser editado (consegue selecionar, mas não pode editar)
      textField3.setEditable(false);
      add(textField3); // add textField3 to JFrame

      // atribuição de um novo objeto a variável 'passwordField' (texto)
      passwordField = new JPasswordField("Hidden text");
      add(passwordField); // add passwordField to JFrame

      // 'handler' é uma espécie de manipulador dos campos 'textField'. Na linha abaixo, há a declaração da variável 'handler', onde é atribuído a ele o construtor 'TextFieldHandler'
      TextFieldHandler handler = new TextFieldHandler();
      // em todas as variáveis 'textField', será adicionado um escutador de ação, e dentro dele será enviado um 'handler'
      textField1.addActionListener(handler);
      textField2.addActionListener(handler);
      textField3.addActionListener(handler);
      passwordField.addActionListener(handler);
   }

   // para que o 'handler' seja objeto, será injetado o objeto 'ActionListener' a classe 'TextFieldHandler'
   private class TextFieldHandler implements ActionListener 
   {
      // o @ serve para não notificar avisos, e o comando 'Override' serve para sobreescrever 
      @Override
      // o public permite importar para outro, e para receber as informações, o event, junto do seu tipo ActionEvent é responsável
      public void actionPerformed(ActionEvent event)
      {
         // 'string' é a variável do tipo 'String', e está sendo atribuido um texto vazio
         String string = ""; 
         // o 'if' permite a validação das ações que serão apresentadas depois dele. Quando há dois sinais de igual, há uma comparação. A comparação retornará verdadeira, já que o 'getSource' será o 'textfield1', e o 'textField1' também
         if (event.getSource() == textField1)
         // a string recebe um novo texto, e 'String.format' entrega o texto formatado. '%' é um caractere coringa, e o 's' retornará uma string   
         string = String.format("textField1: %s",
         // ao apertar enter, o texto escrito será enviado para a telinha de exibição    
         event.getActionCommand());

         // user pressed Enter in JTextField textField2
         else if (event.getSource() == textField2)
            string = String.format("textField2: %s",
               event.getActionCommand());

         // user pressed Enter in JTextField textField3
         else if (event.getSource() == textField3)
            string = String.format("textField3: %s", 
               event.getActionCommand());

         // user pressed Enter in JTextField passwordField
         else if (event.getSource() == passwordField)
            string = String.format("passwordField: %s", 
               event.getActionCommand());

         // é invocado o JOptionPane, pedindo para exibir uma caixa de diálogo
         JOptionPane.showMessageDialog(null, string); 
      } 
   } // end private inner class TextFieldHandler
} // end class TextFieldFrame

