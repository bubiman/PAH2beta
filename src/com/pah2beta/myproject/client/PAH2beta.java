package com.pah2beta.myproject.client;



import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Node;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.google.gwt.http.client.URL;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DecoratedPopupPanel;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
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
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.xml.client.Document;
import com.google.gwt.xml.client.Element;
import com.google.gwt.xml.client.XMLParser;
import com.google.gwt.i18n.client.DateTimeFormat;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PAH2beta implements EntryPoint {


public void myDebugger (String level, String text)
{
	
	Date today = new Date();
	DateTimeFormat fmt = DateTimeFormat.getFormat("H:mm:s,S");
	
	globalDebugger.insertRow(0);
    globalDebugger.setWidget(0, 0, new Label(fmt.format(today)));
    globalDebugger.setWidget(0, 1, new Label(level));
    globalDebugger.setWidget(0, 2, new Label(text));
}
	
class RedmineConnector {
	private Boolean fake;
	private String redmineURL;
	
	public RedmineConnector (String RedmineURL)
	{
		myDebugger("Debug", "Benutze live Daten");
		this.redmineURL = RedmineURL;
		fake = false;
	}
	
	public RedmineConnector (String RedmineURL, Boolean nutzeFakeDaten)
	{
		this.redmineURL = RedmineURL;
		if (nutzeFakeDaten)
		{
			myDebugger("Debug", "Benutze debug Daten");
			fake = true;
		}
		else
		{
			myDebugger("Debug", "Benutze live Daten");
			fake = false;
		}
	}
	
	public void getTops (String issueID)
	{
		myDebugger("Debug", "Hole alle Tops zu #"+issueID);

		if (this.fake)
		{
			globalSitzungen.sitzungenNachTicketId.get(globalSitzungen.selectedSitzung).tagesordnung.update("<issues total_count='9' offset='0' limit='25' type='array'> <issue> <id>10713</id> <project id='66' name='Plenum'/> <tracker id='14' name='Tagesordnungspunkte'/> <status id='10' name='Zukünftige'/> <priority id='2' name='Normal'/> <author id='66' name='Ansgar Flack'/> <subject> Fairen Wettbewerb schaffen: Klare energiewirtschaftliche Regelungen bei der Vergabe von Konzessionen für Strom- und Gasnetze </subject> <description/> <start_date>2014-05-02</start_date> <due_date/> <done_ratio>0</done_ratio> <estimated_hours/> <custom_fields type='array'> <custom_field id='4' name='Datum'> <value>2014-05-07</value> </custom_field> <custom_field id='10' name='Uhrzeit von'> <value/> </custom_field> <custom_field id='59' name='Top'> <value>1</value> </custom_field> <custom_field id='57' name='hat Abstimmungen'> <value>0</value> </custom_field> <custom_field id='58' name='wir Reden'> <value>0</value> </custom_field> </custom_fields> <created_on>2014-05-02T09:27:10Z</created_on> <updated_on>2014-05-05T11:23:05Z</updated_on> <closed_on/> </issue> <issue> <id>10715</id> <project id='66' name='Plenum'/> <tracker id='14' name='Tagesordnungspunkte'/> <status id='10' name='Zukünftige'/> <priority id='2' name='Normal'/> <author id='66' name='Ansgar Flack'/> <subject> Vermeidung von „Greenwashing“ bei der Umstellung der Stromversorgung der Gebäude bzw. Liegenschaften des Landes Nordrhein-Westfalen auf elektrische Energie aus regenerativen Quellen </subject> <description/> <start_date>2014-05-02</start_date> <due_date/> <done_ratio>0</done_ratio> <estimated_hours/> <custom_fields type='array'> <custom_field id='4' name='Datum'> <value>2014-05-07</value> </custom_field> <custom_field id='10' name='Uhrzeit von'> <value/> </custom_field> <custom_field id='59' name='Top'> <value>2</value> </custom_field> <custom_field id='57' name='hat Abstimmungen'> <value>0</value> </custom_field> <custom_field id='58' name='wir Reden'> <value>0</value> </custom_field> </custom_fields> <created_on>2014-05-02T09:58:18Z</created_on> <updated_on>2014-05-02T09:58:18Z</updated_on> <closed_on/> </issue> <issue> <id>10716</id> <project id='66' name='Plenum'/> <tracker id='14' name='Tagesordnungspunkte'/> <status id='10' name='Zukünftige'/> <priority id='2' name='Normal'/> <author id='66' name='Ansgar Flack'/> <subject> Einigung zwischen Bundesregierung und der EU-Kommission zu den besonderen Ausgleichsregelungen für stromintensive Unternehmen in Nordrhein-Westfalen </subject> <description/> <start_date>2014-05-02</start_date> <due_date/> <done_ratio>0</done_ratio> <estimated_hours/> <custom_fields type='array'> <custom_field id='4' name='Datum'> <value>2014-05-07</value> </custom_field> <custom_field id='10' name='Uhrzeit von'> <value/> </custom_field> <custom_field id='59' name='Top'> <value>3</value> </custom_field> <custom_field id='57' name='hat Abstimmungen'> <value>0</value> </custom_field> <custom_field id='58' name='wir Reden'> <value>0</value> </custom_field> </custom_fields> <created_on>2014-05-02T09:59:01Z</created_on> <updated_on>2014-05-02T09:59:01Z</updated_on> <closed_on/> </issue> <issue> <id>10717</id> <project id='66' name='Plenum'/> <tracker id='14' name='Tagesordnungspunkte'/> <status id='10' name='Zukünftige'/> <priority id='2' name='Normal'/> <author id='66' name='Ansgar Flack'/> <subject> Entwicklungschancen eröffnen, nicht beschränken - Rot-Grüne LEP-Novelle darf Kommunen und Wirtschaft nicht drosseln </subject> <description/> <start_date>2014-05-02</start_date> <due_date/> <done_ratio>0</done_ratio> <estimated_hours/> <custom_fields type='array'> <custom_field id='4' name='Datum'> <value>2014-05-07</value> </custom_field> <custom_field id='10' name='Uhrzeit von'> <value/> </custom_field> <custom_field id='59' name='Top'> <value>4</value> </custom_field> <custom_field id='57' name='hat Abstimmungen'> <value>0</value> </custom_field> <custom_field id='58' name='wir Reden'> <value>0</value> </custom_field> </custom_fields> <created_on>2014-05-02T09:59:26Z</created_on> <updated_on>2014-05-02T09:59:26Z</updated_on> <closed_on/> </issue> <issue> <id>10718</id> <project id='66' name='Plenum'/> <tracker id='14' name='Tagesordnungspunkte'/> <status id='10' name='Zukünftige'/> <priority id='2' name='Normal'/> <author id='66' name='Ansgar Flack'/> <subject> Moratorium jetzt: Landesregierung muss ihren missglückten Entwurf einer Novelle des Landesentwicklungsplans sofort zurückziehen! </subject> <description/> <start_date>2014-05-02</start_date> <due_date/> <done_ratio>0</done_ratio> <estimated_hours/> <custom_fields type='array'> <custom_field id='4' name='Datum'> <value>2014-05-07</value> </custom_field> <custom_field id='10' name='Uhrzeit von'> <value/> </custom_field> <custom_field id='59' name='Top'> <value>5</value> </custom_field> <custom_field id='57' name='hat Abstimmungen'> <value>0</value> </custom_field> <custom_field id='58' name='wir Reden'> <value>0</value> </custom_field> </custom_fields> <created_on>2014-05-02T10:00:19Z</created_on> <updated_on>2014-05-02T10:00:19Z</updated_on> <closed_on/> </issue> <issue> <id>10719</id> <project id='66' name='Plenum'/> <tracker id='14' name='Tagesordnungspunkte'/> <status id='10' name='Zukünftige'/> <priority id='2' name='Normal'/> <author id='66' name='Ansgar Flack'/> <subject> Wie geht es weiter mit dem Braunkohlentagesbau in Nordrhein-Westfalen? - Landesregierung muss endlich Antworten geben </subject> <description/> <start_date>2014-05-02</start_date> <due_date/> <done_ratio>0</done_ratio> <estimated_hours/> <custom_fields type='array'> <custom_field id='4' name='Datum'> <value>2014-05-07</value> </custom_field> <custom_field id='10' name='Uhrzeit von'> <value/> </custom_field> <custom_field id='59' name='Top'> <value>6</value> </custom_field> <custom_field id='57' name='hat Abstimmungen'> <value>0</value> </custom_field> <custom_field id='58' name='wir Reden'> <value>0</value> </custom_field> </custom_fields> <created_on>2014-05-02T10:00:59Z</created_on> <updated_on>2014-05-02T10:00:59Z</updated_on> <closed_on/> </issue> <issue> <id>10720</id> <project id='66' name='Plenum'/> <tracker id='14' name='Tagesordnungspunkte'/> <status id='10' name='Zukünftige'/> <priority id='2' name='Normal'/> <author id='66' name='Ansgar Flack'/> <subject> Zeitgemäße Evaluierungskultur für Wirtschaftsförderprogramme aufbauen - Wirksamkeit und Transparenz sicherstellen </subject> <description/> <start_date>2014-05-02</start_date> <due_date/> <done_ratio>0</done_ratio> <estimated_hours/> <custom_fields type='array'> <custom_field id='4' name='Datum'> <value>2014-05-07</value> </custom_field> <custom_field id='10' name='Uhrzeit von'> <value/> </custom_field> <custom_field id='59' name='Top'> <value>7</value> </custom_field> <custom_field id='57' name='hat Abstimmungen'> <value>0</value> </custom_field> <custom_field id='58' name='wir Reden'> <value>0</value> </custom_field> </custom_fields> <created_on>2014-05-02T10:01:47Z</created_on> <updated_on>2014-05-02T10:01:47Z</updated_on> <closed_on/> </issue> <issue> <id>10721</id> <project id='66' name='Plenum'/> <tracker id='14' name='Tagesordnungspunkte'/> <status id='10' name='Zukünftige'/> <priority id='2' name='Normal'/> <author id='66' name='Ansgar Flack'/> <subject> Breitbandausbau beschleunigen - Landesregierung muss Operationelles Programm EFRE für flächendeckenden Breitbandausbau öffnen! </subject> <description/> <start_date>2014-05-02</start_date> <due_date/> <done_ratio>0</done_ratio> <estimated_hours/> <custom_fields type='array'> <custom_field id='4' name='Datum'> <value>2014-05-07</value> </custom_field> <custom_field id='10' name='Uhrzeit von'> <value/> </custom_field> <custom_field id='59' name='Top'> <value>8</value> </custom_field> <custom_field id='57' name='hat Abstimmungen'> <value>0</value> </custom_field> <custom_field id='58' name='wir Reden'> <value>0</value> </custom_field> </custom_fields> <created_on>2014-05-02T10:02:29Z</created_on> <updated_on>2014-05-02T10:02:29Z</updated_on> <closed_on/> </issue> <issue> <id>10722</id> <project id='66' name='Plenum'/> <tracker id='14' name='Tagesordnungspunkte'/> <status id='10' name='Zukünftige'/> <priority id='2' name='Normal'/> <author id='66' name='Ansgar Flack'/> <subject> Erstes Gesetz zur Änderung des Gesetzes über Immobilien- und Standortgemeinschaften </subject> <description/> <start_date>2014-05-02</start_date> <due_date/> <done_ratio>0</done_ratio> <estimated_hours/> <custom_fields type='array'> <custom_field id='4' name='Datum'> <value>2014-05-07</value> </custom_field> <custom_field id='10' name='Uhrzeit von'> <value/> </custom_field> <custom_field id='59' name='Top'> <value>9</value> </custom_field> <custom_field id='57' name='hat Abstimmungen'> <value>0</value> </custom_field> <custom_field id='58' name='wir Reden'> <value>0</value> </custom_field> </custom_fields> <created_on>2014-05-02T10:03:17Z</created_on> <updated_on>2014-05-02T10:03:17Z</updated_on> <closed_on/> </issue> </issues>");
		}
		else
		{
			try {
				String tmp = this.redmineURL+"getfromredmine.php?anfrage="+URL.encodeQueryString("projects/plenum/issues.xml?f[]=relates&f[]=&group_by=&op[relates]==&op[status_id]=o&set_filter=1&utf8=✓&v[relates][]="+issueID);
				myDebugger("Debug", "hole von redmine "+tmp);
				new RequestBuilder(RequestBuilder.GET, tmp).sendRequest("", new RequestCallback()
					{
					  @Override
					  public void onResponseReceived(Request req, Response resp) {
						  myDebugger("Debug", "Antwort bekommen "+resp.getText());
						 globalSitzungen.sitzungenNachTicketId.get(globalSitzungen.selectedSitzung).tagesordnung.update(resp.getText());
					 }

					  @Override
					  public void onError(Request res, Throwable throwable) {
					    // handle errors
						  myDebugger("Error","Fehler bei der Antwort zu getSitzungen()");
					  }

					});
			} catch (RequestException e) {
				// TODO Auto-generated catch block
				  myDebugger("Exception","Fehler bei der Antwort zu getSitzungen()");
			}
		}		
	}
		
	public void getSitzungen ()
	{
		myDebugger("Debug", "Hole alle Sitzungen");

		if (this.fake)
		{
			globalSitzungen.update("<issues total_count='3' offset='0' limit='25' type='array'> <issue> <id>10677</id> <project id='66' name='Plenum'/> <tracker id='15' name='Sitzung'/> <status id='10' name='Zukünftige'/> <priority id='2' name='Normal'/> <author id='66' name='Ansgar Flack'/> <subject>UA17.1 'Klimaschutzplan' 6. Sitzung</subject> <description/> <start_date>2014-04-30</start_date> <due_date/> <done_ratio>0</done_ratio> <estimated_hours/> <custom_fields type='array'> <custom_field id='4' name='Datum'> <value>2014-05-05</value> </custom_field> <custom_field id='12' name='Ort'> <value>E1 - D05</value> </custom_field> <custom_field id='10' name='Uhrzeit von'> <value>11:00</value> </custom_field> <custom_field id='11' name='Uhrzeit bis'> <value>13:00</value> </custom_field> </custom_fields> <created_on>2014-04-30T13:26:41Z</created_on> <updated_on>2014-05-02T09:25:36Z</updated_on> <closed_on/> </issue> <issue> <id>10680</id> <project id='66' name='Plenum'/> <tracker id='15' name='Sitzung'/> <status id='10' name='Zukünftige'/> <priority id='2' name='Normal'/> <author id='66' name='Ansgar Flack'/> <subject> A17 'Klimaschutz, Umwelt, Naturschutz, Landwirtschaft und Verbraucherschutz' 29. Sitzung </subject> <description/> <start_date>2014-04-30</start_date> <due_date/> <done_ratio>0</done_ratio> <estimated_hours/> <custom_fields type='array'> <custom_field id='4' name='Datum'> <value>2014-05-07</value> </custom_field> <custom_field id='12' name='Ort'> <value>E1 - D05</value> </custom_field> <custom_field id='10' name='Uhrzeit von'> <value>15:30</value> </custom_field> <custom_field id='11' name='Uhrzeit bis'> <value/> </custom_field> </custom_fields> <created_on>2014-04-30T13:34:13Z</created_on> <updated_on>2014-04-30T13:34:13Z</updated_on> <closed_on/> </issue> <issue> <id>10712</id> <project id='66' name='Plenum'/> <tracker id='15' name='Sitzung'/> <status id='1' name='Neu'/> <priority id='2' name='Normal'/> <author id='66' name='Ansgar Flack'/> <subject> A18 'Wirtschaft, Energie, Industrie, Mittelstand und Handwerk' 36. Sitzung </subject> <description/> <start_date>2014-05-02</start_date> <due_date/> <done_ratio>0</done_ratio> <estimated_hours/> <custom_fields type='array'> <custom_field id='4' name='Datum'> <value>2014-05-07</value> </custom_field> <custom_field id='12' name='Ort'> <value>E1 - D05</value> </custom_field> <custom_field id='10' name='Uhrzeit von'> <value>10:00</value> </custom_field> <custom_field id='11' name='Uhrzeit bis'> <value>14:00</value> </custom_field> </custom_fields> <created_on>2014-05-02T09:26:31Z</created_on> <updated_on>2014-05-02T09:26:31Z</updated_on> <closed_on/> </issue> </issues>");
		}
		else
		{
			try {
				String tmp = this.redmineURL+"getfromredmine.php?anfrage="+URL.encodeQueryString("issues.xml?project_id=Plenum&tracker_id=15&status_id=open&sort=cf_4:desc");
				myDebugger("Debug", "hole von redmine "+tmp);
				new RequestBuilder(RequestBuilder.GET, tmp).sendRequest("", new RequestCallback()
					{
					  @Override
					  public void onResponseReceived(Request req, Response resp) {
						  myDebugger("Debug", "Antwort bekommen "+resp.getText());
						  globalSitzungen.update(resp.getText());
					 }

					  @Override
					  public void onError(Request res, Throwable throwable) {
					    // handle errors
						  myDebugger("Error","Fehler bei der Antwort zu getSitzungen()");
					  }

					});
			} catch (RequestException e) {
				// TODO Auto-generated catch block
				  myDebugger("Exception","Fehler bei der Antwort zu getSitzungen()");
			}
		}
		
	}
	
	
}
	
	
	


class myIssueClickHandler implements ClickHandler {
	private String id;

	
	public myIssueClickHandler(String ticketID) {
		id = ticketID;
	}
	
	@Override
	public void onClick(ClickEvent event) {

			Window.open("https://redmine.piratenfraktion-nrw.de/issues/"+id, "_blank", ""); // Or open a PopupPanel
		

	}
}

class mySitzungClickHandler implements ClickHandler {
	private String id;

	
	public mySitzungClickHandler(String ticketID) {
		id = ticketID;
	}
	
	@Override
	public void onClick(ClickEvent event) {

			myDebugger("Debug", "Sitzung "+this.id+" ausgewählt");
			globalSitzungen.setSelectedSitzung(id);
			globalRedmineConnector.getTops(id);
		

	}
}



class Tagesordnungspunkt {
	String ticketId;
	String titel;
	String uhrzeitStart;
	String nummer;
	Widget ui;
	
	public Tagesordnungspunkt ()
	{
		this.ticketId = "";
		this.titel = "";
		this.uhrzeitStart = "";
		this.nummer = "";
		this.ui = new Widget();
	}
	

	public Widget getUi()
	{
			Anchor anchor = new Anchor("#"+ticketId); // At this point clicking it won't do a thing
			anchor.addClickHandler(new myIssueClickHandler(ticketId));
			
		    Label labelTitel = new Label(titel);
		    //Label labelRedmineId = new Label(anchor);
		    Label labelDatum = new Label("Startzeit: "+uhrzeitStart);
		    VerticalPanel vpanelSitzung = new VerticalPanel();
		    vpanelSitzung.add(anchor);
		    vpanelSitzung.add(labelTitel);
		    
		    vpanelSitzung.add(labelDatum);
		    
		    FocusPanel fpanelSitzung = new FocusPanel();
		    fpanelSitzung.add(vpanelSitzung);
		    fpanelSitzung.addClickHandler(new mySitzungClickHandler(this.ticketId));
		    
		    
		    
		    DecoratorPanel dpanelSitzung = new DecoratorPanel();
		    dpanelSitzung.add(fpanelSitzung);
			
		    return dpanelSitzung;
		    
		
	}
	
}


class Tagesordnungspunkte
{
	private HashMap<String,Tagesordnungspunkt> topNachTicketId;
	
	public Tagesordnungspunkte()
	{
		topNachTicketId = new HashMap<String,Tagesordnungspunkt>();
	}
	
	public Widget getUi(){
		
	    VerticalPanel vPanelAktuelleSitzungen = new VerticalPanel();
	    vPanelAktuelleSitzungen.setSpacing(10);
	    vPanelAktuelleSitzungen.setWidth("100%");
		
		for (String key : topNachTicketId.keySet()) {
			vPanelAktuelleSitzungen.add(topNachTicketId.get(key).getUi());
		}

		return vPanelAktuelleSitzungen;
		
	}
	
	public void update(String xmlRedmine)
	{
		Document d = XMLParser.parse( xmlRedmine ); // xml - xml data retrieved from server

		int i = 0;  
		
		// Über alle TOPs itterieren
        while (d.getElementsByTagName("issue").item(i) != null)
        {  
	        String tmp_ticketId = "";
        
        	try
        	{
		        com.google.gwt.xml.client.Node sessionNode = d.getElementsByTagName("issue").item(i);  
	
		        com.google.gwt.xml.client.Node trackerNode = ((Element)sessionNode).getElementsByTagName("tracker").item(0);
		        String trackerName = ((Element)trackerNode).getAttribute("name");
		        
		        if (!trackerName.equals("Tagesordnungspunkte"))
		        {
		        	myDebugger("Debug", "Kein tagesordnungspunkt");
		        }
		        else
		        {
			        
		        	String tmp_titel = "";
		        	String tmp_uhrzeitStart = "";
		        	String tmp_nummer = "";
		   	
			             
			        tmp_ticketId = ((Element)sessionNode).getElementsByTagName("id").item(0).getFirstChild().getNodeValue();
			        tmp_titel =  ((Element)sessionNode).getElementsByTagName("subject").item(0).getFirstChild().getNodeValue();
			        
			        int custom_i = 0;
			        while (((Element)sessionNode).getElementsByTagName("custom_field").item(custom_i) != null) {  
			        	
			        	
			        	try
			        	{
			        	
				        	com.google.gwt.xml.client.Node customNode = ((Element)sessionNode).getElementsByTagName("custom_field").item(custom_i);
				        	
				        	String customName = ((Element)customNode).getAttribute("name");
				        	String customValue = ((Element)customNode).getElementsByTagName("value").item(0).getFirstChild().getNodeValue();
				        	
				        	if (customName.equals("Uhrzeit von"))
				        		tmp_uhrzeitStart = customValue;
				        	if (customName.equals("Top"))
				        		tmp_nummer = customValue;
			        	}
			        	catch (Exception e)
			        	{
			        		myDebugger("Exception", "Fehler beim verarbeiten der custom fields von Ticket "+tmp_ticketId);
			        	}
			        	
			        	custom_i++;
			        }
			        
			        Tagesordnungspunkt tmp_top = new Tagesordnungspunkt();
			        tmp_top.titel = tmp_titel;
			        tmp_top.ticketId = tmp_ticketId;
			        tmp_top.nummer = tmp_nummer;
			        tmp_top.uhrzeitStart = tmp_uhrzeitStart;
	
			        topNachTicketId.put(tmp_ticketId, tmp_top);
		        }
        	} // Ende try blokc
	        catch (Exception e)
        	{
        		myDebugger("Exception", "Fehler beim verarbeiten der custom fields von Ticket "+tmp_ticketId);
        	} // Ende catch block
    	
	        i++;
	        }
	        globalTopSPanel.clear();
	        globalTopSPanel.add(getUi());

        }  
 	
} //Ende Klasse

class Sitzung {
	String ort;
	String datum;
	String ticketId;
	String titel;
	String uhrzeitStart;
	String uhrzeitEnde;
	Widget ui;
	String stand;
	Tagesordnungspunkte tagesordnung;
	
	public Sitzung() {
		ort = "";
		datum="";
		ticketId ="";
		uhrzeitStart="";
		uhrzeitEnde="";
		ui = null;
		titel = "";
		stand ="";
		tagesordnung = new Tagesordnungspunkte();
	}

	public Widget getUi() {
		if (ui != null)
		{
			return ui;
		}
		else
		{
			Anchor anchor = new Anchor("#"+ticketId); // At this point clicking it won't do a thing
			anchor.addClickHandler(new myIssueClickHandler(ticketId));
			
		    Label labelTitel = new Label(titel);
		    //Label labelRedmineId = new Label(anchor);
		    Label labelOrt = new Label(ort);
		    Label labelDatum = new Label(datum+" "+uhrzeitStart+"-"+uhrzeitEnde);
		    VerticalPanel vpanelSitzung = new VerticalPanel();
		    vpanelSitzung.add(anchor);
		    vpanelSitzung.add(labelTitel);
		    vpanelSitzung.add(labelOrt);
		    vpanelSitzung.add(labelDatum);
		    
		    FocusPanel fpanelSitzung = new FocusPanel();
		    fpanelSitzung.add(vpanelSitzung);
		    fpanelSitzung.addClickHandler(new mySitzungClickHandler(this.ticketId));
		    
		    
		    
		    DecoratorPanel dpanelSitzung = new DecoratorPanel();
		    dpanelSitzung.add(fpanelSitzung);
			
		    return dpanelSitzung;
		    
		}
		
		
	}
	
} // Class Sitzung

class Sitzungen
{
	
	private HashMap<String,Sitzung> sitzungenNachTicketId; 
	private String selectedSitzung;
	
	public String getSelectedSitzung()
	{
		return selectedSitzung;
	}
	
	public void setSelectedSitzung(String issueID)
	{
		selectedSitzung = issueID;
	}
	
	public Sitzungen()
	{
		sitzungenNachTicketId = new HashMap<String,Sitzung>();
		selectedSitzung = "";
	}
	
	
	public Widget getUi(){
		
	    VerticalPanel vPanelAktuelleSitzungen = new VerticalPanel();
	    vPanelAktuelleSitzungen.setSpacing(10);
	    vPanelAktuelleSitzungen.setWidth("100%");
		
		for (String key : sitzungenNachTicketId.keySet()) {
			vPanelAktuelleSitzungen.add(sitzungenNachTicketId.get(key).getUi());
		}

		return vPanelAktuelleSitzungen;
		
	}
	
	
	public void update(String xmlRedmine)
	{
		Document d = XMLParser.parse( xmlRedmine ); // xml - xml data retrieved from server

		int i = 0;  
		
		// Über alle Sitzungen itterieren
        while (d.getElementsByTagName("issue").item(i) != null) {  
        
	        com.google.gwt.xml.client.Node sessionNode = d.getElementsByTagName("issue").item(i);  

	        String tmp_ticketId = "";
        	String tmp_ort = "";
        	String tmp_datum = "";
        	String tmp_titel = "";
        	String tmp_uhrzeitStart = "";
        	String tmp_uhrzeitEnd = "";
        	String tmp_stand = "";
   	
	             
	        tmp_ticketId = ((Element)sessionNode).getElementsByTagName("id").item(0).getFirstChild().getNodeValue();
	        tmp_titel =  ((Element)sessionNode).getElementsByTagName("subject").item(0).getFirstChild().getNodeValue();
	        
	        int custom_i = 0;
	        while (((Element)sessionNode).getElementsByTagName("custom_field").item(custom_i) != null) {  
	        	
	        	
	        	try
	        	{
	        	
		        	com.google.gwt.xml.client.Node customNode = ((Element)sessionNode).getElementsByTagName("custom_field").item(custom_i);
		        	
		        	String customName = ((Element)customNode).getAttribute("name");
		        	String customValue = ((Element)customNode).getElementsByTagName("value").item(0).getFirstChild().getNodeValue();
		        	
		        	if (customName.equals("Datum"))
		        		tmp_datum = customValue;
		        	if (customName.equals("Ort"))
		        		tmp_ort = customValue;
		        	if (customName.equals("Uhrzeit von"))
		        		tmp_uhrzeitStart = customValue;
		        	if (customName.equals("Uhrzeit bis"))
		        		tmp_uhrzeitEnd = customValue;
	        	}
	        	catch (Exception e)
	        	{
	        		myDebugger("Exception", "Fehler beim verarbeiten der custom fields von Ticket "+tmp_ticketId);
	        	}
	        	
	        	custom_i++;
	        }
	        
	        Sitzung tmp_sitzung = new Sitzung();
	        tmp_sitzung.datum = tmp_datum;
	        tmp_sitzung.ort = tmp_ort;
	        tmp_sitzung.ticketId = tmp_ticketId;
	        tmp_sitzung.uhrzeitStart = tmp_uhrzeitStart;
	        tmp_sitzung.uhrzeitEnde = tmp_uhrzeitEnd;
	        tmp_sitzung.titel = tmp_titel;
	        
	        sitzungenNachTicketId.put(tmp_ticketId, tmp_sitzung);
	        
	        i++;  
        }  
        
        
        globalSitzungenSPanel.clear();
        globalSitzungenSPanel.add(getUi());
        
		
	}
	
}



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
	public Sitzungen globalSitzungen;
	public RedmineConnector globalRedmineConnector;
	public FlexTable globalDebugger;
	public ScrollPanel globalSitzungenSPanel;
	public ScrollPanel globalTopSPanel;
	
	public void init ()
	{
	    globalDebugger = new FlexTable();
	    globalSitzungen = new Sitzungen();
	    globalRedmineConnector = new RedmineConnector("https://abstimmung2.piratenfraktion-nrw.de/",false);
	    globalSitzungenSPanel = new ScrollPanel();
	    globalTopSPanel = new ScrollPanel();
	    
		SplitLayoutPanel splitPanel = new SplitLayoutPanel(8);
	    splitPanel.ensureDebugId("cwSplitLayoutPanel");
	    splitPanel.getElement().getStyle()
	        .setProperty("border", "8px solid #e7e7e7");

	    
	    HorizontalPanel hPanelOben = new HorizontalPanel();
	    hPanelOben.add(new Label("Hallo, Karl Ranseier"));
	    hPanelOben.add(new Button("logout"));
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
	
	    ScrollPanel sPanel = new ScrollPanel();
	    sPanel.add(globalSitzungenSPanel);

        slpLinks.add(sPanel,"Sitzungen",40);
	    slpLinks.add(fPanelFilter,"Filter", 40);
	    
	    ScrollPanel debuggerScroll = new ScrollPanel();
	    debuggerScroll.add(globalDebugger);
	    	    
	    // Add text all around.
	    splitPanel.addNorth(hPanelOben, 50);
	    splitPanel.addSouth(debuggerScroll, 50);
	    splitPanel.addWest(slpLinks, 200);

	    centerText = new Label();
	    centerText.setText("mich sollte man nicht lesen können");
	    ScrollPanel centerScrollable = new ScrollPanel(globalTopSPanel);
	    splitPanel.add(centerScrollable);
		
	    RootLayoutPanel.get().add(splitPanel);

	    globalRedmineConnector.getSitzungen();


	}
	
	
	/** Globale Variablen */
	
	
	public void onModuleLoad() {
		init();
	    
	 /**   
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
	    */
	    
	   /** 
	    try {
			String tmp = "https://redmine.piratenfraktion-nrw.de/issues.xml?project_id=Plenum&tracker_id=15&status_id=open&sort=cf_4";
			new RequestBuilder(RequestBuilder.GET, tmp).sendRequest("", new RequestCallback()
				{
				  @Override
				  public void onResponseReceived(Request req, Response resp) {
				    
					centerText.setText("hab was geladen. Code "+resp.getStatusCode()+" "+resp.getStatusText()+"/n"+resp.getText());
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
	    */
	}
}



