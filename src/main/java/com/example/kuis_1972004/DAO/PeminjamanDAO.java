package com.example.kuis_1972004.DAO;

import com.example.kuis_1972004.Model.PeminjamanEntity;
import com.example.kuis_1972004.Util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class PeminjamanDAO implements daoInterface<PeminjamanEntity>{
    @Override
    public int addData(PeminjamanEntity data) {
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();
        s.save(data);
        t.commit();
        s.close();
        return 0;
    }

    @Override
    public int delData(PeminjamanEntity data) {
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();
        s.delete(data);
        t.commit();
        s.close();
        return 0;
    }

    @Override
    public int updateData(PeminjamanEntity data) {
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();
        s.update(data);
        t.commit();
        s.close();
        return 0;
    }

    @Override
    public ObservableList<PeminjamanEntity> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(PeminjamanEntity.class);

        query.from(PeminjamanEntity.class);

        List<PeminjamanEntity> plist = s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(plist);
    }
}
