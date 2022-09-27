package com.testing.Case;

import com.testing.constants.Constants;
import com.testing.utils.HttpUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterCase {

    @Test(dataProvider = "datas")
    public void testRegister(String params){

        String url = Constants.REGISTER_URL;
        String method = Constants.METHOD;
        HttpUtils.call(method,url,params);


    }

    @DataProvider(name ="datas")
    public Object[][] datas(){
        Object[][] datas = {
                {"mobilephone=&pwd=33"},
                {"mobilephone=13212312312&pwd="},
                {"mobilephone=132aaa&pwd=123456"},
                {"mobilephone=13212312312&pwd=33"},
                {"mobilephone=13212312399&pwd=123456"},
                {"mobilephone=13212312399&pwd=123456"}
        };
        return null;
    }
}
