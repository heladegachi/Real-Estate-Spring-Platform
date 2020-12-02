package tn.esprit.spring.control;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.faces.FacesException;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.imageio.stream.FileImageOutputStream;
import javax.inject.Named;

import org.ocpsoft.rewrite.annotation.Join;
import org.primefaces.event.CaptureEvent;

@Named
@ViewScoped
@Join(path= "/surveillance", to = "/pages/admin/photoCam.jsf")
public class PhotoCamView implements Serializable {
     
    private String filename;
     
    private String getRandomImageName() {
        int i = (int) (Math.random() * 10000000);
         
        return String.valueOf(i);
    }
 
    public String getFilename() {
        return filename;
    }
     
    public void oncapture(CaptureEvent captureEvent) {
        filename = getRandomImageName();
        byte[] data = captureEvent.getData();
 
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        String newFileName = externalContext.getRealPath("") + File.separator + "resources" + File.separator + "demo" +
                                    File.separator + "images" + File.separator + "photocam" + File.separator + filename + ".jpeg";
         
        FileImageOutputStream imageOutput;
        try {
            imageOutput = new FileImageOutputStream(new File(newFileName));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
        }
        catch(IOException e) {
            throw new FacesException("Error in writing captured image.", e);
        }
    }
}