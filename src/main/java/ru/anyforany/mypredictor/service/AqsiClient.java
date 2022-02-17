package ru.anyforany.mypredictor.service;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import ru.anyforany.mypredictor.entity.RecieptDto;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class AqsiClient {

    private String beginDate;
    private String endDate;

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<RecieptDto> getResponse() {

        List<RecieptDto> result = new ArrayList<>();
        result.add(new RecieptDto("Сэндвич чикен-карри", 0,0,0));
        result.add(new RecieptDto("Сэндвич Италия", 0,0,0));
        result.add(new RecieptDto("Сэндвич Англия", 0,0,0));
        result.add(new RecieptDto("Боул с лососем", 0,0,0));
        result.add(new RecieptDto("Боул с тофу", 0,0,0));
        result.add(new RecieptDto("Салат Тосканский", 0,0,0));
        result.add(new RecieptDto("Капрезе", 0,0,0));
        result.add(new RecieptDto("Круассан с лососем", 0,0,0));
        result.add(new RecieptDto("Круассан с моцареллой", 0,0,0));
        result.add(new RecieptDto("Круассан с курицей", 0,0,0));
        result.add(new RecieptDto("Тыквенный крем суп", 0,0,0));
        result.add(new RecieptDto("Крем суп из брокколи", 0,0,0));
        result.add(new RecieptDto("Крем суп из батата", 0,0,0));
        result.add(new RecieptDto("Банановый пудинг", 0,0,0));
        result.add(new RecieptDto("Сырники", 0,0,0));
        result.add(new RecieptDto("Кекс банановый", 0,0,0));
        result.add(new RecieptDto("Кекс банановый ВЕГАНСКИЙ", 0,0,0));
        result.add(new RecieptDto("Кекс", 0,0,0));
        result.add(new RecieptDto("Морковный кекс", 0,0,0));
        result.add(new RecieptDto("Чиабатта блю чиз", 0,0,0));
        result.add(new RecieptDto("Чиабатта курица и бекон", 0,0,0));
        result.add(new RecieptDto("Чиабатта с ветчиной и сыром", 0,0,0));
        result.add(new RecieptDto("Канеле", 0,0,0));
        result.add(new RecieptDto("Канеле+фильтр", 0,0,0));
        result.add(new RecieptDto("Бискотти", 0,0,0));
        result.add(new RecieptDto("Печенье с шоколадом", 0,0,0));

        StringBuilder content = new StringBuilder();

        long pages = 0;

        try {
            final URL url = new URL("https://api.aqsi.ru/pub/v2/Receipts?filtered.BeginDate="+ beginDate +"&filtered.EndDate=" + endDate);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setDoOutput(true);
            con.setUseCaches(false);

            con.addRequestProperty("x-client-key", "Application khP44F88GLRn3brs2tT5cIj8x03jGxWe9WNXj8z89h3oKMWgp5t7FfY666SBzEcy");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            Object obj = new JSONParser().parse(content.toString());

            JSONObject jsonObject = (JSONObject) obj;
            pages = (long) jsonObject.get("pages");

            con.disconnect();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < pages; i++) {
            StringBuilder contentP = new StringBuilder();
            try {
                final URL url2 = new URL("https://api.aqsi.ru/pub/v2/Receipts?filtered.BeginDate="+ beginDate +"&filtered.EndDate="+ endDate +"&page=" + i);
                HttpsURLConnection con2 = (HttpsURLConnection) url2.openConnection();
                con2.setDoOutput(true);
                con2.setUseCaches(false);

                con2.addRequestProperty("x-client-key", "Application khP44F88GLRn3brs2tT5cIj8x03jGxWe9WNXj8z89h3oKMWgp5t7FfY666SBzEcy");

                BufferedReader in2 = new BufferedReader(new InputStreamReader(con2.getInputStream()));
                String inputLine2;

                while ((inputLine2 = in2.readLine()) != null) {
                    contentP.append(inputLine2);
                }
                Object obj2 = new JSONParser().parse(contentP.toString());
                JSONObject jObj = (JSONObject) obj2;
                JSONArray rows = (JSONArray) jObj.get("rows");

                for (RecieptDto check : result) {

                    String coffeeShop;

                    Iterator iterator = rows.iterator();
                    while (iterator.hasNext()) {
                        JSONObject reciep = (JSONObject) iterator.next();
                        coffeeShop = reciep.get("calculationPlace").toString();

                        JSONObject reciepContent = (JSONObject) reciep.get("content");
                        JSONArray positions = (JSONArray) reciepContent.get("positions");
                        Iterator posIterator = positions.iterator();
                        while (posIterator.hasNext()) {
                            JSONObject position = (JSONObject) posIterator.next();
                            String dishName = position.get("text").toString();
                            if (dishName.equals(check.getDish_name()) && coffeeShop.equals("Кофейня Тираж")) {
                                check.setTirage_amount(check.getTirage_amount() + (int) Double.parseDouble(position.get("quantity").toString()));
                            } else if (dishName.equals(check.getDish_name()) && coffeeShop.equals("кафе Наутилус")) {
                                check.setNaut_amount(check.getNaut_amount() + (int) Double.parseDouble(position.get("quantity").toString()));
                            } else if (dishName.equals(check.getDish_name()) && coffeeShop.equals("3 этаж, кофейня")) {
                                check.setHh_amount(check.getHh_amount() + (int) Double.parseDouble(position.get("quantity").toString()));
                            }
                        }
                    }
                }
                con2.disconnect();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException exception) {
                exception.printStackTrace();
            }
        }
        return result;
    }
}
