package org.hdiv.example.backingbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.apache.myfaces.custom.fileupload.UploadedFile;

@ManagedBean
@RequestScoped
public class FileUploadBean {

	private UploadedFile uploadedFile;

	private Integer number = new Integer(12);

	public void submit() {

		// Just to demonstrate what information you can get from the uploaded file.
		System.out.println("File type: " + this.uploadedFile.getContentType());
		System.out.println("File name: " + this.uploadedFile.getName());
		System.out.println("File size: " + this.uploadedFile.getSize() + " bytes");

		System.out.println("Number: " + this.number);

	}

	public UploadedFile getUploadedFile() {
		return this.uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

}
