package io.codex.cryptogram;

import io.codex.cryptogram.codec.Codec;
import io.codex.cryptogram.codec.HexCodec;
import io.codex.cryptogram.codec.PlainCodec;
import io.codex.cryptogram.signature.HMACSHA256SignatureProvider;
import io.codex.cryptogram.signature.SignatureProvider;
import io.codex.cryptogram.stringify.DefaultStringifyProvider;
import io.codex.cryptogram.stringify.StringifyProvider;
import io.codex.cryptogram.verification.HMACSHA256VerificationProvider;
import io.codex.cryptogram.verification.VerificationProvider;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试类
 *
 * @author 杨昌沛 646742615@qq.com
 * 2018/10/19
 */
public class Testing {

    @Test
    public void test() throws Exception {
        Codec signCodec = new HexCodec();
        Codec keyCodec = new PlainCodec();
        StringifyProvider stringifyProvider = new DefaultStringifyProvider();
        SignatureProvider signatureProvider = new HMACSHA256SignatureProvider();
        VerificationProvider verificationProvider = new HMACSHA256VerificationProvider();

        Cryptography cryptography = new Cryptography(
                signCodec,
                keyCodec,
                stringifyProvider,
                signatureProvider,
                verificationProvider
        );

        String secretKey = "io.codex.cryptogram";
        Map<String, String> param = new HashMap<String, String>();
        param.put("username", "codex");
        param.put("password", "codex");

        {
            // HmacSHA256("{password=codex&username=codex}", "io.codex.cryptogram")
            String signature = cryptography.sign(param, secretKey);
            boolean verified = cryptography.verify(param, signature, secretKey);
            assert verified : "A serious bug";
        }

        {
            // HmacSHA256("POST /login?{password=codex&username=codex}&timestamp=1539851150142", "io.codex.cryptogram")
            long timestamp = 1539851150142L;
            String signature = cryptography.sign(param, "POST /login?", "&timestamp=" + timestamp, secretKey);
            boolean verified = cryptography.verify(param, "POST /login?", "&timestamp=" + timestamp, signature, secretKey);
            assert verified : "A serious bug";
        }
    }

}
