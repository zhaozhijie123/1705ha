package com.bw.service;

import java.util.List;
import java.util.Map;

import com.bw.entity.Movie;
import com.bw.entity.Type;

public interface MovieService {

	List<Movie> findAll(Map<String, Object> map);

	int deleteAll(String ids);

	List<Type> findType();

	int add(Movie movie);

	Movie queryById(Integer mid);

	int update(Movie movie);

}
