package wrapper;

import org.openqa.selenium.WebElement;

public interface BaseWrapper {
public void click(WebElement ele);
	
	public void typeValue(WebElement ele, String data);

	public String getTextValue(WebElement ele);

	public void selectValueByvalue(WebElement ele, String value) ;

	public void pageDownToSpecificElement(WebElement ele);
	
	public String getTitleName();
	
}
