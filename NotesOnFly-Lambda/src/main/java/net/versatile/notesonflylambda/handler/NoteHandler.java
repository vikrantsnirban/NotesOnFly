package net.versatile.notesonflylambda.handler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class NoteHandler  implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent>{

	@Override
	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
	   System.out.println("Note Details");
	   String userName = input.getQueryStringParameters().get("userName");
	   String noteBookName = input.getQueryStringParameters().get("noteBookName");
	   String noteName = input.getQueryStringParameters().get("noteName");
	   String noteTitle = input.getQueryStringParameters().get("noteTitle");
	   String noteContent = input.getQueryStringParameters().get("noteContent");
	   System.out.println("userName = " + userName);
	   System.out.println("noteBookName = " + noteBookName);
	   System.out.println("noteName = " + noteName);
	   System.out.println("noteTitle = " + noteTitle);
	   System.out.println("noteContent = " + noteContent);
	   String action = input.getHttpMethod();
	   System.out.println("action = " + action);
	   
	   String noteBucket = "notesonfly-notes";
	   String noteFileName = noteTitle;
	   File noteFile = new File("/tmp/" + noteFileName);
	   ;
	try {
		FileWriter fileWriter = new FileWriter(noteFile);
		fileWriter.append(userName + "," + noteBookName +  "," + noteName + "," + noteTitle + "," + noteContent);
	    fileWriter.flush();
	    fileWriter.close();
	   AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
	   s3Client.putObject(noteBucket, noteFileName, noteFile);
	} catch (IOException e) {
		System.err.println("Error while writing notes.");
		e.printStackTrace();
	}
	   
	   return new APIGatewayProxyResponseEvent()
		        .withStatusCode(200)
		        .withBody("SUCCESS")
		        .withIsBase64Encoded(false);
	}

}
