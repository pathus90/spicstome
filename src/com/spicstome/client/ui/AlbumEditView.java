package com.spicstome.client.ui;

import java.util.Set;

import com.google.gwt.user.client.ui.IsWidget;
import com.spicstome.client.dto.AlbumDTO;
import com.spicstome.client.dto.ArticleDTO;
import com.spicstome.client.dto.FolderDTO;
import com.spicstome.client.dto.StudentDTO;

public interface AlbumEditView extends IsWidget{

	void setAlbum(AlbumDTO album);
	void setOthersAlbum(Set<StudentDTO> list);
	void setOwner(String name);
	void insertFolder(FolderDTO folder);
	void deleteFolder(FolderDTO folder);
	void insertArticle(ArticleDTO articleDTO);
	void deleteArticle(ArticleDTO articleDTO);
	
	public interface Presenter 
	{
		void save(ArticleDTO a);
		void save(FolderDTO f);
		void delete(ArticleDTO a);
		void delete(FolderDTO f);
		void move(FolderDTO child,FolderDTO parent);
	}
}
