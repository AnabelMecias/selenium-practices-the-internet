package tests;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FileUploadPage;

public class FileUploadTests extends BaseTest {
    private FileUploadPage fileUploadPage;
    @BeforeMethod
    public void setUp() {
        super.setUp(); // Call the setUp method from BaseTest to initialize WebDriver
        driver.get(BASE_URL + "/upload"); // Navigate to the File Upload page
        fileUploadPage = new FileUploadPage(driver); // Initialize the page object for FileUploadPage
    }

    @Test
    public void testFileUpload() {
        String filePath = new File("src/resources/Steam Community __ Aseprite.jpeg").getAbsolutePath(); // Get the absolute path of the file to be uploaded
        fileUploadPage.uploadFile(filePath); // Upload the file using the page object method
        String uploadedFileName = fileUploadPage.getUploadedFileName(); // Get the name of the uploaded file from the page
        System.out.println("Uploaded File Name: " + uploadedFileName); // Print the uploaded file name to the console

        // Assert that the uploaded file name matches the expected file name
        Assert.assertEquals(uploadedFileName, "Steam Community __ Aseprite.jpeg");
    }

    
}
