package com.wf.nameprobackend.controller;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.blob.models.BlobItem;
import com.azure.storage.blob.models.BlobStorageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

@Component
public class BlobController {
    private static BlobServiceClient blobServiceClient;
    private BlobContainerClient containerClient;

    @Value("${azure.storage.connection.string}")
    private String azureConnStr;

    public static String uploadFile(BlobContainerClient containerClient,String localPath, String fileName) throws IOException {

        BlobClient blobClient = containerClient.getBlobClient(fileName);
        String blobURl=blobClient.getBlobUrl();
        System.out.println("\nUploading to Blob storage as blob:\n\t" + blobURl);
        blobClient.uploadFromFile(localPath + fileName,true);

        return blobURl;
    }


    public static void downloadBlob(BlobContainerClient containerClient,String localPath, String fileName) throws IOException {

        for (BlobItem blobItem : containerClient.listBlobs()) {
            fileName=blobItem.getName();
            System.out.println("\t" + blobItem.getName());
            BlobClient blobClient = containerClient.getBlobClient(fileName);
            //String downloadFileName = fileName.replace(".txt", "DOWNLOAD.txt");
            File downloadedFile = new File(localPath + fileName);
            System.out.println("\nDownloading blob to\n\t " + localPath + fileName);
            blobClient.downloadToFile(localPath + fileName);
        }
    }

    public BlobContainerClient blobControl() throws IOException {
        String connectStr = azureConnStr;

        BlobServiceClient blobServiceClient = new BlobServiceClientBuilder().connectionString(connectStr).buildClient();

        String containerName = "name0pronunciation";// + java.util.UUID.randomUUID();

        BlobContainerClient containerClient = blobServiceClient.getBlobContainerClient(containerName);

        return  containerClient;
    }

}
