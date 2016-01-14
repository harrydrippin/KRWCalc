package com.kmucs.krwcalc.lib;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by harryhong on 16. 1. 13..
 */
public class ERParser {
    public static String docText;

    public static String random_str() {
        Random rand = new Random();
        String result = "";
        String t = "";
        for (int i = 0 ; i < 20 ; i++){
            t = Integer.toHexString(rand.nextInt(0xff));
            if (t.length() == 1) t = "0" + t;
            result += t; }
        return result;

    }

    public static String time_str(String format) {
        long time = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat(format);
        String str = dayTime.format(new Date(time));

        return str;
    }

    public static float getExchangeRate(String country_code) {
        String yyyy = time_str("yyyy");
        String MM = time_str("MM");
        String dd = time_str("dd");
        String hh = time_str("hh");
        String mm = time_str("mm");
        String ss = time_str("ss");

        boolean flag = false;


        if (Integer.parseInt(hh) < 8) flag = true;
        else if (Integer.parseInt(hh) == 8 & Integer.parseInt(mm) < 40) flag = true;

        if (flag) dd = String.valueOf(Integer.parseInt(dd) - 1);

        String url = "https://open.keb.co.kr/OPFXFR010001.web?targetMethod=doTextDownload&excelFileName=exchange_rate.txt&%EA%B8%B0%EC%A4%80%EC%9D%BC=DAY&%ED%9A%8C%EC%B0%A8%EA%B5%AC%EB%B6%84=0&%ED%86%B5%ED%99%94%EC%BD%94%EB%93%9C=COUNTRY&ncuR=OFF";
        url = url.replace("DAY", time_str("yyyyMM")+dd);
        url = url.replace("COUNTRY", country_code);

        try {
            Document doc = Jsoup.connect(url)
                    .data("searchValue", String.format("%s-%s-%s\t08:40(1회차)\t%s-%s-%s %s:%s",yyyy,MM,dd,yyyy,MM,dd,mm,ss))
                    .data("targetMethod", "doExcelDownload")
                    .data("tiles_frame", "yes")
                    .data("transkeyUuid", random_str())
                    .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.106 Safari/537.36")
                    .ignoreContentType(true)
                    .post();

            docText = doc.text();
            String[] rate = docText.split(country_code);
            rate = rate[1].split(" ");

            if (country_code == "JPY"){
                return (Float.parseFloat(rate[6])/10);
            } else {
                return Float.parseFloat(rate[5]);
            }
        } catch (Exception e) {
            return -1f;
        }
    }
}
