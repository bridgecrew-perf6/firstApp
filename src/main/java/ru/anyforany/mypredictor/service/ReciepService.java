package ru.anyforany.mypredictor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.anyforany.mypredictor.dao.ReciepDao;
import ru.anyforany.mypredictor.entity.RecieptDto;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReciepService {

  private long beginDate;
  private long endDate;

  public long getBeginDate() {
    return beginDate;
  }

  public void setBeginDate(long beginDate) {
    this.beginDate = beginDate;
  }

  public long getEndDate() {
    return endDate;
  }

  public void setEndDate(long endDate) {
    this.endDate = endDate;
  }

  ReciepDao reciepDao = new ReciepDao();

  @Autowired
  private AqsiClient aqsiClient;


  public List<RecieptDto> getAqsiSales() {
    return aqsiClient.getResponse();
  }


  public RecieptDto findReciep(int id) {
    return reciepDao.findById(id);
  }

  public void saveRecieps(List<RecieptDto> recieps) {
    reciepDao.saveRecieps(recieps);
  }

  public void deleteReciep(RecieptDto reciep) {
    reciepDao.delete(reciep);
  }

//    public void updateReciep(RecieptDto reciep) {
//        reciepDao.update(reciep);
//    }

  public List<RecieptDto> findAllRecieps() {
    return reciepDao.findAll();
  }

  public List<RecieptDto> findReciepsByTime() {
    List<RecieptDto> intro = reciepDao.findByTime(beginDate, endDate);

    return intro.stream()
      .collect(Collectors.collectingAndThen(
        Collectors.toMap(RecieptDto::getDish_name,
          recieptDto -> new RecieptDto(recieptDto.getCreate_time(),recieptDto.getDish_name(), recieptDto.getB1_amount(), recieptDto.getB2_amount(), recieptDto.getNrd_amount(), recieptDto.getHpe_amount()),
          (a, b) -> {
            a.setB1_amount(a.getB1_amount() + b.getB1_amount());
            a.setB2_amount(a.getB2_amount() + b.getB2_amount());
            a.setNrd_amount(a.getNrd_amount() + b.getNrd_amount());
            a.setHpe_amount(a.getHpe_amount() + b.getHpe_amount());
            return a;
          }, LinkedHashMap::new),
        m -> new ArrayList<>(m.values())));
  }
}

