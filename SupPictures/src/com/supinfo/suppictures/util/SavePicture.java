package com.supinfo.suppictures.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.Part;

public class SavePicture {

	//Path du dossier des pictures enregistrées
	private static String picturesDir = "C:\\SupPicturesImage";
	
		
	public static String getPicturesDir() {
		return picturesDir;
	}

	public static void setPicturesDir(String picturesDir) {
		SavePicture.picturesDir = picturesDir;
	}

	public static String SavedPicture(Part filePart,String namePicture,String newPictureName) {
		//Nom de la photo
		String pictureExtension = namePicture.substring(namePicture.lastIndexOf("."));
		String fileName = newPictureName(newPictureName,pictureExtension); 
	    
	    InputStream fileContent;
	    
		try {
			fileContent = filePart.getInputStream();
			
			File upload = new File(picturesDir);
		    upload.mkdir();
		    
		    //Creation du fichier 
		    File file = new File(upload, fileName);
		    
		    System.out.println(file.toPath());
		    Files.copy(fileContent, file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	public static String newPictureName(String name,String extension) {
		Boolean existingPicture = true;
		
		int i = 1;
		File rep = new File(picturesDir);
		File picture = new File(rep,name + extension);
		
		while(existingPicture) {
			
			picture = new File(rep,name + i + extension);

			if(picture.exists()) {
				i++;
			} else {
				existingPicture = false;
				name = name + i + extension;
			}
		}
		
		return name;
	}
}
