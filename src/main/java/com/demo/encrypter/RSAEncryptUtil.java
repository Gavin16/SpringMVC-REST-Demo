package com.demo.encrypter;

import com.alibaba.druid.filter.config.ConfigTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Title: SpringMVC-REST-Demo
 * @Package com.demo.encrypter
 * @Description:
 * @author: Minsky
 * @date 2018/5/18 15:35
 */
public class RSAEncryptUtil {
    public static final String PRIVATE_KEY ="MIIBVQIBADANBgkqhkiG9w0BAQEFAASCAT8wggE7AgEAAkEA2G1i2xoBoqarxow9cPU1exzzmWgzcVozxsg78TjJkYDxnDk549Nq61tpbsE/wlfE11pKaaivLJIBltFgc3zlUQIDAQABAkEAucV6+1LhYHnsLGsoOhNgqqJ5Po7AyWWB1/j76tyxuF//5HOsmTu3nBq01Ax+aCAO+9rPjZ37tPzkBA/7mje8IQIhAO5bPxyN3LGTH1i66MSDiwuSAAkns6rpZ6wDC/fNJzqNAiEA6HKXd4mReWgriFSHJc5WqYHjWHSjA7iQWWnsDjvZZtUCID4OxbzCdq5JFsU8TLQ1Z3NIvPelPZMHF/XiCTCoWklVAiEAtsDRgXQxYeiawVbj4r91t1OdsQAS4mwLYaE7rH01kfkCIF3uq8ahfveLuUkuB9mUdhcHeIXlRJ2lMxgeZYDLzb24";
    public static final String PUBLIC_KEY ="MFwwDQYJKoZIhvcNAQEBBQADSwAwSAJBANhtYtsaAaKmq8aMPXD1NXsc85loM3FaM8bIO/E4yZGA8Zw5OePTautbaW7BP8JXxNdaSmmoryySAZbRYHN85VECAwEAAQ==";

    private static final Logger logger = LoggerFactory.getLogger(RSAEncryptUtil.class);

    public static String defaultEnctrypt(String plainText){
        try {
            return ConfigTools.encrypt(plainText);
        } catch (Exception e) {
            logger.error("defaultEnctrypt加密失败：{}",e);
        }
        return  null;
    }

    public static String defaultDecrypt(String encryptedText){
        try {
            return ConfigTools.decrypt(encryptedText);
        } catch (Exception e) {
            logger.error("defaultDecrypt解密失败：{}",e);
        }
        return  null;
    }

    public static String encrypt(String privateKey,String plainText)throws Exception{
        return ConfigTools.encrypt(privateKey,plainText);
    }

    public static String decrypt(String publicKey,String plainText)throws Exception{
         return ConfigTools.decrypt(publicKey,plainText);
    }

    public static String encrypt(String plainText){
        try {
            return encrypt(PRIVATE_KEY,plainText);
        } catch (Exception e) {
            logger.error("encrypt加密失败：{}",e);
        }
        return null;
    }

    public static String decrypt(String plainText){
        try {
            return decrypt(PUBLIC_KEY,plainText);
        } catch (Exception e) {
            logger.error("decrypt解密失败：{}",e);
        }
        return null;
    }

}
