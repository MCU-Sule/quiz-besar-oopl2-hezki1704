package com.example.kuis_1972004.DAO;

import com.example.kuis_1972004.Model.BukuEntity;
import com.example.kuis_1972004.Util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class BukuDAO implements daoInterface<BukuEntity>{
    @Override
    public int addData(BukuEntity data) {
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();
        s.save(data);
        t.commit();
        s.close();
        return 0;
    }

    @Override
    public int delData(BukuEntity data) {
        return 0;
    }

    @Override
    public int updateData(BukuEntity data) {
        return 0;
    }

    @Override
    public ObservableList<BukuEntity> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(BukuEntity.class);

        query.from(BukuEntity.class);

        List<BukuEntity> blist = s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(blist);
    }
}
