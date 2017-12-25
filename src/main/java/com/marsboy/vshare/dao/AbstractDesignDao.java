package com.marsboy.vshare.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AbstractDesignDao <E, I extends Serializable> {
	I save(E e);

	void saveOrupdate(E e);

	void saveMerge(E e);

	void delete(E e);

	E get(I i);

	List<E> find(Query qry);

	void saveAll(List<E> e);

	void saveOrupdateAll(List<E> e);
}
