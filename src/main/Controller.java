package main;

import javafx.fxml.FXML;
import javafx.scene.shape.Line;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.*;

public class Controller {

 private ArmSim app;
 private Model model;
 @FXML
 private TextArea steps;
 @FXML
 private MenuButton mb;
 @FXML
 private MenuItem dpi;
 @FXML
 private MenuItem dpr;
 @FXML
 private MenuItem ldr;
 @FXML
 private MenuItem str;
 @FXML
 private FlowPane buttonPane;
 @FXML
 private Button prev;
 @FXML
 private Button next;
 @FXML
 private Line pcp;
 @FXML
 private Line pcH1;
 @FXML
 private Line instrH;
 @FXML
 private Line cond;
 @FXML
 private Line op;
 @FXML
 private Line funct;
 @FXML
 private Line rd;
 @FXML
 private Line pcSrcH1;
 @FXML
 private Line pcSrcH2;
 @FXML
 private Line memToRegH;
 @FXML
 private Line memWriteH;
 @FXML
 private Line aluControlH;
 @FXML
 private Line aluSrcH;
 @FXML
 private Line immSrcH1;
 @FXML
 private Line regWriteH;
 @FXML
 private Line flagsH1;
 @FXML
 private Line flagsH2;
 @FXML
 private Line flagsH3;
 @FXML
 private Line regSrcH;
 @FXML
 private Line a1;
 @FXML
 private Line a2;
 @FXML
 private Line instrMux1;
 @FXML
 private Line instrMux2;
 @FXML
 private Line a3H1;
 @FXML
 private Line a3H2;
 @FXML
 private Line wd3;
 @FXML
 private Line r15;
 @FXML
 private Line extend;
 @FXML
 private Line extImmH2;
 @FXML
 private Line immSrcH2;
 @FXML
 private Line srcA;
 @FXML
 private Line srcB;
 @FXML
 private Line rd2H1;
 @FXML
 private Line rd2H2;
 @FXML
 private Line extImmH1;
 @FXML
 private Line writeDataH;
 @FXML
 private Line aluResultH1;
 @FXML
 private Line readDataH1;
 @FXML
 private Line readDataH2;
 @FXML
 private Line aluResultH2;
 @FXML
 private Line resultH1;
 @FXML
 private Line resultH2;
 @FXML
 private Line resultH3;
 @FXML
 private Line resultH4;
 @FXML
 private Line pcH2;
 @FXML
 private Line four1;
 @FXML
 private Line pcPlus4H1;
 @FXML
 private Line pcPlus4H2;
 @FXML
 private Line pcPlus4H3;
 @FXML
 private Line pcPlus4H4;
 @FXML
 private Line four2;
 @FXML
 private Line fifteen;
 @FXML
 private Line pcSrcV1;
 @FXML
 private Line pcSrcV2;
 @FXML
 private Line instrV1;
 @FXML
 private Line instrV2;
 @FXML
 private Line instrV3;
 @FXML
 private Line instrV4;
 @FXML
 private Line instrV5;
 @FXML
 private Line flagsV1;
 @FXML
 private Line flagsV2;
 @FXML
 private Line regWriteV;
 @FXML
 private Line immSrcV1;
 @FXML
 private Line immSrcV2;
 @FXML
 private Line aluSrcV;
 @FXML
 private Line aluControlV;
 @FXML
 private Line memWriteV;
 @FXML
 private Line memToRegV;
 @FXML
 private Line regSrcV1;
 @FXML
 private Line regSrcV2;
 @FXML
 private Line a3V;
 @FXML
 private Line writeDataV;
 @FXML
 private Line aluResultV;
 @FXML
 private Line readDataV;
 @FXML
 private Line resultV1;
 @FXML
 private Line resultV2;
 @FXML
 private Line wd3V;
 @FXML
 private Line pcPlus4V1;
 @FXML
 private Line pcPlus4V2;
 @FXML
 private Line pcV;
 @FXML
 private Line extImmV;
 private Map<String, HashSet<Line>> lines;
 private HashSet<Line> currLine;
 //controller setup
 public void setApp(ArmSim app){
  this.app = app;
  this.model = app.getModel();
  model.registerController(this);
 }
 public void initialize(){
  disablePrev();
  disableNext();
  lines = new HashMap<>();
  currLine = new HashSet<>();
  HashSet<Line> pc = new HashSet<>();
  pc.add(pcH1);
  HashSet<Line> ctrlIn = new HashSet<>();
  ctrlIn.add(instrH);
  ctrlIn.add(cond);
  ctrlIn.add(op);
  ctrlIn.add(funct);
  ctrlIn.add(rd);
  ctrlIn.add(instrV1);
  HashSet<Line> instrwImm = new HashSet<>();
  instrwImm.add(instrH);
  instrwImm.add(instrV2);
  instrwImm.add(instrV5);
  instrwImm.add(a1);
  instrwImm.add(instrMux1);
  instrwImm.add(a3H2);
  instrwImm.add(extend);
  HashSet<Line> instrwReg = new HashSet<>();
  instrwReg.add(instrH);
  instrwReg.add(instrV2);
  instrwReg.add(instrV4);
  instrwReg.add(a1);
  instrwReg.add(a2);
  instrwReg.add(instrMux1);
  instrwReg.add(instrMux2);
  instrwReg.add(a3H2);
  HashSet<Line> ra1 = new HashSet<>();
  ra1.add(a1);
  HashSet<Line> ra2 = new HashSet<>();
  ra2.add(a2);
  HashSet<Line> source1 = new HashSet<>();
  source1.add(instrMux1);
  HashSet<Line> source2 = new HashSet<>();
  source2.add(instrMux2);
  HashSet<Line> imm = new HashSet<>();
  imm.add(instrH);
  imm.add(instrV5);
  imm.add(extend);
  imm.add(immSrcH1);
  imm.add(immSrcH2);
  imm.add(immSrcV1);
  imm.add(immSrcV2);
  HashSet<Line> rd1 = new HashSet<>();
  rd1.add(srcA);
  HashSet<Line> rd2toSrcB = new HashSet<>();
  rd2toSrcB.add(srcB);
  rd2toSrcB.add(rd2H1);
  rd2toSrcB.add(rd2H2);
  HashSet<Line> extImm = new HashSet<>();
  extImm.add(srcB);
  extImm.add(extImmV);
  extImm.add(extImmH1);
  extImm.add(extImmH2);
  extImm.add(aluSrcV);
  extImm.add(aluSrcH);
  HashSet<Line> flags = new HashSet<>();
  flags.add(flagsV2);
  flags.add(flagsV1);
  flags.add(flagsH1);
  flags.add(flagsH2);
  flags.add(flagsH3);
  HashSet<Line> aluToRegFile = new HashSet<>();
  aluToRegFile.add(resultV1);
  aluToRegFile.add(aluResultV);
  aluToRegFile.add(resultH1);
  aluToRegFile.add(aluResultH1);
  aluToRegFile.add(aluResultH2);
  aluToRegFile.add(resultH2);
  aluToRegFile.add(wd3);
  aluToRegFile.add(wd3V);
  aluToRegFile.add(regWriteH);
  aluToRegFile.add(regWriteV);
  aluToRegFile.add(a3H2);
  aluToRegFile.add(instrH);
  aluToRegFile.add(instrV4);
  HashSet<Line> aluToData = new HashSet<>();
  aluToData.add(aluResultH1);
  HashSet<Line> dataToReg = new HashSet<>();
  dataToReg.add(readDataH1);
  dataToReg.add(readDataH2);
  dataToReg.add(readDataV);
  dataToReg.add(memToRegV);
  dataToReg.add(memToRegH);
  dataToReg.add(resultV1);
  dataToReg.add(resultH1);
  dataToReg.add(resultH2);
  dataToReg.add(wd3);
  dataToReg.add(wd3V);
  dataToReg.add(regWriteH);
  dataToReg.add(regWriteV);
  dataToReg.add(a3H2);
  dataToReg.add(instrH);
  dataToReg.add(instrV4);
  HashSet<Line> pcp4 = new HashSet<>();
  pcp4.add(pcH1);
  pcp4.add(pcH2);
  pcp4.add(pcV);
  pcp4.add(pcH1);
  pcp4.add(four1);
  pcp4.add(pcPlus4V1);
  pcp4.add(pcPlus4V2);
  pcp4.add(pcPlus4H1);
  pcp4.add(pcPlus4H3);
  pcp4.add(pcPlus4H4);
  pcp4.add(pcp);
  HashSet<Line> memWrite = new HashSet<>();
  memWrite.add(memWriteH);
  memWrite.add(memWriteV);
  HashSet<Line> aluControl = new HashSet<>();
  aluControl.add(aluControlH);
  aluControl.add(aluControlV);
  HashSet<Line> writeData = new HashSet<>();
  writeData.add(rd2H1);
  writeData.add(writeDataV);
  writeData.add(writeDataH);

  lines.put("PC", pc);
  lines.put("CtrlIn", ctrlIn);
  lines.put("InstrwImm", instrwImm);
  lines.put("InstrwReg", instrwReg);
  lines.put("A1", ra1);
  lines.put("A2", ra2);
  lines.put("Source1", source1);
  lines.put("Source2", source2);
  lines.put("Imm", imm);
  lines.put("RD1", rd1);
  lines.put("RD2toSrcB", rd2toSrcB);
  lines.put("ExtImm", extImm);
  lines.put("ALUFlags", flags);
  lines.put("ALUtoRegFile", aluToRegFile);
  lines.put("PCP4", pcp4);
  lines.put("ALUtoData", aluToData);
  lines.put("DatatoReg", dataToReg);
  lines.put("MemWrite", memWrite);
  lines.put("ALUControl", aluControl);
  lines.put("WriteData", writeData);
 }

