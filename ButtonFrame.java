//
import java.awt.FlowLayout; // como as saídas das camadas estão sendo renderizadas (do primeiro ao último)
import java.awt.event.ActionListener; // esse e o debaixo são resposáveis por mostrar as duas telas
import java.awt.event.ActionEvent;
import javax.swing.JFrame; // responsável por entregar a estrutura pronta
import javax.swing.JButton; // responsável pelo funcionamento dos botões
import javax.swing.Icon; // responsável pela imagenzinha (estrutura)
import javax.swing.ImageIcon; // a imagem é carregada pelo ImageIcon
import javax.swing.JOptionPane; // a mensagem que aparecerá quando clicado nos botões

// declaração da classe ButtonFrame, herdando JFrame
public class ButtonFrame extends JFrame 
// inicia o bloco de códigos da classe ButtonFrame
{
   private final JButton plainJButton; // as duas linhas são declarações de variáveis, com destaque ao tipo 'JButton'
   private final JButton fancyJButton; // 
   
   
   // declaração do construtor (public - exportável)
   public ButtonFrame()
   {
      // definição do título
      super("Testing Buttons");
      // define o layout, sendo enviado o objeto FlowLayout
      setLayout(new FlowLayout()); 

      plainJButton = new JButton("Plain Button"); // atribuição de um objeto a variável, permitindo escrever o que deseja no botão
      add(plainJButton); // add plainJButton to JFrame

      // declaração de variável, com o tipo Icon, e atribuindo um novo objeto ImageIcon, abrindo um parâmetro com o parênteses, colocando o getClass, que pega a classe, e o getResource, que pega o recurso (a própria imagem que tem o nome)
      Icon bug1 = new ImageIcon(getClass().getResource("bug1.gif"));
      Icon bug2 = new ImageIcon(getClass().getResource("bug2.gif"));
      fancyJButton = new JButton("Fancy Button", bug1); // definição de valor para fancyJButton, com dois parâmetros, de texto e imagem
      fancyJButton.setRolloverIcon(bug2); // inovcação do método setRolloverIcon (quando o mouse é colocado em cima do botão, troca-se o 'bug1' pelo 'bug2')
      add(fancyJButton); // add fancyJButton to JFrame

      // ButtonHandler é quem vai executar a operação manual, com a variável do tipo ButtonHandler, atribuída ao new ButtonHandler
      ButtonHandler handler = new ButtonHandler();
      // estará escutando a ação, declarado a variável e invocando o método addActionListener
      fancyJButton.addActionListener(handler);
      plainJButton.addActionListener(handler);
   }

   // criação de uma subclasse, privada a classe principal, injetado ao ActionListener
   private class ButtonHandler implements ActionListener 
   {
      // sobrescrever
      @Override
      // actionPerfomed = como ele age dentro da ação, funcionando pelo parâmetro eventm do tipo ActionEvent
      public void actionPerformed(ActionEvent event)
      {
         // showMessageDialog = exibir mensagem de diálogo, o jeito que o computador conversa com o usuário, com o parâmetro da mesma classe, e com uma string formatada, sendo desejado que mostre um texto (o texto do próprio objeto)
         JOptionPane.showMessageDialog(ButtonFrame.this, String.format(
            "You pressed: %s", event.getActionCommand()));
      }
   } 
} 
