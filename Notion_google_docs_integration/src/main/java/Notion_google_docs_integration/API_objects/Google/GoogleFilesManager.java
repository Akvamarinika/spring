package Notion_google_docs_integration.API_objects.Google;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
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
        FileList fileList = googleAPI.getInstance().files().list()
                .setPageSize(quantityFiles)
                .setFields("nextPageToken, files(id, name)")
                .execute();
        return fileList.getFiles();
    }

    public List<File> listFilesInFolder(String folderIdParent) throws GeneralSecurityException, IOException {
        String query;
        if (folderIdParent == null) folderIdParent = "root";
        FileList fileList = googleAPI.getInstance().files().list()
                .setQ("'" + folderIdParent + "'" + " in parents")  //"mimeType = 'application/vnd.google-apps.folder'"
                .execute();
        return fileList.getFiles();
    }

    public String searchFolderByName(String folderIdParent, String folderName) throws IOException, GeneralSecurityException {
        Drive service = googleAPI.getInstance();
        String folderId = null;
        String pageToken = null;
        FileList fileList = null;
        File fileGoogle = new File();
        fileGoogle.setMimeType("application/vnd.google-apps.folder");
        fileGoogle.setName(folderName);

        do {
            String query = (folderIdParent != null) ?
                    "mimeType = 'application/vnd.google-apps.folder' and '" + folderIdParent + "' in parents" :
                    "mimeType = 'application/vnd.google-apps.folder' and 'root' in parents";

            fileList = service.files().list().setQ(query)
                    .setSpaces("drive")
                    .setFields("nextPageToken, files(id, name)")
                    .setPageToken(pageToken)
                    .execute();

            for (File file : fileList.getFiles()) {
                if (file.getName().equalsIgnoreCase(folderName)) {
                    folderId = file.getId();
                }
            }
            pageToken = fileList.getNextPageToken();
        } while (pageToken != null && folderId == null);

        return folderId;
    }

    public String createFolderIfItDoesNotExist(String folderIdParent, String folderName) throws IOException, GeneralSecurityException {
        Drive service = googleAPI.getInstance();
        String folderId = searchFolderByName(folderIdParent, folderName);
        if (folderId != null) return folderId;

        File fileGoogle = new File();
        fileGoogle.setMimeType("application/vnd.google-apps.folder");
        fileGoogle.setName(folderName);

        if (folderIdParent != null) {
            fileGoogle.setParents(Collections.singletonList(folderIdParent));
        }
        return service.files().create(fileGoogle)
                .setFields("id")
                .execute()
                .getId();
    }

    public String createFullPathAndGetIdFolder(String path) throws GeneralSecurityException, IOException {
        Drive service = googleAPI.getInstance();
        String[] folderNames = path.split("/");
        String folderIdParent = null;
        for (String folderName : folderNames) {
            folderIdParent = createFolderIfItDoesNotExist(folderIdParent, folderName);
        }
        return folderIdParent;
    }
}
