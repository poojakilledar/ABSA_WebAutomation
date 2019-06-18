package com.absa.pageObjectModel;

import com.absa.pageObjectModel.pageElements.ButtonPageElement;
import com.absa.pageObjectModel.pageElements.CheckboxPageElement;
import com.absa.pageObjectModel.pageElements.FileDownloadPageElement;
import com.absa.pageObjectModel.pageElements.FileUploadPageElement;
import com.absa.pageObjectModel.pageElements.IframePageElement;
import com.absa.pageObjectModel.pageElements.LabelPageElement;
import com.absa.pageObjectModel.pageElements.LinkPageElement;
import com.absa.pageObjectModel.pageElements.ListboxPageElement;
import com.absa.pageObjectModel.pageElements.RadioButtonPageElement;
import com.absa.pageObjectModel.pageElements.TablePageElement;
import com.absa.pageObjectModel.pageElements.TextboxPageElement;

public class PageElementFactory {

	static public ButtonPageElement button(final String elementName, final Locator locator) {
		return new ButtonPageElement(elementName, locator);
	}

	static public CheckboxPageElement checkbox(final String elementName, final Locator locator) {
		return new CheckboxPageElement(elementName, locator);
	}

	static public FileDownloadPageElement fileDownload(final String elementName, final Locator locator) {
		return new FileDownloadPageElement(elementName, locator);
	}

	static public FileUploadPageElement fileUpload(final String elementName, final Locator locator) {
		return new FileUploadPageElement(elementName, locator);
	}

	static public IframePageElement iframe(final String elementName, final Locator locator) {
		return new IframePageElement(elementName, locator);
	}

	static public LabelPageElement label(final String elementName, final Locator locator) {
		return new LabelPageElement(elementName, locator);
	}

	static public LinkPageElement link(final String elementName, final Locator locator) {
		return new LinkPageElement(elementName, locator);
	}

	static public TablePageElement table(final String elementName, final Locator locator) {
		return new TablePageElement(elementName, locator);
	}
	
	static public ListboxPageElement listBox(final String elementName, final Locator locator) {
		return new ListboxPageElement(elementName, locator);
	}

	static public RadioButtonPageElement radioButton(final String elementName, final Locator locator) {
		return new RadioButtonPageElement(elementName, locator);
	}

	static public TextboxPageElement textbox(final String elementName, final Locator locator) {
		return new TextboxPageElement(elementName, locator);
	}

	private PageElementFactory() {
		// Hide constructor
	}
}
