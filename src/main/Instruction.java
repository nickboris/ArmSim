package main;

import java.util.*;

public abstract class Instruction {
 protected int totalSteps;
 protected int currentStep;
 protected List<String> step = new ArrayList<>();
 protected List<ArrayList<String>> lines = new ArrayList<ArrayList<String>>();

 public void reset(){
  currentStep = 0;
 }
 public Boolean isLast(){
  return currentStep == totalSteps-1;
 }
 public Boolean isFirst(){
  return currentStep == 0;
 }
 public String displayStep(){
  return step.get(currentStep);
 }
 public ArrayList<String> displayLines(){
   return lines.get(currentStep);
 }
 public String next(){
  currentStep++;
  return displayStep();
 }
 public String prev(){
  currentStep--;
  return displayStep();
 }
}
