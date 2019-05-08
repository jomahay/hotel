package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

import exception.UploadException;

public class Fonctions {
    public static Date getDate(int day, int month, int year)
    {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.DATE, day);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.YEAR, year);
        return new Date(cal.getTime().getTime());
    }

    public static Date now()
    {
        Calendar cal = new GregorianCalendar();
        return new Date(cal.getTime().getTime());
    }
    
    public static String hexEncode(byte[] aInput){
        StringBuilder result = new StringBuilder();
        char[] digits = {'0', '1', '2', '3', '4','5','6','7','8','9','a','b','c','d','e','f'};
        for (int idx = 0; idx < aInput.length; ++idx) {
            byte b = aInput[idx];
            result.append(digits[ (b&0xf0) >> 4 ]);
            result.append(digits[ b&0x0f]);
        }
        return result.toString();
    }
    
    public static String hashString(String texte) throws NoSuchAlgorithmException
    {
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        byte[] result =  sha.digest(texte.getBytes());

        System.out.println("Texte: " + texte);
        System.out.println("Message digest: " + hexEncode(result));
        
        return hexEncode(result);
    }
    public static int inArray(Object value, Object... array) {
		int result = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(value)) {
				result = i;
				break;
			}
		}
		return result;
	}
    
    public static String join(Object[] list, String separator) {
		String result = "";
		for (Object item : list)
			result += item + separator;
		if (!result.equalsIgnoreCase(""))
			result = result.substring(0, result.length() - separator.length());
		return result;
	}
    
    public static String upload(FileItem file, String contextPath, String folder, String fileName, int size,
			String... extensions) throws UploadException {
		if (file == null)
			return null;
		String extension = FilenameUtils.getExtension(file.getName());
		if (Fonctions.inArray(extension, extensions) == -1)
			throw new UploadException("Veuillez choisir des fichiers " + join(extensions, ", "));
		if (size != 0 && size < file.getSize())
			throw new UploadException("La taille du fichier ne doit pas éxceder " + (size / 1000000) + "Mo");
		String targetDir = contextPath + "/resources" + folder + "/";
		if (!new File(targetDir).exists()) {
			Path path = Paths.get(targetDir);
			try {
				Files.createDirectories(path);
			} catch (IOException e) {
				throw new UploadException("Un problème est survenu lors du téléchargement du fichier!");
			}
		}
		try {
			file.write(new File(targetDir + fileName + "." + extension));
		} catch (Exception e) {
			throw new UploadException("Un problème est survenu lors du téléchargement du fichier!");
		}
		return fileName + "." + extension;
	}
}
