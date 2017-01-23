package main;

import java.util.*;

public class Model {
 private Controller controller;
 private Map<String, Instruction> instructions = new HashMap<String, Instruction>();
 private Instruction currentInstr;
 //setup methods
 public Model(){
  instructions.put("Data Processing with Immediate Addressing", new DataProcessingImmediateInstruction());
  instructions.put("Data Processing with Register Addressing", new DataProcessingRegisterInstruction());
  instructions.put("LDR", new LoadInstruction());
  instructions.put("STR", new StoreInstruction());
  currentInstr = null;
 }
 public void registerController(Controller controller){
  this.controller = controller;
 }

 //response to instruction selected
 public void instructionSelected(String s){
  currentInstr = instructions.get(s);
  currentInstr.reset();
  controller.disablePrev();//init prev to disable for first step
  controller.enableNext();
  controller.updateText(currentInstr.displayStep());
  controller.updateLines(currentInstr.displayLines());
 }

 //step changed
 public void next(){
  String step = currentInstr.next();
  controller.enablePrev();
  if(currentInstr.isLast())
   controller.disableNext();
  else
   controller.enableNext();
  controller.updateText(step);
  controller.updateLines(currentInstr.displayLines());
 }
 public void prev(){
  String step = currentInstr.prev();
  controller.enableNext();
  if(currentInstr.isFirst())
   controller.disablePrev();
  else
   controller.enablePrev();
  controller.updateText(step);
  controller.updateLines(currentInstr.displayLines());
 }
}
