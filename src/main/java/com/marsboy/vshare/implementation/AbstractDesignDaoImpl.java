package com.marsboy.vshare.implementation;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;

import com.marsboy.vshare.dao.AbstractDesignDao;

public class AbstractDesignDaoImpl<E, I extends Serializable> implements AbstractDesignDao<E, I> {

	private Class<E> entityClass;

	public AbstractDesignDaoImpl(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public I save(E e) {
		I id = (I) getCurrentSession().save(e);
		return id;
	}

	public void saveOrupdate(E e) {
		getCurrentSession().saveOrUpdate(e);
	}

	public void saveMerge(E e) {
		getCurrentSession().merge(e);
	}

	public void delete(E e) {
		getCurrentSession().delete(e);
	}

	public E get(I i) {
		return (E) getCurrentSession().get(entityClass, i);
	}

	@SuppressWarnings("unchecked")
	public List<E> find(Query qry) {
		return qry.list();
	}

	@SuppressWarnings("unchecked")
	public List<E> excuteQuery(Query qry, Class<E> bindResult) {

		return qry.setResultTransformer(new AliasToBeanResultTransformer(bindResult)).list();
	}

	public void saveAll(List<E> e) {
		for (E e2 : e) {
			getCurrentSession().save(e2);
		}
	}

	public void saveOrupdateAll(List<E> e) {
		for (E e2 : e) {
			getCurrentSession().merge(e2);
		}
	}

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

}
