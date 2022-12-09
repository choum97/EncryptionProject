package proSecurity;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Security {
	
	private static Security instance = new Security();
	private SecretKey secretKey = null;
	
	public static Security getInstance() {
		return instance;
	}
	
	private Security() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
			keyGenerator.init(128);
			secretKey = keyGenerator.generateKey();
		}
		catch(Exception e) {
			System.err.println("Exception : " + e.getMessage());
		}
	}
	
	//암호화
	public void encrypt(String fileName) {
		int index1 = fileName.lastIndexOf('\\');
		int index2 = fileName.lastIndexOf('.');
		String tmpFileName1 = fileName.substring(0, index1+1) + "encrypt" + fileName.substring(index2);
		
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		}
		catch(Exception e) {
			System.err.println("Exception[Cipher] : " + e.getLocalizedMessage());
		}
		
		InputStream input = null;
		OutputStream output = null;
		
		try {
			input = new BufferedInputStream(new FileInputStream(fileName));
			output = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(tmpFileName1)), cipher);
			int size = 0;
			byte[] buffer = new byte[1024];
			while((size = input.read(buffer)) != -1) {
				output.write(buffer, 0, size);
			}
		}
		catch(Exception e) {
			System.err.println("Exception1 " + e.getLocalizedMessage());
		}
		finally {
			try {
				if(output != null) output.close();
				if(input != null) input.close();
			}
			catch(Exception e) {
				System.err.println("Exception2 : " +  e.getLocalizedMessage());
			}
			System.out.println("파일 암호화 종료");
		}
		
	}
	
	//복호화
	public void decrypt(String fileName) {
		int index1 = fileName.lastIndexOf('\\');
		int index2 = fileName.lastIndexOf('.');
		String tmpFileName2 = fileName.substring(0, index1+1) + "decrypt" + fileName.substring(index2);
		
		Cipher cipher = null;
		try {
			cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
		}
		catch(Exception e) {
			System.err.println("Exception[Cipher] : " + e.getLocalizedMessage());
		}
		
		InputStream input = null;
		OutputStream output = null;
		
		try {
			input = new BufferedInputStream(new FileInputStream(fileName));
			output = new CipherOutputStream(new BufferedOutputStream(new FileOutputStream(tmpFileName2)), cipher);
			int size = 0;
			byte[] buffer = new byte[1024];
			while((size = input.read(buffer)) != -1) {
				output.write(buffer, 0, size);
			}
		}
		catch(Exception e) {
			System.err.println("Exception1 : " + e.getLocalizedMessage());
		}
		finally {
			try {
				if(output != null) output.close();
				if(input != null) input.close();
			}
			catch(Exception e) {
				System.err.println("Exception2 : " +  e.getLocalizedMessage());
			}
			System.out.println("파일 암호화 종료");
		}
	}
}
