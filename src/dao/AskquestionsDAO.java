package dao;
// default package

import javabean.Askquestions;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Askquestions entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Askquestions
  * @author MyEclipse Persistence Tools 
 */
public class AskquestionsDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(AskquestionsDAO.class);
	

    
    public void save(Askquestions transientInstance) {
        log.debug("saving Askquestions instance");
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
    
	public void delete(Askquestions persistentInstance) {
        log.debug("deleting Askquestions instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Askquestions findById( java.lang.Integer id) {
        log.debug("getting Askquestions instance with id: " + id);
        Transaction tran=getSession().beginTransaction();
        try {
            Askquestions instance = (Askquestions) getSession()
                    .get("javabean.Askquestions", id);
            tran.commit();
     		getSession().close();
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Askquestions instance) {
        log.debug("finding Askquestions instance by example");
        try {
            List results = getSession()
                    .createCriteria("Askquestions")
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
      log.debug("finding Askquestions instance with property: " + propertyName
            + ", value: " + value);
      Transaction tran=getSession().beginTransaction();
      try {
         String queryString = "from Askquestions as model where model." 
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
		log.debug("finding all Askquestions instances");
		Transaction tran=getSession().beginTransaction();
		try {
			String queryString = "from Askquestions";
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
	
    public Askquestions merge(Askquestions detachedInstance) {
        log.debug("merging Askquestions instance");
        try {
            Askquestions result = (Askquestions) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Askquestions instance) {
        log.debug("attaching dirty Askquestions instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Askquestions instance) {
        log.debug("attaching clean Askquestions instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}