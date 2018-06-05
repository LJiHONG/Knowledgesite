package dao;
// default package

import javabean.Integralrecord;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Integralrecord entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Integralrecord
  * @author MyEclipse Persistence Tools 
 */
public class IntegralrecordDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(IntegralrecordDAO.class);
	

    
    public void save(Integralrecord transientInstance) {
        log.debug("saving Integralrecord instance");
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
    
	public void delete(Integralrecord persistentInstance) {
        log.debug("deleting Integralrecord instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Integralrecord findById( java.lang.Integer id) {
        log.debug("getting Integralrecord instance with id: " + id);
        Transaction tran=getSession().beginTransaction();
        try {
            Integralrecord instance = (Integralrecord) getSession()
                    .get("javabean.Integralrecord", id);
            tran.commit();
     		getSession().close();
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Integralrecord instance) {
        log.debug("finding Integralrecord instance by example");
        try {
            List results = getSession()
                    .createCriteria("Integralrecord")
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
      log.debug("finding Integralrecord instance with property: " + propertyName
            + ", value: " + value);
      Transaction tran=getSession().beginTransaction();
      try {
         String queryString = "from Integralrecord as model where model." 
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
		log.debug("finding all Integralrecord instances");
		Transaction tran=getSession().beginTransaction();
		try {
			String queryString = "from Integralrecord";
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
	
    public Integralrecord merge(Integralrecord detachedInstance) {
        log.debug("merging Integralrecord instance");
        try {
            Integralrecord result = (Integralrecord) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Integralrecord instance) {
        log.debug("attaching dirty Integralrecord instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Integralrecord instance) {
        log.debug("attaching clean Integralrecord instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}