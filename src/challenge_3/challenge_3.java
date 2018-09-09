package challenge_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class challenge_3 {
    private static ArrayList<Darzelis> darzeliai = new ArrayList();
    private static ArrayList<Languages> kalbos = new ArrayList();
    private static Darzelis min, max;
    
    public static void main(String[] args) {
        try {
        inputFromFile();
        findMinAndMaxOfChildCount();
        System.out.println("Maziausias vaiku kiekis darzelyje: " + min.getChilds_count());
        System.out.println("Didziausias vaiku kiekis darzelyje: " + max.getChilds_count());
        System.out.println(formingStrangeWords(min));
        System.out.println(formingStrangeWords(max));
        
        calculatingMostFreeLanguage();
        groupAndSort();
        //outputToFile();
        }catch (Exception e) {
            whoops (e);
        }
    }
    public static void whoops (Exception w) {
        System.out.println("error: " + w.getMessage());
    }
    
    public static void inputFromFile() throws Exception {
        Scanner sc = new Scanner(new File("info.csv"));
        String eilute;
        int darz_id;
        String school_name;
        int type_id;
        String type_label;
        int lan_id;
        String lan_label;
        int childs_count;
        int free_space;
        String cvsSplitBy = ";";
        eilute = sc.nextLine(); //first line is not needed because it is just headers 
        while (sc.hasNext()) {
            eilute = sc.nextLine();
            String[] line = eilute.split(cvsSplitBy);
            darz_id = 	Integer.parseInt(line[0]);
            school_name = line[1];
            type_id = Integer.parseInt(line[2]);
            type_label = line[3];
            lan_id = Integer.parseInt(line[4]);
            lan_label = line[5];
            childs_count = Integer.parseInt(line[6]);
	        free_space = Integer.parseInt(line[7]);
            Darzelis a = new Darzelis(darz_id,school_name,type_id,type_label,  lan_id,  lan_label,childs_count,  free_space);
            darzeliai.add(a);
            }
        sc.close();
        }   
    
    public static void findMinAndMaxOfChildCount() {
    	int mini=10000, maxi=-1;
        for (int i=0; i<darzeliai.size(); i++){
        	if(darzeliai.get(i).getChilds_count()<mini) {
        		min=darzeliai.get(i);
        		mini=darzeliai.get(i).getChilds_count();
        	}	
        	if(darzeliai.get(i).getChilds_count()>maxi) {
        		max=darzeliai.get(i);
        		maxi=darzeliai.get(i).getChilds_count();
        	}
        }
    }
    
    public static String formingStrangeWords(Darzelis darz) {
        String result = null; 
        result=darz.getSchool_name().substring(0,3)+'_';
        result+=darz.getType_label().substring(5,6)+'-'+darz.getType_label().substring(7,8)+'_';
        result+=darz.getLan_label().substring(0,4);
        return result; 
    }
    
    public static void calculatingMostFreeLanguage() {
        for(int i=0; i<darzeliai.size(); i++) {
        	boolean needstobeadded=true;
        	for (int j=0; j<kalbos.size();j++){
        		if(darzeliai.get(i).getLan_id()==kalbos.get(j).getLan_id()) {
        			kalbos.get(j).setChilds_count(kalbos.get(j).getChilds_count()+darzeliai.get(i).getChilds_count());
        			kalbos.get(j).setFree_space(kalbos.get(j).getFree_space()+darzeliai.get(i).getFree_space());
        			needstobeadded=false;
        		}
        	}
        	if(needstobeadded) {
        		Languages l = new Languages(darzeliai.get(i).getLan_id(),darzeliai.get(i).getLan_label(),darzeliai.get(i).getChilds_count(),darzeliai.get(i).getFree_space());
        		kalbos.add(l);
        	}
        }
        for(int i=0; i<kalbos.size(); i++) {
        	if(kalbos.get(i).getFree_space()!=0||kalbos.get(i).getChilds_count()!=0)
        	kalbos.get(i).setFree_space_percentages(kalbos.get(i).getFree_space()*100.0/(kalbos.get(i).getChilds_count()*1.0+kalbos.get(i).getFree_space()*1.0));
        System.out.println(kalbos.get(i).getFree_space_percentages());
        }
    }
    
    public static void groupAndSort() {
    }
    
    public static void outputToFiles() throws Exception {
    	BufferedWriter outputStream = null;
    	PrintWriter writer1 = new PrintWriter("First.txt", "UTF-8");
    }
    
    /*
    public static void outputToScreen() {
        for (int i=0; i<kuriniai.size(); i++){
            System.out.println(kuriniai.get(i).toStrangeString());
        }
    }
    
    
    public static void outputToFile() throws Exception {
        BufferedWriter outputStream = null;      
        //outputStream = new BufferedWriter(new FileWriter("KnygelesBetJauMaziau.txt"));
        PrintWriter writer = new PrintWriter("KnygelesBetJauMaziau.txt", "UTF-8");
        int vidurkis;
        for (int i=0; i<kuriniai.size(); i++){
            if (kuriniai.get(i).getLmetai() > vidurkis) {
                if (!kuriniai.get(i).getPavarde().equals(kuriniai.get(i-1).getPavarde())) {
                    writer.println(" ");
                    writer.print(kuriniai.get(i).getVardas()+" "+kuriniai.get(i).getPavarde()+": ");
                }
                else {
                    writer.print(", ");
                }
                writer.print(" \""+kuriniai.get(i).getKpav()+"\" "+kuriniai.get(i).getLmetai());
                }
            }
        writer.close();
    }
    
    /*
    public static void sorter() {
        Collections.sort(kuriniai, new Comparator<Kurinys>(){
        @Override
        public int compare (Kurinys k1, Kurinys k2){
            if(k1.getLmetai() == k2.getLmetai()) {
                return k1.getVardas().compareTo(k2.getVardas());
            }
            return k1.getLmetai() -(k2.getLmetai());
        }
        });
    }
    */
}
