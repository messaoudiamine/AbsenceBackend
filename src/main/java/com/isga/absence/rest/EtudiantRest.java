package com.isga.absence.rest;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.isga.absence.entity.Etudiant;
import com.isga.absence.entity.FileImage;
import com.isga.absence.service.EtudiantService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/etudiant")
public class EtudiantRest {

	@Value("${image.dir}")
	private String imageDir;
	String currentDirectory = System.getProperty("user.dir");
	@Autowired
	private EtudiantService etudiantService;
	
	
	/**
	 * Get all
	 * @return collection
	 */
	@GetMapping(value = "/list")
	public List<Etudiant> getAll(){
		
		return etudiantService.getAll();
	}
	

	/**
	 * save & update
	 * @param etudiant
	 * @return
	 */
	@PostMapping(value = "/save")
	public Etudiant save(@RequestBody Etudiant etudiant) {
		return etudiantService.save(etudiant);		
	}
	
	
	/**
	 * Find a annee by id
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public Etudiant getById(@PathVariable("id") Integer id) {
		return etudiantService.getById(id);
	}
	
	/**
	 * Delete By Objet
	 * @param etudiant
	 */
	@DeleteMapping(value = "/delete/{id}")
	public void deleteByid(@PathVariable(name="id") int id) {
		etudiantService.deleteByid(id);
	}
	/**
	 * List etudiants By id niveau
	 * @param id etudiant
	 */
	@GetMapping(value = "listeEtudiant/{id}")
	public List<Etudiant> getEtudtByNiveau(@PathVariable("id") Integer id) {
		return etudiantService.getLisEtudtByNiveau(id);
	}
	
	
	/**
	 * get file By Objet
	 * @param multipartFile
	 */
	@SuppressWarnings("null")
	@PostMapping(value = "/file")
	public void getFile(@RequestBody  FileImage dataImage) {	
		try {
			String nameImage ="",base64Image,currentDirectory;
			Integer number = 1,id=0;
//			String[] listNamesImg = null;
			ArrayList<String> listNamesImg = new ArrayList<String>();
//			System.out.println(Arrays.toString(dataImage.getDataImag()));
//			String test = dataImage.getDataImag().split(",");
			currentDirectory = System.getProperty("user.dir");
			id = dataImage.getId();
			System.out.println(id);
			for(int i=0; i< dataImage.getDataImag().length; i++){
//				System.out.println(dataImage.getDataImag()[i]);
				 base64Image = dataImage.getDataImag()[i];
				byte[] imageBytes = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
				System.out.println(imageBytes);
				Random random = new Random();
				nameImage = "Eleve"+id+i ;
				listNamesImg.add(nameImage);
				File destFile = new File(currentDirectory+"\\gestionPresence\\FacialRecognition\\image\\"+nameImage+".jpg");
				InputStream in = new ByteArrayInputStream(imageBytes);
				BufferedImage bImageFromConvert =ImageIO.read(in);
				ImageIO.write(bImageFromConvert, "jpg", destFile);
				System.out.println("Image créer");
			}
			System.out.println(listNamesImg);
			String[] cmd = {
				      "python",
				      currentDirectory+"\\gestionPresence\\FacialRecognition\\01_face_dataset.py",
				      listNamesImg.toString(),
				      Integer.toString(id)
				      
				    };
			Process p = Runtime.getRuntime().exec(cmd);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			String s = null;
			while ((s = stdInput.readLine()) != null) {
				System.out.println(s);
			}
			while ((s = stdError.readLine()) != null) {
				System.out.println(s);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}
	
}
