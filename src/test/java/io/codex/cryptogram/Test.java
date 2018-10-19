package io.codex.cryptogram;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.codex.cryptogram.codec.Base64Codec;
import io.codex.cryptogram.codec.Codec;
import io.codex.cryptogram.codec.HexCodec;
import io.codex.cryptogram.signature.SHA256WithRSASignatureProvider;
import io.codex.cryptogram.stringify.DefaultStringifyProvider;
import io.codex.cryptogram.verification.SHA256WithRSAVerificationProvider;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Map;

/**
 * 测试类
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/18
 */
public class Test {

    @org.junit.Test
    public void test() throws Exception {
        Cryptography cryptography = new Cryptography(
                new HexCodec(),
                new Base64Codec(),
                new DefaultStringifyProvider(),
                new SHA256WithRSASignatureProvider(),
                new SHA256WithRSAVerificationProvider()
        );

        Codec codec = new Base64Codec();

        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);
        KeyPair keyPair = generator.generateKeyPair();
        String publicKey = codec.encode(keyPair.getPublic().getEncoded());
        String privateKey = codec.encode(keyPair.getPrivate().getEncoded());

        System.out.println(publicKey.length());
        System.out.println(privateKey.length());

        long now = System.currentTimeMillis();

        String message = "{\n" +
                "    \"goodsNo\": \"2018101900001\",\n" +
                "    \"brand\": \"Nike\",\n" +
                "    \"price\": 998,\n" +
                "    \"designer\": null,\n" +
                "    \"colors\": [\"001\", \"002\"],\n" +
                "    \"sizes\": [\"S\", \"M\"],\n" +
                "    \"barcode\": {\n" +
                "        \"2018101900001-001-S\": {\n" +
                "            \"color\": \"001\",\n" +
                "            \"size\": \"S\"\n" +
                "        },\n" +
                "        \"2018101900001-001-M\": {\n" +
                "            \"color\": \"001\",\n" +
                "            \"size\": \"M\"\n" +
                "        },\n" +
                "        \"2018101900001-002-S\": {\n" +
                "            \"color\": \"002\",\n" +
                "            \"size\": \"S\"\n" +
                "        },\n" +
                "        \"2018101900001-002-M\": {\n" +
                "            \"color\": \"002\",\n" +
                "            \"size\": \"M\"\n" +
                "        }\n" +
                "    }\n" +
                "}\n";
        ObjectMapper mapper = new ObjectMapper();
        Map map = mapper.readValue(message.getBytes(), Map.class);

        String signature = cryptography.sign(map, "POST /api/purchase?", "&timestamp=" + now, privateKey);
        System.out.println(signature);
        boolean verified = cryptography.verify(map, "POST /api/purchase?", "&timestamp=" + now, signature, publicKey);
        System.out.println(verified);
    }

}
