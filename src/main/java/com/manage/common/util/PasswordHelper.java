package com.manage.common.util;
import com.sun.org.apache.bcel.internal.generic.LLOAD;
import org.bson.types.ObjectId;
import com.manage.entity.Login;
import com.manage.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author 王凌霄
 * @FileName management
 * @Date 2019/9/24 11:10
 */
public class PasswordHelper {
    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
    private static String algorithmName = SHA256Util.HASH_ALGORITHM_NAME;
    private static int hashIterations = SHA256Util.HASH_ITERATIONS;

    public static void encryptPassword(User user) {
        Login login = user.getLogin();
        System.out.println(login);
        login.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(algorithmName, login.getPassword(),  ByteSource.Util.bytes(login.getCredentialsSalt()), hashIterations).toHex();
        login.setPassword(newPassword);
    }

    public static String getPassword(User user){
        Login login = user.getLogin();
        String encryptPassword = new SimpleHash(algorithmName,login.getPassword(),ByteSource.Util.bytes(login.getCredentialsSalt()),hashIterations).toHex();
        return encryptPassword;
    }

    public static void main(String[] args) {
        User user = new User();
        String s = ObjectId.get().toHexString();
        user.setId(s);
        System.out.println(user);
        Login login = new Login();
        login.setUsername("admin");
        login.setPassword("123456");
        login.setSalt("sadat");
        user.setLogin(login);
        encryptPassword(user);
        System.out.println(user);

        String password = getPassword(user);
        System.out.println("ss"+password);
    }
}
