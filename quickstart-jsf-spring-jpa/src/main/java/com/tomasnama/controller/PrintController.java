package com.tomasnama.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.Sides;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named("printController")
@ViewScoped
public class PrintController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SelectItem[] allPrinters;
	private String selectedPrinter;
	private static final Logger LOG = LogManager.getLogger(PrintController.class);

	public SelectItem[] getAllPrinters() {
		if (allPrinters == null) {
			PrintService[] printers = PrintServiceLookup.lookupPrintServices(null, null);
			allPrinters = new SelectItem[printers.length];
			for (int i = 0; i < printers.length; i++) {
				SelectItem printer = new SelectItem(printers[i].getName(), printers[i].getName());
				allPrinters[i] = printer;
			}
		}
		return allPrinters;
	}

	public String getDefaultPrinter() {
		PrintService defaultPrinter = PrintServiceLookup.lookupDefaultPrintService();
		return defaultPrinter.getName();
	}

	public String getSelectedPrinter() {
		if (selectedPrinter == null) {
			return getDefaultPrinter();
		} else {
			return selectedPrinter;
		}
	}
	
	public void setSelectedPrinter(String selectedPrinter) {
		this.selectedPrinter = selectedPrinter;
	}

	public void invokePrintJob(ActionEvent actionEvent) {
		PrintService[] printers = PrintServiceLookup.lookupPrintServices(null, null);
		Boolean printerFound = false;
		for (int i = 0; i < printers.length && !printerFound; i++) {
			if (printers[i].getName().equalsIgnoreCase(getSelectedPrinter())) {
				printerFound = true;
				PrintService printer = printers[i];
				DocFlavor[] flavors = printer.getSupportedDocFlavors();
				for (int x = 0; x < flavors.length; x++) {
        			System.out.println("\t" + flavors[i].getMimeType());
        		}
				
				FileInputStream input;
				try {
					ClassLoader classLoader = getClass().getClassLoader();
					File file = new File(classLoader.getResource("test.png").getFile());
					input = new FileInputStream(file);
					Doc doc = new SimpleDoc(input, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
					PrintRequestAttributeSet attrs = new HashPrintRequestAttributeSet();
					attrs.add (new Copies (1));
					attrs.add (OrientationRequested.PORTRAIT);
					attrs.add (Sides.ONE_SIDED);
					attrs.add (MediaSizeName.ISO_A4);

					DocPrintJob job = printer.createPrintJob();
					job.print(doc, attrs);
					input.close();
				} catch (PrintException e) {
					LOG.error(e.getMessage());
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
				} catch (FileNotFoundException e) {
					LOG.error(e.getMessage());
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
				} catch (IOException e) {
					LOG.error(e.getMessage());
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", e.getMessage()));
				}
			}
		}
	}

}
