/**
 * 
 */
package org.spring.boot.dubbox.consumer.action;

import java.util.List;

import org.spring.boot.dubbox.api.JournalService;
import org.spring.boot.dubbox.entity.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

/**
 * @author houjianguang
 *
 */
@RestController
public class JournalAction {

	@Reference
	private JournalService journalService;
	
	@RequestMapping("/index")
	public String index() {
		journalService.insertData();
		List<Journal> list = journalService.findAll();
		return com.alibaba.fastjson.JSONObject.toJSONString(list);
	}
}
