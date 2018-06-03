package com.currency.convert.repository.impls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.currency.convert.model.Queries;
import com.currency.convert.repository.QueriesCustomRepository;

@Repository
public class QueriesRepositoryImpl implements QueriesCustomRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Queries> listQueries(String username) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Queries> criteriaQuery = builder.createQuery(Queries.class);
		Root<Queries> root = criteriaQuery.from(Queries.class);

		criteriaQuery.select(root).where(builder.and(builder.equal(root.get("queryUsername"), username)));
		criteriaQuery.orderBy(builder.desc(root.get("queriedDate")));

		return em.createQuery(criteriaQuery).setMaxResults(10).getResultList();
	}

}
