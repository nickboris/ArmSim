package main;

import java.util.*;

public class LoadInstruction extends Instruction{
 public LoadInstruction(){
  step.add("Step 1: Initial PC value passed to Instrucion Memory to retrieve next instruction.");
  ArrayList<String> step1 = new ArrayList<>();
  step1.add("PC");

  step.add("Step 2: The next instruction retrieved from the Instruction Memory module, and bits 31:12 are passed to the Control Unit to process the signal. The Control Unit's output sends out signals to control the flow of data.");
  ArrayList<String> step2 = new ArrayList<>();
  step2.add("CtrlIn");

  step.add("Step 3: Meanwhile the data fields in the instruction are separated and sent down their respective data paths.");
  ArrayList<String> step3 = new ArrayList<>();
  step3.add("InstrwImm");

  step.add("Step 4: Next, the source register containing the base address located in data field 'Rn' is loaded into register file port 'A1' and read onto RD1.");
  ArrayList<String> step4 = new ArrayList<>();
  step4.add("A1");
  step4.add("Source1");

  step.add("Step 5: The LDR instruction requires an offset. The value stored in the immediate field of the instruction is passed to the 'Extend' module to be zero-extended.");
  ArrayList<String> step5 = new ArrayList<>();
  step5.add("Imm");

  step.add("Step 6: The memory address in data memory to be retrieved may now be computed in the ALU. Signals RD1 (base address) and ExtImm (offset) are sent to the ALU to be computed.");
  ArrayList<String> step6 = new ArrayList<>();
  step6.add("RD1");
  step6.add("ExtImm");
  step6.add("ALUControl");
  
  step.add("Step 7: The computation produces four flags (ALUFlags 3:0), which are used if the instruction is optionally specified to be conditional.");
  ArrayList<String> step7 = new ArrayList<>();
  step7.add("ALUFlags");

  step.add("Step 8: The ALUResult signal is passed to the Data Memory module to retrieve the data from the computed address.");
  ArrayList<String> step8 = new ArrayList<>();
  step8.add("ALUtoData");

  step.add("Step 9: The MemtoReg is set to 1, allowing the ReadData value to pass. The ReadData signal is passed back to register file port WD3 in the Register File module. This data is written into the destination register (which was passed to register file port A3).");
  ArrayList<String> step9 = new ArrayList<>();
  step9.add("DatatoReg");

  step.add("Step 10: Lastly, the PC is incremented.");
  ArrayList<String> step10 = new ArrayList<>();
  step10.add("PCP4");

  lines.add(step1);
  lines.add(step2);
  lines.add(step3);
  lines.add(step4);
  lines.add(step5);
  lines.add(step6);
  lines.add(step7);
  lines.add(step8);
  lines.add(step9);
  lines.add(step10);
  currentStep = 0;
  totalSteps = step.size();
 }
}
