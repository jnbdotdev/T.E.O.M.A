package backend;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;

public class Person {

	String name;
	double stature;
	int age;
	int power;
	int mana;
	String ppower;
	String patack;
	String pat;
	String type;
	String rarity;
	int mlevel;
	public static String directory = "";
	
	public Person(String name, double stature, int age, int power, int mana, String ppower, String patack, String pat, String type, String rarity, int mlevel) {
		this.name = name;
		this.stature = stature;
		this.age = age;
		this.power = power;
		this.mana = mana;
		this.ppower = ppower;
		this.patack = patack;
		this.pat = pat;
		this.type = type;
		this.rarity = rarity;
		this.mlevel = mlevel;
	}
	
	public Person() {
		
	}
	
	public String getName() {
		return name;
	}
	public double getStature() {
		return stature;
	}
	public int getAge() {
		return age;
	}
	public int getPower() {
		return power;
	}
	public int getMana() {
		return mana;
	}
	public String getPpower() {
		return ppower;
	}
	public String getPatack() {
		return patack;
	}
	public String getPat() {
		return pat;
	}
	public String getType() {
		return type;
	}
	public String getRarity() {
		return rarity;
	}
	public int getMlevel() {
		return mlevel;
	}
	public String getDirectory() {
		return directory;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setStature(double stature) {
		this.stature = stature;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public void setMana(int mana) {
		this.mana = mana;
	}
	public void setPpower(String ppower) {
		this.ppower = ppower;
	}
	public void setPatack(String patack) {
		this.patack = patack;
	}
	public void setPat(String pat) {
		this.pat = pat;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	public void setMlevel(int mlevel) {
		this.mlevel = mlevel;
	}
	public void setDirectory(String directory) {
		Person.directory = directory;
	}

	public void savePerson() {
		
		try {
			File arquivo;
			arquivo = new File(Person.directory+this.name+".txt");
			FileOutputStream fos = new FileOutputStream(arquivo);
			
			String content = this.name + "\n" + 
							 this.stature + "\n" + 
							 this.age + "\n" + 
							 this.power + "\n" + 
							 this.mana + "\n" + 
							 this.ppower + "\n" + 
							 this.patack + "\n" + 
							 this.pat + "\n" + 
							 this.type + "\n" + 
							 this.rarity + "\n" + 
							 this.mlevel;
			
			fos.write(content.getBytes());
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String showPerson(String person_name, String path) {
		String data = "";
		try {
			File arquivo;
			arquivo = new File(path+person_name+".txt");
			FileInputStream fis = new FileInputStream(arquivo);
			int ln;
			while((ln = fis.read()) != -1) {
				data = data + ((char)ln);
			}
			
			fis.close();
		} catch (Exception es) {
			es.printStackTrace();
		}
		
		return data;
	}
	
	public String reviewFiles(String filePath){
		
		String allFiles = "";
		
		File file = new File(filePath);
		File[] archives = file.listFiles();
		
		for (File fileTxt : archives) {
			if(fileTxt.getName().endsWith(".txt")) {
				allFiles = fileTxt.getName().replaceAll(".txt", "");
			}
		}
		
		return allFiles;
	}
	
	public DefaultListModel<String> reviewFiles2(String filePath){
		
		String allFiles = "";
		
		File file = new File(filePath);
		File[] archives = file.listFiles();
		DefaultListModel<String> modelList = new DefaultListModel<String>();
		
		for (File fileTxt : archives) {
			if(fileTxt.getName().endsWith(".txt")) {
				allFiles = fileTxt.getName().replaceAll(".txt", "");
				modelList.addElement(allFiles);
			}
		}
		
		return modelList;
	}
	
	public int countFiles(String filePath){
		
		int count = 0;
		
		File file = new File(filePath);
		File[] archives = file.listFiles();
		
		for (File fileTxt : archives) {
			if(fileTxt.getName().endsWith(".txt")) {
				count++;
			}
		}
		
		return count;
	}
	
	public String fileFinder() {
		
		String baseDirectory = System.getProperty("user.home")+"/Downloads";
		File dir = new File(baseDirectory);
		
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(dir);
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		String filePath = "";
		
		int openFile = chooser.showOpenDialog(null);
		if(openFile == JFileChooser.APPROVE_OPTION) {
			filePath = chooser.getSelectedFile().getAbsolutePath();
		}
		
		return filePath;
	}
	
}
