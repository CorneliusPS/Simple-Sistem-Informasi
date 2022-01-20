package Tubes;

import java.util.Date;

// CLASS USER
class User {
	private String username;
	private String password;
	private String name;
	private String noKtp;
	private String birthPlace;
	private CharSequence bornDates;
	private Date lastLoggedIn;
	
	public User(String username, String password, String name, String noKtp, String birthPlace, CharSequence bornDates, Date lastLoggedIn){
		this.username = username;
	    this.password = password;
	    this.name = name;
	    this.noKtp = noKtp;
	    this.birthPlace = birthPlace;
		this.bornDates = bornDates;
		this.lastLoggedIn = lastLoggedIn;
	}
	
	public void setUserName(String username){
		this.username = username;
	}
	 
	public String getUserName(){
		return username;
	}
	
	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}
	
	public String getName(){
		return name;
	}
	
	public String getNoKtp(){
		return noKtp;
	}
	
	public String getBirthPlace(){
		return birthPlace;
	}

	public CharSequence getBornDates(){
		return bornDates;
	}

	public Date getLastLoggedIn(){
		return lastLoggedIn;
	}

	public void setLastLoggedIn(Date lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}

}

//CLASS STAFFS
class Staffs extends User{
  private String nip;

      public Staffs (String username, String password, String name, String noKtp, String birthPlace, CharSequence bornDates, Date lastLoggedIn, String nip){
        super(username, password, name, noKtp, birthPlace, bornDates, lastLoggedIn);
        this.nip = nip;  
      }

      public String getNip(){
          return nip;
      }
}

//CLASS STUDENTS
class Students extends User{
   private String nim;
   private String classEnrolledStudents;

   public Students(String username, String password, String name, String noKtp, String birthPlace, CharSequence bornDates, Date lastLoggedIn, String nim, String classEnrolledStudents){
      super(username, password, name, noKtp, birthPlace, bornDates, lastLoggedIn);
      this.nim = nim;
      this.classEnrolledStudents = classEnrolledStudents;
   }
   
   public String getNim(){
       return nim;
   }

   public void setClassEnrolledStudents (String classEnrolledStudents){
	   this.classEnrolledStudents = classEnrolledStudents;
   }
  
   public String getClassEnrolledStudents(){
	   return classEnrolledStudents;
   }

public void set(String password, String newPassEncr) {
}
   
}

//CLASS DOSEN
class Dosen extends Staffs{
   private String nidn;
   private String classEnrolledDosen;

   public Dosen (String username, String password, String name, String noKtp, String birthPlace, CharSequence bornDates, Date lastLoggedIn, String nip, String nidn, String classEnrolledDosen){
       super(username, password, name, noKtp, birthPlace, bornDates, lastLoggedIn, nip);
       this.nidn = nidn;
       this.classEnrolledDosen = classEnrolledDosen;
   }
  
   public String getNidn(){
      return nidn;
   }
  
   public String getClassEnrolledDosen(){
	   return classEnrolledDosen;
   }

}
