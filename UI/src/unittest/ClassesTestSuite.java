package unittest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


/**
 * @author shahe
 *
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	TestAbuseReport.class,
	TestAdmin.class,
	TestAnonymousUser.class,
	TestAuditTrail.class,
	TestSupervisor.class	
	})
public final class ClassesTestSuite {

}
