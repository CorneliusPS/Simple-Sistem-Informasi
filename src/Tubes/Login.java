package Tubes;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;
import java.util.Vector;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Login {

	public static Dosen searchDosen(String UserName, Vector<Dosen> pengajar ){ 
                for(Dosen k : pengajar) {
                    if (k.getUserName().toLowerCase().contains(UserName.toLowerCase()) || k.getNidn().contains(UserName)) {
						System.out.println(k.getName() +
											"\nNIDN =  " + k.getNidn()); 
						System.out.println();  
						return k;
                    }       
				}
	return null;
	}

	public static Students searchMahasiswa(String UserName, Vector<Students> mahasiswa ){ 
		for(Students l : mahasiswa) {
			if (l.getUserName().toLowerCase().contains(UserName.toLowerCase()) || l.getNim().contains(UserName)) {
				System.out.println(l.getName() +
									"\nNIM =  " + l.getNim()); 
				System.out.println();  
				return l;
			}       
		}
		return null;
	}

	public static Staffs searchStaffs(String UserName, Vector<Staffs> daftarStaffs){
		for (Staffs m: daftarStaffs){
			if (m.getUserName().toLowerCase().contains(UserName.toLowerCase()) || m.getNip().contains(UserName)) {
				System.out.println(m.getName() +
									"\nNIP =  " + m.getNip()); 
				System.out.println();  
				return m;
			} 
		}
		return null;
	}

	public static Course searchCourse(String NamaCourse, Vector<Course> daftarCourse){
		for (Course n: daftarCourse){
			if (n.getNameCourse().toLowerCase().contains(NamaCourse.toLowerCase()) ||
									 n.getIdCourse().toLowerCase().contains(NamaCourse.toLowerCase())) {
				System.out.println(n.getNameCourse()+
									"\nID =  " + n.getIdCourse()+
									"\nDescription = "+ n.getDescription()); 
				System.out.println();  
				return n;
			} 
		}
		return null;
	}
	
	public static void SearchClass(Vector<Students> mahasiswa){
    	Scanner scanner = new Scanner(System.in); 
    	
        //memilih menu didalam class
    	System.out.print("Pencarian Class" + 
                "\n1. Cek Sudah Masuk Kelas Mana" + 
                "\n2. Lihat Daftar Mahasiswa Pada kelas" + 
                "\nInput Pilihan = ");
    	  int CariClass = scanner.nextInt();
    	  
    	  switch(CariClass){
    	  case 1 :{
    	        //Cari mahasiswa di dalam kelas dengan nim
    	        System.out.print("Masukkan Kelas: ");
    	        String kelas = scanner.next();
    	        System.out.print("Masukkan Nim: ");
    	        String nim = scanner.next();
    	 

    	            for(Students n : mahasiswa) {
    	            	//sistem cek keyword nim ke array student
    	                if (n.getNim().contains(nim)) {
    	                	//sistem cek keyword class ke array students
    	                	if (n.getClassEnrolledStudents().contains(kelas)) {
    	                System.out.println(n.getName() +" Enrolled in Class " + kelas);
    	                break;   	                
    	                    }
    	                	else {
    				System.out.println();
    				System.out.println(n.getName() +" Not Enrolled in Class " + kelas);
    				break;
    	            }
    	            }   	
    			          
    	            }
    	            System.out.println();
                    break;   
    	  }
    	  case 2 :{
        //user input kelas yang ingin dilihat mahasiswanya
        System.out.print("Masukkan Kelas: ");
        String kelas = scanner.next();
        int countNM2 = 1;
        		
        	//sistem cek students yang memiliki class sesuai yang diinput
            for(Students n : mahasiswa) {
                if (n.getClassEnrolledStudents().contains(kelas)) {
                System.out.println(n.getName() +"  " + n.getNim());
                continue;
                }
              
		countNM2++; 
            }
                System.out.println();
                break;
        } //akhir dari case 2 class
    	  
    	  }
    } 

	// Method buat enkripsi password MD5
	public static String getMd5(String input) { 
		try { 
  
			// Static getInstance method is called with hashing MD5 
			MessageDigest md = MessageDigest.getInstance("MD5"); 
  
			// digest() method is called to calculate message digest 
			//  of an input digest() return array of byte 
			byte[] messageDigest = md.digest(input.getBytes()); 
  
			// Convert byte array into signum representation 
			BigInteger no = new BigInteger(1, messageDigest); 
  
			// Convert message digest into hex value 
			String hashtext = no.toString(16); 
			while (hashtext.length() < 32) { 
				hashtext = "0" + hashtext; 
			} 
			return hashtext; 
		}
			// For specifying wrong message digest algorithms 
			catch (NoSuchAlgorithmException e) { 
				throw new RuntimeException(e); 
			} 
	}

	public static void main(String[] args) throws NoSuchAlgorithmException {
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter jamFormat = DateTimeFormatter.ofPattern("hh:mm:ss a");
		
			//List All User
            Vector<User> userList = new Vector<User>();
            userList.add(new User("solimin","dcba2a5ce84701dff564cf558b6e35cb","Soli Min ","1872683970820021","Aceh","2000-10-11", new Date(2001, 11, 8, 11, 11, 11)));
            userList.add(new User("andretau","54e94c02659f850a74e769dbf50b206d","Andre Taulani","1823437898711209","Medan","2001-08-19", new Date(2001, 11, 8, 11, 11, 11)));
            userList.add(new User("soimahh","4462053a139ebb8a1cb8d37a80a207da","Soimah Harimin","1223456789019013","Jakarta","2000-05-10", new Date(2001, 11, 8, 11, 11, 11)));
            userList.add(new User("mariakeri","af0a2eb41ffbcb38163c62db9d5e63bc","Maria Keriiye","1908965432456787","Bekasi","2001-01-11", new Date(2001, 11, 8, 11, 11, 11)));
            userList.add(new User("notoasuhe","9f2e8b339adca5cfc43a884f770769f6","Noto Suherman","1234234567892435","Cirebon","2002-01-10", new Date(2001, 11, 8, 11, 11, 11)));
            userList.add(new User("srirahayu","aa0631cd8a947bb5b383fff252b77a07","Sri Rahayu","1274980902345672","Cirebon","1974-09-11", new Date(2001, 11, 8, 11, 11, 11)));
            userList.add(new User("astutiwijaya","61f84f0d60cb4b54a57795a66aa05cc6","Astuti Wijaya","1274098776654323","Makassar","1975-11-21", new Date(2001, 11, 8, 11, 11, 11)));
            userList.add(new User("andrianperdana","2f1d887857f736d31a0256813b9d0fb3","Andrian Perdana","1274085437600002","Medan","1972-07-02", new Date(2001, 11, 8, 11, 11, 11)));
            userList.add(new User("sutisna","c1ce2d9e2fb4ff0af8fae456350c590c","Sutisna","1273676000533366","Bogor","1973-03-13", new Date(2001, 11, 8, 11, 11, 11)));
            userList.add(new User("totoiskandar","bc4883dc824a47f77e0b78c4eb7ac34d","Toto Iskandar","1272766560000001","Surabaya","1974-06-19", new Date(2001, 11, 8, 11, 11, 11)));
			
			//List Students
            Vector<Students> mahasiswa = new Vector<Students>();
            mahasiswa.add(new Students("solimin","dcba2a5ce84701dff564cf558b6e35cb","Soli Min ","1872683970820021","Aceh","2000-10-11", new Date(2001, 11, 8, 11, 11, 11), "191401001","A"));
            mahasiswa.add(new Students("andretau","54e94c02659f850a74e769dbf50b206d","Andre Taulani","1823437898711209","Medan","2001-08-19", new Date(2001, 11, 8, 11, 11, 11), "191401002","B"));
            mahasiswa.add(new Students("soimahh","4462053a139ebb8a1cb8d37a80a207da","Soimah Harimin","1223456789019013","Jakarta","2000-05-10", new Date(2001, 11, 8, 11, 11, 11), "191401003","C"));
            mahasiswa.add(new Students("mariakeri","af0a2eb41ffbcb38163c62db9d5e63bc","Maria Keriiye","1908965432456787","Bekasi","2001-01-11", new Date(2001, 11, 8, 11, 11, 11), "191401004","A"));
            mahasiswa.add(new Students("notoasuhe","9f2e8b339adca5cfc43a884f770769f6","Noto Suherman","1234234567892435","Cirebon","2002-01-10", new Date(2001, 11, 8, 11, 11, 11), "191401005","B"));

			//List Dosen
			Vector<Dosen> pengajar = new Vector<Dosen>();
			pengajar.add(new Dosen("srirahayu","aa0631cd8a947bb5b383fff252b77a07","Sri Rahayu","1274980902345672","Cirebon","1974-09-11", new Date(2001, 11, 8, 11, 11, 11), "010112236709","001874635","A"));
			pengajar.add(new Dosen("astutiwijaya","61f84f0d60cb4b54a57795a66aa05cc6","Astuti Wijaya","1274098776654323","Makassar","1975-11-21", new Date(2001, 11, 8, 11, 11, 11), "020278498210","0018656786","B"));
			pengajar.add(new Dosen("andrianperdana","2f1d887857f736d31a0256813b9d0fb3","Andrian Perdana","1274085437600002","Medan","1972-07-02", new Date(2001, 11, 8, 11, 11, 11), "030383012094","0017554357","C"));
			pengajar.add(new Dosen("sutisna","c1ce2d9e2fb4ff0af8fae456350c590c","Sutisna","1273676000533366","Bogor","1973-03-13", new Date(2001, 11, 8, 11, 11, 11), "040496812095","0018987574","A"));
			pengajar.add(new Dosen("totoiskandar","bc4883dc824a47f77e0b78c4eb7ac34d","Toto Iskandar","1272766560000001","Surabaya","1974-06-19", new Date(2001, 11, 8, 11, 11, 11), "050520919124","0017685643","B"));

			//List Staffs
			Vector <Staffs> daftarStaffs = new Vector<Staffs>();
			daftarStaffs.add(new Staffs("srirahayu","aa0631cd8a947bb5b383fff252b77a07","Sri Rahayu","1274980902345672","Cirebon","1974-09-11", new Date(2001, 11, 8, 11, 11, 11), "010112236709"));
			daftarStaffs.add(new Staffs("astutiwijaya","61f84f0d60cb4b54a57795a66aa05cc6","Astuti Wijaya","1274098776654323","Makassar","1975-11-21", new Date(2001, 11, 8, 11, 11, 11), "010178498210"));
			daftarStaffs.add(new Staffs("andrianperdana","2f1d887857f736d31a0256813b9d0fb3","Andrian Perdana","1274085437600002","Medan","1972-07-02", new Date(2001, 11, 8, 11, 11, 11),"010183012094"));
			daftarStaffs.add(new Staffs("sutisna","c1ce2d9e2fb4ff0af8fae456350c590c","Sutisna","1273676000533366","Bogor","1973-03-13", new Date(2001, 11, 8, 11, 11, 11), "010196812095"));
			daftarStaffs.add(new Staffs("totoiskandar","bc4883dc824a47f77e0b78c4eb7ac34d","Toto Iskandar","1272766560000001","Surabaya","1974-06-19", new Date(2001, 11, 8, 11, 11, 11), "010120919124"));

			//List Course
			Vector <Course> daftarCourse = new Vector<Course>();
			daftarCourse.add(new Course("Konsep Dasar Pemrograman","ILK1201","Pemrograman dengan bahasa Pascal"));
			daftarCourse.add(new Course("Pemrograman Berorientasi Objek","ILK2210","Pemrograman dengan bahasa Java"));
			daftarCourse.add(new Course("Pemrograman Semantik Web","ILK2213", "Pemrograman berbasis Web"));
			daftarCourse.add(new Course("Sistem Manajemen Database", "ILK2212", "Pemrograman Berbasis Database"));
			daftarCourse.add(new Course("Struktur Data dan Algoritma", "ILK2211", "Pemrograman dengan bahasa C++"));


		// Mulai Program
		String ulg = "y";
		while (ulg.equals("y")) {
			System.out.println();
			System.out.println("Welcome to SIA Online");
			System.out.println("Login");
			System.out.println();
			
			// User Input Password
			System.out.print("Username: ");
			String username = scanner.next();
			
			System.out.print("Password: ");
			String password = scanner.next();
			String encpass = getMd5(password); // Password yang dimasukkan langung dienkripsi

			int countUser = 1;
			System.out.println();

			for (User m: userList){
				
				// jika Username dan Password cocok dengan database, maka program akan lanjut 
				// kalau salah satu tidak cocok, maka akan terus berulang

				if (!(username.equals(m.getUserName())) || !(encpass.equals(m.getPassword())) || countUser == userList.size()) {
					System.out.println("Username atau Password salah, silahkan coba lagi");
					ulg = "y";
					break;
				} 

				if ((username.equals(m.getUserName())) && (encpass.equals(m.getPassword()))) {
					
					Date date = new Date();
					m.setLastLoggedIn(date);  // Untuk mendapatkan tanggal dan waktu jika user berhasil login
					
					String menu = "y";
					while (menu.equals("y")) {
						System.out.println();
						System.out.println("Selamat Datang di SIA Online");
						System.out.println("Waktu sekarang adalah " + LocalTime.now().format(jamFormat));
						System.out.println();
						
						System.out.println("Pilihan Menu: " +
											"\n1. Profil User" +
											"\n2. Search User" +
											"\n3. Search Course" +
											"\n4. Search Class" +
											"\n5. List All Students" +
											"\n6. Exit");
						System.out.print("Masukkan pilihan menu: ");
						int pil = scanner.nextInt();
						
						switch(pil) {
						
							case 1: { 
								System.out.println();
								System.out.println("Profil User");
								System.out.println();
								System.out.println("Hai, " + m.getName());
								System.out.println("User Last Logged In: " + m.getLastLoggedIn()); // Tampilan last log in user
								System.out.println();
								System.out.println("Username: " + m.getUserName() + 
													"\nID: " + m.getNoKtp() + 
													"\nTTL: " + m.getBirthPlace() + ", " + m.getBornDates());
								System.out.println();
								System.out.println("1. Edit Username");
								System.out.println("2. Edit Password");
								System.out.println("3. kembali ke menu utama");
								System.out.println();
								System.out.print("Masukkan pilihan Anda: ");
								int pilprofil = scanner.nextInt();
								switch (pilprofil){
									case 1:{
										System.out.println();
										System.out.println("Username Anda sekarang adalah: " + m.getUserName());
										System.out.println();
										System.out.print("Masukkan username yang baru: ");
										String newUsername = scanner.next(); 
										m.setUserName(newUsername); // Me-replace username lama dengan yang baru
										System.out.println();
										System.out.println("================================");
										System.out.println("Username Anda berhasil berubah");
										System.out.println("================================");
										System.out.println("Username Anda yang baru adalah: " + m.getUserName());
										System.out.println();
										System.out.print("Kembali ke menu utama (y/n)? ");
										menu = scanner.next();
										break;
									}

									case 2: {
										System.out.println();
										System.out.print("Masukkan password yang baru: ");
										String newPass = scanner.next();
										String newPassEncr = getMd5(newPass); // Enkripsi password yang baru dimasukkan
										m.setPassword(newPassEncr); // Me-replace pass lama dengan pass yang baru di vector user
										System.out.println();
										System.out.println("================================");
										System.out.println("Password Anda berhasil berubah");
										System.out.println("================================");
										System.out.println();
										System.out.println("Password baru Anda adalah:  " + newPass);
										System.out.println();
										System.out.print("Kembali ke menu utama (y/n)? ");
										menu = scanner.next();
										break;
									}

									case 3: {
										menu ="y";
									}
								}
								break;
							}
							
							case 2: {
								System.out.println();
								System.out.println("Search User");
								System.out.println();
								System.out.println("1. Pencarian Mahasiswa" +
													"\n2. Pencarian Dosen" +
													"\n3. Pencarian Staff" +
													"\n4. Kembali Ke Menu Utama");
								System.out.print("Masukkan Pilihan Anda: ");
								int piluser = scanner.nextInt();
								switch (piluser) {
									case 1:{
										System.out.println();
										System.out.print("Masukkan Username Atau NIM: ");
										String NamaMahasiswa = scanner.next();
										searchMahasiswa(NamaMahasiswa, mahasiswa);
										System.out.print("Kembali ke menu utama (y/n)? ");
										menu = scanner.next();
										break;
									}

									case 2: {
										System.out.println();
										System.out.print("Masukkan Username atau NIDN: ");
										String NamaDosen = scanner.next();
										searchDosen(NamaDosen, pengajar);
										System.out.print("Kembali ke menu utama (y/n)? ");
										menu = scanner.next();
										break;
									}

									case 3: {
										System.out.println();
										System.out.print("Masukkan Username atau NIP: ");
										String NamaStaffs = scanner.next();
										searchStaffs(NamaStaffs, daftarStaffs);
										System.out.print("Kembali ke menu utama (y/n)? ");
										menu = scanner.next();
										break;
									}

									case 4: {
										menu = "y";
										break;
									}

									default: {
										System.out.println("Pilihan yang Anda masukkan salah");
										System.out.println();
										System.out.print("Kembali ke menu utama (y/n)? ");
										menu = scanner.next();
										break;
									}
								}
								break;
							}
							
							case 3: {
								System.out.println();
								System.out.println("Search Course");
								System.out.print("Masukkan Nama atau ID Course: ");
								String NamaCourse = scanner.next();
								searchCourse(NamaCourse, daftarCourse);
								System.out.print("Kembali ke menu utama (y/n)? ");
								menu = scanner.next();
								break;
							}
							
							case 4 :{
								System.out.println();
                                System.out.println("Search Class");
                                SearchClass(mahasiswa);
                                System.out.print("Kembali ke menu utama (y/n)? ");
								menu = scanner.next();
								break;
							}
							
							case 5: {
								System.out.println("List All Students");
								for(Students s : mahasiswa){
                                    System.out.println(s.getName() + " " +s.getNim ());
                                    //continue;
                                }
								System.out.println();
								System.out.print("Kembali ke menu utama (y/n)? ");
								menu = scanner.next();
								break;
							}
							
							case 6: {
								System.out.println("Exit");
								System.exit(0); // exit(0) used to successful termination
								break;
							}
							
							default: {
								System.out.println("Pilihan yang Anda masukkan salah");
								System.out.println();
								System.out.print("Kembali ke menu utama (y/n)? ");
								menu = scanner.next();
								if (menu.equals("n")){
									System.exit(0);
								}
								break;
							}
						
						}
					}
				}
                countUser++; 
			}
		}
	}
}
