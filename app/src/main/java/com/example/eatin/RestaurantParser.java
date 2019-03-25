package com.example.eatin;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class RestaurantParser {
    public static String getOriginal(String url){
         int k;
         for(k = url.length()-1; k >=0; k--){
             if(url.charAt(k) == '/'){
              break;
             }


         }
         return url.substring(0, k+1) + "0.jpg";

    }

    public static List<String> getPictures(String html) {
        Document Doc = Jsoup.parse(html);
        Elements Images = Doc.select("div.photo_box > img");
        List<String> urls = new ArrayList<>();
        String src;
        for(Element e : Images){
           src= e.attr("src");
            if (src  != null && !src.equals("") ){
              urls.add(getOriginal(src));

            }
        }
        return urls;
    }








}
