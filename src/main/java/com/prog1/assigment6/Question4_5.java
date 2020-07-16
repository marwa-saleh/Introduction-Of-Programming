package com.prog1.assigment6;

import java.util.Scanner;

//Write a program to deal with complex numbers (addition, subtraction, multiplication, division, and conjugate). 
//The input should be two complex numbers and an operation of the proceeding ones. 
//Use functions for each operation and the main program only for calling them according to the input
public class Question4_5 {
  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    System.out.println("Please enter first number :");
    final String firstNumber = scanner.next();
    
    System.out.println("Please enter second number :");
    final String secondNumber = scanner.next();
    
    System.out.println("Please enter the operation :");
    String inData = scanner.next();
    char operation = inData.charAt(0);
    
    ComplexNumber firstComplexNumber = getComplexNumbers(firstNumber);
    ComplexNumber secondComplexNumber = getComplexNumbers(secondNumber);
    
    switch (operation) {
      case '+':
        complexNumbersAddition(firstComplexNumber, secondComplexNumber);
        break;
      case '-':
        complexNumbersSubtraction(firstComplexNumber, secondComplexNumber);
        break;
      case '*':
        complexNumbersMultiplication(firstComplexNumber, secondComplexNumber);
        break;
      case '/':
        complexNumbersDivision(firstComplexNumber, secondComplexNumber);
        break;
      case '!':
        complexNumbersConjugate(firstComplexNumber, secondComplexNumber);
        break;
      default:
        System.out.println("Invalid operation");
    }
  }
  
  private static void complexNumbersAddition(ComplexNumber firstComplexNumber, ComplexNumber secondComplexNumber) {
    double realAddition = firstComplexNumber.getComplexRealNumber() + secondComplexNumber.getComplexRealNumber();
    double imginaryAddition = firstComplexNumber.getComplexImaginaryNumber() + secondComplexNumber.getComplexImaginaryNumber();
    System.out.println("Addition is: " + realAddition + " + " + imginaryAddition + "i");
  }
  
  private static void complexNumbersSubtraction(ComplexNumber firstComplexNumber, ComplexNumber secondComplexNumber) {
    double realSubtraction = firstComplexNumber.getComplexRealNumber() - secondComplexNumber.getComplexRealNumber();
    double imginarySubtraction = firstComplexNumber.getComplexImaginaryNumber() - secondComplexNumber.getComplexImaginaryNumber();
    System.out.println("Subtraction is: " + realSubtraction + " + " + imginarySubtraction + "i");
  }
  
  private static void complexNumbersMultiplication(ComplexNumber firstComplexNumber, ComplexNumber secondComplexNumber) {
    double realMultiplication = firstComplexNumber.getComplexRealNumber() * secondComplexNumber.getComplexRealNumber();
    double imginaryMultiplication = firstComplexNumber.getComplexImaginaryNumber() * secondComplexNumber.getComplexImaginaryNumber();
    System.out.println("Multiplication is: " + realMultiplication + " + " + imginaryMultiplication + "i");
  }
  
  private static void complexNumbersDivision(ComplexNumber firstComplexNumber, ComplexNumber secondComplexNumber) {
    if (secondComplexNumber.getComplexRealNumber() == 0 || secondComplexNumber.getComplexImaginaryNumber() == 0) {
      System.out.println("Invalid Division");
      return;
    }
    
    double realDivision = firstComplexNumber.getComplexRealNumber() / secondComplexNumber.getComplexRealNumber();
    double imginaryDivision = firstComplexNumber.getComplexImaginaryNumber() / secondComplexNumber.getComplexImaginaryNumber();
    System.out.println("Division is: " + realDivision + " + " + imginaryDivision + "i");
  }
  
  private static void complexNumbersConjugate(ComplexNumber firstComplexNumber, ComplexNumber secondComplexNumber) {
    
    String firstNumber = firstComplexNumber.getComplexRealNumber() + " + " + firstComplexNumber.getComplexImaginaryNumber() + "i";
    String secondNumber = secondComplexNumber.getComplexRealNumber() + " + " + secondComplexNumber.getComplexImaginaryNumber() + "i";
    
    String firstNumberConjugate = firstComplexNumber.getComplexRealNumber() + " - " + firstComplexNumber.getComplexImaginaryNumber() + "i";
    String secondNumberConjugate = secondComplexNumber.getComplexRealNumber() + " - " + secondComplexNumber.getComplexImaginaryNumber() + "i";
    
    System.out.println("Conjugate of " + firstNumber + " = " + firstNumberConjugate);
    System.out.println("Conjugate of " + secondNumber + " = " + secondNumberConjugate);
  }
  
  private static ComplexNumber getComplexNumbers(final String number) {
    if (number.indexOf('+') != -1) {
      String[] complexNumber = number.split("\\+");
      String complexImaginaryNumber = complexNumber[1];
      complexImaginaryNumber = complexImaginaryNumber.replace("i", "");
      return new ComplexNumber(Double.parseDouble(complexNumber[0]), Double.parseDouble(complexImaginaryNumber));
    }
    
    return null;
  }
  
}