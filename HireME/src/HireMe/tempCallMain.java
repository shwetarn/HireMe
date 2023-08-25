package HireMe;

import javax.swing.JFrame;

public class tempCallMain {
	JFrame f;    
	tempCallMain(){
		f=new JFrame("Hire!Me Job Portal");
		
		}
	public static void main(String[] args) {
		applicantRegister lo=new applicantRegister();
		lo.setUserType("Company");
		lo.main(null);
		// TODO Auto-generated method stub

	}

}
