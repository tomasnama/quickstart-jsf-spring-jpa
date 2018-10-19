package com.tomasnama.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.jpa.domain.Specification;

import com.tomasnama.entities.Employee;

public class FilterEmployees implements Specification<Employee> {

	private static final Logger LOG = LogManager.getLogger(FilterEmployees.class);

	public FilterEmployees(Map<String, Object> filter) {
		super();
		this.filter = filter;
	}

	Map<String, Object> filter;

	@Override
	public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

		List<Predicate> predicates = new ArrayList<Predicate>();
		Iterator<Map.Entry<String, Object>> itCriteria = filter.entrySet().iterator();

		while (itCriteria.hasNext()) {
			Map.Entry<String, Object> criteria = itCriteria.next();
			if (("id".equals(criteria.getKey())  || "salary".equals(criteria.getKey()) && criteria.getValue() != null)) {
				predicates.add(builder.equal(root.get(criteria.getKey()), criteria.getValue()));
				
			} else if ((criteria.getValue() != null)) {
				StringBuilder criteriaBuilder = new StringBuilder();
				criteriaBuilder.append("%").append(criteria.getValue().toString().toLowerCase()).append("%");
				predicates.add(
						builder.like(builder.lower(root.<String>get(criteria.getKey())), criteriaBuilder.toString()));
			}

		}

		return builder.and(predicates.toArray(new Predicate[predicates.size()]));
	}

}
