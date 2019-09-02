package hibernate_demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    public void printAllStudents(){
        List<Student> list = new ArrayList<>();
        SessionFactory factory = HibernateUtil.getSessionFactory();
        try (Session session = factory.openSession()) {

            // Narzędzie do kreowania zapytania, do tworzenia query i budowania klauzuli 'where'
            CriteriaBuilder cb = session.getCriteriaBuilder();

            // Obiekt reprezentujący zapytanie o <typ generyczny>
            CriteriaQuery<Student> criteriaQuery = cb.createQuery(Student.class);

            // reprezentuje tabelę 'Student' i tworzymy tą instancję żeby owiedzieć
            // "do jakiej tabeli chcemy wykonać zapytanie"
            Root<Student> rootTable = criteriaQuery.from(Student.class);

            // wykonanie select'a z tabeli
            criteriaQuery.select(rootTable);

            // wywołujemy zapytanie, wyniki zbieramy do listy
            list.addAll(session.createQuery(criteriaQuery).list());

        }catch (HibernateException e){
            e.printStackTrace();
        }
    }



//  public void saveOrUpdate(Student studentEntity){
//      SessionFactory factory = HibernateUtil.getSessionFactory();
//      Transaction transaction = null;
//      try (Session session = factory.openSession()){
//          transaction = session.beginTransaction();

//          session.saveOrUpdate(studentEntity);


//          transaction.commit();
//      }catch (HibernateException he){
//          if (transaction != null){
//              transaction.rollback();
//          }
//      }
//  }



}

