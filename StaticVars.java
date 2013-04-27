/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor;

import emt.evexmodel.EvexModel;
import emt.tutor.studentmodel.*;
import emt.tutor.studentmodel.StudentModel;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;

/**
 *
 * @author David
 */
public class StaticVars {
    public static String PROJECTROOTPATH="";
    public static boolean TUTORSON=true;
    
    public static void Log(String eventType, String ... parameters) {
        try {
            FileWriter fstream = new FileWriter(PROJECTROOTPATH + File.separator + "softwareLog.csv",true);
            BufferedWriter out = new BufferedWriter(fstream);
            
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            String outputString=eventType+"	"+sdf.format(cal.getTime())+"	";
            for(String s : parameters) {
                outputString=outputString+s+"	";
            }
            out.write(outputString.substring(0,outputString.length()-1));
            out.newLine();
            out.close();
            fstream.close();
        } catch(Exception ex) {}
    }
    
    public static ArrayList<String> usedActions=new ArrayList<String>();
    public static void loadUsedActions() {
        try {
            FileInputStream reader=new FileInputStream(PROJECTROOTPATH + File.separator + "StudentModels" + File.separator + "actions.xml");
            XMLDecoder decoder=new XMLDecoder(reader);
            usedActions=(ArrayList<String>)decoder.readObject();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
    public static void saveUsedActions() {
        new File(PROJECTROOTPATH + File.separator + "StudentModels").mkdir();
        String modelPath=PROJECTROOTPATH + File.separator + "StudentModels" + File.separator;
        new File(modelPath).mkdir();
        try {
            FileOutputStream save = new FileOutputStream(modelPath + "actions.xml");
            XMLEncoder encoder=new XMLEncoder(save);
            encoder.writeObject(usedActions);
            encoder.close();
        } catch(Exception ex) {
            System.out.println("Used actions save failed.");
            System.out.println(ex.getMessage());
        }
    }
    
    public static StudentModel previousEcologyModel;
    public static StudentModel previousInquiryModel;
    public static StudentModel previousModelingModel;
    public static StudentModel currentEcologyModel;
    public static StudentModel currentInquiryModel;
    public static StudentModel currentModelingModel;
    
    public static void initializeNewStudentModels() {
        previousEcologyModel=new StudentModel(new EcologyTargetModel());
        previousInquiryModel=new StudentModel(new InquiryTargetModel());
        previousModelingModel=new StudentModel(new ModelingTargetModel());
        currentEcologyModel=new StudentModel(new EcologyTargetModel());
        currentInquiryModel=new StudentModel(new InquiryTargetModel());
        currentModelingModel=new StudentModel(new ModelingTargetModel());
    }
    public static void loadPreviousStudentModels() {
        loadStudentModel(previousEcologyModel,currentEcologyModel,"Ecology");
        loadStudentModel(previousInquiryModel,currentInquiryModel,"Inquiry");
        loadStudentModel(previousModelingModel,currentModelingModel,"Modeling");
    }
    public static void saveStudentModels() {
        saveStudentModel(currentEcologyModel,"Ecology");
        saveStudentModel(currentInquiryModel,"Inquiry");
        saveStudentModel(currentModelingModel,"Modeling");
    }
    private static void saveStudentModel(StudentModel model, String type) {
        new File(PROJECTROOTPATH + File.separator + "StudentModels").mkdir();
        String modelPath=PROJECTROOTPATH + File.separator + "StudentModels" + File.separator + type;
        new File(modelPath).mkdir();
        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            FileOutputStream save = new FileOutputStream(modelPath + File.separator + type + "_" + sdf.format(cal.getTime())+".xml");
            XMLEncoder encoder=new XMLEncoder(save);
            encoder.writeObject(model);
            encoder.close();
        } catch(Exception ex) {
            System.out.println("Student model save failed.");
            System.out.println(ex.getMessage());
        }
    }
    private static void loadStudentModel(StudentModel previousModel,StudentModel currentModel,String type) {
        String modelPath=PROJECTROOTPATH + File.separator + "StudentModels" + File.separator + type + File.separator;
        try {
            File f=new File(modelPath);
            ArrayList<String> files=new ArrayList(Arrays.asList(f.list()));
            Collections.sort(files);
            
            /*if(files.get(files.size()-1).equals("model.xml")) { //was created with EMT 1.9 or earlier
                Calendar cal = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                String newName = "model-"+sdf.format(cal.getTime())+".xml";
                new File(projectRootPath + File.separator + model + File.separator + files.get(files.size()-1)).renameTo(new File(projectRootPath + File.separator + model + File.separator + newName));
                
                f=new File(projectRootPath + File.separator + model + File.separator);
                files=new ArrayList(Arrays.asList(f.list(new ModelFilter())));
                Collections.sort(files);
            }*/
            if(files.size()>0) {
                FileInputStream reader=new FileInputStream(modelPath + files.get(files.size()-1));
                XMLDecoder decoder=new XMLDecoder(reader);
                previousModel=(StudentModel)decoder.readObject();
                decoder.close();
                reader.close();
                FileInputStream reader2=new FileInputStream(modelPath + files.get(files.size()-1));
                XMLDecoder decoder2=new XMLDecoder(reader2);
                currentModel=(StudentModel)decoder2.readObject();
                decoder2.close();
                reader2.close();
            } else {
                System.out.println("No student models found.");
                initializeNewStudentModels();
            }
        
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
    
}
