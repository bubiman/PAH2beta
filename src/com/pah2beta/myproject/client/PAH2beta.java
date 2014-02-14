package com.pah2beta.myproject.client;

import java.util.Map;

import com.pah2beta.myproject.shared.FieldVerifier;
import com.sun.corba.se.impl.interceptors.SlotTableStack;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dev.util.collect.HashMap;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DecoratedStackPanel;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.StackLayoutPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.XMLParser;


class Tagesordnungspunkt {
	String ticketId;
	String titel;
	String uhrzeitStart;
	String nummer;
	
}


class Sitzung {
	String ort;
	String datum;
	String ticketId;
	String titel;
	String uhrzeitStart;
	String uhrzeitEnde;
	Widget ui;
	String stand;
	
	public Sitzung() {
		ort = "";
		datum="";
		ticketId ="";
		uhrzeitStart="";
		uhrzeitEnde="";
		ui = null;
		titel = "";
		stand ="";
	}

	public Widget getUi() {
		if (ui != null)
		{
			return ui;
		}
		else
		{
		    Label labelTitel = new Label(titel);
		    Label labelRedmineId = new Label("#"+ticketId);
		    Label labelOrt = new Label(ort);
		    Label labelDatum = new Label(datum+" "+uhrzeitStart+"-"+uhrzeitEnde);
		    VerticalPanel vpanelSitzung = new VerticalPanel();
		    vpanelSitzung.add(labelRedmineId);
		    vpanelSitzung.add(labelTitel);
		    vpanelSitzung.add(labelOrt);
		    vpanelSitzung.add(labelDatum);
		    
		    FocusPanel fpanelSitzung = new FocusPanel();
		    fpanelSitzung.add(vpanelSitzung);
		    
		    DecoratorPanel dpanelSitzung = new DecoratorPanel();
		    dpanelSitzung.add(vpanelSitzung);
			
		    return dpanelSitzung;
		    
		}
		
		
	}
	
}

class Sitzungen
{
	
	Map<String,Sitzung> sitzungenNachTicketId = new HashMap<String,Sitzung>(); 
	
	
	public Sitzungen()
	{
		
	}
	
	
	public void update(String xmlRedmine)
	{
		Document xml = XMLParser.parse(xmlRedmine);
	}
	
}





















