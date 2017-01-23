package main;

import java.util.*;

public class DataProcessingRegisterInstruction extends Instruction{
 public DataProcessingRegisterInstruction(){
  step.add("Step 1: Initial PC value passed to Instrucion Memory to retrieve next instruction.");
  ArrayList<String> step1 = new ArrayList<>();
  step1.add("PC");

  step.add("Step 2: The next instruction retrieved from the Instruction Memory module, and bits 31:12 are passed to the Control Unit to process the signal. The Control Unit's output sends out signals to control the flow of data.");
  ArrayList<String> step2 = new ArrayList<>();
  step2.add("CtrlIn");

  step.add("Step 3: Meanwhile the data fields in the instruction are separated and sent down their respective data paths.");
  ArrayList<String> step3 = new ArrayList<>();
  step3.add("InstrwReg");

  step.add("Step 4: Next, the source register containing a data value located in data field 'Rn' is loaded into register file port 'A1' and read onto RD1.");
  ArrayList<String> step4 = new ArrayList<>();
  step4.add("A1");
  step4.add("Source1");

  step.add("Step 5: Next, the second source register located in data field 'Rm' of the instruction is loaded into the register file port 'A2' and read onto RD2.");
  ArrayList<String> step5 = new ArrayList<>();
  step5.add("A2");
  step5.add("Source2");

  step.add("Step 6: The RD1 and RD2 data lines are passed to the ALU to be computed (the Control Unit determines the type of operation requested by the instruction and passes the appropriate signal via the ALUControl data line).");
  ArrayList<String> step6 = new ArrayList<>();
  step6.add("RD1");
  step6.add("RD2toSrcB");
  step6.add("ALUControl");

  step.add("Step 7: The computation produces four flags (ALUFlags 3:0), which are used if the instruction is optionally specified to be conditional.");
  ArrayList<String> step7 = new ArrayList<>();
  step7.add("ALUFlags");

  step.add("Step 8: The ALUResult is passed back to the Register File to be stored in the destination register.");
  ArrayList<String> step8 = new ArrayList<>();
  step8.add("ALUtoRegFile");

  step.add("Step 9: Lastly, the PC is incremented.");
  ArrayList<String> step9 = new ArrayList<>();
  step9.add("PCP4");

  lines.add(step1);
  lines.add(step2);
  lines.add(step3);
  lines.add(step4);
  lines.add(step5);
  lines.add(step6);
  lines.add(step7);
  lines.add(step8);
  lines.add(step9);
  
  currentStep = 0;
  totalSteps = step.size();
 }
}
