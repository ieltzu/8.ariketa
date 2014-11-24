import java.util.Scanner;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;


public class MyTableModel extends AbstractTableModel {
	
	private Vector<String> columnNames = new Vector<String>();
	
	public MyTableModel(){
		hasieratuZutabeIzenak();
		kargatu();
	}
	public void hasieratuZutabeIzenak(){
		columnNames.add("First name");
		columnNames.add("Last name");
		columnNames.add("Sport");
		columnNames.add("# of years");
		columnNames.add("Vegetarian");
	}
	class Lag{
		
		String izena;
		String abizena;
		String kirola;
		Integer tamaina;
		Boolean baiez;
		
		public Lag(String izena, String abizena, String kirola, Integer tamaina, Boolean baiez) {
			super();
			this.izena = izena;
			this.abizena = abizena;
			this.kirola = kirola;
			this.tamaina = tamaina;
			this.baiez = baiez;
		}
		public Object getBalioa(int i) {
			try{
				if (i==0){
					return this.izena;
				}else if(i==1){
					return this.abizena;
				}else if(i==2){
					return this.kirola;
				}else if(i==3){
					return this.tamaina;
				}else if(i==4){
					return this.baiez; 
				}
			}catch(NumberFormatException e){
				System.out.println("sartutako zenbakia ez da egokia");
			}
			return null;
		}
		
		public void insertElementAt(Object value, int i){
			if (i==0){
				this.izena=(String)value;
			}else if(i==1){
				this.abizena=(String)value;
			}else if(i==2){
				this.kirola=(String)value;
			}else if(i==3){
				this.tamaina=(int)value;
			}else if(i==4 ){
				this.baiez=(boolean)value; 
			}
		}
				
	}
	
	private Vector<Lag> data = new Vector<Lag>();
	
	public void kargatu(){
		data.add(new Lag("Kathy","Smith","Snowboarding",5,false));
		data.add(new Lag("John","Doe","Rowing",3,true));
		data.add(new Lag("Sue","Black","Knitting",2,true));
		data.add(new Lag("Jane","White","Speed reading",20,true));
	}
	public int getColumnCount(){
		return columnNames.size();
	}
	public int getRowCount(){
		return data.size();
	}
	public String getColumnName(int col){
		return columnNames.get(col);
	}
	public Object getValueAt(int row, int col){
		return data.get(row).getBalioa(col);
	}
	public Class getColumnClass(int c){
		if (c==0){
			return String.class;
		}else if(c==1){
			return String.class;
		}else if(c==2){
			return String.class;
		}else if(c==3){
			return Integer.class;
		}else if(c==4){
			return Boolean.class; 
		}else {
			return null;
		}
	}
	public boolean isCellEditable(int row, int col){
		//TODO
		return false;
	}
	public void setValueAt(Object value, int row, int col){
		data.get(row).insertElementAt(value, col);
	}

}
