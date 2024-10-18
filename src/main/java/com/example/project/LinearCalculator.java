package com.example.project;
public class LinearCalculator{
    //FOR EXTRA CREDIT 
    //you should copy and paste all of your code from the LinearCalculator class
    // but NOT printInfo(). Please update it below
    private int x1;
    private int x2;
    private int y1;
    private int y2;


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String point1,String point2){ // <--add 2 string parameters to this constructor
    x1 = Integer.parseInt(point1.substring(point1.indexOf("(") + 1 ,point1.indexOf(",")));
    x2 =  Integer.parseInt(point2.substring(point2.indexOf("(") + 1 ,point2.indexOf(",")));
    y1 = Integer.parseInt( point1.substring(point1.indexOf(",") + 1 ,point1.indexOf(")")));
    y2 = Integer.parseInt (point2.substring(point2.indexOf(",") + 1 ,point2.indexOf(")")));
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    
    public void setX1(int newx1){
        x1 = newx1;
    }
    public void setY1(int newy1){
        y1 = newy1;
    }
    public void setX2(int newx2){
        x2 =  newx2;
    }
    public void setY2(int newy2){
        y2 = newy2;
    }


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double distance = roundedToHundredth(Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2)));
        return distance;
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        if(x2-x1 == 0){
            return -999.99;
        }
        return roundedToHundredth(y1-(slope()*x1));
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        double slope = roundedToHundredth((double)(y2-y1)/(x2-x1));
        if(x2-x1 == 0){
            return -999.99;
        }
        return roundedToHundredth((double)(y2-y1)/(x2-x1));
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        if(x2 - x1 == 0){
        return "undefined";
        }
        if(slope() == 0){
            return "y=" + yInt();  
        }
        if(yInt() == 0){
            return "y=" + slope()+"x" ;  
        }
        if(yInt()> 0){
            return "y=" + slope()+"x+"+yInt(); 
        }
        return "y=" + slope()+"x"+yInt();
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        return Math.round(x*100.0)/100.0;
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + x1 +"," + y1 +")" /*insert var here*/  /*insert var here*/ ;
        str += " and " + "(" + x2 +"," + y2 +")"  + /*insert var here*/  "," + /*insert var here*/ ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: ";
        str += findSymmetry();
        str += Midpoint();
 
        return str;
    }
    //You will need to concatenate to the string 
    //the results from findSymmetry() and Midpoint()
    // public String printInfo(){
    
    //     return "";
    // }

    //findSymmetry()-> returns a string 
    //the method should determine if there is symmetry between the two points
    // there should be  4 return statements 
    // return "Symmetric about the x-axis";
    // return "Symmetric about the y-axis";
    //return "Symmetric about the origin";
    //return "No symmetry";
    public String findSymmetry(){
        boolean xEqual = (x1==x2);
        boolean yEqual = (y1==y2);
        boolean xSym = (xEqual && (Math.abs(y1) == Math.abs(y2))) ;
        boolean ySym = (yEqual && (Math.abs(x1) == Math.abs(x2))) ;
        boolean org = (x1 == -x2) &&(y1== -y2);
        if(xSym){
            return "Symmetric about the x-axis";
        }
        if(ySym){
            return "Symmetric about the y-axis";
        }
        if(org){
            return "Symmetric about the origin";
        }
        return "No symmetry";
    }

    //Midpoint()->return a string 
    //the method should calculate the midpoint between the two points
    //it should return "The midpoint of this line is: (0,0)";
    public String Midpoint(){
        
        return "The midpoint of this line is: ("  + ((((double)x2-x1)/2)+x1) +"," + ((((double)y2-y1)/2)+y1) + ")";
    }

}



