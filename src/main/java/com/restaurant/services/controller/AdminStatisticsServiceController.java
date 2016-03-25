package com.restaurant.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.services.dao.repository.AdminStatisticsRepository;
import com.restaurant.services.model.AdminStatistics;

@RestController
public class AdminStatisticsServiceController {
	
	@Autowired
	AdminStatisticsRepository adminStatisticsRepository;
	
	
	@RequestMapping(value = "/getAdminStatistics", method = RequestMethod.GET, produces = "application/json")
	public AdminStatistics getAdminStatistics() {
		String sqlStatus = "Sql Success!";
		AdminStatistics adminStats = new AdminStatistics();
		try {
			adminStats = adminStatisticsRepository.getAdminStatistics();
		} catch (Exception e) {
			e.printStackTrace();
			sqlStatus = "Sql failed ";
		}
		return adminStats;
	}

}
