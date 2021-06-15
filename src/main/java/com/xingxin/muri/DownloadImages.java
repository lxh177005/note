package com.xingxin.muri;

import com.xingxin.utils.CSVFileUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author liuxh
 * @date 2021/5/31
 */
public class DownloadImages {
    public static void main(String[] args)  {
        //读取文件
        List<String> lines = CSVFileUtil.getLines("C:\\Users\\dagege\\Desktop\\searchImg(1).csv", "UTF-8");
        List<Map<String, String>> mapList = CSVFileUtil.parseList(lines);
        System.out.println(Arrays.toString(mapList.toArray()));

        List<Map<String, String>> collect = mapList.stream()
                .distinct()
                .filter(p -> StringUtils.isBlank(p.get("searchImg")))
                .collect(Collectors.toList());
        //下载
        for (Map<String,String> map : collect) {
            String searchImg = String.valueOf(map.get("\"searchImg\""));
            String newString = searchImg.substring(0,searchImg.lastIndexOf("?"));
            String name = newString.substring(newString.lastIndexOf("/")+1);
            download(searchImg,name);
        }

    }

    public static void download(String imgUrl, String name){
        try {
            URL url = new URL(imgUrl);
            URLConnection uc = url.openConnection();
            InputStream inputStream = uc.getInputStream();
            FileOutputStream out = new FileOutputStream("D:\\image\\"+name);
            int j = 0;
            while ((j = inputStream.read()) != -1) {
                out.write(j);
            }
            System.out.println("download success:  name="+name);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
