package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {

    private static final String URL_FORMAT = "http://hh.ru/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        Document document;
        int page_number = 0;
        try {
            while (true) {
                document = getDocument(searchString, page_number++);
                Elements elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
                if (elements.size()== 0) break;
                for (Element e : elements) {
                        Vacancy vacancy = new Vacancy();
                        vacancy.setSiteName(URL_FORMAT);
                        vacancy.setTitle(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
                        vacancy.setCity(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
                        vacancy.setCompanyName(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text().trim());
                        String salary = e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text();
                        vacancy.setSalary(salary.length() == 0 ? "" : salary);
                        vacancy.setUrl(e.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));

                        vacancies.add(vacancy);
                    }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        return Jsoup.connect(String.format(URL_FORMAT, searchString, page)).
                userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4128.3 Safari/537.36")
                .referrer("no-referrer-when-downgrade").get();
    }
}
