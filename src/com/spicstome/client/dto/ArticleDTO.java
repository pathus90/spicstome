package com.spicstome.client.dto;

import java.io.Serializable;

public class ArticleDTO extends SubjectDTO implements Serializable {

	private static final long serialVersionUID = 93295496658731146L;


	public ArticleDTO()
	{
		
	}
	
	public ArticleDTO(long id)
	{
		super(id);
	}
	
	public ArticleDTO(Long id, String name, int order, FolderDTO folder, ImageDTO image,int favorite,int gender,int number)
	{
		super(id, name, order, folder, image,favorite,gender,number);

	}
	
	@Override
	public String toString() {
		return "Article []";
	}

}
