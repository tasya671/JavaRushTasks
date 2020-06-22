package com.javarush.task.task28.task2810.view;

import com.javarush.task.task28.task2810.Controller;
import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HtmlView implements View{

    private Controller controller;
    private final String filePath = "./4.JavaCollections/src/" + this.getClass().getPackage().getName().replace('.', '/') + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            String content = getUpdatedFileContent(vacancies);
            updateFile(content);

        } catch (Exception e) { e.printStackTrace(); }
    }

    private String getUpdatedFileContent(List<Vacancy> list)  {
        try {
        Document document = getDocument();
        Element element = document.getElementsByClass("template").first();
        Element template = element.clone();
        template.removeAttr("style");
        template.removeClass("template");
        document.getElementsByAttributeValueEnding("class", "vacancy").remove();
        for (Vacancy vac : list) {
            Element temp = template.clone();
            temp.getElementsByClass("city").first().text(vac.getCity());
            temp.getElementsByClass("companyName").first().text(vac.getCompanyName());
            temp.getElementsByClass("salary").first().text(vac.getSalary());
            temp.getElementsByTag("a").first().attr("href", vac.getUrl()).text(vac.getTitle());

            element.before(temp.outerHtml());
        }
        return document.html();
        } catch (IOException e) {
            e.printStackTrace();
            return "Some exception occurred";
        }
    }

    private void updateFile(String list) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write(list);
        writer.flush();
        writer.close();
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Odessa");
    }

    protected  Document getDocument() throws IOException{
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
