package com.xaver.tests;

//import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.xaver.App;
import com.xaver.model.StatusUpdate;
import com.xaver.model.StatusUpdateDao;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(App.class)
@WebAppConfiguration
@Transactional
public class StatusTest {
	
	@Autowired
	private StatusUpdateDao statusUpdateDao;
	
	@Test
	public void testSave(){
		StatusUpdate status = new StatusUpdate("This is a test StatusUpdate.");
		statusUpdateDao.save(status);
		assertNotNull("Non-Null ID", status.getId());
		assertNotNull("Non-Null Date", status.getAdded());
		StatusUpdate retrieved = statusUpdateDao.findOne(status.getId());
		assertEquals("Matching StatusUpdate",status, retrieved);
		
	}
	
	@Test
	public void testFindLatest(){
		Calendar calendar = Calendar.getInstance();
		StatusUpdate lastStatusUpdate = null;
		for(int i=0; i<10;i++){
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			StatusUpdate status = new StatusUpdate("Status update " + i, calendar.getTime());
			statusUpdateDao.save(status);
			lastStatusUpdate=status;
		}
		
		StatusUpdate retrieved = statusUpdateDao.findFirstByOrderByAddedDesc();
		assertEquals("Latest status update", lastStatusUpdate, retrieved);
	}
	
	
	

}
