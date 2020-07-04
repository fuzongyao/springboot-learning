package cn.fuzongyao.learning.springboot;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author fuzongyao
 * @date 2020/05/29
 * @since 1.0.0
 */
public class JsoupApplication {

    public static void main(String[] args) throws Exception {
        String provinceUrl = "http://www.stats.gov.cn/tjsj/tjbz/tjyqhdmhcxhfdm/2019/index.html";
        Document provinceDocument = Jsoup.connect(provinceUrl).timeout(10000).get();
        //若HTML文档包含相对URLs路径，需要将这些相对路径转换成绝对路径的URLs
        Elements provinceElements = provinceDocument.select("tr[class='provincetr']");

        for (Element provinceElement : provinceElements) {
            Elements provinceDatas = provinceElement.select("a");
            for (Element provinceData : provinceDatas) {
                String provinceName = provinceData.text();
                String cityUrl = provinceData.absUrl("href");
                String href = provinceData.attr("href");
                String provinceCode = href.split("\\.")[0];
                System.out.println(String.format("省份编码：%s, 名称：%s", provinceCode, provinceName));

                Thread.sleep(1000);
                Document cityDocument = Jsoup.connect(cityUrl).timeout(10000).get();
                Elements cityElements = cityDocument.select("tr[class='citytr']");
                for (Element cityElement : cityElements) {
                    Elements cityDatas = cityElement.select("a");
                    String cityName = cityDatas.get(1).text();
                    String countyUrl = cityDatas.get(0).absUrl("href");
                    String href1 = cityDatas.get(0).attr("href");
                    String cityCode = href1.substring(href1.indexOf("/") + 1).split("\\.")[0];
                    System.out.println(String.format("城市编码：%s, 名称：%s", cityCode, cityName));

                    Thread.sleep(1000);
                    Document countyDocument = Jsoup.connect(countyUrl).timeout(10000).get();
                    Elements countyElements = countyDocument.select("tr[class='countytr']");
                    for (Element countyElement : countyElements) {
                        if (countyElement.hasAttr("a")) {
                            Elements countyDatas = countyElement.select("a");
                            String countyName = countyDatas.get(1).text();
                            String townUrl = countyDatas.get(0).absUrl("href");
                            String countyHref = countyDatas.get(0).attr("href");
                            String countyCode = countyHref.substring(countyHref.indexOf("/") + 1).split("\\.")[0];
                            System.out.println(String.format("区县编码：%s, 名称：%s", countyCode, countyName));
                        } else {
                            Elements countyDatas = countyElement.select("td");
                            String countyName = countyDatas.get(1).text();
                            String countyCode = countyDatas.get(0).text();
                            System.out.println(String.format("区县编码：%s, 名称：%s", countyCode, countyName));
                        }
                    }
                }
            }
        }
    }
}
