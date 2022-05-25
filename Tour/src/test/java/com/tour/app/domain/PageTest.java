package com.tour.app.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PageTest {

	@Test
	void page() {
		PageHandler ph = new PageHandler(250, 11);
		ph.print();
		System.out.println("ph="+ph);
		assertTrue(ph.getBeginPage()==11);
		assertTrue(ph.getEndPage()==15);
	}
	@Test
	void page2() {
		PageHandler ph = new PageHandler(300, 21);
		ph.print();
		System.out.println("ph="+ph);
		assertTrue(ph.getBeginPage()==21);
		assertTrue(ph.getEndPage()==25);
	}
	

}
