package org.arpit.java2blog.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.log4j.Logger;

@Path("/files")
public class RestFileDownloadExample {
  static Logger logger = Logger.getLogger(RestFileDownloadExample.class);
  private static final String api_version = "1.01A rev.1";
  private static final String FILE_FOLDER = "c://tmp/";
  
  @Path("/version")
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String returnVersion() {
    return "<p>Version: " + api_version + "</p>";
  }
  
  @GET
  @Path("/download")
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public Response downloadFilebyQuery(@QueryParam("filename") String fileName) {
	  Response res=null;
    try {
		res= download(fileName);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return res;
  }
  
  @GET
  @Path("/download/{filename}")
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public Response downloadFilebyPath(@PathParam("filename")  String fileName) {
	  Response res=null;
    try {
    	res= download(fileName);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return res;
  }

  private Response download(String fileName) throws FileNotFoundException {     
    String fileLocation = fileName;
    Response response = null;
    NumberFormat myFormat = NumberFormat.getInstance();
      myFormat.setGroupingUsed(true);
    
    // Retrieve the file 
   File file = new File(fileName);
    PrintWriter pw = new PrintWriter(file);
    StringBuilder sb = new StringBuilder();
    sb.append("id");
    sb.append(',');
    sb.append("Name");
    sb.append('\n');

    sb.append("1");
    sb.append(',');
    sb.append("Prashant Ghimire");
    sb.append('\n');

    pw.write(sb.toString());
    pw.close();
    System.out.println("done!");
   // if (file.exists()) {
    
      ResponseBuilder builder = Response.ok(file);
      builder.header("Content-Disposition", "attachment; filename=" + file.getName());
      response = builder.build();
      
      long file_size = file.length();
            logger.info(String.format("Inside downloadFile==> fileName: %s, fileSize: %s bytes", 
                fileName, myFormat.format(file_size)));
   // } else {
   /*   logger.error(String.format("Inside downloadFile==> FILE NOT FOUND: fileName: %s", 
                fileName));
     
      response = Response.status(404).
              entity("FILE NOT FOUND: " + fileLocation).
              type("text/plain").
              build();
    }
      */
    return response;
  }
}