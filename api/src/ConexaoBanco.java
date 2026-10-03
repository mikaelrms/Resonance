import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBanco {
    public static void main(String[] args) {
        String url = "jdbc:mysql://resonance-db-resonance.b.aivencloud.com:15156/defaultdb";
        String usuario = "avnadmin";
        String senha = System.getenv("DB_PASSWORD");

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conexao realizada com sucesso!");
            conexao.close();
        } catch (Exception e) {
            System.out.println("Erro ao conectar:");
            e.printStackTrace();
        }
    }
}