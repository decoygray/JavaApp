import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class guisystem{

	public JFrame frame;
	public JTextField txtEnterNumber;
	public JTable table;
	public List<Playersarray> Calist = new ArrayList<Playersarray>();
	public int xzibit = 1;
	public int totalteams = 4;	
	private JScrollPane scrollPane_1;
	String HName = "bean";
	String Shooting = "0";
	String Skating = "0";
	String Checking = "0";

	/**
	 * Create the application.
	 */
	public guisystem(List<Playersarray> AJT, int num) {
		xzibit = num;
		Calist = AJT;
		initialize();
	}

	
	//default table after parsing
	public void defaulttable(DefaultTableModel mo, int listlength, int innn) {
		int shtotal = 0;
		int sktotal = 0;
		int chtotal = 0;
		
		while ( innn < listlength) {
			HName = Calist.get(innn).name;
			Shooting = Integer.toString(Calist.get(innn).shooting);
			Skating = Integer.toString(Calist.get(innn).skating);
			Checking = Integer.toString(Calist.get(innn).checking);
			mo.addRow(new Object[]{"Waiting List", HName, Shooting, Skating, Checking});
			shtotal = shtotal + Calist.get(innn).shooting;
			sktotal = sktotal + Calist.get(innn).skating;
			chtotal = chtotal + Calist.get(innn).checking;
			innn ++;
		}
		mo.addRow(new Object[]{"", "AVERAGE", Integer.toString(Math.round(shtotal/listlength)), Integer.toString(Math.round(sktotal/listlength)), Integer.toString(Math.round(chtotal/listlength))});
	}
	
	//creates array from input
	
	public void balancer(DefaultTableModel mo, int numberofteams, int numberofplayers) {
		int shtotal = 0;
		int sktotal = 0;
		int chtotal = 0;
		int parsecount = 0;
		//players per team
		int ppt = (numberofplayers-numberofplayers%numberofteams)/numberofteams;
		//player position
		int ppp = 0;
		
		
		//waiting list	
		if (ppp < numberofplayers%numberofteams){
			for(int x = 0; x < numberofplayers%numberofteams; x++){
				HName = Calist.get(x).name;
				Shooting = Integer.toString(Calist.get(x).shooting);
				Skating = Integer.toString(Calist.get(x).skating);
				Checking = Integer.toString(Calist.get(x).checking);
				mo.addRow(new Object[]{"Waiting List", HName, Shooting, Skating, Checking});
				shtotal = shtotal + Calist.get(x).shooting;
				sktotal = sktotal + Calist.get(x).skating;
				chtotal = chtotal + Calist.get(x).checking;
				ppp++;
			}
		mo.addRow(new Object[]{"", "AVERAGE", Integer.toString(Math.round(shtotal/ppp)), Integer.toString(Math.round(sktotal/ppp)), Integer.toString(Math.round(chtotal/ppp))});
		
		}

			shtotal = 0;
			sktotal = 0;
			chtotal = 0;
			parsecount = ppp;

			//creates # of teams
			for (int y =0; y<numberofteams; y++){
				shtotal = 0;
				sktotal = 0;
				chtotal = 0;				
				
				//creates a team's roster
				for(int x=0; x<ppt; x++){

				
				//adds to table
				HName = Calist.get(parsecount+numberofteams*x).name;
				Shooting = Integer.toString(Calist.get(parsecount+numberofteams*x).shooting);
				Skating = Integer.toString(Calist.get(parsecount+numberofteams*x).skating);
				Checking = Integer.toString(Calist.get(parsecount+numberofteams*x).checking);
				mo.addRow(new Object[]{Integer.toString(y+1), HName, Shooting, Skating, Checking});
				shtotal = shtotal + Calist.get(parsecount+numberofteams*x).shooting;
				sktotal = sktotal + Calist.get(parsecount+numberofteams*x).skating;
				chtotal = chtotal + Calist.get(parsecount+numberofteams*x).checking;

				}
			
			//average summary
			mo.addRow(new Object[]{"", "AVERAGE", Integer.toString(Math.round(shtotal/ppt)), Integer.toString(Math.round(sktotal/ppt)), Integer.toString(Math.round(chtotal/ppt))});
			parsecount++;
			}
		

	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.setBounds(50, 60, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//text field
		txtEnterNumber = new JTextField();
		txtEnterNumber.setText("enter # of teams");
		txtEnterNumber.setBounds(551, 67, 103, 20);
		frame.getContentPane().add(txtEnterNumber);
		txtEnterNumber.setColumns(10);
		
		//scroll pane for table
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(22, 35, 478, 584);
		frame.getContentPane().add(scrollPane_1);
	 
		JTable table = new JTable(new DefaultTableModel(new Object[]{"Team #", "Name", "Shooting", "Skating", "Checking"}, 0));
		DefaultTableModel model = (DefaultTableModel) table.getModel();


		defaulttable(model, xzibit, 0);
		scrollPane_1.setViewportView(table);
		
		
		//Enter button
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					totalteams = Integer.parseInt(txtEnterNumber.getText());
					if (totalteams < 0){
						JOptionPane.showMessageDialog(null, "Enter a number greater than 1");
					}
					else{	
						//zero out table
						table.getModel();
						model.setRowCount(0);
						if (totalteams > xzibit){
							defaulttable(model, xzibit, 0);
						}
						else{
							table.getModel();
							model.setRowCount(0);
							balancer(model, totalteams, xzibit);						


						}
					}
					
					}
					catch(Exception e) {
						JOptionPane.showMessageDialog(null, "Enter a number greater than 1");
					}


			}
			
		});
		
		
		//clear button
				
		btnNewButton.setBounds(565, 97, 89, 23);
		frame.getContentPane().add(btnNewButton);
		JButton btnEnter = new JButton("Clear");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.getModel();
				model.setRowCount(0);
				defaulttable(model, xzibit, 0);
			}
			
		});
		btnEnter.setBounds(565, 131, 89, 23);
		frame.getContentPane().add(btnEnter);
		

		}
	
	}

