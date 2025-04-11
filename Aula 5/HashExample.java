import java.security.MessageDigest;
import java.util.Base64;

public class HashExample {
    public static void main(String[] args) throws Exception {
        // Dados de entrada
        String senha = "SenhaSegura123";

        // Criar hash SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = digest.digest(senha.getBytes());

        // Converter para hexadecimal
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            hexString.append(String.format("%02x", b));
        }

        System.out.println("Hash SHA-256: " + hexString.toString());
    }
}