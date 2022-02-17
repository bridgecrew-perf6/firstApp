package ru.anyforany.mypredictor.service;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.anyforany.mypredictor.dao.ReciepDao;
import ru.anyforany.mypredictor.entity.RecieptDto;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class QRClient {

//    ReciepDao dao = new ReciepDao();
//
//    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
//
//    @EventListener(ApplicationReadyEvent.class)
//    public void runAfterStartup() {
//
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//
//                List<List<Long>> allIn = new ArrayList<>(4);
//
//                Date dateInTimer = new Date();
//                long sinceTimer = dateInTimer.getTime() - 21600000;
//                long tillTimer = dateInTimer.getTime();
//
//                String userpass = "nh780:jXb9Z5R7";
//                String basicAuth = "Basic " + new String(Base64.getEncoder().encode(userpass.getBytes()));
//                String payload = "{\"filters\": [{\"field\": \"createDate\", \"operation\": \"range\", \"value\": {\"since\":" + sinceTimer + ", \"till\":" + tillTimer + "}}]}";
//
//                try {
//                    List<Long> idChB1 = new ArrayList<>();
//                    List<Long> idChB2 = new ArrayList<>();
//                    List<Long> idChHPE = new ArrayList<>();
//                    List<Long> idChNRD = new ArrayList<>();
//
//                    final URL url = new URL("https://nh780.quickresto.ru/platform/online/api/list?moduleName=front.orders");
//
//                    HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
//
//                    con.setDoOutput(true);
//                    con.setUseCaches(false);
//
//                    con.setRequestProperty("Authorization", basicAuth);
//                    con.setRequestProperty("Content-Type", "application/json");
//
//                    OutputStream os = con.getOutputStream();
//                    os.write(payload.getBytes(StandardCharsets.UTF_8));
//                    os.flush();
//                    os.close();
//
//
//                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//                    String inputLine;
//                    StringBuilder content = new StringBuilder();
//
//                    while ((inputLine = in.readLine()) != null) {
//                        content.append(inputLine);
//                    }
//                    try {
//                        Object obj = new JSONParser().parse(String.valueOf(content));
//                        JSONArray jArray = (JSONArray) obj;
//                        Iterator jArrayItr = jArray.iterator();
//                        while (jArrayItr.hasNext()) {
//                            JSONObject jObj = (JSONObject) jArrayItr.next();
//
//                            JSONObject test = (JSONObject) jObj.get("createTerminalSalePlace");
//                            String place = (String) test.get("title");
//                            switch (place) {
//                                case "Б1":
//                                    idChB1.add((long) jObj.get("id"));
//                                    break;
//                                case "Б2":
//                                    idChB2.add((long) jObj.get("id"));
//                                    break;
//                                case "HPE":
//                                    idChHPE.add((long) jObj.get("id"));
//                                    break;
//                                case "НРД":
//                                    idChNRD.add((long) jObj.get("id"));
//                                    break;
//                            }
//                        }
//                        allIn.add(idChB1);
//                        allIn.add(idChB2);
//                        allIn.add(idChNRD);
//                        allIn.add(idChHPE);
//                    } catch (ParseException exception) {
//                        System.out.println("нет чека");
//                    }
//                } catch (IOException ex) {
//                    System.out.println("Ошибка соединения! Сервер не доступен");
//                }
//
//                List<RecieptDto> result = new ArrayList<>();
//                result.add(new RecieptDto(0,"Сэндвич чикен-карри", 0, 0, 0, 0));
//                result.add(new RecieptDto(0, "Сэндвич Италия", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Сэндвич Англия", 0, 0, 0, 0));
//                result.add(new RecieptDto(0, "Боул с лососем", 0, 0, 0, 0));
//                result.add(new RecieptDto(0, "Боул с тофу", 0, 0, 0, 0));
//                result.add(new RecieptDto(0, "Салат Тосканский", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Капрезе", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Круассан с лососем", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Круассан с моцареллой", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Круассан с курицей", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Тыквенный крем суп", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Крем суп из брокколи", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Крем суп из батата", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Банановый пудинг", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Сырники", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Кекс банановый", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Кекс банановый ВЕГАНСКИЙ", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Кекс", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Морковный кекс", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Чиабатта блю чиз", 0, 0, 0, 0));
//                result.add(new RecieptDto(0, "Чиабатта курица и бекон", 0, 0, 0, 0));
//                result.add(new RecieptDto(0, "Чиабатта с ветчиной и сыром", 0, 0, 0, 0));
//                result.add(new RecieptDto(0, "Канеле", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Канеле+фильтр", 0, 0, 0, 0));
//                result.add(new RecieptDto(0, "Бискотти", 0, 0, 0, 0));
//                result.add(new RecieptDto(0,"Печенье с шоколадом", 0, 0, 0, 0));
//
//
//              int index = 0;
//
//              for (List<Long> checks : allIn) {
//                  for (int j = 0; j < checks.size(); j++) {
//                    try {
//                      final URL url2 = new URL("https://nh780.quickresto.ru/platform/online/api/read?moduleName=front.orders&objectId=" + checks.get(j));
//                      HttpsURLConnection con2 = (HttpsURLConnection) url2.openConnection();
//                      con2.setRequestProperty("Authorization", basicAuth);
//                      con2.setRequestProperty("Content-Type", "application/json");
//
//                      BufferedReader in2 = new BufferedReader(new InputStreamReader(con2.getInputStream()));
//                      String inputLine2;
//                      StringBuilder content2 = new StringBuilder();
//                      while ((inputLine2 = in2.readLine()) != null) {
//                        content2.append(inputLine2);
//                      }
//                      try {
//                        Object obj2 = new JSONParser().parse(String.valueOf(content2));
//                        JSONObject test2 = (JSONObject) obj2;
//                        String createTime = (String) test2.get("createDate");
//                        Date dateTime = df.parse(createTime);
//                        String createTimeMill = "" + (dateTime.getTime() + 10800000);
//                        JSONArray orderItems = (JSONArray) test2.get("orderItemList");
//                        Iterator itemsItr = orderItems.iterator();
//                        while (itemsItr.hasNext()) {
//                          JSONObject dish = (JSONObject) itemsItr.next();
//                          for (RecieptDto reciep : result) {
//                            if (reciep.getDish_name().equals(dish.get("name")) && index == 0) {
//                              reciep.setCreate_time(Long.parseLong(createTimeMill));
//                              reciep.setB1_amount(reciep.getB1_amount() + (int) Double.parseDouble(dish.get("amount").toString()));
//                            } else if (reciep.getDish_name().equals(dish.get("name")) && index == 1) {
//                              reciep.setCreate_time(Long.parseLong(createTimeMill));
//                              reciep.setB2_amount(reciep.getB2_amount() + (int) Double.parseDouble(dish.get("amount").toString()));
//                            } else if (reciep.getDish_name().equals(dish.get("name")) && index == 2) {
//                              reciep.setCreate_time(Long.parseLong(createTimeMill));
//                              reciep.setNrd_amount(reciep.getNrd_amount() + (int) Double.parseDouble(dish.get("amount").toString()));
//                            } else if (reciep.getDish_name().equals(dish.get("name")) && index == 3) {
//                              reciep.setCreate_time(Long.parseLong(createTimeMill));
//                              reciep.setHpe_amount(reciep.getHpe_amount() + (int) Double.parseDouble(dish.get("amount").toString()));
//                            } else {
//                              reciep.setCreate_time(Long.parseLong(createTimeMill));
//                            }
//                          }
//                        }
//                      } catch (ParseException ex) {
//                        System.out.println("Ошибка парсинга списка продаж");
//                      } catch (java.text.ParseException e) {
//                        e.printStackTrace();
//                      }
//                    } catch (IOException ex) {
//                      System.out.println("Нет соединения! Сервер сломался");
//                    }
//                  }
//                index++;
//              }
//              dao.saveRecieps(result);
//            }
//        }, new Date(), 21600000);
//    }
}

