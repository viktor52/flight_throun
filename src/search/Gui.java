package search;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import search.SearchFlight;
import search.SelectFlight;
import java.util.Date;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;

public class Gui {

	SearchFlight SearchFlight = new SearchFlight();
	protected Shell shlVelduLeitarSkilyri;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	boolean b = false;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Gui window = new Gui();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlVelduLeitarSkilyri.open();
		shlVelduLeitarSkilyri.layout();
		while (!shlVelduLeitarSkilyri.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		
		shlVelduLeitarSkilyri = new Shell();
		shlVelduLeitarSkilyri.setSize(450, 300);
		shlVelduLeitarSkilyri.setText("Search");
		
		
		DateTime dateOut = new DateTime(shlVelduLeitarSkilyri, SWT.BORDER);
		dateOut.setBounds(27, 30, 85, 27);
		
		DateTime dateHome = new DateTime(shlVelduLeitarSkilyri, SWT.BORDER);
		dateHome.setEnabled(false);
		dateHome.setBounds(185, 30, 85, 27);
		
		Button btnRoundTrip = new Button(shlVelduLeitarSkilyri, SWT.CHECK);
		btnRoundTrip.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dateHome.setEnabled(true);
				if(!btnRoundTrip.getSelection()){
					dateHome.setEnabled(false);
				}
			}
		});
		btnRoundTrip.setBounds(310, 30, 95, 18);
		btnRoundTrip.setText("Round Trip");
		
		Label lblFarat = new Label(shlVelduLeitarSkilyri, SWT.NONE);
		lblFarat.setBounds(27, 10, 60, 14);
		lblFarat.setText("fara út");
		
		Label lblKoma = new Label(shlVelduLeitarSkilyri, SWT.NONE);
		lblKoma.setBounds(185, 10, 60, 14);
		lblKoma.setText("koma");
		
		CCombo Adults = new CCombo(shlVelduLeitarSkilyri, SWT.BORDER);
		Adults.setListVisible(true);
		Adults.setItems(new String[] {"1", "2", "3", "4", "5", "6"});
		Adults.setBounds(27, 145, 77, 18);
		
		Label lblFullornir = new Label(shlVelduLeitarSkilyri, SWT.NONE);
		lblFullornir.setBounds(27, 125, 60, 14);
		lblFullornir.setText("Fullorðnir");
		
		Label lblBrn = new Label(shlVelduLeitarSkilyri, SWT.NONE);
		lblBrn.setBounds(197, 127, 60, 14);
		lblBrn.setText("Börn");
		
		CCombo Children = new CCombo(shlVelduLeitarSkilyri, SWT.BORDER);
		Children.setListVisible(true);
		Children.setItems(new String[] {"1", "2", "3", "4", "5", "6"});
		Children.setBounds(193, 147, 77, 16);
		
		Label lblSmbrn = new Label(shlVelduLeitarSkilyri, SWT.NONE);
		lblSmbrn.setBounds(27, 178, 60, 14);
		lblSmbrn.setText("Smábörn");
		
		CCombo infants = new CCombo(shlVelduLeitarSkilyri, SWT.BORDER);
		infants.setListVisible(true);
		infants.setItems(new String[] {"1", "2", "3", "4", "5", "6"});
		infants.setBounds(27, 198, 77, 18);
		
		Label lblFr = new Label(shlVelduLeitarSkilyri, SWT.NONE);
		lblFr.setBounds(27, 73, 60, 14);
		lblFr.setText("Frá");
		
		Label lblTil = new Label(shlVelduLeitarSkilyri, SWT.NONE);
		lblTil.setBounds(185, 73, 60, 14);
		lblTil.setText("Til");
		
		CCombo From = new CCombo(shlVelduLeitarSkilyri, SWT.BORDER);
		From.setBounds(27, 93, 77, 18);
		
		CCombo To = new CCombo(shlVelduLeitarSkilyri, SWT.BORDER);
		To.setBounds(185, 91, 85, 18);
		
		Button btnSearch = new Button(shlVelduLeitarSkilyri, SWT.NONE);
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				int adult = Adults.getSelectionIndex()+1;
				int child = Children.getSelectionIndex()+1;
				int count = adult+child;
				DateTime out = dateOut;
				DateTime home = dateHome;
				String s = SearchFlight.searchDep();
				String c = SearchFlight.searchRet();
				SelectFlight.selectFlight(s, c);

			}
		});
		btnSearch.setBounds(299, 240, 95, 28);
		btnSearch.setText("Leita");
		
	}
}