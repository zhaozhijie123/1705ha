package com.bw.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bw.entity.Movie;
import com.bw.entity.Type;
import com.bw.mapper.MovieDao;

@Service
public class MovieServiceImpl implements MovieService {

	@Resource
	private MovieDao dao;
	
	public List<Movie> findAll(Map<String, Object> map) {
		return dao.findAll(map);
	}

	public int deleteAll(String ids) {
		dao.deleteMovieType(ids);
		return dao.deleteAll(ids);
	}

	public List<Type> findType() {
		return dao.findType();
	}

	public int add(Movie movie) {
		Map<String, Object> map = new HashMap<String, Object>();
		if(movie.getMname()==null || movie.getMname().equals("")){
			return 1;
		}else if(movie.getAuthor()==null || movie.getAuthor().equals("")){
			return 2;
		}else if(movie.getIntroduction()==null || movie.getIntroduction().equals("")){
			return 3;
		}else if(movie.getMdate()==null || movie.getMdate().equals("")){
			return 4;
		}else if(movie.getTids()==null || movie.getTids().equals("")){
			return 5;
		}
		dao.addMovie(movie);
		String[] tids = movie.getTids().split(",");
		for (String tid : tids) {
			map.put("tid", tid);
			map.put("mid", movie.getMid());
			dao.addMovieType(map);
			map.clear();
		}
		return 0;
	}

	public Movie queryById(Integer mid) {
		return dao.queryById(mid);
	}

	public int update(Movie movie) {
		Map<String, Object> map = new HashMap<String, Object>();
		dao.updateMovie(movie);
		dao.deleteMovieTy(movie.getMid());
		String tids = movie.getTids();
		String[] tidsArr = tids.split(",");
		for (String tid : tidsArr) {
			map.put("tid", tid);
			map.put("mid", movie.getMid());
			dao.addMovieType(map);
			map.clear();
		}
		return 1;
	}

}
