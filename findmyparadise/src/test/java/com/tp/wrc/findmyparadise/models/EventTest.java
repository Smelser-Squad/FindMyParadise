package com.tp.wrc.findmyparadise.models;

import com.tp.wrc.findmyparadise.models.Event;
import com.tp.wrc.findmyparadise.services.EventServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class EventTest {

	@Autowired
	EventServiceImpl toTest;


	//this will run before each @Test method
	@BeforeEach
	public void setup() {

	}


}
