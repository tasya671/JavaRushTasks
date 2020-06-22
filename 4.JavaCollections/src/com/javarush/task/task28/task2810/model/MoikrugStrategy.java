package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {

    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        try {
            int page = 0;
            while (true) {
                Document document = getDocument(searchString, page++);
                Elements elements = document.getElementsByClass("job");
                if (elements.size() == 0) break;
                for (Element e : elements) {
                    Vacancy vacancy = new Vacancy();
                    vacancy.setTitle(e.getElementsByClass("title").first().text());
                    vacancy.setUrl("https://moikrug.ru" + e.select("a[class=job_icon]").attr("href"));
                    vacancy.setSalary(e.getElementsByClass("salary").first().text());
                    vacancy.setSiteName(URL_FORMAT);
                    vacancy.setCompanyName(e.getElementsByClass("company_name").text());
                    String city = e.getElementsByClass("location").text();
                    vacancy.setCity(city == null ? " " : city);

//                Elements elements = document.getElementsByClass("vacancy-card");
//                if(elements.size() == 0) break;
//                for (Element e : elements) {
//                    Vacancy vacancy = new Vacancy();
//                    vacancy.setTitle(e.getElementsByClass("vacancy-card__title").first().text());
//                    vacancy.setUrl(e.getElementsByTag("a").first().absUrl("href"));
//                    vacancy.setSalary(e.getElementsByClass("vacancy-card__salary").first().text());
//                    vacancy.setCity(URL_FORMAT);
//
//                    Elements meta = e.getElementsByClass("vacancy-card__meta").first().getElementsByTag("a");
//                    if (meta.size() >= 2) {
//                        vacancy.setCompanyName(meta.first().text());
//                        vacancy.setCity(meta.get(1).text());
//                    } else {
//                        vacancy.setCompanyName(meta.first().text());
//                        vacancy.setCity("unknown");
//                    }

                    vacancies.add(vacancy);
                }
            }
        } catch (IOException e) { e.printStackTrace(); }
        return vacancies;
    }


    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page)).
                userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4128.3 Safari/537.36")
                .referrer("no-referrer-when-downgrade").get();
    }
}