/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PAH2beta implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	
	
	
	public Label centerText;
	
	public void onModuleLoad() {
	
		SplitLayoutPanel splitPanel = new SplitLayoutPanel(15);
	    splitPanel.ensureDebugId("cwSplitLayoutPanel");
	    splitPanel.getElement().getStyle()
	        .setProperty("border", "3px solid #e7e7e7");

	    
	    HorizontalPanel hPanelOben = new HorizontalPanel();
	    hPanelOben.add(new Label("Hallo, Karl Ranseier"));
	    hPanelOben.add(new Button("logout"));
	    
	    
	    // 1. Sitzung
	    Label uebrschrift1 = new Label("51. Plenar Sitzung");
	    Label redmineID1 = new Label("#874");
	    Label ort1 = new Label("Plenarsaal, Landtag");
	    Label datum1 = new Label("2014-02-31 10:00-22:00");
	    VerticalPanel sitzungenvPanel1 = new VerticalPanel();
	    sitzungenvPanel1.add(redmineID1);
	    sitzungenvPanel1.add(uebrschrift1);
	    sitzungenvPanel1.add(ort1);
	    sitzungenvPanel1.add(datum1);
	    
	    FocusPanel sitzungFPanel1 = new FocusPanel();
	    sitzungFPanel1.add(sitzungenvPanel1);
	    
	    DecoratorPanel sitzungdPanel1 = new DecoratorPanel();
	    sitzungdPanel1.add(sitzungFPanel1);
	    
	    // 2. Sitzung
	    Label uebrschrift2 = new Label("52. Plenar Sitzung");
	    Label redmineID2 = new Label("#874");
	    Label ort2 = new Label("Plenarsaal, Landtag");
	    Label datum2 = new Label("2014-02-32 10:00-22:00");
	    VerticalPanel sitzungenvPanel2 = new VerticalPanel();
	    sitzungenvPanel2.add(redmineID2);
	    sitzungenvPanel2.add(uebrschrift2);
	    sitzungenvPanel2.add(ort2);
	    sitzungenvPanel2.add(datum2);
	    
	    FocusPanel sitzungFPanel2 = new FocusPanel();
	    sitzungFPanel2.add(sitzungenvPanel2);
	    
	    DecoratorPanel sitzungdPanel2 = new DecoratorPanel();
	    sitzungdPanel2.add(sitzungFPanel2);

	    // 3. Sitzung
	    Label uebrschrift3 = new Label("17. A18.1 Sitzung");
	    Label redmineID3 = new Label("#874");
	    Label ort3 = new Label("E1 - D05, Landtag");
	    Label datum3 = new Label("2014-02-33 10:00-11:00");
	    VerticalPanel sitzungenvPanel3 = new VerticalPanel();
	    sitzungenvPanel3.add(redmineID3);
	    sitzungenvPanel3.add(uebrschrift3);
	    sitzungenvPanel3.add(ort3);
	    sitzungenvPanel3.add(datum3);
	    
	    FocusPanel sitzungFPanel3 = new FocusPanel();
	    sitzungFPanel3.add(sitzungenvPanel3);
	    
	    DecoratorPanel sitzungdPanel3 = new DecoratorPanel();
	    sitzungdPanel3.add(sitzungFPanel3);
	    
	    
	    
	    
	    ScrollPanel spSitzungen = new ScrollPanel();
	    
	    VerticalPanel vPanelAktuelleSitzungen = new VerticalPanel();
	   
	    vPanelAktuelleSitzungen.add(sitzungdPanel1);
	    vPanelAktuelleSitzungen.add(sitzungdPanel2);
	    vPanelAktuelleSitzungen.add(sitzungdPanel3);
	    
	    vPanelAktuelleSitzungen.setSpacing(10);
	    vPanelAktuelleSitzungen.setWidth("100%");
	    
	    spSitzungen.add(vPanelAktuelleSitzungen);
	    
	    FlowPanel fPanelFilter = new FlowPanel();
	    fPanelFilter.add(new CheckBox("all/none"));
	    fPanelFilter.add(new CheckBox("A01"));
	    fPanelFilter.add(new CheckBox("A02"));
	    fPanelFilter.add(new CheckBox("A03"));
	    fPanelFilter.add(new CheckBox("A04"));
	    fPanelFilter.add(new CheckBox("A05"));
	    fPanelFilter.add(new CheckBox("A06"));
	    fPanelFilter.add(new CheckBox("A07"));
	    fPanelFilter.add(new CheckBox("A08"));
	    
	    StackLayoutPanel slpLinks = new StackLayoutPanel(Unit.PX);
	    slpLinks.add(spSitzungen,"Aktuelle Sitzungen",80);
	    slpLinks.add(fPanelFilter,"Filter", 80);
	    
	    // Add text all around.
	    splitPanel.addNorth(hPanelOben, 50);
	    splitPanel.addSouth(new Label("unten"), 50);
	    splitPanel.addWest(slpLinks, 200);

	    centerText = new Label();
	    centerText.setText("mich sollte man nicht lesen können");
	    
	    
	    try {
			String tmp = "https://redmine.piratenfraktion-nrw.de/issues.xml?project_id=Plenum&tracker_id=15&status_id=open&sort=cf_4";
			new RequestBuilder(RequestBuilder.GET, tmp).sendRequest("", new RequestCallback()
				{
				  @Override
				  public void onResponseReceived(Request req, Response resp) {
				    
					centerText.setText("hab was geladen "+resp.getText());
				    //RootPanel.get().add(verarbeitestring(text));
					//RootPanel.get().add(new Label("rückgabe"));
				 }

				  @Override
				  public void onError(Request res, Throwable throwable) {
				    // handle errors
				  }

				});
		} catch (RequestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    
	    // Add scrollable text to the center.


	    
	    ScrollPanel centerScrollable = new ScrollPanel(centerText);
	    splitPanel.add(centerScrollable);
		
	    RootLayoutPanel.get().add(splitPanel);
		
	    
	    
	    
	    
	    
	    
	    
		
	}
}
