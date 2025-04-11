import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;

public class AESExample {
    public static void main(String[] args) throws Exception {
        // Gerar chave AES-256
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // Tamanho da chave
        SecretKey secretKey = keyGen.generateKey();

        // Texto original
        String mensagem = "Dados confidenciais";
        System.out.println("Original: " + mensagem);

        // Criptografar
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] textoCriptografado = cipher.doFinal(mensagem.getBytes());
        String textoCriptografadoBase64 = Base64.getEncoder().encodeToString(textoCriptografado);
        System.out.println("Criptografado: " + textoCriptografadoBase64);

        // Descriptografar
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] textoDescriptografado = cipher.doFinal(Base64.getDecoder().decode(textoCriptografadoBase64));
        System.out.println("Descriptografado: " + new String(textoDescriptografado));
    }
}