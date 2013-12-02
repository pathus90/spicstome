package com.spicstome.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

import com.spicstome.client.services.MailMeServices;
import com.spicstome.client.ClientFactory;
import com.spicstome.client.hibernate.HibernateManager;
import com.spicstome.client.place.GoodbyePlace;
import com.spicstome.client.place.LoginPlace;
import com.spicstome.client.ui.LoginView;

public class LoginActivity extends AbstractActivity implements
		LoginView.Presenter {
	
	// Used to obtain views, eventBus, placeController

	private ClientFactory clientFactory;


	public LoginActivity(LoginPlace place, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		System.out.println("start de l'activit� Hello");
		LoginView loginView = clientFactory.getLoginView();
		loginView.setPresenter(this);
		containerWidget.setWidget(loginView.asWidget());
	}

	/**
	 * Navigate to a new Place in the browser
	 */
	public void goTo(Place place) {
		System.out.println("go To HelloActivity");
		clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void login(String login, String password) {
		
		System.out.println("appel service");
		
		MailMeServices.Util.getInstance().Login(login, password, new AsyncCallback<Boolean>() {
			@Override
			public void onSuccess(Boolean result) {

				if(result) 
					goTo(new GoodbyePlace("Youhou"));

			}
			@Override
			public void onFailure(Throwable caught) {
				System.out.println(caught);
			}
		});
	}
}
