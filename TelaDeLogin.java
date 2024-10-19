import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
  
public class TelaDeLogin extends JFrame 
{
    private final JLabel lblLogin;
    private final JLabel lblSenha;

    private final JTextField txtLogin;
    private final JPasswordField txtSenha;

    private final JButton btnLogar;
    private final JLabel lblNotificacoes;

public TelaDeLogin()
{
    super("Tela de Login");
    setLayout(new FlowLayout());

    lblLogin = new JLabel("Usuário");
    add (lblLogin);

    txtLogin = new JTextField(10);
    add (txtLogin);

    lblSenha = new JLabel("Senha");
    add (lblSenha);

    txtSenha = new JPasswordField(10);
    add (txtSenha);

    btnLogar = new JButton("Logar");
    add (btnLogar);

    lblNotificacoes = new JLabel ("Notificações");
        add (lblNotificacoes);

        ButtonHandler buttonHandler = new ButtonHandler();
        btnLogar.addActionListener(buttonHandler);
        
        txtSenha.addKeyListener(
            new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    if (String.valueOf(txtSenha.getPassword()).trim().length() > 0){
                        if (e.getKeyCode() == 10) {
                            System.out.println("Você teclou enter");
                            logar();
                        }
                    }
                }
            }
        );
}

private class ButtonHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
        logar();
        // aqui será invocado o método de logar
    }
}

public void logar() {
        try{
        
            Connection conexao = MySQLConnector.conectar();
            String strSqlLogin = "select * from `db_senac`.`tbl_senac` where `email` = '" + txtLogin.getText() + "' and `senha` = '" + String.valueOf(txtSenha.getPassword()) + "';";
            Statement stmSqlLogin = conexao.createStatement();
            ResultSet rstSqlLogin = stmSqlLogin.executeQuery(strSqlLogin);
            if (rstSqlLogin.next()){
                lblNotificacoes.setText("Login realizado com sucesso");
                //aqui vamos notificar o usuario que o login e senha foram encontrados
                
            } else {
                lblNotificacoes.setText("Não foi possível encontrar o login e/ou senha digitados. Por favor, verifique e tente novamente.");
                // aqui vamos notificar o usuario que o login e senha nao foram encontrados
            }
        }
        catch (Exception e) {
            lblNotificacoes.setText("Houve um problema e não será possível realizar o login neste momento. Por favor, tente novamente mais tarde. ");
            System.err.println("ops! Deu ruim, se liga no erro" + e);
        }

    }

public String setHtmlFormat(String txt) {
    return "<html><body>" + txt + "</body></html>";
}

public void notificarUsuario(String strTexto) {
    lblNotificacoes.setText(setHtmlFormat(strTexto));
}

    public static void main (String[] args)
    {
    TelaDeLogin telaDeLogin = new TelaDeLogin();
    telaDeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    telaDeLogin.setSize(200,300);
    telaDeLogin.setVisible(true);
    }

}