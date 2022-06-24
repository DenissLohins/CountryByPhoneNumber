package core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.HashMap;

public class PrepareRepositoryService {


    public HashMap<String, String> prepare() throws IOException {
        Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/List_of_country_calling_codes").get();
        Element table = doc.select("table").get(1);
        Elements rows = table.select("tr");
        HashMap<String, String> repository = new HashMap<>();
        for (int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements columns = row.select("td");
            var codes = StringUtils.trimAllWhitespace(columns.get(1).text());
            if (codes.contains(",")) {
                var codesArray = codes.split(",", -1);
                var countrynames = columns.get(0).text();
                for (int j = 0; j < codesArray.length; j++) {
                    var code = StringUtils.trimAllWhitespace(codesArray[j]);
                    repository.put(code, countrynames);
                }
            } else {
//            var phoneCode = StringUtils.trimAllWhitespace((columns.get(1).text()));
                var countryName = columns.get(0).text();
                repository.put(codes, countryName);
            }

        }
        return repository;
    }
}