 //step handling
 public void prevButtonClicked(){
  model.prev();
 }
 public void nextButtonClicked(){
  model.next();
 }

 //instruction options
 public void dataImmItemClicked(){
  mb.setText(dpi.getText());
  instructionSelected(mb.getText());
 }
 public void dataRegItemClicked(){
  mb.setText(dpr.getText());
  instructionSelected(mb.getText());
 }
 public void loadItemClicked(){
  mb.setText(ldr.getText());
  instructionSelected(mb.getText());
 }
 public void storeItemClicked(){
  mb.setText(str.getText());
  instructionSelected(mb.getText());
 }

 //called based on option selected
 public void instructionSelected(String option){
  model.instructionSelected(option);
 }

 //responses from model
 public void disablePrev(){
  prev.setDisable(true);
 }

 public void disableNext(){
  next.setDisable(true);
 }
 public void enablePrev(){
  prev.setDisable(false);
 }
 public void enableNext(){
  next.setDisable(false);
 }
 public void updateText(String s){
  steps.setText(s);
 }
 public void updateLines(ArrayList<String> s){
  activateLines(s);
 }

 //helper function for handling lines
 public void activateLines(ArrayList<String> s){
   for(Line l: currLine)
       l.setVisible(false);
   for(String set : s){
     HashSet<Line> c = lines.get(set);
     for(Line l : c){
       currLine.add(l);
       l.setVisible(true);
     }
   }
 }
}
