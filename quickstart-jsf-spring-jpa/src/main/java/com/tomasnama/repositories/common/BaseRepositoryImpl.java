package com.tomasnama.repositories.common;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class BaseRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID> {
	

	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
	}

	public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);
	}
	
	@Override
	public Page<T> findAll(Specification<T> spec, Pageable pageable) {
		 TypedQuery<T> query = getQuery(spec, pageable);
		    query.setFirstResult((int) pageable.getOffset());
		    query.setMaxResults(pageable.getPageSize());
		    Page<T> page = new PageImpl<>(query.getResultList());
		    return page;
	}

}
