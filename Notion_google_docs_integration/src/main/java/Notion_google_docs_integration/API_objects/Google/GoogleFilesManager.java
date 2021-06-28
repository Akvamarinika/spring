package Notion_google_docs_integration.API_objects.Google;

import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class GoogleFilesManager {
    private GoogleAPI googleAPI;

    @Autowired
    public GoogleFilesManager(GoogleAPI googleAPI) {
        this.googleAPI = googleAPI;
    }

    public void printList(List<File> files){
        if (files == null || files.isEmpty()) {
            System.out.println("No files found.");
        } else {
            System.out.println("Files:");
            for (File file : files) {
                System.out.printf("%s (%s)\n", file.getName(), file.getId());
            }
        }
    }

    public List<File> listFiles(int quantityFiles) throws IOException, GeneralSecurityException {
        FileList result = googleAPI.getInstance().files().list()
                .setPageSize(quantityFiles)
                .setFields("nextPageToken, files(id, name)")
                .execute();
        return result.getFiles();
    }

    public List<File> listFilesInFolder(String folderIdParent) throws GeneralSecurityException, IOException {
        String query;
        if (folderIdParent == null) folderIdParent = "root";
        FileList result = googleAPI.getInstance().files().list()
                .setQ("'" + folderIdParent + "'" + " in parents")  //"mimeType = 'application/vnd.google-apps.folder'"
                .execute();
        return result.getFiles();
    }


}
