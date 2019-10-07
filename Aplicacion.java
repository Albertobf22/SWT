package ejercicio;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class Aplicacion {

	protected Shell shell;
	private Text txtUnidades;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Text text;
	private Text txtPrecio;
	private Text txtNewText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Aplicacion window = new Aplicacion();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(985, 563);
		shell.setText("SWT Application");
		
		Composite composite = new Composite(shell, SWT.BORDER);
		composite.setBounds(0, 0, 969, 524);
		
		txtUnidades = new Text(composite, SWT.CENTER);
		txtUnidades.setBackground(SWTResourceManager.getColor(SWT.COLOR_TEXT_DISABLED_BACKGROUND));
		txtUnidades.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		txtUnidades.setText("Unidades");
		txtUnidades.setBounds(94, 41, 138, 34);
		
		text = formToolkit.createText(composite, "New Text", SWT.NONE);
		text.setText("");
		text.setBounds(516, 38, 225, 34);
		
		txtPrecio = new Text(composite, SWT.CENTER);
		txtPrecio.setText("Precio\r\n");
		txtPrecio.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		txtPrecio.setBackground(SWTResourceManager.getColor(SWT.COLOR_TEXT_DISABLED_BACKGROUND));
		txtPrecio.setBounds(94, 131, 138, 34);
		formToolkit.adapt(txtPrecio, true, true);
		
		txtNewText = formToolkit.createText(composite, "New Text", SWT.NONE);
		txtNewText.setText("");
		txtNewText.setBounds(517, 128, 224, 34);
		
		Label lblNewLabel = new Label(composite, SWT.SHADOW_IN | SWT.CENTER);
		Button btnNewButton = formToolkit.createButton(composite, "Calcular", SWT.NONE);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				int c = Integer.parseInt(text.getText());
				double p = Double.parseDouble(txtNewText.getText());
				String total = Double.toString(c*p);
				
				if (c == 0) {
					lblNewLabel.setText("no puede haber 0 cantidades");
				}else {
				lblNewLabel.setText(total);
				}
			}
		});
		btnNewButton.setBounds(267, 231, 200, 41);
		
		
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setBounds(0, 327, 965, 193);
		formToolkit.adapt(lblNewLabel, true, true);
		

	}
}
