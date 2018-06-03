package com.currency.convert.repository;

import java.util.List;

import com.currency.convert.model.Queries;

public interface QueriesCustomRepository {

	List<Queries> listQueries(String username);

}
