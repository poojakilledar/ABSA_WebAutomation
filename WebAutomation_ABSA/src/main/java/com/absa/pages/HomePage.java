package com.absa.pages;

import com.absa.pageObjectModel.LocatorFactory;
import com.absa.pageObjectModel.PageElementFactory;
import com.absa.pageObjectModel.pageElements.ButtonPageElement;
import com.absa.pageObjectModel.pageElements.LabelPageElement;
import com.absa.pageObjectModel.pageElements.ListboxPageElement;
import com.absa.pageObjectModel.pageElements.RadioButtonPageElement;
import com.absa.pageObjectModel.pageElements.TablePageElement;
import com.absa.pageObjectModel.pageElements.TextboxPageElement;

public class HomePage {
	
	public static TablePageElement userListTable(){
		return PageElementFactory.table("User List Table", LocatorFactory.xpath("//table[@class='smart-table table table-striped']"));
	}
	
	public static TablePageElement userListTableRecord(String data){
		return PageElementFactory.table("User List Table Latest Record", LocatorFactory.xpath("//table[@table-title='Smart Table example']//td[contains(text(),'"+data+"')]"));
	}


	public static ButtonPageElement addUserButton()
	{
		return PageElementFactory.button("Add User Button", LocatorFactory.xpath("//button[@type='add' and @class='btn btn-link pull-right']"));
	}
	
	public static TextboxPageElement firstNameTextBox()
	{
		return PageElementFactory.textbox("First Name", LocatorFactory.xpath("//input[@name='FirstName']"));
	}
	
	public static TextboxPageElement lastNameTextBox()
	{
		return PageElementFactory.textbox("Last Name Text Box", LocatorFactory.xpath("//input[@name='LastName']"));
	}
	
	public static TextboxPageElement userNameTextBox()
	{
		return PageElementFactory.textbox("User Name Text Box", LocatorFactory.xpath("//input[@name='UserName']"));
	}
	 
	public static TextboxPageElement passwordTextBox()
	{
		return PageElementFactory.textbox("Password Text Box", LocatorFactory.xpath("//input[@name='Password']"));
	}
	
	public static ListboxPageElement roleList()
	{
		return PageElementFactory.listBox("Role List", LocatorFactory.xpath("//select[@name='RoleId']"));
	}
	
	public static TextboxPageElement emailTextBox()
	{
		return PageElementFactory.textbox("Email Text Box", LocatorFactory.xpath("//input[@name='Email']"));
	}

	public static TextboxPageElement mobilePhoneTextBox()
	{
		return PageElementFactory.textbox("Password Text Box", LocatorFactory.xpath("//input[@name='Mobilephone']"));
	}
	
	public static RadioButtonPageElement customerRadioButton(String companyName)
	{
		return PageElementFactory.radioButton("Customer Radio Button", LocatorFactory.xpath("//label[text()='"+companyName+"']/./input[@name='optionsRadios']"));
	}
	
	public static ButtonPageElement saveButton()
	{
		return PageElementFactory.button("Save Button",LocatorFactory.xpath("//button[text()='Save']"));
	}
	
	public static LabelPageElement userName()
	{
		return PageElementFactory.label("User Name in the table",LocatorFactory.xpath("//table[@class='smart-table table table-striped']//tr//td[3]"));
	}
	
}
