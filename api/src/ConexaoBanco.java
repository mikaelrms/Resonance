import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexaoBanco {
    public static void main(String[] args) {
        String url = "jdbc:mysql://resonance-db-resonance.b.aivencloud.com:15156/defaultdb";
        String usuario = "avnadmin";
        String senha = System.getenv("DB_PASSWORD");

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);

            String sql = "SELECT id, nome, genero, ano FROM bandas";

            PreparedStatement comando = conexao.prepareStatement(sql);
            ResultSet resultado = comando.executeQuery();

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String genero = resultado.getString("genero");
                int ano = resultado.getInt("ano");

                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Gênero: " + genero);
                System.out.println("Ano: " + ano);
                System.out.println();
            }

            resultado.close();
            comando.close();
            conexao.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}