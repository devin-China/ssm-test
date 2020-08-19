package com.devin.web;

import com.devin.dao.ConfigDao;
import com.devin.service.ConfigService;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@Import({ConfigDao.class, ConfigService.class})
public class ApplictionConfig extends WebMvcConfigurationSupport {

}
