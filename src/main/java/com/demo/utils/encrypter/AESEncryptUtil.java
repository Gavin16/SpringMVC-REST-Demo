package com.demo.utils.encrypter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @Title: ${FILE_NAME}
 * @Package: com.demo.utils.encrypter
 * @Description: ECB模式的AES加密实现工具类
 * @author: Minsky
 * @date: 2018/5/19 11:17
 */
public class AESEncryptUtil {

    // 加密模式和加密的填充模式
    public static final String AES_ALGORITHM = "AES";
    public static final String ECB_CIPHER_ALGORITHM="AES/ECB/PKCS5Padding";

    // 加密秘钥 KeyGenerator 生成
    public static final byte[] AES_ECB_KEY = {  (byte)0X8A,(byte)0X9C,(byte)0X27,(byte)0XEB,
            (byte)0X95,(byte)0X6B,(byte)0X30,(byte)0XB3,
            (byte)0X5D,(byte)0X6D,(byte)0XC6,(byte)0X04,
            (byte)0XD4,(byte)0X19,(byte)0X6C,(byte)0X26};

    private static final Logger logger = LoggerFactory.getLogger(AESEncryptUtil.class);

    public static String AesEcbEncrypt(String plainText){
        try {
            Cipher cipher = Cipher.getInstance(ECB_CIPHER_ALGORITHM);
            SecretKey secretKey = new SecretKeySpec(AES_ECB_KEY,AES_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            // 字符串转为字节数组 进行加密
            byte[] textBytes = plainText.getBytes();
            byte[] encryptedText =  cipher.doFinal(textBytes);
            // 加密后使用base64编码
            Base64.Encoder encoder =  Base64.getEncoder();
            return encoder.encodeToString(encryptedText);

        } catch (NoSuchAlgorithmException e) {
            logger.error("Cipher无法获取该加密算法实例：{}",e);
        } catch (NoSuchPaddingException e) {
            logger.error("不存在该加密填充：{}",e);
        } catch (InvalidKeyException e) {
            logger.error("无效的加密秘钥：{}",e);
        } catch (BadPaddingException e) {
            logger.error("错误的加密填充：{}",e);
        } catch (IllegalBlockSizeException e) {
            logger.error("加密文本块大小不合法：{}",e);
        }

        return  null;
    }

    public static String AesEcbDecrypt(String decodeText){
        try {
            Cipher cipher = Cipher.getInstance(ECB_CIPHER_ALGORITHM);
            SecretKey secretKey = new SecretKeySpec(AES_ECB_KEY,AES_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE,secretKey);

            // 先将字符串解码为byte数组
            byte[]decodeTextBytes =  Base64.getDecoder().decode(decodeText);
            return new String(cipher.doFinal(decodeTextBytes));

        } catch (NoSuchAlgorithmException e) {
            logger.error("Cipher无法获取该加密算法实例：{}",e);
        } catch (NoSuchPaddingException e) {
            logger.error("不存在该加密填充：{}",e);
        } catch (InvalidKeyException e) {
            logger.error("无效的加密秘钥：{}",e);
        } catch (BadPaddingException e) {
            logger.error("错误的加密填充：{}",e);
        } catch (IllegalBlockSizeException e) {
            logger.error("加密文本块大小不合法：{}",e);
        }
        return null;
    }
}
