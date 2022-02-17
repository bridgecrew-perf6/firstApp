package ru.anyforany.mypredictor.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.anyforany.mypredictor.entity.RecieptDto;
import ru.anyforany.mypredictor.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class ReciepDao {

    public RecieptDto findById(int id) {
        return (RecieptDto) HibernateSessionFactoryUtil.getSessionFactory().openSession().get(RecieptDto.class, id);
    }

    public void save(RecieptDto reciep) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(reciep);
        tx1.commit();
        session.close();
    }

    public void saveRecieps(List<RecieptDto> list) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        for (RecieptDto reciep : list) {
            session.save(reciep);
            if (!tx1.isActive()) {
                tx1.commit();
            }
        }
        session.close();
    }

//    public void update(RecieptDto reciep) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        session.update(reciep);
//        tx1.commit();
//        session.close();
//    }

    public void delete(RecieptDto reciep) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(reciep);
        tx1.commit();
        session.close();
    }


    public List<RecieptDto> findAll() {
        List<RecieptDto> recieps = (List<RecieptDto>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From RecieptDto").list();
        return recieps;
    }

    public List<RecieptDto> findByTime(long since, long till) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("SELECT r FROM RecieptDto r WHERE r.create_time >=: since AND r.create_time <=: till")
                .setParameter("till", till).setParameter("since", since).list();
    }
}
