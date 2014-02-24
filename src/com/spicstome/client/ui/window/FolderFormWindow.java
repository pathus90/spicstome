package com.spicstome.client.ui.window;

import java.util.ArrayList;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.IconButton;
import com.smartgwt.client.widgets.Window;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.layout.VLayout;
import com.spicstome.client.dto.FolderDTO;
import com.spicstome.client.dto.ImageDTO;
import com.spicstome.client.dto.PecsDTO;
import com.spicstome.client.ui.form.ImageUploadForm;

public class FolderFormWindow extends Window{

	VLayout verticalLayout = new VLayout();
	DynamicForm form = new DynamicForm();
	
	ImageUploadForm imageUploadForm = new ImageUploadForm(128, 128);
	
	IconButton buttonValidate = new IconButton("");
	
	public FolderDTO folder;
	
	TextItem nameDetail = new TextItem("name");

	
	public enum Mode{NEW, EDIT}
	
	public FolderFormWindow(Mode mode,FolderDTO folderDTO,FolderDTO parent) 
	{
		super();

		setWidth(500);
		setHeight(300);

		if(mode==Mode.NEW)
		{
			setTitle("Création d'un nouveau dossier");
			
			int order=0;
			
			if(parent!=null)
				order = parent.getContent().size();
			
			this.folder = new FolderDTO((long)-1,
					"Nouveau dossier",
					order,
					parent,
					new ImageDTO((long)-1,"default_folder.png"),
					new ArrayList<PecsDTO>());
		}
			
		else if(mode==Mode.EDIT)
		{
			setTitle("Edition d'un dossier");		
			this.folder=folderDTO;
		}
		
		
		
		setShowMinimizeButton(false);
		setIsModal(true);
		setShowModalMask(true);
		centerInPage();

		setDismissOnOutsideClick(true);
		

		imageUploadForm.setImageFileName(folder.getImage().getFilename());
		
		nameDetail.setHeight(20);    
		nameDetail.setTitle("Nom");
		
		form.setFields(nameDetail);
		
		buttonValidate.setIconSize(42);
		buttonValidate.setIcon("check.png");
		buttonValidate.setLayoutAlign(Alignment.CENTER);
		buttonValidate.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				
				folder.setName(nameDetail.getValueAsString());
				folder.getImage().setFilename(imageUploadForm.getImageFileName());
				
				destroy();
				
			}
		});
		
		nameDetail.setValue(this.folder.getName());
		
		imageUploadForm.getUploadButton().setWidth(200);
		imageUploadForm.getImage().setLayoutAlign(Alignment.CENTER);
		imageUploadForm.getUploadButton().setLayoutAlign(Alignment.CENTER);
		form.setAlign(Alignment.CENTER);
		
		verticalLayout.setWidth(300);
		verticalLayout.setLayoutAlign(Alignment.CENTER);
		verticalLayout.setMargin(20);

	    verticalLayout.addMember(imageUploadForm.getImage());
	    verticalLayout.addMember(imageUploadForm.getUploadButton());
		verticalLayout.addMember(form);
		verticalLayout.addMember(buttonValidate);
		
		addItem(verticalLayout);

	}
}
