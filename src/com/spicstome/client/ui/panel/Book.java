package com.spicstome.client.ui.panel;

import java.util.ArrayList;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.IconButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.events.FocusChangedEvent;
import com.smartgwt.client.widgets.events.FocusChangedHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.spicstome.client.ui.widget.ImageRecord;
import com.spicstome.client.ui.widget.ImageTileGrid;
import com.spicstome.client.ui.widget.ImageTileGrid.Mode;

/**
 * A book is a list of pages which contain tilegrids.
 * a pagination allow to move from one page to the other.
 */
public class Book extends VLayout{
	
	protected ArrayList<ImageTileGrid> listPage= new ArrayList<ImageTileGrid>();
	protected VLayout verticalPanel = new VLayout();
	protected HLayout horizontalPagePanel = new HLayout();
	protected HLayout horizontalNextPrevPanel = new HLayout();
	protected IconButton buttonNext = new IconButton("");
	protected IconButton buttonPrev = new IconButton("");
	public int imageSize;
	public int heightPage; 
	public int widthPage;
	public int tileWidth;
	public int tileHeight;
			
	public ImageRecord selectedImage=null;
	
	public int nbRowPerPage=2;
	public int nbColPerPage=3;
	
	int iLeftPage=0;
	int lastPage=0;
	
	public Book(int imageSize) {
		
		super();
		
		if (com.google.gwt.user.client.Window.getClientWidth() < 1300)
			nbColPerPage = 2;
		
		setMargin(10);
		this.imageSize=imageSize;
		
		tileWidth  = imageSize+10;
		tileHeight = imageSize+30;
		
		widthPage =(nbColPerPage*(tileWidth+20));
		heightPage = (nbRowPerPage*(tileHeight+20));
		
		buttonNext.setIcon("next-icon.png");
		buttonPrev.setIcon("prev-icon.png");
		buttonNext.setIconSize(30);
		buttonPrev.setIconSize(30);
		buttonNext.setPrompt("Page suivante");
		buttonPrev.setPrompt("Page précédente");
		
		buttonNext.setWidth(30);
		buttonPrev.setWidth(30);
		
		buttonNext.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {

				iLeftPage+=2;
				UpdatePage();
			}
		});
		
		buttonPrev.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {

				iLeftPage-=2;
				UpdatePage();
			}
		});
		
		verticalPanel.setWidth(2*widthPage);
		verticalPanel.setLayoutAlign(Alignment.CENTER);

		
		horizontalNextPrevPanel.addMember(buttonPrev);
		horizontalNextPrevPanel.addMember(buttonNext);
		
		horizontalNextPrevPanel.setHeight(28);
		horizontalNextPrevPanel.setWidth(50);
		horizontalNextPrevPanel.setLayoutAlign(Alignment.CENTER);
		
		verticalPanel.addMember(horizontalPagePanel);
		verticalPanel.addMember(horizontalNextPrevPanel);
		
		addMember(verticalPanel);

		UpdateNextPrev();
	}
	
	public void selectItem(int i)
	{
		int nbPerPage=nbColPerPage*nbRowPerPage;

		if(i<(nbPerPage))
			listPage.get(iLeftPage).selectRecord(i);	
		else
			listPage.get(iLeftPage+1).selectRecord(i-nbPerPage);
	}
	
	
	
	public void selectPage(int i)
	{
		iLeftPage=i;
		UpdatePage();
	}

	public void setList(ArrayList<ImageRecord> list)
	{
		selectedImage=null;
		
		listPage.clear();
		iLeftPage=0;
		int nbElementPerPage = nbColPerPage*nbRowPerPage;
		lastPage = (list.size()/nbElementPerPage);
		
		if(lastPage>0)
		{
			if(list.size()%(lastPage*nbElementPerPage)!=0)
				lastPage++;
		}
		if(lastPage==0)
			lastPage=2;
		if(lastPage%2==1)
			lastPage++;

		for(int i=0;i<lastPage;i++)
		{
			final Book book=this;
			
			final ImageTileGrid imageList = new ImageTileGrid(Mode.DRAG,tileWidth,tileHeight,imageSize){
				
				@Override
				public void OnSelectChanged(ImageRecord object)
				{
					book.onSelectChangeBook(object);
				}
				
				@Override
				public void OnDoubleClickImage(ImageRecord object)
				{
					book.onDoubleClickImage(object);
				}
				
				
			};
			
			imageList.addFocusChangedHandler(new FocusChangedHandler() {
				
				@Override
				public void onFocusChanged(FocusChangedEvent event) {

					if(!event.getHasFocus())
					{
						if(imageList.getSelectedItem()!=null)
						{
							imageList.deselectRecord(imageList.getSelectedItem());
						}			
					}
				}
			});
			
			
			
			
			imageList.setWidth(widthPage);
			imageList.setHeight(heightPage);

			imageList.setStyleName("page");
			
			listPage.add(imageList);
		}
		
		
		for(int i=0;i<list.size();i++)
		{
			int nPage = i/nbElementPerPage;
			listPage.get(nPage).addItem(list.get(i));
		}

		UpdatePage();
	
	}
	
	public void UpdateNextPrev()
	{
		buttonPrev.setDisabled(!(iLeftPage>0));		
		buttonNext.setDisabled(!(iLeftPage+2<lastPage));
	}
	
	public void UpdatePage()
	{
		Canvas[] children = horizontalPagePanel.getChildren();
		horizontalPagePanel.removeMembers(children);
	
		
		UpdateNextPrev();
			
		horizontalPagePanel.addMember(listPage.get(iLeftPage));
		horizontalPagePanel.addMember(listPage.get(iLeftPage+1));
		
		
		onChangePage();
		
	}
	
	public void onChangePage()
	{
		selectedImage=null;
	}
	
	public void onSelectChangeBook(ImageRecord image)
	{
		if(image!=null)
			selectedImage=image;
	}
	
	public void onDoubleClickImage(ImageRecord image)
	{
		
	}

}
