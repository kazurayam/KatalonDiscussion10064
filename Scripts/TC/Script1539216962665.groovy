import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

Map m = (Map)GlobalVariable.TestingA

WebUI.comment(">>> before update, m.get('A')=${m.get('A')}")

m.put("A", "This is modified")

