/**
 * 
 */
package com.amdocs.fx.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.amdocs.fx.ppv.itests.PpvAccountQdeCheckTest;
import com.amdocs.fx.ppv.itests.PpvOfferValidateTest;
import com.amdocs.fx.ppv.itests.PpvOrderItemAssembleTest;
import com.amdocs.fx.ppv.itests.PpvOutletFindByAccountTest;
import com.amdocs.fx.ppv.itests.PpvOutletFindByServiceTest;
import com.amdocs.fx.ppv.itests.PpvOutletFindTest;
import com.amdocs.fx.ppv.itests.PpvReferenceDataGetTest;

/**
 * @author jatinma
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ PpvAccountQdeCheckTest.class, PpvOfferValidateTest.class, PpvOrderItemAssembleTest.class,
		PpvOutletFindByAccountTest.class, PpvOutletFindTest.class, PpvReferenceDataGetTest.class,
		PpvOutletFindByServiceTest.class })
public class PpvTestSuite {

}
