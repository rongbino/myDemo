package com.sogou.test;

import com.sogou.upd.passport.common.math.Coder;
import com.sogou.upd.passport.manager.ManagerHelper;
import org.junit.Test;


/**
 * Created by wanghuaqing on 2016/12/1.
 */
public class DemoTest {
    @Test
    public void test() {
        String firstStr = "coderqing333";
        int clientId = 1120;
        String secret = "4xoG%9>2Z67iL5]OdtBq$l#>DfW@TY";
        long ct = System.currentTimeMillis();
//        long ct = 1580414752554L;

        String code = ManagerHelper.generatorCode(firstStr, clientId, secret, ct);
        System.err.println(ct);
        System.err.println(code);
    }

    public static String generatorCode(String firstStr, int clientId, String secret, long ct) {
        //计算默认的code
        String code = "";
        try {
            code = firstStr + clientId + secret + ct;
            code = Coder.encryptMD5(code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return code;
    }
}
