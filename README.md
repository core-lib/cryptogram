# cryptogram [![](https://www.jitpack.io/v/core-lib/cryptogram.svg)](https://www.jitpack.io/#core-lib/cryptogram)

## Installation
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://www.jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.core-lib</groupId>
    <artifactId>cryptogram</artifactId>
    <version>1.0.0</version>
</dependency>
<dependency>
    <groupId>commons-codec</groupId>
    <artifactId>commons-codec</artifactId>
    <version>1.11</version>
</dependency>
```

## Usage
```java
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
            // HmacSHA256("{username=codex&password=codex}", "io.codex.cryptogram")
            String signature = cryptography.sign(param, secretKey);
            boolean verified = cryptography.verify(param, signature, secretKey);
            assert verified : "A serious bug";
        }

        {
            // HmacSHA256("POST /login?{username=codex&password=codex}&timestamp=1539851150142", "io.codex.cryptogram")
            long timestamp =1539851150142L;
            String signature = cryptography.sign(param, "POST /login?", "&timestamp=" + timestamp, secretKey);
            boolean verified = cryptography.verify(param, "POST /login?", "&timestamp=" + timestamp, signature, secretKey);
            assert verified : "A serious bug";
        }
    }

}
```