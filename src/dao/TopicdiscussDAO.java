package dao;
// default package

import javabean.Topicdiscuss;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 	* A data access object (DAO) providing persistence and search support for Topicdiscuss entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Topicdiscuss
  * @author MyEclipse Persistence Tools 
 */
public class TopicdiscussDAO extends BaseHibernateDAO  {
	     private static final Logger log = LoggerFactory.getLogger(TopicdiscussDAO.class);
	

    
    public void save(Topicdiscuss transientInstance) {
        log.debug("saving Topicdiscuss instance");
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
    
	public void delete(Topicdiscuss persistentInstance) {
        log.debug("deleting Topicdiscuss instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Topicdiscuss findById( java.lang.Integer id) {
        log.debug("getting Topicdiscuss instance with id: " + id);
        Transaction tran=getSession().beginTransaction();
        try {
            Topicdiscuss instance = (Topicdiscuss) getSession()
                    .get("javabean.Topicdiscuss", id);
            tran.commit();
     		getSession().close();
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Topicdiscuss instance) {
        log.debug("finding Topicdiscuss instance by example");
        try {
            List results = getSession()
                    .createCriteria("Topicdiscuss")
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
      log.debug("finding Topicdiscuss instance with property: " + propertyName
            + ", value: " + value);
      Transaction tran=getSession().beginTransaction();
      try {
         String queryString = "from Topicdiscuss as model where model." 
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
		log.debug("finding all Topicdiscuss instances");
		Transaction tran=getSession().beginTransaction();
		try {
			String queryString = "from Topicdiscuss";
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
	
    public Topicdiscuss merge(Topicdiscuss detachedInstance) {
        log.debug("merging Topicdiscuss instance");
        try {
            Topicdiscuss result = (Topicdiscuss) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Topicdiscuss instance) {
        log.debug("attaching dirty Topicdiscuss instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Topicdiscuss instance) {
        log.debug("attaching clean Topicdiscuss instance");
        try {
                      	getSession().buildLockRequest(LockOptions.NONE).lock(instance);
          	            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}