import javax.crypto.Cipher;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;

public class RSAExample {
    public static void main(String[] args) throws Exception {
        // Gerar par de chaves RSA (2048 bits)
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();

        // Texto original
        String mensagem = "Mensagem secreta";
        System.out.println("Original: " + mensagem);

        // Criptografar com chave pública
        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] textoCriptografado = cipher.doFinal(mensagem.getBytes());
        String textoCriptografadoBase64 = Base64.getEncoder().encodeToString(textoCriptografado);
        System.out.println("Criptografado: " + textoCriptografadoBase64);

        // Descriptografar com chave privada
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] textoDescriptografado = cipher.doFinal(Base64.getDecoder().decode(textoCriptografadoBase64));
        System.out.println("Descriptografado: " + new String(textoDescriptografado));
    }
}