package com.qhit.pojo.result;

/**
 * 上传文件结果
 * 
 * @author Administrator
 * 
 */
public class UploadFileResult extends UploadImgResult {

	private String name;// 文件名称

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}