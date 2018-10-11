import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

class TL {
	
	@BeforeTestCase
	def beforeTestCase(TestCaseContext testCaseContext) {
		Map m = (Map)GlobalVariable.TestingA
		m.put("A","Testing 123")
	}
	
	@AfterTestCase
	def afterTestCase(TestCaseContext testCaseContext) {
		Map m = (Map)GlobalVariable.TestingA
		WebUI.comment(">>> after test case, m.get('A')=${m.get('A')}")
	}
	
}