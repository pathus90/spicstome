package com.spicstome.client.ui;

import com.spicstome.client.dto.StudentDTO;
import com.spicstome.client.place.AlbumManagementPlace;
import com.spicstome.client.ui.panel.AlbumBookPanel;
import com.spicstome.client.ui.panel.Book;
import com.spicstome.client.ui.widget.Crumb;

public class AlbumViewImpl extends UserViewImpl  implements AlbumView{
	
	
	AlbumBookPanel albumBookPanel;
	Crumb crumb;
	
	public AlbumViewImpl()
	{
		
		super();
		
		addCrumb(new Crumb("Les albums"){
			@Override
			public void onClickCrumb() {			
				goTo(new AlbumManagementPlace());
			}
		});
		
		crumb = new Crumb(""){
			@Override
			public void onClickCrumb() {}
		};
		
		addCrumb(crumb);

		this.albumBookPanel = new AlbumBookPanel(new Book(100));
		
		mainPanel.addMember(this.albumBookPanel);
	}


	@Override
	public void setStudent(StudentDTO student){
		
		this.albumBookPanel.setStudent(student);
		
		if(student.getAlbum().getId()==1)
			crumb.setCrumbTitle("Album général (consultation)");
		else if(student.getAlbum().getId()==2)
			crumb.setCrumbTitle("Album exemple (consultation)");
		else
			crumb.setCrumbTitle("Album de "+student.getFirstName()+" (consultation)");
		
	}
}
