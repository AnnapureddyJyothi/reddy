package com_objectreposiltory;

import org.openqa.selenium.By;

public class Locaters {
	public final By FB_LOGIN_USERNANE_EDITBOX=By.name("email");
	public final By FB_LOGIN_PASSWORD_EDITBOX=By.name("pass");
	public final By FB_LOGIN__BUTTON=By.name("login");
	public final By FRAME_ZONAL_LINK = By.name("P-24Alist");
	public final By FRAME_LASTUPDAE_TEXT = By.xpath("//body[1]/table[1]/tbody[1]/tr[8]/td[2]/span[1]");
	//Drag and Drop
	public final By FRAME_JQEARY_DRAG_LINK = By.xpath("//p[contains(text(),'Drag me to my target')]");
	public final By FRAME_JQEARY_DROP_LINK = By.xpath("//div[@id='droppable']");
    //AppleVaction
	public final By LEAVING_FROM= By.name("org");
	public final By DESTINATION_TO= By.xpath("//input[@id='desAC_value']");
	public final By X_Button=By.name("closeToaster");
	//ShareCircle
	public final By Register_AS_Partner_button=By.xpath("//*[@id=\"page\"]/div[1]/div/div/section[1]/div/div/div[3]/div/div/div/div/div/div/a");
    public final By Bessinus_Name_Textbox=By.name("form_fields[name]");
    public final By City_Textbox=By.name("form_fields[field_5398eb3]");
    public final By ShareCircle_Mail_Textbox=By.name("form_fields[email]");
    public final By Phone_Number_Textbox=By.name("form_fields[field_127424c]");
    public final By Enter_Massege_Textbox=By.name("form_fields[message]");
    public final By Sent_Massege_Button=By.xpath("//*[@id=\"post-21\"]/div/div/div/div/section[9]/div/div/div/div/div/section[2]/div/div/div/div/div/div/div/form/div/div[6]/button/span/span[2]");
    //Demo Web
    public final By DemoWeb_EDit_Button=By.xpath("//*[@id=\"d2\"]/td[5]/button/span");
    public final By Frist_Name_TextBox=By.id("fn");
    public final By Second_Name_TextBox=By.id("ln");
    public final By Demo_Mail_TextBox =By.id("mn");
    public final By Update_Bottom=By.id("up");
    
    
    
}
