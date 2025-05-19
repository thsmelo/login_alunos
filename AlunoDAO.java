import java.sql.*;
import java.util.*;

public class AlunoDAO {
    public void cadastrar(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO alunos (nome, email, data_nascimento, id_curso) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.nome);
            stmt.setString(2, aluno.email);
            stmt.setString(3, aluno.dataNasc);
            stmt.setInt(4, aluno.idCurso);
            stmt.execute();
            conn.close();
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar aluno");
        }
    }

    public List<Aluno> listar() {
        List<Aluno> lista = new ArrayList<>();
        try {
            Connection conn = Conexao.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM alunos");

            while (rs.next()) {
                Aluno a = new Aluno(
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("data_nascimento"),
                    rs.getInt("id_curso")
                );
                lista.add(a);
            }

            conn.close();
        } catch (Exception e) {
            System.out.println("Erro ao listar alunos");
        }
        return lista;
    }
}