package org.tcs;

import org.testng.annotations.Test;

public class A {
	
	@Test
	private void tc1() {
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	private void tc2() {
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	private void tc3() {
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	private void tc4() {
		System.out.println(Thread.currentThread().getId());
	}
	@Test
	private void tc5() {
		System.out.println(Thread.currentThread().getId());
	}
}
