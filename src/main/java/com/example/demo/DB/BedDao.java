package com.example.demo.DB;
import com.example.demo.models.Bed;
import com.example.demo.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BedDao {
    public static Long saveBed(Bed bed) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            Long bedId = (Long) session.save(bed);
            transaction.commit();
            return bedId;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return null;
    }
}
