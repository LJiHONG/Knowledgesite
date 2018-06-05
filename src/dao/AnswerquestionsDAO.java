package dao;
// default package

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javabean.Answerquestions;

/**
 	* A data access object (DAO) providing persistence and search support for Answerquestions entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Answerquestions
  * @author MyEclipse Persistence Tools 
 */
public class AnswerquestionsDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AnswerquestionsDAO.class);
	

    
    public void save(Answerquestions transientInstance) {
        log.debug("saving Answerquestions instance");
        Transaction tran=getSession().beginTransaction();
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
        tran.commit();
 		getSession().close();
    }
    
	public void delete(Answerquestions persistentInstance) {
        log.debug("deleting Answerquestions instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Answerquestions findById( java.lang.Integer id) {
        log.debug("getting Answerquestions instance with id: " + id);
        Transaction tran=getSession().beginTransaction();
        try {
            Answerquestions instance = (Answerquestions) getSession()
                    .get("javabean.Answerquestions", id);
            tran.commit();
     		getSession().close();
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Answerquestions instance) {
        log.debug("finding Answerquestions instance by example");
        try {
            List results = getSession()
                    .createCriteria("Answerquestions")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Answerquestions instance with property: " + propertyName
            + ", value: " + value);
      Transaction tran=getSession().beginTransaction();
      try {
         String queryString = "from Answerquestions as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 List lt=queryObject.list();
		 tran.commit();
	 	 getSession().close();
		 return lt;
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all Answerquestions instances");
		Transaction tran=getSession().beginTransaction();
		try {
			String queryString = "from Answerquestions";
	         Query queryObject = getSession().createQuery(queryString);
	         List lt=queryObject.list();
			 tran.commit();
		 	 getSession().close();
			 return lt;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Answerquestions merge(Answerquestions detachedInstance) {
        log.debug("merging Answerquestions instance");
        try {
            Answerquestions result = (Answerquestions) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Answerquestions instance) {
        log.debug("attaching dirty Answerquestions instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Answerquestions instance) {
        log.debug("attaching clean Answerquestions instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}