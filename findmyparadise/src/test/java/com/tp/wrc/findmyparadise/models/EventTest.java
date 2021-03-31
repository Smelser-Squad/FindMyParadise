package com.tp.wrc.findmyparadise.models;

import com.tp.wrc.findmyparadise.services.EventServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EventTest {

	@Autowired
	EventServiceImpl toTest;


	//this will run before each @Test method
	@BeforeEach
	public void setup() {

	}


}
