package com.currency.convert.repository.impls;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.currency.convert.model.Queries;
import com.currency.convert.repository.QueriesCustomRepository;

/**
 * @author yeshendra Repository Impl for Queries
 *
 */
@Repository
public class QueriesRepositoryImpl implements QueriesCustomRepository {

	@PersistenceContext
	private EntityManager em;

	private static final Logger logger = LoggerFactory.getLogger(QueriesRepositoryImpl.class);

	@Override
	public List<Queries> listQueries(String username) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Queries> criteriaQuery = builder.createQuery(Queries.class);
		Root<Queries> root = criteriaQuery.from(Queries.class);

		criteriaQuery.select(root).where(builder.and(builder.equal(root.get("queryUsername"), username)));
		criteriaQuery.orderBy(builder.desc(root.get("queriedDate")));
		logger.info("Querying for last 10 queries made by user ");
		return em.createQuery(criteriaQuery).setMaxResults(10).getResultList();
	}

}
