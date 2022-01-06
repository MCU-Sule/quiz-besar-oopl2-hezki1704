package com.example.kuis_1972004.DAO;

import com.example.kuis_1972004.Model.AnggotaEntity;
import com.example.kuis_1972004.Util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AnggotaDAO implements daoInterface<AnggotaEntity>{
    @Override
    public int addData(AnggotaEntity data) {
        Session s = HibernateUtil.getSession();
        Transaction t = s.beginTransaction();
        s.save(data);
        t.commit();
        s.close();
        return 0;
    }

    @Override
    public int delData(AnggotaEntity data) {
        return 0;
    }

    @Override
    public int updateData(AnggotaEntity data) {
        return 0;
    }

    @Override
    public ObservableList<AnggotaEntity> showData() {
        Session s = HibernateUtil.getSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(AnggotaEntity.class);

        query.from(AnggotaEntity.class);

        List<AnggotaEntity> alist = s.createQuery(query).getResultList();
        s.close();

        return FXCollections.observableArrayList(alist);
    }
}
