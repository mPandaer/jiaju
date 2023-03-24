package space.pandaer.test;

import org.junit.jupiter.api.Test;
import space.pandaer.utils.MD5Utils;

public class MD5UtilsTest {
    @Test
    public void testMD5String(){
        String md5Str = MD5Utils.getMD5Str("11");
        System.out.println(md5Str);
    }
}
