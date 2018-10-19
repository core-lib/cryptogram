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

        String signature = cryptography.sign(param, secretKey);
        boolean verified = cryptography.verify(param, signature, secretKey);
        assert verified : "A serious bug";
    }

}
```