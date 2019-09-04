package com.bw.mapper;

import java.util.List;
import java.util.Map;

import com.bw.entity.Movie;
import com.bw.entity.Type;

public interface MovieDao {

	List<Movie> findAll(Map<String, Object> map);

	int deleteAll(String ids);

	void deleteMovieType(String ids);

	List<Type> findType();

	void addMovie(Movie movie);

	void addMovieType(Map<String, Object> map);

	Movie queryById(Integer mid);

	void updateMovie(Movie movie);

	void deleteMovieTy(Integer mid);

}
