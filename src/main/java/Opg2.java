import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.Persistence;

public class Opg2{

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

            System.out.println("Kontoer over 100kr:");
        int i = 1;
        Konto konto = null;
        while (true) {
            konto = entityManager.find(Konto.class, i);
            if (konto == null) break;
            if (konto.getSaldo() > 100) {
                System.out.println("Ilern? : " + konto.getName());
            }
            i++;
        }



        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();

        entityManagerFactory.close();


    }
}
