/**
 * 
 */
package com.compliance.repo.service;

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doThrow;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

/**
 * @author hp
 *
 */

public class ArticleServiceTest {

	@InjectMocks
	@Spy
	private ArticleService service;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = NullPointerException.class)
	public void serviceMethodTest() throws NullPointerException {
		doThrow(new NullPointerException()).when(service).serviceMethod(1);
		String value = service.serviceMethod(1);
		assertNull(value);
	}

}
