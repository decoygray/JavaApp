import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.awt.EventQueue;



public class Main {

	
	public static void main(String[] args) {

	
		//access Json list
		Jlist Totallist = new Jlist();
				

		//create array of objects from json
		List<Playersarray> HockeyList = new ArrayList<Playersarray>(Totallist.GetLength());
		for (int i = 0; i <Totallist.GetLength(); i++){
			Playersarray f = new Playersarray(Totallist.arr1[i][1] +" " + Totallist.arr1[i][2], Totallist.arr1[i][3], Totallist.arr1[i][4], Totallist.arr1[i][5]);
		    HockeyList.add(f);
						
		}

		//bubble sort
		for(int j=0;j<HockeyList.size();j++){
			   for(int i=j+1;i<HockeyList.size();i++){
			
				   if((HockeyList.get(i).stat) < HockeyList.get(j).stat){
					   Playersarray lindros = HockeyList.get(j);
					   	HockeyList.set( j, HockeyList.get(i));
					   	HockeyList.set(i, lindros);
			
			                }
			
			            }
		}
		

//calls gui
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					guisystem window = new guisystem(HockeyList, Totallist.GetLength());
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

		
//Json parse attempt		
		
		/*
		try{ 
		byte[] jsonData = Files.readAllBytes(Paths.get("C:\\Users\\Edward\\git\\squad-maker\\players.json"));
		}
		catch(Exception e){
			System.out.println("error");
		}
		*/

		
		
	}
	}


