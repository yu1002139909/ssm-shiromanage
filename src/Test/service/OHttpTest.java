package service;

import com.alibaba.fastjson.JSON;
import entity.Adress;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author yuyu
 * @since 2018/2/8 18:36
 */
public class OHttpTest {

    public static void main(String[] args) throws IOException {

        String url  = "http://api.map.baidu.com/geocoder/v2/?callback=renderReverse&location=23.107683,112.892562&output=json&pois=1&ak=2yzaejuxHacVcruOaB9fmO3jodgWmAuU";
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Response response = okHttpClient.newCall(request).execute();
        String string = response.body().string();
        String substring = string.substring(29,string.length()-1);
        Adress parseObject = JSON.parseObject(substring, Adress.class);
        System.out.println();
        System.out.println(substring);
    }


}
