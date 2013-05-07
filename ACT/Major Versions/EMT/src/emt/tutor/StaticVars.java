/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import emt.evexmodel.EvexModel;
import emt.tutor.studentmodel.*;
import emt.tutor.studentmodel.EcologyModel;
import emt.tutor.studentmodel.ModelingModel;
import emt.tutor.studentmodel.InquiryModel;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author David
 */
public class StaticVars {
    public static String PROJECTROOTPATH="";
    public static boolean PROJECTOPENED=false;
    public static boolean TUTORSON=true;
    //public static ArrayList<String> logs=new ArrayList<String>();
    public static String mostRecentLog="";
    public static ComboBoxModel evidenceBoxModel=new DefaultComboBoxModel(new String[]{"","Observation on the system itself","Observation from a simulation","Observation from a similar situation","Result from a controlled experiment","Information from an expert","Information from a non-expert","Information from a trusted source","Logical explanation"});
    public static int CURRENTDAY=new Date().getDate();
    //public static int CURRENTDAY=12;
    
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
            mostRecentLog=outputString;
            out.write(outputString.substring(0,outputString.length()-1));
            //logs.add(outputString.substring(0,outputString.length()-1));
            out.newLine();
            out.close();
            fstream.close();
            if(!eventType.contains("Tutor")) {
                StaticHooks.alertTutor("Interviewer");
                StaticHooks.alertTutor("Observer");
                if(!currentMiscModel.getHasInserted()) {
                    StaticHooks.alertTutor("Mentor");
                }
            }
        } catch(Exception ex) {}
    }
    
    public static void reinitializeTutors() {
        loadPreviousStudentModels();
        loadUsedActions();
    }
    
    public static ArrayList<String> usedActions=new ArrayList<String>();
    public static void loadUsedActions() {
        try {
            String modelPath=PROJECTROOTPATH + File.separator + "StudentModels" + File.separator;
            XStream stream=new XStream(new StaxDriver());
            usedActions=(ArrayList<String>)stream.fromXML(new FileReader(modelPath+"actions.xml"));
            System.out.println("Used actions load complete.");
//            FileInputStream reader=new FileInputStream(PROJECTROOTPATH + File.separator + "StudentModels" + File.separator + "actions.xml");
//            XMLDecoder decoder=new XMLDecoder(reader);
//            usedActions=(ArrayList<String>)decoder.readObject();
        } catch(Exception ex) {
            System.out.println(ex);
            usedActions=new ArrayList<String>();
        }
    }
    public static void saveUsedActions() {
        new File(PROJECTROOTPATH + File.separator + "StudentModels").mkdir();
        String modelPath=PROJECTROOTPATH + File.separator + "StudentModels" + File.separator;
        new File(modelPath).mkdir();
        try {
            FileWriter w=new FileWriter(modelPath + "actions.xml");
            XStream stream=new XStream(new StaxDriver());
            w.write(stream.toXML(usedActions));
            w.close();
//            FileOutputStream save = new FileOutputStream(modelPath + "actions.xml");
//            XMLEncoder encoder=new XMLEncoder(save);
//            encoder.writeObject(usedActions);
//            encoder.close();
        } catch(Exception ex) {
            System.out.println("Used actions save failed.");
            System.out.println(ex.getMessage());
        }
    }
    
    public static EcologyModel previousEcologyModel;
    public static InquiryModel previousInquiryModel;
    public static ModelingModel previousModelingModel;
    public static EcologyModel currentEcologyModel;
    public static InquiryModel currentInquiryModel;
    public static ModelingModel currentModelingModel;
    public static MiscModel currentMiscModel;
    
    public static void initializeNewStudentModels() {
        previousEcologyModel=new EcologyModel();
        previousInquiryModel=new InquiryModel();
        previousModelingModel=new ModelingModel();
        currentEcologyModel=new EcologyModel();
        currentInquiryModel=new InquiryModel();
        currentModelingModel=new ModelingModel();
        currentMiscModel=new MiscModel();
    }
    public static void loadPreviousStudentModels() {
        loadStudentModel("Ecology");
        loadStudentModel("Inquiry");
        loadStudentModel("Modeling");
        loadStudentModel("Misc");
    }
    public static void saveStudentModels() {
        saveEcologyModel(currentEcologyModel);
        saveInquiryModel(currentInquiryModel);
        saveModelingModel(currentModelingModel);
        saveMiscModel(currentMiscModel);
    }
    private static void saveEcologyModel(EcologyModel model) {
        new File(PROJECTROOTPATH + File.separator + "StudentModels").mkdir();
        String modelPath=PROJECTROOTPATH + File.separator + "StudentModels" + File.separator + "Ecology";
        new File(modelPath).mkdir();
        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            String filename=modelPath + File.separator + "Ecology" + "_" + sdf.format(cal.getTime())+".xml";
            FileWriter w=new FileWriter(filename);
            XStream stream=new XStream(new StaxDriver());
            w.write(stream.toXML(model));
            w.close();
        } catch(Exception ex) {
            System.out.println("Ecology model save failed.");
            System.out.println(ex.getMessage());
        }
    }
    private static void saveInquiryModel(InquiryModel model) {
        new File(PROJECTROOTPATH + File.separator + "StudentModels").mkdir();
        String modelPath=PROJECTROOTPATH + File.separator + "StudentModels" + File.separator + "Inquiry";
        new File(modelPath).mkdir();
        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            String filename=modelPath + File.separator + "Inquiry" + "_" + sdf.format(cal.getTime())+".xml";
            FileWriter w=new FileWriter(filename);
            XStream stream=new XStream(new StaxDriver());
            w.write(stream.toXML(model));
            w.close();
        } catch(Exception ex) {
            System.out.println("Inquiry model save failed.");
            System.out.println(ex.getMessage());
        }
    }
    private static void saveModelingModel(ModelingModel model) {
        new File(PROJECTROOTPATH + File.separator + "StudentModels").mkdir();
        String modelPath=PROJECTROOTPATH + File.separator + "StudentModels" + File.separator + "Modeling";
        new File(modelPath).mkdir();
        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            String filename=modelPath + File.separator + "Modeling" + "_" + sdf.format(cal.getTime())+".xml";
            FileWriter w=new FileWriter(filename);
            XStream stream=new XStream(new StaxDriver());
            w.write(stream.toXML(model));
            w.close();
        } catch(Exception ex) {
            System.out.println("Modeling model save failed.");
            System.out.println(ex.getMessage());
        }
    }
    private static void saveMiscModel(MiscModel model) {
        new File(PROJECTROOTPATH + File.separator + "StudentModels").mkdir();
        String modelPath=PROJECTROOTPATH + File.separator + "StudentModels" + File.separator + "Misc";
        new File(modelPath).mkdir();
        try {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
            String filename=modelPath + File.separator + "Misc" + "_" + sdf.format(cal.getTime())+".xml";
            FileWriter w=new FileWriter(filename);
            XStream stream=new XStream(new StaxDriver());
            w.write(stream.toXML(model));
            w.close();
        } catch(Exception ex) {
            System.out.println("Misc model save failed.");
            System.out.println(ex.getMessage());
        }
    }
    private static void loadStudentModel(String type) {
        try {
            String modelPath=PROJECTROOTPATH + File.separator + "StudentModels" + File.separator + type + File.separator;
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
                XStream stream=new XStream(new StaxDriver());
                if(type.equals("Ecology")) {
                    previousEcologyModel=(EcologyModel)stream.fromXML(new FileReader(modelPath + files.get(files.size()-1)));
                    currentEcologyModel=(EcologyModel)stream.fromXML(new FileReader(modelPath + files.get(files.size()-1)));
                    System.out.println("Ecology model loaded.");
                } else if(type.equals("Inquiry")) {
                    previousInquiryModel=(InquiryModel)stream.fromXML(new FileReader(modelPath + files.get(files.size()-1)));
                    currentInquiryModel=(InquiryModel)stream.fromXML(new FileReader(modelPath + files.get(files.size()-1)));
                    System.out.println("Inquiry model loaded.");
                } else if(type.equals("Modeling")) {
                    previousModelingModel=(ModelingModel)stream.fromXML(new FileReader(modelPath + files.get(files.size()-1)));
                    currentModelingModel=(ModelingModel)stream.fromXML(new FileReader(modelPath + files.get(files.size()-1)));
                    System.out.println("Modeling model loaded.");
                } else if(type.equals("Misc")) {
                    currentMiscModel=(MiscModel)stream.fromXML(new FileReader(modelPath + files.get(files.size()-1)));
                    System.out.println("Misc model loaded.");
                }
                
            } else {
                System.out.println("No student models found.");
                initializeNewStudentModels();
            }
        
        } catch(Exception ex) {
            initializeNewStudentModels();
            System.out.println(ex);
        }
    }
    
}
