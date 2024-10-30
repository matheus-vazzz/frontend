import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class NavegadorDeRegistro extends TelaDePesquisa
{
    public static void inicializacaoDeRegistros() {
        try {
            String strSqlInicializacao = "select * from `db_senac`.`tbl_senac` order by `id` asc;";
            Connection conexao = MySQLConnector.conectar();
            Statement stmSqlInicializacao = conexao.createStatement();
            ResultSet rstSqlInicializacao = stmSqlInicializacao.executeQuery(strSqlInicializacao);
            if (rstSqlInicializacao.next()) {
                txtId.setText(rstSqlInicializacao.getString("id"));
                txtNome.setText(rstSqlInicializacao.getString("nome"));
                txtEmail.setText(rstSqlInicializacao.getString("email"));
                notificarUsuario("Primeiro registro posicionado com sucesso!");
                habilitarAvancar();
            } else {
                notificarUsuario("Não foram encontrados registros");
            }
        }   catch (Exception e) {
            notificarUsuario("Ops! Houve um problema no servidor e não será possível inicializar os registros no momento. Por favor, retorne novamente mais tarde.");
            System.err.println("Erro:" + e);
        }
    }

    public static void vaParaPrimeiroRegistro() {
        inicializacaoDeRegistros();

    }

    public static void vaParaRegistroAnterior() {
        try {
            String strSqlProxRegistro = "select * from `db_senac`.`tbl_senac` where `id` < " + txtId.getText() + " order by `id` desc;";
            Connection conexao = MySQLConnector.conectar();
                Statement stmSqlInicializacao = conexao.createStatement();
                ResultSet rstSqlInicializacao = stmSqlInicializacao.executeQuery(strSqlProxRegistro);
                if (rstSqlInicializacao.next()) {
                    txtId.setText(rstSqlInicializacao.getString("id"));
                    txtNome.setText(rstSqlInicializacao.getString("nome"));
                    txtEmail.setText(rstSqlInicializacao.getString("email"));
                    notificarUsuario("");
                    habilitarTodos();
                } else {
                    notificarUsuario("Não foram encontrados registros");
                }
            }   catch (Exception e) {
                notificarUsuario("Ops! Houve um problema no servidor e não será possível inicializar os registros no momento. Por favor, retorne novamente mais tarde.");
                System.err.println("Erro:" + e);
            }
        }

    public static void vaParaProximoRegistro() {
        try {
            String strSqlProxRegistro = "select * from `db_senac`.`tbl_senac` where `id` > " + txtId.getText() + " order by `id` asc";
            Connection conexao = MySQLConnector.conectar();
            Statement stmSqlInicializacao = conexao.createStatement();
            ResultSet rstSqlInicializacao = stmSqlInicializacao.executeQuery(strSqlProxRegistro);
            if (rstSqlInicializacao.next()) {
                txtId.setText(rstSqlInicializacao.getString("id"));
                txtNome.setText(rstSqlInicializacao.getString("nome"));
                txtEmail.setText(rstSqlInicializacao.getString("email"));
                notificarUsuario("");
                habilitarTodos();
            } else {
                notificarUsuario("Não foram encontrados registros");
            }
        }   catch (Exception e) {
            notificarUsuario("Ops! Houve um problema no servidor e não será possível inicializar os registros no momento. Por favor, retorne novamente mais tarde.");
            System.err.println("Erro:" + e);
        }
    }

    public static void vaParaUltimoRegistro() {
        try {
            String strSqlProxRegistro = "select * from `db_senac`.`tbl_senac` where `id` order by `id` desc";
            Connection conexao = MySQLConnector.conectar();
            Statement stmSqlInicializacao = conexao.createStatement();
            ResultSet rstSqlInicializacao = stmSqlInicializacao.executeQuery(strSqlProxRegistro);
            if (rstSqlInicializacao.next()) {
                txtId.setText(rstSqlInicializacao.getString("id"));
                txtNome.setText(rstSqlInicializacao.getString("nome"));
                txtEmail.setText(rstSqlInicializacao.getString("email"));
                notificarUsuario("Último registro posicionado com sucesso!");
                habilitarVoltar();
            } else {
                notificarUsuario("Não foram encontrados registros");
            }
        }   catch (Exception e) {
            notificarUsuario("Ops! Houve um problema no servidor e não será possível inicializar os registros no momento. Por favor, retorne novamente mais tarde.");
            System.err.println("Erro:" + e);
        }
    }

}
