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

    public List<File> listFiles(int quantityFiles) throws IOException, GeneralSecurityException {
        // Print the names and IDs for up to 10 files.
        FileList result = googleAPI.getInstance().files().list()
                .setPageSize(quantityFiles)
                .setFields("nextPageToken, files(id, name)")
                .execute();
        return result.getFiles();
    }
}
