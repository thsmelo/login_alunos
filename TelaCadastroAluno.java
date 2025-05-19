import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaCadastroAluno extends JFrame {
    JTextField nome, email, nascimento, curso;
    JTextArea lista;
    AlunoDAO dao = new AlunoDAO();

    public TelaCadastroAluno() {
        setTitle("Cadastro de Alunos");
        setSize(400, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        nome = new JTextField(25);
        email = new JTextField(25);
        nascimento = new JTextField(10);
        curso = new JTextField(5);
        lista = new JTextArea(10, 30);
        lista.setEditable(false);

        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnListar = new JButton("Listar");

        add(new JLabel("Nome:")); add(nome);
        add(new JLabel("Email:")); add(email);
        add(new JLabel("Nascimento:")); add(nascimento);
        add(new JLabel("ID Curso:")); add(curso);
        add(btnCadastrar); add(btnListar);
        add(new JScrollPane(lista));

        btnCadastrar.addActionListener(e -> {
            Aluno a = new Aluno(nome.getText(), email.getText(), nascimento.getText(), Integer.parseInt(curso.getText()));
            dao.cadastrar(a);
            JOptionPane.showMessageDialog(null, "Aluno cadastrado!");
        });

        btnListar.addActionListener(e -> {
            lista.setText("");
            for (Aluno a : dao.listar()) {
                lista.append("Nome: " + a.nome + "\nEmail: " + a.email + "\nNascimento: " + a.dataNasc + "\nCurso: " + a.idCurso + "\n\n");
            }
        });
    }

    public static void main(String[] args) {
        new TelaCadastroAluno().setVisible(true);
    }
}