package com.bw.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bw.entity.Movie;
import com.bw.entity.Type;
import com.bw.service.MovieService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class MovieController {

	@Resource
	private MovieService service;
	
	@RequestMapping("list.do")
	public String findAll(String mname,Model model,@RequestParam(required=false,defaultValue="1")Integer pageNum){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("mname", mname);
		PageHelper.startPage(pageNum, 3);
		List<Movie> list = service.findAll(map);
		PageInfo<Movie> page = new PageInfo<Movie>(list);
		model.addAttribute("page", page);
		model.addAttribute("mname", mname);
		return "list";
	}
	
	@RequestMapping("deleteAll.do")
	@ResponseBody
	public boolean deleteAll(String ids){
		int num = service.deleteAll(ids);
		if(num>0){
			return true;
		}
		return false;
	}
	
	@RequestMapping("findType.do")
	@ResponseBody
	public List<Type> findType(){
		List<Type> list = service.findType();
		return list;
	}
	
	@RequestMapping("add.do")
	@ResponseBody
	public int add(Movie movie){
		int add = service.add(movie);
		return add;
	}
	
	@RequestMapping("queryById.do")
	@ResponseBody
	public Movie queryById(Integer mid){
		Movie movie = service.queryById(mid);
		return movie;
	}
	
	@RequestMapping("update.do")
	@ResponseBody
	public boolean update(Movie movie){
		int i = service.update(movie);
		if(i>0)
			return true;
		
		return false;
	}
}
